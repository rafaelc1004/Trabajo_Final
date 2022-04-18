
package modelos;

import java.util.ArrayList;
import java.util.Date;

public class Autos {
    
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private ArrayList<Mantenciones> listaMantencion;

    public Autos(String patente, String marca, String modelo, int anioFabricacion) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        listaMantencion = new ArrayList<>();
    }
    
    public void agregarMantencion(Mantenciones mantencion ){
        this.listaMantencion.add(mantencion);
    }


    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
    
}
