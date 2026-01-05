package DataAccess;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import DataAccess.DTO.ZSSexoDTO;

public class ZSSexoDAO extends ZSSQLiteDataHelper<ZSSexoDTO>{
    private static final String zsTableName = "ZSSexo";
    private static final String zsTablePK   = "idSexo";

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
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public boolean zsUpdate(ZSSexoDTO zsEntity){
        return false;
    }

    @Override
    public boolean zsDelete(Integer zsId) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ZSSexoDTO zsReadBy(Integer zsId){
        return null;
    }

}