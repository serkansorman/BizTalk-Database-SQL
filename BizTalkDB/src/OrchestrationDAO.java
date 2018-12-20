import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrchestrationDAO extends DBHandler {

    public Orchestration getOrchestration() throws Exception {

        Connection conn = getConnection();
        Orchestration orchestration = new Orchestration();
        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * FROM Orchestration WHERE Status=?");

        preparedStmt.setInt(1, 0);
        ResultSet rs = preparedStmt.executeQuery();

        if(rs.next()) {
            OrchestrationHelper(orchestration,rs);
        }

        closePreparedStatement(preparedStmt);
        closeResultSet(rs);
        closeConnection(conn);

        return orchestration;
    }
    
    public Set<Orchestration> getOrchestration(int OrchestrationOwner) throws Exception {

        Connection conn = getConnection();
        Set<Orchestration> orchestrations = new HashSet<Orchestration>();

        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * FROM Orchestration WHERE OrchestrationOwner=?");

        preparedStmt.setInt(1, OrchestrationOwner);
        ResultSet rs = preparedStmt.executeQuery();

        while(rs.next()) {
            Orchestration orchestration = new Orchestration();
            OrchestrationHelper(orchestration,rs);
            orchestrations.add(orchestration);
        }

        closePreparedStatement(preparedStmt);
        closeResultSet(rs);
        closeConnection(conn);

        return orchestrations;
    }

    public boolean insertOrchestration(Orchestration orchestration)  throws Exception {

        Connection conn = getConnection();
        PreparedStatement preparedStmt = conn.prepareStatement(" INSERT INTO Orchestration (OrchestrationId, OrchestrationOwner, Status, StartJobId, InsertDateTime,UpdateDateTime)"
                + " values (?, ?, ?, ?, ?, ?)");

        preparedStmt.setInt(1, orchestration.getId());
        preparedStmt.setInt(2, orchestration.getOwnerID());
        preparedStmt.setInt(3, orchestration.getStatus());
        preparedStmt.setInt(4, orchestration.getStartJobID());
        preparedStmt.setString(5, orchestration.getInsertDateTime());
        preparedStmt.setString(6, orchestration.getUpdateDateTime());

        closePreparedStatement(preparedStmt);
        closeConnection(conn);

        return preparedStmt.execute();
    }

    public boolean updateOrchestration(int orchestrationid,String columnname,int value)  throws Exception {

        Connection conn = getConnection();

        PreparedStatement preparedStmt = conn.prepareStatement("UPDATE Orchestration SET ? = ? WHERE OrchestrationId = ?");

        preparedStmt.setString(1,columnname);
        preparedStmt.setInt(2,value);
        preparedStmt.setInt(3,orchestrationid);

        closePreparedStatement(preparedStmt);
        closeConnection(conn);

        return preparedStmt.execute();
    }

    public boolean updateOrchestration(int orchestrationid, String columnname, Date value)  throws Exception {

        Connection conn = getConnection();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = dateFormat.format(value);

        PreparedStatement preparedStmt = conn.prepareStatement("UPDATE Orchestration SET ? = ? WHERE OrchestrationId = ?");

        preparedStmt.setString(1,columnname);
        preparedStmt.setString(2,date);
        preparedStmt.setInt(3,orchestrationid);

        closePreparedStatement(preparedStmt);
        closeConnection(conn);

        return preparedStmt.execute();
    }

    private void OrchestrationHelper(Orchestration orchestration, ResultSet rs) throws SQLException, ParseException {
        orchestration.setId(rs.getInt("OrchestrationId"));
        orchestration.setOwnerID(rs.getInt("OrchestrationOwner"));
        orchestration.setStatus(rs.getInt("Status"));
        orchestration.setStartJobID(rs.getInt("StartJobId"));
        orchestration.setInsertDateTime(rs.getString("InsertDateTime"));
        orchestration.setUpdateDateTime(rs.getString("UpdateDateTime"));
    }
}
