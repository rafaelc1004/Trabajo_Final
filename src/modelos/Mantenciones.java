
package modelos;

public abstract class Mantenciones {
    
    protected String tipoMantencion;
    protected int montoServicio;
    protected String observacion;

    
    
    public abstract void crearMantencion();

    public String toString(){
        return "Mantencion :"+this.tipoMantencion+", "+this.observacion+", valor :$"+this.montoServicio;
    }
    
    
}
