package ZSBusinessLogic;

import java.util.List;

import ZSDataAccess.ZSTipoPersonaDAO;
import ZSDataAccess.ZSDTO.ZSTipoPersonaDTO;



public class ZSTipoPersonaBL {
    private ZSTipoPersonaDTO zsTipoPersona;
    private ZSTipoPersonaDAO zsTipoPersonaDAO = new ZSTipoPersonaDAO();

    public ZSTipoPersonaBL(){}

    public List<ZSTipoPersonaDTO> zsGetAll() throws Exception {
        List <ZSTipoPersonaDTO> zsList = zsTipoPersonaDAO.zsReadAll();
        for (ZSTipoPersonaDTO zsTipoPersona : zsList) {
            zsTipoPersona.setZSNombre(zsTipoPersona.getZSNombre().toUpperCase());
        }
        return zsList;
    }

    public ZSTipoPersonaDTO zsGetBy(int idReg) throws Exception {
        return zsTipoPersonaDAO.zsReadBy(idReg);
    }

    public boolean zsAdd(ZSTipoPersonaDTO regDTO) throws Exception{
        return zsTipoPersonaDAO.zsCreate(regDTO);
    }

    public boolean zsUpdate(ZSTipoPersonaDTO regDTO) throws Exception{
        return zsTipoPersonaDAO.zsUpdate(regDTO);
    }

    public boolean zsDelete(int idReg) throws Exception{
        return zsTipoPersonaDAO.zsDelete(idReg);
    }

    public Integer getRowCOunt() throws Exception{
        return zsTipoPersonaDAO.zsGetRowCount();
    }
}
