/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejecutables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import modelos.Autos;
import modelos.Clientes;
import modelos.Fechas;
import modelos.MantencionElectricas;
import modelos.MantencionMecanicas;
import modelos.Mantenciones;

public class TestMantencion {

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static int valor;
    private static long valorLong;
    private static boolean estado;
    private static boolean estado1;
    private static String respuesta;
    private static int i, j;
    private static int opcionPatente;
    private static int totalRecaudacionDiaria;

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
        System.out.println("2.- Agregar auto a Cliente");
        System.out.println("3.- Eliminar Cliente");
        System.out.println("4.- Nueva mantencion");
        System.out.println("5.- Mantenciones realizada a Vehiculo");
        System.out.println("6.- Informe de Recaudacion del dia");
        System.out.println("7.- Salir");

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
                agregarVehiculoCliente();

            case 3 ->
                eliminarCliente();
            case 4 ->
                nuevaMantencion();
            case 5 ->
                mantencionesRealizadasVehiculo();
            case 6 ->
                informeRecaudacionDia();
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

            //en caso de no existir el cliente
            Clientes cliente = new Clientes(rutCliente, nombreCliente, apellidoCliente, email, fono);

            listaCliente.add(cliente);

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

    private static void agregarVehiculoCliente() throws Exception {
        do {

            do {
                System.out.print("Ingrese rut de Cliente para agregar Vehiculo :");
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
            } else {
                estado1 = false;
            }

            if (estado1 == false) {
                System.out.println("Cliente No existe");
                TimeUnit.SECONDS.sleep(1);
            } else {

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
                }
                System.out.println("Auto Agregado a Cliente Correctamente");
                TimeUnit.SECONDS.sleep(1);
            }
            do {
                System.out.print("Desea ingresar un nuevo vehiculo si/no :");
                respuesta = bf.readLine();
                estado = Validaciones.validarRespuesta(respuesta);
            } while (estado == false);
        } while (respuesta.equalsIgnoreCase("si"));

        menuInicial();
    }

    private static void eliminarCliente() throws Exception {
        do {

            do {
                System.out.println("Ingrese rut de cliente :");
                rutCliente = bf.readLine();
                estado = Validaciones.validarCadena(rutCliente);

            } while (estado == true);
            if (!listaCliente.isEmpty()) {//se comprueba si la lista de clientes no esta vacia
                for (i = 0; i < listaCliente.size(); i++) {
                    if (rutCliente.equalsIgnoreCase(listaCliente.get(i).getRut())) {
                        listaCliente.remove(i);
                        System.out.println("Cliente eliminado Correctamente");
                        estado = true;
                        break;
                    } else {
                        estado = false;
                    }
                }
            } else {
                estado = false;
            }
            if (estado == false) {
                System.out.println("Cliente no se ha Encontrado");
            }
            do {
                System.out.print("Desea eliminar otro Cliente si/no :");
                respuesta = bf.readLine();
                estado = Validaciones.validarRespuesta(respuesta);
            } while (estado == false);

        } while (respuesta.equalsIgnoreCase("si"));

        menuInicial();

    }

    private static void nuevaMantencion() throws Exception {

        do {
            String tipoMantencion;
            int opcionPatente;
            String observacion;
            int opcion;

            do {
                System.out.print("Ingrese rut Cliente :");
                rutCliente = bf.readLine();
                estado = Validaciones.validarCadena(rutCliente);
            } while (estado == true);
            if (!listaCliente.isEmpty()) {//se comprueba si la lista de clientes no esta vacia
                for (i = 0; i < listaCliente.size(); i++) {
                    if (rutCliente.equalsIgnoreCase(listaCliente.get(i).getRut())) {
                        if (!listaCliente.get(i).getListaAutos().isEmpty()) {//se comprueba si la lista de autos de cliente no esta vacia
                            for (j = 0; j < listaCliente.get(i).getListaAutos().size(); j++) {
                                System.out.printf((j + 1) + ".- %s%n", listaCliente.get(i).getListaAutos().get(j).getPatente());

                            }
                            do {
                                System.out.print("Ingrese opcion de patente a realizar mantencion :");
                                estado = validarNumero();
                                if (valor > listaCliente.get(i).getListaAutos().size() || valor < 1) {
                                    System.out.println("Valor ingresado no es valido");
                                    estado = false;
                                }
                            } while (estado == false);

                            opcionPatente = (valor - 1);
                            // se eligira entre una mantencion electrica o mecanica del para el vehiculo
                            do {
                                System.out.println("\t\tEliga mantencion a realizar\n");
                                System.out.println("1.- Mantencion Electrica");
                                System.out.println("2.- Mantencion Mecanica");
                                System.out.print("\ningrese numero de opcion a elegir :");
                                estado = validarNumero();
                                if (estado == false || valor > 2 || valor < 1) {
                                    System.out.println("Valor ingresado no es valido");
                                    estado = false;
                                } else {

                                }
                            } while (estado == false);
                            opcion = valor;
                            //input con informacion de mantencion a realizar
                            do {
                                System.out.print("Ingrese tipo de mantencion a realizar :");
                                tipoMantencion = bf.readLine();
                                estado = Validaciones.validarCadena(tipoMantencion);
                            } while (estado == true);

                            do {
                                System.out.print("Ingrese precio de mantencion :");
                                estado = validarNumero();
                                if (valor < 1 || estado == false) {
                                    System.out.println("Valor ingresado no es valido");
                                    estado = false;
                                }
                            } while (estado == false);

                            do {
                                System.out.print("Ingrese observacion de Mantencion :");
                                observacion = bf.readLine();
                                estado = Validaciones.validarCadena(observacion);
                            } while (estado == true);
                            int dia = LocalDate.now().getDayOfMonth();
                            int mes = LocalDate.now().getMonthValue();
                            int year = LocalDate.now().getYear();
                            Fechas fecha = new Fechas(year, mes, dia);

                            if (opcion == 1) {
                                Mantenciones mantencion = new MantencionElectricas(tipoMantencion, valor, observacion, fecha);
                                listaCliente.get(i).getListaAutos().get(opcionPatente).agregarMantencion(mantencion);
                            } else {
                                Mantenciones mantencion = new MantencionMecanicas(tipoMantencion, valor, observacion, fecha);
                                listaCliente.get(i).getListaAutos().get(opcionPatente).agregarMantencion(mantencion);
                            }
                            System.out.println("Mantencion agregada correctamente");
                        } else {
                            System.out.println("Lista de vehiculos de cliente esta vacia");
                            TimeUnit.SECONDS.sleep(1);
                        }
                        break;

                    } else {
                        System.out.println("Rut de cliente no se encuentra en lista de clientes");
                        TimeUnit.SECONDS.sleep(1);
                    }
                }

            } else {
                System.out.println("Lista de Clientes esta vacia");
                TimeUnit.SECONDS.sleep(1);
            }
            do {
                System.out.print("Desea hacer otra mantencion a vehiculo si/no :");
                respuesta = bf.readLine();
                estado = Validaciones.validarRespuesta(respuesta);
            } while (estado == false);

        } while (respuesta.equalsIgnoreCase("si"));
        menuInicial();

    }

    private static void mantencionesRealizadasVehiculo() throws Exception {
        do {
            do {
                System.out.println("Ingrese rut de cliente :");
                rutCliente = bf.readLine();
                estado = Validaciones.validarCadena(rutCliente);

            } while (estado == true);
            if (!listaCliente.isEmpty()) {//se comprueba si la lista de clientes no esta vacia
                for (i = 0; i < listaCliente.size(); i++) {
                    if (rutCliente.equalsIgnoreCase(listaCliente.get(i).getRut())) {

                        do {
                            System.out.print("\nIngrese Patente de Vehiculo :");
                            patente = bf.readLine();
                            estado = Validaciones.validarPatente(patente);
                            if (estado == true) {
                                System.out.println("Patente ingresada no es valida");
                            }
                        } while (estado == true);

                        if (!listaCliente.get(i).getListaAutos().isEmpty()) {//se comprueba si la lista de clientes no esta vacia
                            for (j = 0; j < listaCliente.get(i).getListaAutos().size(); j++) {
                                if (listaCliente.get(i).getListaAutos().get(j).getPatente().equalsIgnoreCase(patente)) {//se comprueba que la patente ingresada no exista en lista de vehiculos del cliente

                                    System.out.printf("\t\tMantenciones hechas a vehiculo patente \"%s\"%n", patente);
                                    for (Mantenciones mantencion : listaCliente.get(i).getListaAutos().get(j).getListaMantencion()) {
                                        System.out.printf("\n" + mantencion.toString());

                                    }
                                    break;

                                } else {
                                    System.out.println("\nVehiculo no existe");
                                }

                            }
                         
                        } else {
                            System.out.println("lista de vehiculos esta vacia");
                        }
                       break; 
                    } else {
                        System.out.println("\nCliente no existe");
                    }
                }

            } else {
                System.out.println("lista de clientes esta vacia");
            }
            do {
                System.out.println("Desea listar mantenciones de otro vehiculo si/no :");
                respuesta = bf.readLine();
                estado = Validaciones.validarRespuesta(respuesta);
            } while (estado == false);

        } while (respuesta.equalsIgnoreCase("si"));

        menuInicial();
    }

    private static void informeRecaudacionDia() throws Exception {
        int dia, mes, year; 
        totalRecaudacionDiaria = 0;
        dia = LocalDate.now().getDayOfMonth();
        mes = LocalDate.now().getMonthValue();
        year = LocalDate.now().getYear();
        LocalDate fecha = LocalDate.of(year, mes, dia);
        for(int i=0; i< listaCliente.size(); i++){
            
            for(int j=0; j<listaCliente.get(i).getListaAutos().size() ;j++){
                for( int x=0; x<listaCliente.get(i).getListaAutos().get(j).getListaMantencion().size(); x++){
                    if(fecha.equals(listaCliente.get(i).getListaAutos().get(j).getListaMantencion().get(x).getFecha().getFechaMantencion())){
                        totalRecaudacionDiaria+= listaCliente.get(i).getListaAutos().get(j).getListaMantencion().get(x).getMontoServicio();
                    }
                }
            }
            
        }
        System.out.printf("El total recaudado durante el dia es :%d",totalRecaudacionDiaria);
        TimeUnit.SECONDS.sleep(1);
        menuInicial();
            

    }

}
