/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
        
import java.time.LocalDate;
import java.time.Month;

public class Fechas{
    
    private LocalDate fechaMantencion;
    
    

    public Fechas(int dia, int mes, int year) {
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
