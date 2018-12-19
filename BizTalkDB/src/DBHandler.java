import java.sql.*;

public class DBHandler {

    private String dbUrl="";
    private String userName="";
    private String password="";
    private String driver = "";

    public Connection getConnection() throws Exception {

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(dbUrl, userName, password);

        return conn;
    }

    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null)
            conn.close();
    }


    public void closePreparedStatement (PreparedStatement pst) throws SQLException {
        if(pst != null)
            pst.close();
    }


    public void closeResultSet(ResultSet rs) throws Exception {
        if(rs != null)
            rs.close();
    }

}
