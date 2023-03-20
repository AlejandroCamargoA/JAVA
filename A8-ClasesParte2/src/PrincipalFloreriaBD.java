import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PrincipalFloreriaBD {
    private static List<List<String>> data = new ArrayList<>();
    public static int clienteExisteID(int ID){
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call cExisteID(" + ID + ")");
        List<String> dato = data.get(0);
        return Integer.parseInt(dato.get(0));
    }
    public static int clienteExiste(String tipodoc, String numdoc){
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call cExiste('" + tipodoc + "','" + numdoc + "')");
        List<String> dato = data.get(0);
        return Integer.parseInt(dato.get(0));
    }
    public static void crearCliente(){
        conector c = new conector();

        System.out.println("Ingrese los datos del nuevo cliente");
        System.out.println("Nombres: ");
        String nombres = leerTexto();
        System.out.println("Apellidos: ");
        String apellidos = leerTexto();
        System.out.println("Tipo de Documento: ");
        String tipodoc = leerTexto();
        System.out.println("Numero de Documento: ");
        String numdoc = leerTexto();
        System.out.println("Stock: ");
        String correo = leerTexto();
        System.out.println("Tipo: ");
        String tipo = leerTexto();
        System.out.println("Estado: ");
        String estado = leerTexto();

        if (clienteExiste(tipodoc, numdoc) == 0){
            c.ejecutarProcedimientoSinDatos("call crearFlor('" + nombres + "', '" + apellidos + "', '" + tipodoc + "', '" + numdoc + "', '" + correo + "','" + tipo + "','" + estado + "')");
            System.out.println("Cliente creado correctamente...");
        }
        else{
            System.out.println("El cliente ya existe...");
            System.out.println("Intentelo Nuevamente...");
        }
    }
    public static void eliminarCliente(){
        conector c = new conector();
        System.out.println("Ingrese el ID a eliminar: ");
        int ID = leerEnteroPositivo();

        if (clienteExisteID(ID) > 0){
            c.ejecutarProcedimientoSinDatos("call eliminarcliente(" + ID + ")");
            System.out.println("Cliente eliminado correctamente");
        }
        else{
            System.out.println("El cliente no existe...");
            System.out.println("Intentelo Nuevamente...");
        }
    }

    public static void actualizarCliente(){
        conector c = new conector();

        System.out.println("Ingrese el ID");
        int ID = leerEnteroPositivo();

        if (clienteExisteID(ID) > 0){
            System.out.println("Ingrese los datos del nuevo cliente");
            System.out.println("Nombres: ");
            String nombres = leerTexto();
            System.out.println("Apellidos: ");
            String apellidos = leerTexto();
            System.out.println("Tipo de Documento: ");
            String tipodoc = leerTexto();
            System.out.println("Numero de Documento: ");
            String numdoc = leerTexto();
            System.out.println("Stock: ");
            String correo = leerTexto();
            System.out.println("Tipo: ");
            String tipo = leerTexto();
            System.out.println("Estado: ");
            String estado = leerTexto();
            c.ejecutarProcedimientoSinDatos("call actualizarFlor(" + ID + ", '" + nombres + "', '" + apellidos + "', '" + tipodoc + "', '" + numdoc + "', '" + correo + "','" + tipo + "','" + estado + "')");
            System.out.println("Cliente actualizado correctamente...");
        }
        else{
            System.out.println("El cliente no existe...");
            System.out.println("Intentelo Nuevamente...");
        }
    }

    public static void mostrarCliente(){
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call listarcliente()");

        System.out.print(validarATexto("ID", 5));
        System.out.print(validarATexto("NOMBREs", 25));
        System.out.print(validarATexto("APELLIDOS", 25));
        System.out.print(validarATexto("TIPO DE DOCUMENTO", 25));
        System.out.print(validarATexto("NUMERO DE DOCUMENTO", 25));
        System.out.print(validarATexto("CORREO", 30));
        System.out.print(validarATexto("TIPO", 25));
        System.out.print(validarATexto("ESTADO", 25) + "\n");

        for (List<String> dato: data ) {
            System.out.print(validarATexto(dato.get(0), 5));
            System.out.print(validarATexto(dato.get(1), 25));
            System.out.print(validarATexto(dato.get(2), 25));
            System.out.print(validarATexto(dato.get(3), 25));
            System.out.print(validarATexto(dato.get(4), 25));
            System.out.print(validarATexto(dato.get(5), 30));
            System.out.print(validarATexto(dato.get(6), 25));
            System.out.print(validarATexto(dato.get(7), 25) + "\n");
        }
    }
    public static int vendedorExisteID(int ID){
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call vExisteID(" + ID + ")");
        List<String> dato = data.get(0);
        return Integer.parseInt(dato.get(0));
    }
    public static int vendedorExiste(String nombres, String apellidos){
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call fExiste('" + nombres + "','" + apellidos + "')");
        List<String> dato = data.get(0);
        return Integer.parseInt(dato.get(0));
    }
    public static void crearVendedor(){
        conector c = new conector();

        System.out.println("Ingrese los datos del nuevo vendedor");
        System.out.println("Nombres: ");
        String nombres = leerTexto();
        System.out.println("Apellidos: ");
        String apellidos = leerTexto();
        System.out.println("Correo: ");
        String correo = leerTexto();
        System.out.println("Comision: ");
        String comision = leerTexto();
        System.out.println("Estado: ");
        String estado = leerTexto();

        if (vendedorExiste(nombres, apellidos) == 0){
            c.ejecutarProcedimientoSinDatos("call crearvendedor('" + nombres + "', '" + apellidos + "', '" + correo + "','" + comision + "','" + estado + "')");
            System.out.println("Vendedor creado correctamente...");
        }
        else{
            System.out.println("El vendedor ingresado ya existe...");
            System.out.println("Intentelo Nuevamente...");
        }
    }
    public static void eliminarVendedor(){
        conector c = new conector();
        System.out.println("Ingrese el ID a eliminar: ");
        int ID = leerEnteroPositivo();

        if (vendedorExisteID(ID) > 0){
            c.ejecutarProcedimientoSinDatos("call eliminarvendedor(" + ID + ")");
            System.out.println("Vendedor eliminado correctamente");
        }
        else{
            System.out.println("El vendedor ingresado no existe...");
            System.out.println("Intentelo Nuevamente...");
        }
    }

    public static void actualizarVendedor(){
        conector c = new conector();

        System.out.println("Ingrese el ID");
        int ID = leerEnteroPositivo();

        if (vendedorExisteID(ID) > 0){
            System.out.println("Ingrese los datos del nuevo vendedor");
            System.out.println("Nombres: ");
            String nombres = leerTexto();
            System.out.println("Apellidos: ");
            String apellidos = leerTexto();
            System.out.println("Correo: ");
            String correo = leerTexto();
            System.out.println("Comision: ");
            String comision = leerTexto();
            System.out.println("Estado: ");
            String estado = leerTexto();
            c.ejecutarProcedimientoSinDatos("call actualizarvendedor(" + ID + ", '" + nombres + "', '" + apellidos + "', '" + correo + "','" + comision + "','" + estado + "')");

            System.out.println("Vendedor actualizado correctamente...");
        }
        else{
            System.out.println("El vendedor ingresado no existe...");
            System.out.println("Intentelo Nuevamente...");
        }
    }

    public static void mostrarVendedor(){
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call listarvendedor()");

        System.out.print(validarATexto("ID", 5));
        System.out.print(validarATexto("NOMBRES", 25));
        System.out.print(validarATexto("APELLIDOS", 25));
        System.out.print(validarATexto("CORREO", 25));
        System.out.print(validarATexto("COMISION", 25));
        System.out.print(validarATexto("ESTADO", 25) + "\n");

        for (List<String> dato: data ) {
            System.out.print(validarATexto(dato.get(0), 5));
            System.out.print(validarATexto(dato.get(1), 25));
            System.out.print(validarATexto(dato.get(2), 25));
            System.out.print(validarATexto(dato.get(3), 25));
            System.out.print(validarATexto(dato.get(4), 25));
            System.out.print(validarATexto(dato.get(5), 25) + "\n");
        }
    }
    public static int florExisteID(int ID){
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call fExisteID(" + ID + ")");
        List<String> dato = data.get(0);
        return Integer.parseInt(dato.get(0));
    }
    public static int florExiste(String nombre, String aroma, String color){
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call fExiste('" + nombre + "','" + aroma + "','" + color + "')");
        List<String> dato = data.get(0);
        return Integer.parseInt(dato.get(0));
    }
    public static void crearFlor(){
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

        if (florExiste(nombre, aroma, color) == 0){
            c.ejecutarProcedimientoSinDatos("call crearFlor('" + nombre + "', '" + aroma + "', '" + color + "', " + precio + ", " + stock + ",'" + dtm + "','" + estado + "')");
            System.out.println("Flor creada correctamente...");
        }
        else{
            System.out.println("La flor ingresada ya existe...");
            System.out.println("Intentelo Nuevamente...");
        }
    }
    public static void eliminarFLor(){
        conector c = new conector();
        System.out.println("Ingrese el ID a eliminar: ");
        int ID = leerEnteroPositivo();

        if (florExisteID(ID) > 0){
            c.ejecutarProcedimientoSinDatos("call eliminarFlor(" + ID + ")");
            System.out.println("Flor eliminada correctamente");
        }
        else{
            System.out.println("La flor ingresada no existe...");
            System.out.println("Intentelo Nuevamente...");
        }
    }

    public static void actualizarFlor(){
        conector c = new conector();
        SimpleDateFormat FechaMysql = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dtm = "" + FechaMysql.format(new Date());

        System.out.println("Ingrese el ID");
        int ID = leerEnteroPositivo();

        if (florExisteID(ID) > 0){
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

            System.out.println("Flor actualizada correctamente...");
        }
        else{
            System.out.println("La flor ingresada no existe...");
            System.out.println("Intentelo Nuevamente...");
        }
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
        System.out.print(validarATexto("ESTADO", 25) + "\n");

        for (List<String> dato: data ) {
            System.out.print(validarATexto(dato.get(0), 5));
            System.out.print(validarATexto(dato.get(1), 25));
            System.out.print(validarATexto(dato.get(2), 25));
            System.out.print(validarATexto(dato.get(3), 25));
            System.out.print(validarATexto(dato.get(4), 10));
            System.out.print(validarATexto(dato.get(5), 10));
            System.out.print(validarATexto(dato.get(6), 30));
            System.out.print(validarATexto(dato.get(7), 25) + "\n");
        }
    }
    public static String validarATexto(String texto, int tamanio){
        while (texto.length() < tamanio){
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
        boolean flag = true;
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
        boolean flag = true;
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
        String texto;
        Scanner teclado;
        teclado = new Scanner(System.in);
        texto = teclado.nextLine();
        return texto;
    }
    //Menus
    public static void menuPrincipal(){
        System.out.println("*********** MENU PRINCIPAL ***********");
        System.out.println("0- Salir");
        System.out.println("1- Gestionar Flores.");
        System.out.println("2- Gestionar Clientes.");
        System.out.println("3- Gestionar Vendedores.");
        System.out.println("  << Ingrese una opción >>  ");
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
    public static void crudFlores(){
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
                    crearFlor();
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
    public static void crudClientes(){
        int opcion;
        do {
            menuClases("CLIENTES");
            opcion = leerEnteroPositivo();
            switch (opcion){
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                case 1:
                    //Agregar
                    crearCliente();
                    break;
                case 2:
                    //Mostrar
                    mostrarCliente();
                    break;
                case 3:
                    //Actualizar
                    actualizarCliente();
                    break;
                case 4:
                    //Eliminar
                    eliminarCliente();
                    break;
                default:
                    System.out.println("Opción fuera de rango");
                    break;
            }
        }while (opcion != 0);
    }
    public static void crudVendedores(){
        int opcion;
        do {
            menuClases("VENDEDORES");
            opcion = leerEnteroPositivo();
            switch (opcion){
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                case 1:
                    //Agregar
                    crearVendedor();
                    break;
                case 2:
                    //Mostrar
                    mostrarVendedor();
                    break;
                case 3:
                    //Actualizar
                    actualizarVendedor();
                    break;
                case 4:
                    //Eliminar
                    eliminarVendedor();
                    break;
                default:
                    System.out.println("Opción fuera de rango");
                    break;
            }
        }while (opcion != 0);
    }
    public static void main(String[] args) {
        int opcionPrincipal;
        do{
            menuPrincipal();
            opcionPrincipal = leerEnteroPositivo();
            switch(opcionPrincipal){
                case 0:
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    crudFlores();
                    break;
                case 2:
                    crudClientes();
                    break;
                case 3:
                    crudVendedores();
                    break;
                default:
                    System.out.println("Opción fuera de rango");
                    break;
            }
        } while (opcionPrincipal != 0);
    }
}