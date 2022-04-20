/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
        
import java.time.LocalDate;


public class Fechas{
    
    private LocalDate fechaMantencion;
    
    

    public Fechas(int year, int mes, int dia) {
        this.fechaMantencion = LocalDate.of(year, mes, dia);
    }
    
    public Fechas(){
        
    }

    public LocalDate getFechaMantencion() {
        return fechaMantencion;
    }

    public void setFechaMantencion(LocalDate fechaMantencion) {
        this.fechaMantencion = fechaMantencion;
    }
    
    
    
}
