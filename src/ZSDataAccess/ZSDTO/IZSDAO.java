package ZSDataAccess.ZSDTO;

import java.util.List;

public interface IZSDAO<T> {
    public boolean zsCreate(T zsEntity)         throws Exception;
    public List<T> zsReadAll()                  throws Exception;
    public boolean zsUpdate(T zsEntity)          throws Exception;
    public boolean zsDelete(Integer zsId)       throws Exception;

    public T zsReadBy(Integer zsId)             throws Exception;

}
