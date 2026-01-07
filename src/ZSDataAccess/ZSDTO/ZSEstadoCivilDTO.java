package ZSDataAccess.ZSDTO;

public class ZSEstadoCivilDTO {
    private Integer zsIdCatalogo;
    private Integer zsIdCatalogoTipo;
    private String zsNombre;
    private String zsDescripcion;
    private String zsEstado;
    private String zsFechaCreacion;
    private String zsFechaModificacion;

    public ZSEstadoCivilDTO() {}
    
    public ZSEstadoCivilDTO(Integer zsIdCatalogo, Integer zsIdCatalogoTipo, String zsNombre, String zsDescripcion,
            String zsEstado, String zsFechaCreacion, String zsFechaModificacion) {
        this.zsIdCatalogo = zsIdCatalogo;
        this.zsIdCatalogoTipo = zsIdCatalogoTipo;
        this.zsNombre = zsNombre;
        this.zsDescripcion = zsDescripcion;
        this.zsEstado = zsEstado;
        this.zsFechaCreacion = zsFechaCreacion;
        this.zsFechaModificacion = zsFechaModificacion;
    }
    public Integer getZSIdCatalogo() {
         return zsIdCatalogo;
     }

     public void setZsIdCatalogo(Integer zsIdCatalogo) {
         this.zsIdCatalogo = zsIdCatalogo;
     }

     public Integer getZSIdCatalogoTipo() {
         return zsIdCatalogoTipo;
     }

     public void setZSIdCatalogoTipo(Integer zsIdCatalogoTipo) {
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
        return   "\n idCatalogo           " + zsIdCatalogo 
               + "\n idCatalogoTipo       " + zsIdCatalogoTipo
               + "\n nombre               " + zsNombre 
               + "\n descripcion          " + zsDescripcion 
               + "\n estado               " + zsEstado  
               + "\n fechaCreacion        " + zsFechaCreacion 
               + "\n fechaModificacion    " + zsFechaModificacion;
    }

}
