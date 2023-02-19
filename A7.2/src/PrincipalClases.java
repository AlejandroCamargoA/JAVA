import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PrincipalClases {
    //Declarar listas globales
    private static List<Object> flores = new ArrayList<Object>();
    private static List<Object> clientes = new ArrayList<Object>();
    private static List<Object> vendedores = new ArrayList<Object>();
    private static List<Object> ventas = new ArrayList<Object>();
    private static List<Object> detalleVenta = new ArrayList<Object>();

    //VALIDACIONES y FUNCIONES BASICAS

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
        texto = texto.toUpperCase();
        return texto;
    }
    //Para Mostrar las listas de manera ordenada
    public static String validarATexto(String texto, int tamaño){
        while (texto.length() < tamaño){
            texto = texto + " ";
        }
        return texto;
    }
    //Validar existencia en lista
    public static boolean confirmarExistenciaO(List<Object> objetos, Object objeto){
        boolean flag = false;
        if (objetos.size() > 0){
            Object obj = objetos.get(0);
            if (obj instanceof CFlor){
                CFlor flor = (CFlor) objeto;
                for (Object f : objetos) {
                    CFlor fl = (CFlor) f;
                    if (fl.getNombre().equals(flor.getNombre()) && fl.getColor().equals(flor.getColor())) {
                        flag = true;
                    }
                }
            }
            if (obj instanceof CCliente){
                CCliente cliente = (CCliente) objeto;
                for (Object c : objetos) {
                    CCliente cl = (CCliente) c;
                    if (cl.getNumDocumento().equals(cliente.getNumDocumento())) {
                        flag = true;
                    }
                }
            }
            if (obj instanceof CVendedor){
                CVendedor vendedor = (CVendedor) objeto;
                for (Object v : objetos) {
                    CVendedor vl = (CVendedor) v;
                    if (vl.getNumDocumento().equals(vendedor.getNumDocumento())) {
                        flag = true;
                    }
                }
            }
        }
        else {
            System.out.println("La lista se encuentra vacia");
            System.out.println("Ingrese datos primero");
        }
        return flag;
    }
    //Validar existencia en lista por clave
    public static boolean confirmarExistenciaC(String att1, String att2, List<Object> objetos){
        boolean flag = false;
        if (objetos.size() > 0){
            Object obj = objetos.get(0);
            if (obj instanceof CFlor){
                for (Object f : objetos) {
                    CFlor fl = (CFlor) f;
                    if (fl.getNombre().equals(att1) && fl.getColor().equals(att2)) {
                        flag = true;
                    }
                }
            }
            if (obj instanceof CCliente){
                for (Object c : objetos) {
                    CCliente cl = (CCliente) c;
                    if (cl.getNumDocumento().equals(att1)) {
                        flag = true;
                    }
                }
            }
            if (obj instanceof CVendedor){
                for (Object v : objetos) {
                    CVendedor vl = (CVendedor) v;
                    if (vl.getNumDocumento().equals(att1)) {
                        flag = true;
                    }
                }
            }
        }
        else {
            System.out.println("La lista se encuentra vacia");
            System.out.println("Ingrese datos primero");
        }
        return flag;
    }

    //FUNCIONES DIRECTAMENTE UTILES
    public static void mostrarTodo(List<Object> objetos){
        if (objetos.size() > 0){
            Object obj = objetos.get(0);
            if (obj instanceof CFlor){
                System.out.println(validarATexto("NOMBRE",20) + validarATexto("COLOR",20) + validarATexto("AROMA",20) + validarATexto("PRECIO",20));
                for (Object f: objetos) {
                    CFlor fl = (CFlor) f;
                    fl.mostrarCLista();
                    System.out.println("");
                }
            }
            if (obj instanceof CCliente){
                System.out.println(validarATexto("TIPO DE DOCUMENTO",25) + validarATexto("NÚMERO DE DOCUMENTO",25) + validarATexto("NOMBRES",25) + validarATexto("APELLIDOS",25) + validarATexto("CORREO",25) + validarATexto("ESTADO",25) + validarATexto("TIPO",25));
                for (Object c: objetos) {
                    CCliente cl = (CCliente) c;
                    cl.mostrarCLista();
                    System.out.println("");
                }
            }
            if (obj instanceof CVendedor){
                System.out.println(validarATexto("ID DE VENDEDOR",25) + validarATexto("TIPO DE DOCUMENTO",25) + validarATexto("NÚMERO DE DOCUMENTO",25) + validarATexto("NOMBRES",25) + validarATexto("APELLIDOS",25) + validarATexto("CORREO",25) + validarATexto("CONTRASEÑA",25) + validarATexto("ESTADO",25));
                for (Object v: objetos) {
                    CVendedor vl = (CVendedor) v;
                    vl.mostrarCLista();
                    System.out.println("");
                }
            }
        }
        else {
            System.out.println("La lista se encuentra vacia");
            System.out.println("Ingrese datos primero");
        }
    }
    //Brindar un objeto de la lista por una posicion dada
    public static Object darObjetoPorPosicion(int posicion, List<Object> objetos){
        Object objeto;
        if (objetos.size() == 0){
            System.out.println("La lista se encuentra vacia");
            System.out.println("Ingrese datos primero");
            objeto = null;
        }
        else if (posicion > objetos.size()-1){
            System.out.println("Esa posición no existe");
            System.out.println("No se ejecutó la instrucción");
            objeto = null;
        }
        else {
            objeto = objetos.get(posicion);
        }
        return objeto;
    }
    //Brindar un objeto de la lista por una clave dada
    public static Object darObjetoPorClave(String att1, String att2, List<Object> objetos){
        Object objeto = null;
        if (objetos.size() == 0){
            System.out.println("La lista se encuentra vacia");
            System.out.println("Ingrese datos primero");
            objeto = null;
        }
        else {
            Object obj = objetos.get(0);
            if (obj instanceof CFlor){
                boolean flag = true;
                for (Object f : objetos) {
                    CFlor fl = (CFlor) f;
                    if (fl.getNombre().equals(att1) && fl.getColor().equals(att2)) {
                        objeto = fl;
                        flag = false;
                    }
                }
                if (flag){
                    System.out.println("La clave ingresada no existe");
                    System.out.println("No se ejecuto la instrucción");
                }
            }
            if (obj instanceof CCliente){
                boolean flag = true;
                for (Object c : objetos) {
                    CCliente cl = (CCliente) c;
                    if (cl.getNumDocumento().equals(att1)) {
                        objeto = cl;
                        flag = false;
                    }
                }
                if (flag){
                    System.out.println("La clave ingresada no existe");
                    System.out.println("Regresando...");
                }
            }
            if (obj instanceof CVendedor){
                boolean flag = true;
                for (Object v : objetos) {
                    CVendedor vl = (CVendedor) v;
                    if (vl.getNumDocumento().equals(att1)) {
                        objeto = vl;
                        flag = false;
                    }
                }
                if (flag){
                    System.out.println("La clave ingresada no existe");
                    System.out.println("Regresando...");
                }
            }
        }
        return objeto;
    }
    //Borrar toda la lista
    public static void eliminarTodo(List<Object> objetos){
        int op;
        System.out.println("Estas a punto de eliminar toda la lista");
        System.out.println("¿Estás seguro?");
        System.out.println("(1) SI  (Otro número) NO");
        op = leerEnteroPositivo();
        if (op == 1){
            objetos.clear();
            System.out.println("La lista fue eliminada correctamente");
        }
        else {
            System.out.println("No se eliminó la lista");
        }
    }
    //Agregar nuevo dato en lista
    public static void agregarNuevo(List<Object> objetos, Object objeto){
        if (objetos.size() == 0){
            System.out.println("El objeto fue agregado a la lista correctamente");
            objetos.add(objeto);
        }
        else {
            if (confirmarExistenciaO(objetos, objeto)){
                System.out.println("No se puede ingresar por que el objeto ya existe en la lista");
                System.out.println("No se ejecutó la instrucción");
            }
            else {
                System.out.println("El objeto fue agregado a la lista correctamente");
                objetos.add(objeto);
            }
        }
    }
    //Actualizar
    public static void actualizar(List<Object> objetos, Object objeto){
        if (objetos.size() > 0){
            Object obj = objetos.get(0);
            if (obj instanceof CFlor){
                CFlor f = (CFlor) objetos.get(objetos.indexOf(objeto));
                System.out.println("Ingrese el nuevo aroma: ");
                f.setAroma(leerTexto());
                System.out.println("Ingrese el nuevo precio: ");
                f.setPrecio(leerDecimalPositivo());
                objetos.set(objetos.indexOf(objeto), f);
                System.out.println("Actualizado correctamente");
            }
            if (obj instanceof CCliente){
                CCliente c = (CCliente) objetos.get(objetos.indexOf(objeto));
                System.out.println("Ingrese los nuevos nombres: ");
                c.setNombres(leerTexto());
                System.out.println("Ingrese los nuevos apellidos: ");
                c.setApellidos(leerTexto());
                System.out.println("Ingrese el nuevo correo: ");
                c.setCorreo(leerTexto());
                System.out.println("Ingrese el nuevo estado: ");
                c.setEstado(leerTexto());
                System.out.println("Ingrese el nuevo tipo: ");
                c.setTipo(leerTexto());
                objetos.set(objetos.indexOf(objeto), c);
                System.out.println("Actualizado correctamente");
            }
            if (obj instanceof CVendedor){
                CVendedor v = (CVendedor) objetos.get(objetos.indexOf(objeto));
                System.out.println("Ingrese los nuevos nombres: ");
                v.setNombres(leerTexto());
                System.out.println("Ingrese los nuevos apellidos: ");
                v.setApellidos(leerTexto());
                System.out.println("Ingrese el nuevo correo: ");
                v.setCorreo(leerTexto());
                System.out.println("Ingrese la nueva contraseña: ");
                v.setContrasenya(leerTexto());
                System.out.println("Ingrese el nuevo estado: ");
                v.setEstado(leerTexto());
                objetos.set(objetos.indexOf(objeto), v);
                System.out.println("Actualizado correctamente");
            }
        }
        else {
            System.out.println("La lista se encuentra vacia");
            System.out.println("Ingrese datos primero");
        }
    }
    //Actualizar Todo
    public static void actualizarTodo(List<Object> objetos){
        if (objetos.size() > 0){
            int op;
            System.out.println("Estas a punto de actualizar toda la lista");
            System.out.println("tiene " + objetos.size() + " elementos ¿Estás seguro?");
            System.out.println("(1) SI  (Otro número) NO");
            op = leerEnteroPositivo();
            if (op == 1){
                Object obj = objetos.get(0);
                if (obj instanceof CFlor){
                    for (Object f : objetos) {
                        CFlor fl = (CFlor) f;
                        actualizar(objetos, fl);
                    }
                }
                if (obj instanceof CCliente){
                    for (Object c : objetos) {
                        CCliente cl = (CCliente) c;
                        actualizar(objetos, cl);
                    }
                }
                if (obj instanceof CVendedor){
                    for (Object v : objetos) {
                        CVendedor vl = (CVendedor) v;
                        actualizar(objetos, vl);
                    }
                }
            }
            else {
                System.out.println("No se actualizó la lista");
            }
        }
        else {
            System.out.println("La lista se encuentra vacia");
            System.out.println("Ingrese datos primero");
        }
    }

    //MENúS
    public static void menuPrincipal(){
        System.out.println("*********** MENU PRINCIPAL ***********");
        System.out.println("0- Salir");
        System.out.println("1- Gestionar Flores.");
        System.out.println("2- Gestionar Clientes.");
        System.out.println("3- Gestionar Vendedores.");
        System.out.println("4- Gestionar Ventas.");
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

    //CRUDs
    public static void CRUDFlores(){
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
                    System.out.println("¿Cuántas Flores quieres agregar?");
                    int cantAgregar = leerEnteroPositivo();
                    CFlor flor;
                    if (cantAgregar < 1){
                        System.out.println("Solo se admiten numeros mayores a 0");
                        System.out.println("Regresando al menú flores...");
                    }else {
                        for (int i = 0; i < cantAgregar; i++) {
                            System.out.println("Ingrese los datos de la nueva flor");
                            flor = new CFlor();
                            agregarNuevo(flores, flor);
                        }
                    }
                    break;
                case 2:
                    //Mostrar
                    int opcionMostrarFlores;
                    do {
                        subMenus("Flores", "Mostrar");
                        opcionMostrarFlores = leerEnteroPositivo();
                        switch (opcionMostrarFlores){
                            case 0:
                                System.out.println("Regresando al menú flores...");
                                break;
                            case 1:
                                System.out.println("Ingrese la posición de la flor buscada");
                                int florPorPos = leerEnteroPositivo();
                                CFlor f1 = (CFlor) darObjetoPorPosicion(florPorPos, flores);
                                if (f1 != null){
                                    f1.mostrar();
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el nombre y el color de la flor buscada: ");
                                System.out.println("Nombre: ");
                                String n = leerTexto();
                                System.out.println("Color: ");
                                String c = leerTexto();
                                CFlor f2 = (CFlor) darObjetoPorClave(n, c, flores);
                                if (f2 != null){
                                    f2.mostrar();
                                }
                                break;
                            case 3:
                                mostrarTodo(flores);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionMostrarFlores != 0);
                    break;
                case 3:
                    //Actualizar
                    int opcionActualizarFlores;
                    do {
                        subMenus("Flores", "Actualizar");
                        opcionActualizarFlores = leerEnteroPositivo();
                        switch (opcionActualizarFlores){
                            case 0:
                                System.out.println("Regresando al menú flores...");
                                break;
                            case 1:
                                System.out.println("Ingrese la posición de la flor a actualizar");
                                int florPorPos = leerEnteroPositivo();
                                CFlor flor1 = (CFlor) darObjetoPorPosicion(florPorPos, flores);
                                if (flor1 != null){
                                    actualizar(flores, flor1);
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el nombre y el color de la flor a actualizar: ");
                                System.out.println("Nombre: ");
                                String n = leerTexto();
                                System.out.println("Color: ");
                                String c = leerTexto();
                                CFlor flor2 = (CFlor) darObjetoPorClave(n, c, flores);
                                if (flor2 != null){
                                    actualizar(flores, flor2);
                                }
                                break;
                            case 3:
                                actualizarTodo(flores);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionActualizarFlores != 0);
                    break;
                case 4:
                    int opcionEliminarFlores;
                    do {
                        subMenus("Flores", "Eliminar");
                        opcionEliminarFlores = leerEnteroPositivo();
                        switch (opcionEliminarFlores){
                            case 0:
                                System.out.println("Regresando al menú flores...");
                                break;
                            case 1:
                                System.out.println("Ingrese la posición de la flor a eliminar");
                                int florPorPos = leerEnteroPositivo();
                                CFlor flor1 = (CFlor) darObjetoPorPosicion(florPorPos, flores);
                                if (flor1 != null){
                                    flores.remove(flor1);
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el nombre y el color de la flor a eliminar: ");
                                System.out.println("Nombre: ");
                                String n = leerTexto();
                                System.out.println("Color: ");
                                String c = leerTexto();
                                CFlor flor2 = (CFlor) darObjetoPorClave(n, c, flores);
                                if (flor2 != null){
                                    flores.remove(flor2);
                                }
                                break;
                            case 3:
                                eliminarTodo(flores);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionEliminarFlores != 0);
                    break;
                default:
                    System.out.println("Opción fuera de rango");
                    break;
            }
        }while (opcion != 0);
    }
    public static void CRUDClientes(){
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
                    System.out.println("¿Cuántos Clientes quieres agregar?");
                    int cantAgregar = leerEnteroPositivo();
                    CCliente cliente;
                    if (cantAgregar < 1){
                        System.out.println("Solo se admiten numeros mayores a 0");
                        System.out.println("Regresando al menú clientes...");
                    }else {
                        for (int i = 0; i < cantAgregar; i++) {
                            System.out.println("Ingrese los datos del nuevo cliente");
                            cliente = new CCliente();
                            agregarNuevo(clientes, cliente);
                        }
                    }
                    break;
                case 2:
                    //Mostrar
                    int opcionMostrarClientes;
                    do {
                        subMenus("Clientes", "Mostrar");
                        opcionMostrarClientes = leerEnteroPositivo();
                        switch (opcionMostrarClientes){
                            case 0:
                                System.out.println("Regresando al menú clientes...");
                                break;
                            case 1:
                                System.out.println("Ingrese la posición del cliente buscado");
                                int clientePorPos = leerEnteroPositivo();
                                CCliente c1 = (CCliente) darObjetoPorPosicion(clientePorPos, clientes);
                                if (c1 != null){
                                    c1.mostrar();
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el número de documento del cliente buscado: ");
                                System.out.println("DNI o RUC: ");
                                String n = leerTexto();
                                CCliente c2 = (CCliente) darObjetoPorClave(n, "", clientes);
                                if (c2 != null){
                                    c2.mostrar();
                                }
                                break;
                            case 3:
                                mostrarTodo(clientes);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionMostrarClientes != 0);
                    break;
                case 3:
                    //Actualizar
                    int opcionActualizarClientes;
                    do {
                        subMenus("Clientes", "Actualizar");
                        opcionActualizarClientes = leerEnteroPositivo();
                        switch (opcionActualizarClientes){
                            case 0:
                                System.out.println("Regresando al menú clientes...");
                                break;
                            case 1:
                                System.out.println("Ingrese la posición del cliente a actualizar");
                                int clientePorPos = leerEnteroPositivo();
                                CCliente c1 = (CCliente) darObjetoPorPosicion(clientePorPos, clientes);
                                if (c1 != null){
                                    actualizar(clientes, c1);
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el número de documento del cliente a actualizar: ");
                                System.out.println("DNI o RUC: ");
                                String n = leerTexto();
                                CCliente c2 = (CCliente) darObjetoPorClave(n, "", clientes);
                                if (c2 != null){
                                    actualizar(clientes, c2);
                                }
                                break;
                            case 3:
                                actualizarTodo(clientes);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionActualizarClientes != 0);
                    break;
                case 4:
                    int opcionEliminarClientes;
                    do {
                        subMenus("Clientes", "Eliminar");
                        opcionEliminarClientes = leerEnteroPositivo();
                        switch (opcionEliminarClientes){
                            case 0:
                                System.out.println("Regresando al menú clientes...");
                                break;
                            case 1:
                                System.out.println("Ingrese la posición del cliente a eliminar");
                                int clientePorPos = leerEnteroPositivo();
                                CCliente c1 = (CCliente) darObjetoPorPosicion(clientePorPos, clientes);
                                if (c1 != null){
                                    clientes.remove(c1);
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el número de documento del cliente a eliminar: ");
                                System.out.println("DNI o RUC: ");
                                String n = leerTexto();
                                CCliente c2 = (CCliente) darObjetoPorClave(n, "", clientes);
                                if (c2 != null){
                                    clientes.remove(c2);
                                }
                                break;
                            case 3:
                                eliminarTodo(clientes);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionEliminarClientes != 0);
                    break;
                default:
                    System.out.println("Opción fuera de rango");
                    break;
            }
        }while (opcion != 0);
    }
    public static void CRUDVendedores(){
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
                    System.out.println("¿Cuántos Vendedores quieres agregar?");
                    int cantAgregar = leerEnteroPositivo();
                    CVendedor vendedor;
                    if (cantAgregar < 1){
                        System.out.println("Solo se admiten numeros mayores a 0");
                        System.out.println("Regresando al menú vendedores...");
                    }else {
                        for (int i = 0; i < cantAgregar; i++) {
                            System.out.println("Ingrese los datos del nuevo vendedor");
                            vendedor = new CVendedor();
                            agregarNuevo(vendedores, vendedor);
                        }
                    }
                    break;
                case 2:
                    //Mostrar
                    int opcionMostrarVendedores;
                    do {
                        subMenus("Vendedores", "Mostrar");
                        opcionMostrarVendedores = leerEnteroPositivo();
                        switch (opcionMostrarVendedores){
                            case 0:
                                System.out.println("Regresando al menú vendedores...");
                                break;
                            case 1:
                                System.out.println("Ingrese la posición del vendedor buscado");
                                int vendedorPorPos = leerEnteroPositivo();
                                CVendedor v1 = (CVendedor) darObjetoPorPosicion(vendedorPorPos, vendedores);
                                if (v1 != null){
                                    v1.mostrar();
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el número de documento del vendedor buscado: ");
                                System.out.println("DNI o RUC: ");
                                String n = leerTexto();
                                CVendedor v2 = (CVendedor) darObjetoPorClave(n, "", vendedores);
                                if (v2 != null){
                                    v2.mostrar();
                                }
                                break;
                            case 3:
                                mostrarTodo(vendedores);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionMostrarVendedores != 0);
                    break;
                case 3:
                    //Actualizar
                    int opcionActualizarVendedores;
                    do {
                        subMenus("Vendedores", "Actualizar");
                        opcionActualizarVendedores = leerEnteroPositivo();
                        switch (opcionActualizarVendedores){
                            case 0:
                                System.out.println("Regresando al menú vendedores...");
                                break;
                            case 1:
                                System.out.println("Ingrese la posición del vendedor a actualizar");
                                int vendedorPorPos = leerEnteroPositivo();
                                CVendedor v1 = (CVendedor) darObjetoPorPosicion(vendedorPorPos, vendedores);
                                if (v1 != null){
                                    actualizar(vendedores, v1);
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el número de documento del vendedor a actualizar: ");
                                System.out.println("DNI o RUC: ");
                                String n = leerTexto();
                                CVendedor v2 = (CVendedor) darObjetoPorClave(n, "", vendedores);
                                if (v2 != null){
                                    actualizar(vendedores, v2);
                                }
                                break;
                            case 3:
                                actualizarTodo(vendedores);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionActualizarVendedores != 0);
                    break;
                case 4:
                    int opcionEliminarVendedores;
                    do {
                        subMenus("Vendedores", "Eliminar");
                        opcionEliminarVendedores = leerEnteroPositivo();
                        switch (opcionEliminarVendedores){
                            case 0:
                                System.out.println("Regresando al menú vendedores...");
                                break;
                            case 1:
                                System.out.println("Ingrese la posición del vendedor a eliminar");
                                int VendedorPorPos = leerEnteroPositivo();
                                CVendedor v1 = (CVendedor) darObjetoPorPosicion(VendedorPorPos, vendedores);
                                if (v1 != null){
                                    vendedores.remove(v1);
                                }
                                break;
                            case 2:
                                System.out.println("Ingrese el número de documento del vendedor a eliminar: ");
                                System.out.println("DNI o RUC: ");
                                String n = leerTexto();
                                CVendedor v2 = (CVendedor) darObjetoPorClave(n, "", vendedores);
                                if (v2 != null){
                                    vendedores.remove(v2);
                                }
                                break;
                            case 3:
                                eliminarTodo(vendedores);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionEliminarVendedores != 0);
                    break;
                default:
                    System.out.println("Opción fuera de rango");
                    break;
            }
        }while (opcion != 0);
    }

    //MAIN
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
                    CRUDFlores();
                    break;
                case 2:
                    CRUDClientes();
                    break;
                case 3:
                    CRUDVendedores();
                    break;
                case 4: //Gestionar Ventas
                    int opcionVentas;
                    do{
                        opcionVentas = menuVentas();
                        switch (opcionVentas){
                            case 0:
                                System.out.println("... Regresando al menu principal.");
                                opcionVentas = 0;
                                break;
                            case 1: // Resgistrar una venta
                                String tipoDocumento;
                                String numDocumento;
                                do{
                                    System.out.println("Seleccione tipo de documento:");
                                    System.out.println("  (F) Factura        (B) Boleta     (*) para salir");
                                    tipoDocumento = new Scanner(System.in).nextLine(); // Factura | Boleta
                                    if(tipoDocumento.equals("F")){
                                        System.out.println("GENERANDO FACTURA");
                                    }else{
                                        if(tipoDocumento.equals("B"))
                                            System.out.println("GENERANDO BOLETA DE VENTA");
                                        else {
                                            System.out.println("Error ...");
                                            opcionVentas = 0;
                                        }
                                    }
                                } while (!tipoDocumento.equals("B") && !tipoDocumento.equals("F"));
                                System.out.println("Ingrese el DNI del cliente:");
                                String dniCliente = leerTexto(); // 00000006
                                if(dniExiste(dniCliente))
                                    System.out.println("El cliente existe");
                                else{
                                    System.out.println("No se encontro un cliente con ese numero de documento");
                                    System.out.println("Por favor ingrese otro DNI o agrege un nuevo cliente");
                                    System.out.println(" (N) Nuevo DNI     (A) Agregar cliente   (*) Para salir");
                                    String accion = new Scanner(System.in).nextLine(); // N | A | fjhdlkjh
                                    switch (accion){
                                        case "N":
                                            System.out.println("Ingrese el DNI del cliente:");
                                            dniCliente = new Scanner(System.in).nextLine();
                                            break;
                                        case "A":
                                            System.out.println("Registrando nuevo cliente");
                                            CCliente cliente = new CCliente();
                                            agregarNuevo(clientes, cliente);
                                            dniCliente = cliente.getNumDocumento();
                                            break;
                                    }
                                }
                                numDocumento = ingresarNumDocVenta();
                                CVenta v = new CVenta(numDocumento,
                                        tipoDocumento,
                                        numDocumento,
                                        new Date(),
                                        "Unico Vendedor",
                                        dniCliente,
                                        0,
                                        0,
                                        0,
                                        "Proceso"
                                );
                                ventas.add(v);
                                System.out.println("");
                                while (flores.size() == 0){
                                    System.out.println("No ha registrado ninguna flor");
                                    System.out.println("Para registrar la venta debe ingresar al menos una flor");
                                    System.out.println("¿Cuántas Flores quieres agregar?");
                                    int cantAgregar = leerEnteroPositivo();
                                    CFlor flor1;
                                        for (int i = 0; i < cantAgregar; i++) {
                                            System.out.println("Ingrese los datos de la nueva flor");
                                            CFlor flor = new CFlor();
                                            agregarNuevo(flores, flor);
                                        }
                                }
                                System.out.println("Mostrando Todas las flores");
                                mostrarTodo(flores);
                                System.out.println("Agregar flor a la venta, Seleccione la flor que quiera agregar:");
                                String agregarFlores;
//                                List<CFlor> floresVendidas = new ArrayList<CFlor>();
                                double pTotal = 0;

                                do{
                                    System.out.println("(A) Agregar flor    (otro) terminar");
                                    agregarFlores = leerTexto();
                                    if(agregarFlores.equals("A")) {
                                        System.out.print("Seleccione posición de la flor para vender:");
                                        int posFlorVenta = leerEnteroPositivo();

                                        if (posFlorVenta > flores.size()-1){
                                            System.out.println("Esa posición no existe");
                                            System.out.println("Intentelo nuevamente...");
                                        }else {
                                            // Pregunta cuantas quiere
                                            System.out.println("Cantidad: ");
                                            int cantidad = leerEnteroPositivo();

                                            CFlor f2 = (CFlor) flores.get(posFlorVenta);
//                                    f2.mostrar();
//                                    floresVendidas.add(f2);

                                            pTotal = pTotal + (f2.getPrecio()*cantidad);

                                            CDetalleVenta dv = new CDetalleVenta(
                                                    detalleVenta.size(),
                                                    numDocumento,
                                                    f2.getNombre() + " " + f2.getColor(),
                                                    cantidad,
                                                    0,
                                                    f2.getPrecio()*cantidad
                                            );
                                            detalleVenta.add(dv);
//                                        detalleVenta.get(detalleVenta.size()-1).setIdDetalleVenta(detalleVenta.indexOf(dv));
//                                        detalleVenta.get(detalleVenta.size()-1).setIdDetalleVenta(detalleVenta.size()-1);
                                        }
                                    }
                                }while(agregarFlores.equals("A"));

//                                for (CDetalleVenta dv1:detalleVenta) {
//                                    if(dv1.getIdVenta()==ventas.size()-1){
//                                        pTotal+=dv1.getPrecio()* dv1.getCantidad();
//                                    }
//                                }
                                double igv = pTotal*0.18;
                                DecimalFormat formato1 = new DecimalFormat("#.00");

                                v.setIDVenta(numDocumento);
                                v.setIGV(pTotal*0.18);
                                v.setDescuento(descuetoGlobal());
                                v.setPrecioTotal(pTotal);
                                v.setEstado("Activo");
                                System.out.println("");
                                System.out.println("Venta registrada correctamente... ");
                                System.out.println("Mostrando documento de venta:");
                                v.mostrarLista();
                                System.out.println("Detalle de la venta:");
                                mostrarDetalleVenta(v.getIDVenta());
                                System.out.println("");
                                break;
                            case 2: //Anular Venta
                                System.out.println("Ingrese el Número del Documento a anular");
                                String idventatemp = leerTexto();
                                anularVenta(idventatemp);
                                break;
                            case 3: // Reporte de Ventas
                                mostrarVentas();
                                break;
                            default:
                                break;
                        }
                    } while( opcionVentas != 0 );
                    break;
                default:
                    System.out.println("Opción fuera de rango");
                    break;
            }
        } while (opcionPrincipal != 0);
    }
    public static void mostrarVentas(){
        if (ventas.size() == 0){
            System.out.println("La lista se encuentra vacia");
            System.out.println("No se ha registrado ninguna venta aún");
        }
        else {
            System.out.print(validarATexto("Tipo de Documento",20));
            System.out.print(validarATexto("Número de Documento",20));
            System.out.print(validarATexto("Fecha de la Venta",30));
            System.out.print(validarATexto("ID del Vendedor",20));
            System.out.print(validarATexto("ID del Cliente",20));
            System.out.print(validarATexto("Precio",20));
            System.out.print(validarATexto("IGV",20));
            System.out.print(validarATexto("Descuento",20));
            System.out.print(validarATexto("Estado",20));
            System.out.print(validarATexto("Precio Final",20));
            System.out.println("");
            for (Object v : ventas){
                CVenta vl = (CVenta) v;
                vl.mostrarCLista();
                double preciofinal = vl.getPrecioTotal() + vl.getIGV() - vl.getDescuento();
                System.out.println(validarATexto(" " + (preciofinal), 20));
                System.out.println("");
            }
        }
    }
    public static void anularVenta(String idventa){
        if (ventas.size() == 0){
            System.out.println("La lista se encuentra vacia");
            System.out.println("No se ha registrado ninguna venta aún");
        }
        else {
            boolean flag = true;
            for (Object v : ventas){
                CVenta vl = (CVenta) v;
                if (vl.getIDVenta().equals(idventa)){
                    CVenta v1 = (CVenta) ventas.get(ventas.indexOf(vl));
                    v1.setEstado("Inactivo");
                    ventas.set(ventas.indexOf(vl), v1);
                    System.out.println("Venta anulada correctamente");
                    flag = false;
                }
            }
            if (flag){
                System.out.println("El número de documento ingresado no existe");
            }
        }
    }
    public static int menuVentas(){
        System.out.println("0- Regresar al menu anterior.");
        System.out.println("1- Registrar nueva venta.");
        System.out.println("2- Anular venta.");
        System.out.println("3- Reporte de ventas.");
        System.out.print("   >> Ingrese una opción: ");
        return new Scanner(System.in).nextInt();
    }
    public static String ingresarNumDocVenta(){
        String numdoc = "";
        numdoc = "100" + ventas.size();
        System.out.println("Generando documento de venta Nª: " + numdoc);
        return numdoc;
    }
    public static double descuetoGlobal(){
        System.out.print("Ingrese el monto de descuento global: ");
        return new Scanner(System.in).nextDouble();
    }
    public static void mostrarDetalleVenta(String idVenta){
        System.out.println(validarATexto("ID",20) + validarATexto("ID Venta",20) + validarATexto("ID Producto", 20) + validarATexto("Cantidad", 20) + validarATexto("Descuento", 20) + validarATexto("Precio", 20));
        for (Object dv: detalleVenta) {
            CDetalleVenta dvl = (CDetalleVenta) dv;
            if(dvl.getIDVenta().equals(idVenta)){
                dvl.mostrarCLista();
                System.out.println("");
            }
        }
    }
    public static boolean dniExiste(String DNI){
        boolean flag = false;

        for (Object c : clientes) {
            CCliente cl = (CCliente) c;
            if (cl.getNumDocumento().equals(DNI)) {
                flag = true;
            }
        }

        return flag;
    }
}
