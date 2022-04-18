
package modelos;

public class MantencionElectricas extends Mantenciones{

    public MantencionElectricas(String tipoMantencion, int montoServicio, String observacion) {   
        this.tipoMantencion = tipoMantencion;
        this.montoServicio = montoServicio;
        this.observacion = observacion;
    }

    public MantencionElectricas(){
        
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
    public void crearMantencion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
