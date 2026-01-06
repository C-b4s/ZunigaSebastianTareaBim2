package DataAccess;

import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.ZSSexoDTO;

public class ZSSexoDAO extends ZSSQLiteDataHelper<ZSSexoDTO>{
    private static final String zsTableName = "ZSSexo";
    private static final String zsTablePK   = "idZSSexo";

    public ZSSexoDAO() throws Exception {
        super(ZSSexoDTO.class, zsTableName, zsTablePK);
    }

    @Override
    public boolean zsCreate(ZSSexoDTO zsEntity) throws Exception {
        String zsQuery = "INSERT INTO Catalogo (IdZSCatalogoTipo, ZSNombre, ZSDescripcion) VALUES (?, ?, ?)";
        try (PreparedStatement zsStmt = zsOpenConnection().prepareStatement(zsQuery)) {
            zsStmt.setObject(1, 2);
            zsStmt.setObject(2, zsEntity.getZSNombre());
            zsStmt.setObject(3, zsEntity.getZSDescripcion());
            zsStmt.executeUpdate();
            return true;
        }catch (SQLException e){
            throw e;
        }
    }


    @Override
    public List<ZSSexoDTO> zsReadAll() throws Exception {
        List <ZSSexoDTO> zsList = new ArrayList<>();
        String zsQuery = "SELECT IdZSCatalogo            "
                       +" ,IdZSCatalogoTipo            "
                       +" ,ZSNombre                    "
                       +" ,ZSDescripcion               "
                       +" ,ZSEstado                    "
                       +" ,ZSFechaCreacion             "
                       +" ,ZSFechaModificacion         "
                       +" FROM      ZSCatalogo         "
                       +" WHERE     ZSEstado = 'A'     "
                       +" AND IdZSCatalogoTipo = 2     ";
        try{
            Connection zsConn = zsOpenConnection();
            Statement zsStmt = zsConn.createStatement();
            ResultSet zsRs = zsStmt.executeQuery(zsQuery);
            while(zsRs.next()){
                ZSSexoDTO zsSexo = new ZSSexoDTO(
                    zsRs.getInt(1),
                    zsRs.getInt(2),
                    zsRs.getString(3),
                    zsRs.getString(4),
                    zsRs.getString(5),
                    zsRs.getString(6),
                    zsRs.getString(7)
                );
                zsList.add(zsSexo);
            }
        }catch(SQLException e){
            throw e; 
        }                                                                 

        return zsList;
    }



    @Override
    public boolean zsUpdate(ZSSexoDTO zsEntity) throws Exception{
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
            throw e;
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
    public ZSSexoDTO zsReadBy(Integer zsId) throws Exception{
        ZSSexoDTO zsSexo = new ZSSexoDTO();
        String zsQuery = "SELECT IdZSCatalogo            "
                       +" ,IdZSCatalogoTipo            "
                       +" ,ZSNombre                    "
                       +" ,ZSDescripcion               "
                       +" ,ZSEstado                    "
                       +" ,ZSFechaCreacion             "
                       +" ,ZSFechaModificacion         "
                       +" FROM      ZSCatalogo           "
                       +" WHERE     ZSEstado = 'A'     "
                       +" AND IdZSCatalogoTipo = 2     "
                       +" AND IdZSCatalogo = " + zsId.toString();        

        try{
            Connection zsConn = zsOpenConnection();
            Statement zsStmt = zsConn.createStatement();
            ResultSet zsRs = zsStmt.executeQuery(zsQuery);
            while(zsRs.next()){
                zsSexo = new ZSSexoDTO(
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
            throw e;
        }

        return zsSexo;
    }

    public Integer getRowCount() throws Exception{
        String query = "SELECT COUNT(*) TotalReg   "
                     + "FROM    ZSCatalogo           "
                     + "WHERE ZSEstado = 'A'       "
                     + "AND IdZSCatalogoTipo = 2   ";

        try{
            Connection zsConn = zsOpenConnection();
            Statement zsStmt = zsConn.createStatement();
            ResultSet zsRs = zsStmt.executeQuery(query);
            while(zsRs.next()){
                return zsRs.getInt(1);
            }
            
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

}