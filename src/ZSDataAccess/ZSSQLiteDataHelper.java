package ZSDataAccess;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ZSSQLiteDataHelper <T>{
    

    private static final String zsDBPath = "jdbc:sqlite:DataBase/ZSEXOBOT.sqlite";
    private static Connection zsConn = null;

    protected static synchronized Connection zsOpenConnection() throws SQLException {
        if (zsConn == null || zsConn.isClosed()) {
            zsConn = DriverManager.getConnection(zsDBPath);
        }
        return zsConn;
    }

    protected static void zsCloseConnection() throws SQLException {
        if (zsConn != null && !zsConn.isClosed()) {
            zsConn.close();
        }
    }

    protected String zsGetDataTimeNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    
}
