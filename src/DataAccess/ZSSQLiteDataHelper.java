package DataAccess;
import java.sql.*;
import java.util.List;


import DataAccess.DTO.IZSDAO;

import java.util.ArrayList;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ZSSQLiteDataHelper <T> implements IZSDAO<T> {
    protected final Class<T> zsDTOClass;
    protected final String  zsTableName;
    protected final String  zsTablePK;

    private static final String zsDBPath = "jdbc:sqlite:db//ZSEXOBOT.sqlite";
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

    @Override
    public boolean zsCreate(T zsEntity) throws Exception {
        Field[] zsFields = zsDTOClass.getDeclaredFields();
        StringBuilder zsColumns = new StringBuilder();
        StringBuilder zsPlaceholders = new StringBuilder();

        for (Field zsField : zsFields) {
            zsField.setAccessible(true);
            String zsName = zsField.getName();
            // Excluir PK y campos por defecto y auditoria
            if (!zsName.equalsIgnoreCase(zsTablePK)
                && !zsName.equalsIgnoreCase("Estado")
                && !zsName.equalsIgnoreCase("FechaCreacion")
                && !zsName.equalsIgnoreCase("FechaModifica")) {
                zsColumns.append(zsName).append(",");
                zsPlaceholders.append("?,");
            }
        }

        // Eliminar la última coma
        String zsCols = zsColumns.substring(0, zsColumns.length() - 1);
        String zsVals = zsPlaceholders.substring(0, zsPlaceholders.length() - 1);

        String zsSql = String.format("INSERT INTO %s (%s) VALUES (%s)", zsTableName, zsCols, zsVals);

        try (PreparedStatement zsStmt = zsOpenConnection().prepareStatement(zsSql)) {
            int zsIndex = 1;
            for (Field zsField : zsFields) {
                String zsName = zsField.getName();
                if (!zsName.equalsIgnoreCase(zsTablePK)
                    && !zsName.equalsIgnoreCase("Estado")
                    && !zsName.equalsIgnoreCase("FechaCreacion")
                    && !zsName.equalsIgnoreCase("FechaModifica")) 
                        zsStmt.setObject(zsIndex++, zsField.get(zsEntity));
            }
            return (zsStmt.executeUpdate() > 0);
        } 
    }

    @Override
    public boolean zsUpdate(T zsEntity) throws Exception {
        Field[] zsFields = zsDTOClass.getDeclaredFields();
        StringBuilder zsUpdates = new StringBuilder();
        Object zsPkValue = null;

        for (Field zsField : zsFields) {
            zsField.setAccessible(true);
            String zsName = zsField.getName();
            if (!zsName.equalsIgnoreCase(zsTablePK)) {
                zsUpdates.append(zsName).append(" = ?,");
            } else {
                zsPkValue = zsField.get(zsEntity);
            }
        }

        zsUpdates.append("FechaModifica = ?");

        String zsSql = String.format("UPDATE %s SET %s WHERE %s = ?", zsTableName, zsUpdates, zsTablePK);
        try (PreparedStatement zsStmt = zsOpenConnection().prepareStatement(zsSql)) {
            int zsIndex = 1;
            for (Field zsField : zsFields) {
                if (!zsField.getName().equalsIgnoreCase(zsTablePK)) {
                    zsStmt.setObject(zsIndex++, zsField.get(zsEntity));
                }
            }
            zsStmt.setString(zsIndex++, zsGetDataTimeNow());
            zsStmt.setObject(zsIndex, zsPkValue);
            return zsStmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean zsDelete(Integer zsId) throws Exception {
        String zsSql = String.format("UPDATE %s SET Estado = ?, FechaModifica = ? WHERE %s = ?", zsTableName, zsTablePK);
        try (PreparedStatement zsStmt = zsOpenConnection().prepareStatement(zsSql)) {
            zsStmt.setString(1, "X");
            zsStmt.setString(2, zsGetDataTimeNow());
            zsStmt.setInt   (3, zsId);
            return zsStmt.executeUpdate() > 0;
        }
    }

    @Override
    public T zsReadBy(Integer zsId) throws Exception {
        String zsSql = String.format("SELECT * FROM %s WHERE %s = ? AND Estado = 'A'", zsTableName, zsTablePK);
        try (PreparedStatement zsStmt = zsOpenConnection().prepareStatement(zsSql)) {
            zsStmt.setInt(1, zsId);
            try (ResultSet zsRs = zsStmt.executeQuery()) {
                return zsRs.next() ? mapResultSetToEntity(zsRs) : null;
            }
        }
    }

    @Override
    public List<T> zsReadAll() throws Exception {
        List<T> zsList = new ArrayList<>();
        String zsSql = String.format("SELECT * FROM %s WHERE Estado = 'A'", zsTableName);
        try (PreparedStatement zsStmt = zsOpenConnection().prepareStatement(zsSql);
             ResultSet zsRs = zsStmt.executeQuery()) {
            while (zsRs.next()) {
                zsList.add(mapResultSetToEntity(zsRs));
            }
        }
        return zsList;
    }

    protected T mapResultSetToEntity(ResultSet zsRs) throws Exception {
        T zsInstance = zsDTOClass.getDeclaredConstructor().newInstance();
        ResultSetMetaData zsMeta = zsRs.getMetaData();

        for (int i = 1; i <= zsMeta.getColumnCount(); i++) {
            String zsCol = zsMeta.getColumnName(i);
            Object zsVal = zsRs.getObject(i);
            try {
                Field zsField = zsDTOClass.getDeclaredField(zsCol);
                zsField.setAccessible(true);
                zsField.set(zsInstance, zsVal);
            } catch (NoSuchFieldException zsIgnored) {
                zsIgnored.getMessage();
            }
        }
        return zsInstance;
    }
}
