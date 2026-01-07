package ZSDataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ZSDataAccess.ZSDTO.IZSDAO;
import ZSDataAccess.ZSDTO.ZSEstadoCivilDTO;
import ZSFramework.ZSException;

public class ZSEstadoCivilDAO extends ZSSQLiteDataHelper <ZSEstadoCivilDTO> implements IZSDAO <ZSEstadoCivilDTO> {

    @Override
    public boolean zsCreate (ZSEstadoCivilDTO zsEntity) throws Exception {
        String zsQuery = "INSERT INTO Catalogo (IdZSCatalogoTipo, ZSNombre, ZSDescripcion) VALUES (?, ?, ?)";
        try (PreparedStatement zsStmt = zsOpenConnection().prepareStatement(zsQuery)) {
            zsStmt.setObject(1, 3);
            zsStmt.setObject(2, zsEntity.getZSNombre());
            zsStmt.setObject(3, zsEntity.getZSDescripcion());
            zsStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new ZSException(e.getMessage(), getClass().getName(), "zsReadAll()");
        }
    }


    @Override
    public List<ZSEstadoCivilDTO> zsReadAll() throws Exception {
        List <ZSEstadoCivilDTO> zsList = new ArrayList<>();
        String zsQuery = "SELECT IdZSCatalogo            "
                       +" ,IdZSCatalogoTipo            "
                       +" ,ZSNombre                    "
                       +" ,ZSDescripcion               "
                       +" ,ZSEstado                    "
                       +" ,ZSFechaCreacion             "
                       +" ,ZSFechaModificacion         "
                       +" FROM      ZSCatalogo         "
                       +" WHERE     ZSEstado = 'A'     "
                       +" AND IdZSCatalogoTipo = 3     ";
        try{
            Connection zsConn = zsOpenConnection();
            Statement zsStmt = zsConn.createStatement();
            ResultSet zsRs = zsStmt.executeQuery(zsQuery);
            while(zsRs.next()){
                ZSEstadoCivilDTO zsEc = new ZSEstadoCivilDTO(
                    zsRs.getInt(1),
                    zsRs.getInt(2),
                    zsRs.getString(3),
                    zsRs.getString(4),
                    zsRs.getString(5),
                    zsRs.getString(6),
                    zsRs.getString(7)
                );
                zsList.add(zsEc);
            }
        }catch(SQLException e){
            throw new ZSException(e.getMessage(), getClass().getName(), "zsReadAll()"); 
        }                                                                 

        return zsList;
    }



    @Override
    public boolean zsUpdate(ZSEstadoCivilDTO zsEntity) throws Exception{
        DateTimeFormatter zsDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime zsNow = LocalDateTime.now();
        String zsQuery = "UPDATE ZSCatalogo SET ZSNombre = ?, ZSDescripcion = ?, ZSFechaModificacion = ? WHERE IdZSCatalogo = ?";
        try{
            Connection zsConn = zsOpenConnection();
            PreparedStatement zsPstmt = zsConn.prepareStatement(zsQuery);
            zsPstmt.setString(1, zsEntity.getZSNombre());
            zsPstmt.setString(2, zsEntity.getZSDescripcion());
            zsPstmt.setString(3, zsDtf.format(zsNow).toString());
            zsPstmt.setInt(4, zsEntity.getZSIdCatalogo());
            zsPstmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new ZSException(e.getMessage(), getClass().getName(), "zsReadAll()");
        }   
    }

    @Override
    public boolean zsDelete(Integer zsId) throws Exception {
        String zsQuery = "UPDATE ZSCatalogo SET ZSEstado = ? WHERE IdZSCatalogo = ?";
        try{
            Connection zsConn = zsOpenConnection();
            PreparedStatement zsPstmt = zsConn.prepareStatement(zsQuery);
            zsPstmt.setString(1, "X");
            zsPstmt.setInt(2, zsId);
            zsPstmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw e;
        }
    }

    @Override
    public ZSEstadoCivilDTO zsReadBy(Integer zsId) throws Exception{
        ZSEstadoCivilDTO zsEc = new ZSEstadoCivilDTO();
        String zsQuery = "SELECT IdZSCatalogo            "
                       +" ,IdZSCatalogoTipo            "
                       +" ,ZSNombre                    "
                       +" ,ZSDescripcion               "
                       +" ,ZSEstado                    "
                       +" ,ZSFechaCreacion             "
                       +" ,ZSFechaModificacion         "
                       +" FROM      ZSCatalogo           "
                       +" WHERE     ZSEstado = 'A'     "
                       +" AND IdZSCatalogoTipo = 3     "
                       +" AND IdZSCatalogo = " + zsId.toString();        

        try{
            Connection zsConn = zsOpenConnection();
            Statement zsStmt = zsConn.createStatement();
            ResultSet zsRs = zsStmt.executeQuery(zsQuery);
            while(zsRs.next()){
                zsEc = new ZSEstadoCivilDTO(
                    zsRs.getInt(1),
                    zsRs.getInt(2),
                    zsRs.getString(3),
                    zsRs.getString(4),
                    zsRs.getString(5),
                    zsRs.getString(6),
                    zsRs.getString(7)
                );
                
            }
        }catch(SQLException e){
            throw new ZSException(e.getMessage(), getClass().getName(), "zsReadAll()");
        }

        return zsEc;
    }

    public Integer zsGetRowCount() throws Exception{
        String query = "SELECT COUNT(*) TotalReg   "
                     + "FROM    ZSCatalogo           "
                     + "WHERE ZSEstado = 'A'       "
                     + "AND IdZSCatalogoTipo = 3   ";

        try{
            Connection zsConn = zsOpenConnection();
            Statement zsStmt = zsConn.createStatement();
            ResultSet zsRs = zsStmt.executeQuery(query);
            while(zsRs.next()){
                return zsRs.getInt(1);
            }
            
        }catch (SQLException e){
            throw new ZSException(e.getMessage(), getClass().getName(), "zsReadAll()");
        }
        return 0;
    }

}
