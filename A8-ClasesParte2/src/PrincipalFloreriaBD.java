import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PrincipalFloreriaBD {
    private static List<List<String>> data = new ArrayList<List<String>>();

    public static void createFlor(){
        conector c = new conector();
        SimpleDateFormat FechaMysql = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dtm = "" + FechaMysql.format(new Date());

        System.out.println("Ingrese los datos de la nueva flor");
        System.out.println("Fecha " + dtm);
        System.out.println("Nombre: ");
        String nombre = leerTexto();
        System.out.println("Aroma: ");
        String aroma = leerTexto();
        System.out.println("Color: ");
        String color = leerTexto();
        System.out.println("Precio: ");
        double precio = leerDecimalPositivo();
        System.out.println("Stock: ");
        int stock = leerEnteroPositivo();
        System.out.println("Estado: ");
        String estado = leerTexto();

        c.ejecutarProcedimientoSinDatos("call crearFlor('" + nombre + "', '" + aroma + "', '" + color + "', " + precio + ", " + stock + ",'" + dtm + "','" + estado + "')");

        System.out.println("Flor creada correctamente...");

    }
    public static void eliminarFLor(){
        conector c = new conector();
        System.out.println("Ingrese el ID a eliminar: ");
        int ID = leerEnteroPositivo();
        c.ejecutarProcedimientoSinDatos("call eliminarFlor(" + ID + ")");
        System.out.println("Flor eliminada correctamente");
    }

    public static void actualizarFlor(){
        conector c = new conector();
        SimpleDateFormat FechaMysql = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dtm = "" + FechaMysql.format(new Date());

        System.out.println("Ingrese el ID");
        int ID = leerEnteroPositivo();

        System.out.println("Ingrese los datos de la nueva flor");
        System.out.println("Fecha " + dtm);
        System.out.println("Nombre: ");
        String nombre = leerTexto();
        System.out.println("Aroma: ");
        String aroma = leerTexto();
        System.out.println("Color: ");
        String color = leerTexto();
        System.out.println("Precio: ");
        double precio = leerDecimalPositivo();
        System.out.println("Stock: ");
        int stock = leerEnteroPositivo();
        System.out.println("Estado: ");
        String estado = leerTexto();

        c.ejecutarProcedimientoSinDatos("call actualizarFlor(" + ID + ", '" + nombre + "', '" + aroma + "', '" + color + "', " + precio + ", " + stock + ",'" + dtm + "','" + estado + "')");

        System.out.println("Flor actualiada correctamente...");
    }

    public static void mostrarFlor(){
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call listarFlores()");

        System.out.print(validarATexto("ID", 5));
        System.out.print(validarATexto("NOMBRE", 25));
        System.out.print(validarATexto("AROMA", 25));
        System.out.print(validarATexto("COLOR", 25));
        System.out.print(validarATexto("PRECIO", 10));
        System.out.print(validarATexto("STOCK", 10));
        System.out.print(validarATexto("FECHA", 30));
        System.out.print(validarATexto("ESTADO", 25));
        System.out.println("");

        for (List<String> dato: data ) {
            System.out.print(validarATexto(dato.get(0), 5));
            System.out.print(validarATexto(dato.get(1), 25));
            System.out.print(validarATexto(dato.get(2), 25));
            System.out.print(validarATexto(dato.get(3), 25));
            System.out.print(validarATexto(dato.get(4), 10));
            System.out.print(validarATexto(dato.get(5), 10));
            System.out.print(validarATexto(dato.get(6), 30));
            System.out.print(validarATexto(dato.get(7), 25));
            System.out.println("");
        }
    }
    public static String validarATexto(String texto, int tamaño){
        while (texto.length() < tamaño){
            texto = texto + " ";
        }
        return texto;
    }
    public static boolean validarNum(String Texto){
        boolean flag = false;
        if (Texto == null || Texto.equals("")) {
            flag = false;
        }
        for (int i = 0; i < Texto.length(); i++)
        {
            char c = Texto.charAt(i);
            if (Character.toString(c).matches("[0-9?]")) {
                flag = true;
            }
        }
        return flag;
    }

    //Validar enteros positivos
    public static int leerEnteroPositivo(){
        int entero = 0;
        Boolean flag = true;
        Scanner teclado;
        do {
            teclado = new Scanner(System.in);
            try{
                entero = teclado.nextInt();
                while (entero < 0) {
                    System.out.println("Error: No se admite numeros negativos");
                    System.out.println("Intentalo nuevamente.");
                    entero = teclado.nextInt();
                }
                flag = false;
            }catch(Exception e){
                System.out.println("Error: Ese no es un entero válido.");
                System.out.println("Intentalo nuevamente.");
            }
        }while (flag);
        return entero;
    }
    //Validar decimales positivos
    public static double leerDecimalPositivo(){
        double decimal = 0.0;
        Boolean flag = true;
        Scanner teclado;
        do {
            teclado = new Scanner(System.in);
            try{
                decimal = teclado.nextDouble();
                while (decimal < 0) {
                    System.out.println("Error: No se admite numeros negativos");
                    System.out.println("Intentalo nuevamente.");
                    decimal = teclado.nextDouble();
                }
                flag = false;
            }catch(Exception e){
                System.out.println("Error: Ese no es un decimal válido.");
                System.out.println("Intentalo nuevamente.");
            }
        }while (flag);
        return decimal;
    }
    //Leer texto
    public static String leerTexto(){
        String texto = "";
        Scanner teclado;
        teclado = new Scanner(System.in);
        texto = teclado.nextLine();
        return texto;
    }
    public static void menuClases(String ClaseS){
        System.out.println("*********** MENÚ " + ClaseS + " ***********");
        System.out.println("0- Salir.");
        System.out.println("1- (C) Crear (Create).");
        System.out.println("2- (R) Mostrar (Read).");
        System.out.println("3- (U) Actualizar (update).");
        System.out.println("4- (D) Eliminar (Delete).");
        System.out.println("  <<Ingrese una opción >>  ");
    }
    public static void subMenus(String ClaseS, String opcion){
        System.out.println("***** Menú " + opcion + " " + ClaseS + " *****");
        System.out.println(" 0- Regresar al menu " + ClaseS);
        System.out.println(" 1- " + opcion + " por posición");
        System.out.println(" 2- " + opcion + " por clave");
        System.out.println(" 3- " + opcion + " todo " + ClaseS);
        System.out.println("  << Ingrese una opción >>  ");
    }
    public static void main(String[] args) {
        SimpleDateFormat FechaMysql = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dtm = "" + FechaMysql;

        int opcion;
        do {
            menuClases("FLORES");
            opcion = leerEnteroPositivo();
            switch (opcion){
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                case 1:
                    //Agregar
                    createFlor();
                    break;
                case 2:
                    //Mostrar
                    mostrarFlor();
                    break;
                case 3:
                    //Actualizar
                    actualizarFlor();
                    break;
                case 4:
                    //Eliminar
                    eliminarFLor();
                    break;
                default:
                    System.out.println("Opción fuera de rango");
                    break;
            }
        }while (opcion != 0);
    }
}