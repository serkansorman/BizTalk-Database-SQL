import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class OrchestrationDAO extends DBHandler {

    // status 0 olani döndürmeli ...
    public Orchestration getOrchestration() throws Exception {

        Connection conn = getConnection();
        Orchestration orchestration = new Orchestration();
        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * FROM Orchestration WHERE Status=?");

        preparedStmt.setInt(1, 0);
        ResultSet rs = preparedStmt.executeQuery();

        if(rs.next()) {
            orchestration.setId(rs.getInt("OrchestrationId"));
            orchestration.setOwnerID(rs.getInt("OrchestrationOwner"));
            orchestration.setStatus(rs.getInt("Status"));
            orchestration.setStartJobID(rs.getInt("StartJobId"));
            orchestration.setInsertDateTime(rs.getString("InsertDateTime"));
            orchestration.setUpdateDateTime(rs.getString("UpdateDateTime"));
        }

        closePreparedStatement(preparedStmt);
        closeResultSet(rs);
        closeConnection(conn);

        return orchestration;

    }

    // status olayı belirsiz....
    public Orchestration getOrchestration(int OrchestrationOwner) throws Exception {

        Connection conn = getConnection();
        Orchestration orchestration = new Orchestration();
        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * FROM Orchestration WHERE OrchestrationOwner=?");

        preparedStmt.setInt(1, OrchestrationOwner);
        ResultSet rs = preparedStmt.executeQuery();

        if(rs.next()) {
            orchestration.setId(rs.getInt("OrchestrationId"));
            orchestration.setOwnerID(rs.getInt("OrchestrationOwner"));
            orchestration.setStatus(rs.getInt("Status"));
            orchestration.setStartJobID(rs.getInt("StartJobId"));
            orchestration.setInsertDateTime(rs.getString("InsertDateTime"));
            orchestration.setUpdateDateTime(rs.getString("UpdateDateTime"));
        }

        closePreparedStatement(preparedStmt);
        closeResultSet(rs);
        closeConnection(conn);

        return orchestration;
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
}
