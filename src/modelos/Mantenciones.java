
package modelos;

import static java.lang.String.format;
import java.time.LocalDate;

public abstract class Mantenciones {
    
    protected String tipoMantencion;
    protected int montoServicio;
    protected String observacion;
    protected Fechas fecha = new Fechas();
    

    public String toString(){
        return format("Mantencion :%s, Detalle :%s, Valor :$%d",this.tipoMantencion, this.observacion, this.montoServicio);
    }
    
    public abstract Fechas getFecha();
    
    public abstract Fechas getFechaMantencion();
    
    public abstract int getMontoServicio();
    
    
}
