
package modelos;

import static java.lang.String.format;

public abstract class Mantenciones {
    
    protected String tipoMantencion;
    protected int montoServicio;
    protected String observacion;

    
    
    public abstract void crearMantencion();

    public String toString(){
        return format("Mantencion :%s, Detalle :%s, Valor :$%d",this.tipoMantencion, this.observacion, this.montoServicio);
    }
    
    
}
