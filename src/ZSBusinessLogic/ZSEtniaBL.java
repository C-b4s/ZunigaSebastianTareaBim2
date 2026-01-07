package ZSBusinessLogic;

import java.util.List;

import ZSDataAccess.ZSEtniaDAO;
import ZSDataAccess.ZSDTO.ZSEtniaDTO;


public class ZSEtniaBL {
    private ZSEtniaDTO zsEtnia;
    private ZSEtniaDAO zsEtniaDAO = new ZSEtniaDAO();

    public ZSEtniaBL(){}

    public List<ZSEtniaDTO> zsGetAll() throws Exception {
        List <ZSEtniaDTO> zsList = zsEtniaDAO.zsReadAll();
        for (ZSEtniaDTO zsEtnia : zsList) {
            zsEtnia.setZSNombre(zsEtnia.getZSNombre().toUpperCase());
        }
        return zsList;
    }

    public ZSEtniaDTO zsGetBy(int idReg) throws Exception {
        return zsEtniaDAO.zsReadBy(idReg);
    }

    public boolean zsAdd(ZSEtniaDTO regDTO) throws Exception{
        return zsEtniaDAO.zsCreate(regDTO);
    }

    public boolean zsUpdate(ZSEtniaDTO regDTO) throws Exception{
        return zsEtniaDAO.zsUpdate(regDTO);
    }

    public boolean zsDelete(int idReg) throws Exception{
        return zsEtniaDAO.zsDelete(idReg);
    }

    public Integer getRowCOunt() throws Exception{
        return zsEtniaDAO.zsGetRowCount();
    }
}
