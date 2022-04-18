/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejecutables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import modelos.Autos;
import modelos.Clientes;

public class TestMantencion {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int valor;
    private static long valorLong;
    private static boolean estado;
    private static boolean estado1;
    private static String respuesta;
    private static int i, j;

    private static ArrayList<Clientes> listaCliente = new ArrayList<>();

    //atributos de clase Clientes
    private static String rutCliente;
    private static String nombreCliente;
    private static String apellidoCliente;
    private static String email;
    private static long fono;

    //atributos de clase Autos
    private static String patente;
    private static String marca;
    private static String modelo;
    private static int anioFabricacion;

    public static void main(String[] args) throws Exception {

        menuInicial();

    }

    private static void menuInicial() throws Exception {
        System.out.println("\t\tMenu Mantenciones MyCard\n");
        System.out.println("1.- Agregar Cliente");
        System.out.println("2.- Eliminar Cliente");
        System.out.println("3.- Nueva mantencion");
        System.out.println("4.- Mantenciones realizada a Vehiculo");
        System.out.println("5.- Informe de Recaudacion del dia");
        System.out.println("6.- Salir");

        do {
            System.out.print("Ingrese numero de Opcion a Realizar :");
            estado = validarNumero();
            if (estado) {
                estado = Validaciones.validaOpcion(valor);
            } else {
                System.out.println("Opcion ingresada no es valida");
            }

        } while (estado == false);

        menuOperacion(valor);

    }

    //se valida numero int capturando exception en caso de error
    private static boolean validarNumero() {
        try {
            valor = Integer.parseInt(bf.readLine());
            estado = true;
        } catch (IOException | NumberFormatException e) {
            estado = false;
        } finally {
            return estado;
        }
    }

    //se valida numero long y captura exception en caso de error
    private static boolean validarNumeroTelefono() {
        try {
            valorLong = Long.parseLong(bf.readLine());
            estado = true;
        } catch (IOException | NumberFormatException e) {
            estado = false;
        } finally {
            return estado;
        }
    }

    private static void menuOperacion(int opcion) throws Exception {

        switch (opcion) {
            case 1 ->
                agregarCliente();
            case 2 ->
                eliminarCliente();
            case 3 ->
                nuevaMantencion();
            case 4 ->
                mantencionesRealizadasVehiculo();
            case 5 ->
                informeRecaudacion();
            default ->
                System.exit(0);

        }
    }

    //Creacion de metodo para agregar cliente 
    private static void agregarCliente() throws Exception {

        do {

            System.out.println("\t\tDatos de Cliente");

            do {
                System.out.print("\nIngrese Rut de Cliente :");
                rutCliente = bf.readLine();
                estado = Validaciones.validarCadena(rutCliente);
            } while (estado == true);

            if (!listaCliente.isEmpty()) {//se comprueba si la lista de clientes no esta vacia
                for (i = 0; i < listaCliente.size(); i++) {
                    if (listaCliente.get(i).getRut().equalsIgnoreCase(rutCliente)) {//se comprueba el rut ingresado con los clientes de la lista clientes
                        estado1 = true;
                        break;
                    } else {
                        estado1 = false;
                    }
                }

            }
            if (estado1 == false) {
                // si el cliente no existe se hace ingreso y validacion de datos de cliente
                do {
                    System.out.print("Ingrese nombres de Cliente :");
                    nombreCliente = bf.readLine();
                    estado = Validaciones.validarCadena(nombreCliente);
                } while (estado == true);
                do {
                    System.out.print("Ingrese apellidos de Cliente :");
                    apellidoCliente = bf.readLine();
                    estado = Validaciones.validarCadena(apellidoCliente);
                } while (estado == true);
                do {
                    System.out.print("Ingrese email de Cliente :");
                    email = bf.readLine();
                    estado = Validaciones.validarCadena(email);
                } while (estado == true);
                do {
                    System.out.println("Ingrese numero de telefono de Cliente entre 9 y 11 digitos :");
                    validarNumeroTelefono();
                    if (estado) {
                        fono = valorLong;

                        estado = Validaciones.validarTelefono(fono);
                    } else {
                        System.out.println("Numero de telefono ingresado no es valido");
                    }
                } while (estado == false);
            }

            System.out.println("\n\t\tDatos de Vehiculo");
            do {
                System.out.print("\nIngrese Patente de Vehiculo :");
                patente = bf.readLine();
                estado = Validaciones.validarPatente(patente);
            } while (estado == true);
            
            //se verifica si el vehiculo a agregar ya existe en la lista de vehiculos del cliente
            if (estado1 == true) {

                if (!listaCliente.get(i).getListaAutos().isEmpty()) {//se comprueba si la lista de clientes no esta vacia
                    for (j = 0; j < listaCliente.get(i).getListaAutos().size(); j++) {
                        if (listaCliente.get(i).getListaAutos().get(j).getPatente().equalsIgnoreCase(patente)) {//se comprueba que la patente ingresada no exista en lista de vehiculos del cliente
                            System.out.println("Vehiculo ya esta ingresado en Cliente");
                            TimeUnit.SECONDS.sleep(1);
                            menuInicial();
                        }
                    }

                }
            }

            //validacion de atributos
            do {
                System.out.print("Ingrese Marca de Vehiculo :");
                marca = bf.readLine();
                estado = Validaciones.validarCadena(marca);
            } while (estado == true);
            do {
                System.out.print("Ingrese Modelo de Vehiculo :");
                modelo = bf.readLine();
                estado = Validaciones.validarCadena(modelo);
            } while (estado == true);
            do {
                System.out.print("Ingrese anio de Fabricacion de Vehiculo :");
                estado = validarNumero();
                if (estado) {

                    estado = Validaciones.validarAnio(valor);
                } else {
                    System.out.println("Anio de Fabricacion de vehiculo ingresado no Corresponde");
                }

            } while (estado == false);
            Autos auto = new Autos(patente, marca, modelo, valor);
            if (estado1) {
                //si el cliente ya existe solo se agrega el vehiculo a su lista de vehiculos
                listaCliente.get(i).agregarAuto(auto);
            } else {
                //en caso de no existir el cliente, se crea y agrega un vehiculo y a la lista de clientes
                Clientes cliente = new Clientes(rutCliente, nombreCliente, apellidoCliente, email, fono);
                cliente.agregarAuto(auto);
                listaCliente.add(cliente);
            }

            
            System.out.println("Cliente Agregado Correctamente");
            TimeUnit.SECONDS.sleep(1);
            do {
                System.out.print("Desea ingresar un nuevo Cliente si/no :");
                respuesta = bf.readLine();
                estado = Validaciones.validarRespuesta(respuesta);
            } while (estado == false);

        } while (respuesta.equalsIgnoreCase("si"));
        menuInicial();

    }

    private static void eliminarCliente() {

    }

    private static void nuevaMantencion() {

    }

    private static void mantencionesRealizadasVehiculo() {

    }

    private static void informeRecaudacion() {

    }

}
