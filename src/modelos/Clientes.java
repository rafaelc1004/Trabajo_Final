/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;

public class Clientes {
    
    private String rut;
    private String nombres;
    private String apellidos;
    private String email;
    private long fono;
    private ArrayList<Autos> listaAutos;

    public Clientes(String rut, String nombres, String apellidos, String email, long fono) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.fono = fono;
        listaAutos = new ArrayList<>();
    }
    
    public Clientes(){
        
    }
    
    public void agregarAuto(Autos auto){
        listaAutos.add(auto);
    }

    public ArrayList<Autos> getListaAutos() {
        return listaAutos;
    }

    public void setListaAutos(ArrayList<Autos> listaAutos) {
        this.listaAutos = listaAutos;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApelldos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getFono() {
        return fono;
    }

    public void setFono(long fono) {
        this.fono = fono;
    }
    
    
    
}
