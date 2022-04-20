/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejecutables;

import java.util.Calendar;

/**
 *
 * @author Rafaelito
 */
public class Validaciones {

    private static boolean estado;

    @SuppressWarnings("finally")
    public static boolean validarRespuesta(String respuesta) {

        if (!(respuesta.equalsIgnoreCase("si")) && !(respuesta.equalsIgnoreCase("no"))) {
            System.out.println("Respuesta ingresada no valida");
            estado = false;
        } else {
            estado = true;
        }

        return estado;
    }

    public static boolean validaOpcion(int opcion) {
        if (opcion < 1 || opcion > 7) {
            estado = false;
            System.out.println("Opcion ingresada no es valida");
        } else {
            estado = true;
        }
        return estado;
    }

    public static boolean validarAnio(int anio) {
        if (anio < 1960 || Calendar.getInstance().getWeekYear() < anio) {
            estado = false;
            System.out.println("Anio de Fabricacion de vehiculo ingresado no Corresponde");
        } else {
            estado = true;
        }

        return estado;
    }

    public static boolean validarTelefono(long fono) {
        if (fono < 99999999L || fono > 99999999999L) {
            estado = false;
            System.out.println("Numero de telefono ingresado no es valido15");
        } else {
            estado = true;
        }
        return estado;

    }

    public static boolean validarCadena(String cadena) {
        if (null == cadena || cadena.isBlank()) {
            System.out.println("El valor ingresado no es valido");
            estado = true;
        } else {
            estado = false;
        }
        return estado;
    }

    public static boolean validarPatente(String patente) {
        if (patente.isBlank() || patente.length() != 6) {
            estado = true;
        } else {
            estado = false;
        }
        return estado;
    }
}
