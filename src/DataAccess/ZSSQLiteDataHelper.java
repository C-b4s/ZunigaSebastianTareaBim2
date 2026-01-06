package DataAccess;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ZSSQLiteDataHelper <T>{
    protected final Class<T> zsDTOClass;
    protected final String  zsTableName;
    protected final String  zsTablePK;

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

    /**
     * 
     * @param zsDTOClass: Nombre de la clase DTO   
     * @param zsTableName: Nombre de la tabla
     * @param zsTablePK: Nombre del PK de la tabla
     * @throws Exception: Error que no se puede asociar la clase a tabla
     */
    public ZSSQLiteDataHelper(Class<T> zsDTOClass, String zsTableName, String zsTablePK) throws Exception {
        zsOpenConnection();
        this.zsDTOClass  = zsDTOClass;
        this.zsTableName = zsTableName;
        this.zsTablePK   = zsTablePK;
    }
}
