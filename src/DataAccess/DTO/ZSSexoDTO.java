package DataAccess.DTO;

public class ZSSexoDTO {
    private String zsIdCatalogo;
    private String zsIdCatalogoTipo;
    private String zsNombre;
    private String zsDescripcion;
    private String zsEstado;
    private String zsFechaCreacion;
    private String zsFechaModificacion;
    
    public ZSSexoDTO(String idCatalogo, String idCatalogoTipo, String nombre, String descripcion, String estado,
            String fechaCreacion, String fechaModificacion) {
        this.zsIdCatalogo = idCatalogo;
        this.zsIdCatalogoTipo = idCatalogoTipo;
        this.zsNombre = nombre;
        this.zsDescripcion = descripcion;
        this.zsEstado = estado;
        this.zsFechaCreacion = fechaCreacion;
        this.zsFechaModificacion = fechaModificacion;
    }

    public String getZSIdCatalogo() {
        return zsIdCatalogo;
    }

    public void setZSIdCatalogo(String zsIdCatalogo) {
        this.zsIdCatalogo = zsIdCatalogo;
    }

    public String getZSIdCatalogoTipo() {
        return zsIdCatalogoTipo;
    }

    public void setZSIdCatalogoTipo(String zsIdCatalogoTipo) {
        this.zsIdCatalogoTipo = zsIdCatalogoTipo;
    }

    public String getZSNombre() {
        return zsNombre;
    }

    public void setZSNombre(String zsNombre) {
        this.zsNombre = zsNombre;
    }

    public String getZSDescripcion() {
        return zsDescripcion;
    }

    public void setZSDescripcion(String zsDescripcion) {
        this.zsDescripcion = zsDescripcion;
    }

    public String getZSEstado() {
        return zsEstado;
    }

    public void setZSEstado(String zsEstado) {
        this.zsEstado = zsEstado;
    }

    public String getZSFechaCreacion() {
        return zsFechaCreacion;
    }

    public void setZSFechaCreacion(String zsFechaCreacion) {
        this.zsFechaCreacion = zsFechaCreacion;
    }

    public String getZSFechaModificacion() {
        return zsFechaModificacion;
    }

    public void setZSFechaModificacion(String zsFechaModificacion) {
        this.zsFechaModificacion = zsFechaModificacion;
    }
   
     @Override
    public String toString() {
        return "\n idCatalogo = " + zsIdCatalogo 
               + "\n idCatalogoTipo = " + zsIdCatalogoTipo
               + "\n nombre = " + zsNombre 
               + "\n descripcion = " + zsDescripcion 
               + "\n estado = " + zsEstado  
               + "\n fechaCreacion = " + zsFechaCreacion 
               + "\n fechaModificacion = " + zsFechaModificacion;
    }
   
}
