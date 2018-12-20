import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JobDAO extends DBHandler{

    public Job getJob(int jobID) throws Exception {

        Connection conn = getConnection();
        Job job = new Job();
        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * FROM Jobs WHERE JobId=?");

        preparedStmt.setInt(1, jobID);
        ResultSet rs = preparedStmt.executeQuery();

        if(rs.next()) {
            job.setId(rs.getInt("JobId"));
            job.setOwner(rs.getInt("JobOwner"));
            job.setDescription(rs.getString("JobDescription"));
            job.setDestination(rs.getString("Destination"));
            job.setFileUrl(rs.getString("FileURL"));
            job.setRelatives(rs.getString("Relatives"));
            job.setStatus(rs.getInt("Status"));
            job.setRuleId(rs.getInt("RuleID"));
            job.setInsertDateTime(rs.getString("InsertDateTime"));
            job.setUpdateDateTime(rs.getString("UpdateDateTime"));
        }

        closePreparedStatement(preparedStmt);
        closeResultSet(rs);
        closeConnection(conn);

        return job;

    }

    public boolean insertJob(Job job)throws Exception{

        Connection conn = getConnection();
        PreparedStatement preparedStmt = conn.prepareStatement(" INSERT INTO Jobs (JobId, JobOwner, JobDescription, " +
                "Destination, FileURL, Relatives, Status, RuleId, InsertDateTime, UpdateDateTime)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        preparedStmt.setInt(1,job.getId());
        preparedStmt.setInt(2,job.getOwner());
        preparedStmt.setString(3,job.getDescription());
        preparedStmt.setString(4,job.getDestination());
        preparedStmt.setString(5,job.getFileUrl());
        preparedStmt.setString(6,job.getRelatives());
        preparedStmt.setInt(7,job.getStatus());
        preparedStmt.setInt(8,job.getRuleId());
        preparedStmt.setString(9,job.getInsertDateTime());
        preparedStmt.setString(10,job.getUpdateDateTime());

        closePreparedStatement(preparedStmt);
        closeConnection(conn);

        return preparedStmt.execute();
    }

    public boolean UpdateJob(int JobId, String columnName, int value) throws Exception {

        Connection conn = getConnection();

        PreparedStatement preparedStmt = conn.prepareStatement("UPDATE Jobs SET ? = ? WHERE JobId = ?");

        preparedStmt.setString(1,columnName);
        preparedStmt.setInt(2,value);
        preparedStmt.setInt(3,JobId);

        closePreparedStatement(preparedStmt);
        closeConnection(conn);

        return preparedStmt.execute();
    }

    public boolean UpdateJob(int JobId, String columnName, String value) throws Exception {

        Connection conn = getConnection();

        PreparedStatement preparedStmt = conn.prepareStatement("UPDATE Jobs SET ? = ? WHERE JobId = ?");

        preparedStmt.setString(1,columnName);
        preparedStmt.setString(2,value);
        preparedStmt.setInt(3,JobId);

        closePreparedStatement(preparedStmt);
        closeConnection(conn);

        return preparedStmt.execute();
    }

    public boolean UpdateJob(int JobId, String columnName, Date value) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = dateFormat.format(value);

        Connection conn = getConnection();
        PreparedStatement preparedStmt = conn.prepareStatement("UPDATE Jobs SET ? = ? WHERE JobId = ?");

        preparedStmt.setString(1,columnName);
        preparedStmt.setString(2,date);
        preparedStmt.setInt(3,JobId);

        closePreparedStatement(preparedStmt);
        closeConnection(conn);

        return preparedStmt.execute();
    }
}
