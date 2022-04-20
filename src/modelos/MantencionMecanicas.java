
package modelos;

public class MantencionMecanicas extends Mantenciones{

    public MantencionMecanicas(String tipoMantencion, int montoServicio, String observacion, Fechas fecha) {
     
        this.tipoMantencion = tipoMantencion;
        this.montoServicio = montoServicio;
        this.observacion = observacion;
        this.fecha = fecha;
    }
    
    public MantencionMecanicas(){
        
    }

    public String getTipoMantencion() {
        return tipoMantencion;
    }

    public void setTipoMantencion(String tipoMantencion) {
        this.tipoMantencion = tipoMantencion;
    }

    public int getMontoServicio() {
        return montoServicio;
    }

    public void setMontoServicio(int montoServicio) {
        this.montoServicio = montoServicio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public Fechas getFecha() {
        return fecha;
    }

    public void setFecha(Fechas fecha) {
        this.fecha = fecha;
    }
    
    public Fechas getFechaMantencion(){
        return this.getFecha();
    }
    
        
}
