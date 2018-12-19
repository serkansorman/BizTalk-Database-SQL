package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHandler {

    private String dbUrl="";
    private String userName="";
    private String password="";
    private String driver = "";

    public Connection getConnectionLocal() throws Exception {

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(dbUrl, userName, password);

        return conn;
    }

}
