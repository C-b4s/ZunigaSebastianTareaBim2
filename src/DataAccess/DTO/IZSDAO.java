package DataAccess.DTO;

import java.util.List;

public interface IZSDAO<T> {
    public boolean zsCreate(T zsEntity)         throws Exception;
    public List<T> zsReadAll()                throws Exception;
    public boolean zsUpdate(T zEntity)         throws Exception;
    public boolean zsDelete(Integer zsId)       throws Exception;

    public T zsReadBy(Integer zsId)             throws Exception;

}
