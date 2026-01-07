package ZSBusinessLogic;

import java.util.List;

import ZSDataAccess.ZSSexoDAO;
import ZSDataAccess.ZSDTO.ZSSexoDTO;

public class ZSSexoBL {
    private ZSSexoDTO zsSexo;
    private ZSSexoDAO zsSexoDAO = new ZSSexoDAO();

    public ZSSexoBL(){}

    public List<ZSSexoDTO> zsGetAll() throws Exception {
        List <ZSSexoDTO> zsList = zsSexoDAO.zsReadAll();
        for (ZSSexoDTO zsSexo : zsList) {
            zsSexo.setZSNombre(zsSexo.getZSNombre().toUpperCase());
        }
        return zsList;
    }

    public ZSSexoDTO zsGetBy(int idReg) throws Exception {
        return zsSexoDAO.zsReadBy(idReg);
    }

    public boolean zsAdd(ZSSexoDTO regDTO) throws Exception{
        return zsSexoDAO.zsCreate(regDTO);
    }

    public boolean zsUpdate(ZSSexoDTO regDTO) throws Exception{
        return zsSexoDAO.zsUpdate(regDTO);
    }

    public boolean zsDelete(int idReg) throws Exception{
        return zsSexoDAO.zsDelete(idReg);
    }

    public Integer getRowCOunt() throws Exception{
        return zsSexoDAO.zsGetRowCount();
    }
    
}
