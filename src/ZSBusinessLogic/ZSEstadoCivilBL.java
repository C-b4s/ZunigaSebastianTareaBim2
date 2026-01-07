package ZSBusinessLogic;

import java.util.List;

import ZSDataAccess.ZSEstadoCivilDAO;
import ZSDataAccess.ZSDTO.ZSEstadoCivilDTO;



public class ZSEstadoCivilBL {
    private ZSEstadoCivilDTO zsEc;
    private ZSEstadoCivilDAO zsEstadoCivilDAO = new ZSEstadoCivilDAO();

    public ZSEstadoCivilBL(){}

    public List<ZSEstadoCivilDTO> zsGetAll() throws Exception {
        List <ZSEstadoCivilDTO> zsList = zsEstadoCivilDAO.zsReadAll();
        for (ZSEstadoCivilDTO zsEc : zsList) {
            zsEc.setZSNombre(zsEc.getZSNombre().toUpperCase());
        }
        return zsList;
    }

    public ZSEstadoCivilDTO zsGetBy(int idReg) throws Exception {
        return zsEstadoCivilDAO.zsReadBy(idReg);
    }

    public boolean zsAdd(ZSEstadoCivilDTO regDTO) throws Exception{
        return zsEstadoCivilDAO.zsCreate(regDTO);
    }

    public boolean zsUpdate(ZSEstadoCivilDTO regDTO) throws Exception{
        return zsEstadoCivilDAO.zsUpdate(regDTO);
    }

    public boolean zsDelete(int idReg) throws Exception{
        return zsEstadoCivilDAO.zsDelete(idReg);
    }

    public Integer getRowCOunt() throws Exception{
        return zsEstadoCivilDAO.zsGetRowCount();
    }
}
