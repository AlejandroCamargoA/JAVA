import java.util.*;

public class PrincipalClases {
    private static List<Object> flores = new ArrayList<Object>();
    private static List<Object> clientes = new ArrayList<Object>();
    private static List<Object> vendedores = new ArrayList<Object>();
    private static List<CVenta> ventas = new ArrayList<CVenta>();
    private static List<CDetalleVenta> detalleVenta = new ArrayList<CDetalleVenta>();
    public static void mostrarFlores(List<Object> flores){
        System.out.println("NOMBRE              \t\tAROMA               \t\tCOLOR               \t\tPRECIO               ");
        for (Object flor: flores) {
            CFlor fl = (CFlor) flor;
            System.out.println(fl.getNombre()+"\t\t"+
                    fl.getAroma()+"\t\t"+
                    fl.getColor()+"\t\t"+
                    fl.getPrecio());
        }
    }

    public static void mostrarDetalleVenta(String idVenta){
        System.out.println("ID\tIDV\tIDP\tCant\tDes\tPre");
        for (CDetalleVenta dv: detalleVenta) {
            if(dv.getIDVenta().equals(idVenta)){
                dv.mostrarLista();
                System.out.println("");
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
        System.out.print("Num Documento: ");
        return new Scanner(System.in).nextLine();
    }

    public static double descuetoGlobal(){
        System.out.print("Ingrese el monto de descuento global: ");
        return new Scanner(System.in).nextDouble();
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
    public static boolean confimarExistencia(String att1, String att2, List<Object> objetos){
        boolean flag = false;
        if (objetos.size() != 0){
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
                    if (cl.getNombres().equals(att1) && cl.getApellidos().equals(att2)) {
                        flag = true;
                    }
                }
            }
            if (obj instanceof CVendedor){
                for (Object v : objetos) {
                    CVendedor vl = (CVendedor) v;
                    if (vl.getNombres().equals(att1) && vl.getApellidos().equals(att2)) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }
    public static void mostrarPorPos(int posicion, List<Object> objetos){
        Object obj = objetos.get(0);
        if (posicion > objetos.size()){
            System.out.println("La posición ingresada no existe");
            System.out.println("Regresando...");
        }
        else {
            if (obj instanceof CFlor){
                CFlor fl = (CFlor) objetos.get(posicion);
                fl.mostrar();
            }
            if (obj instanceof CCliente){
                CCliente cl = (CCliente) objetos.get(posicion);
                cl.mostrar();
            }
            if (obj instanceof CVendedor){
                CVendedor vl = (CVendedor) objetos.get(posicion);
                vl.mostrar();
            }
        }
    }
    public static void mostrarPorClave(String att1, String att2, List<Object> objetos){
        Object obj = objetos.get(0);
        if (obj instanceof CFlor){
            boolean flag = true;
            for (Object f : objetos) {
                CFlor fl = (CFlor) f;
                if (fl.getNombre().equals(att1) && fl.getColor().equals(att2)) {
                    fl.mostrar();
                    flag = false;
                }
            }
            if (flag){
                System.out.println("La clave ingresada no existe");
                System.out.println("Regresando...");
            }
        }
        if (obj instanceof CCliente){
            boolean flag = true;
            for (Object c : objetos) {
                CCliente cl = (CCliente) c;
                if (cl.getNombres().equals(att1) && cl.getApellidos().equals(att2)) {
                    cl.mostrar();
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
                if (vl.getNombres().equals(att1) && vl.getApellidos().equals(att2)) {
                    vl.mostrar();
                    flag = false;
                }
            }
            if (flag){
                System.out.println("La clave ingresada no existe");
                System.out.println("Regresando...");
            }
        }
    }
    public static void mostrarTodo(List<Object> objetos){
        Object obj = objetos.get(0);
        if (obj instanceof CFlor){
            for (Object f: objetos) {
                CFlor fl = (CFlor) f;
                System.out.println(fl.getNombre()+"\t"+
                        fl.getColor()+"\t"+
                        fl.getAroma()+"\t"+
                        fl.getPrecio());
            }
        }
        if (obj instanceof CCliente){
            for (Object c: objetos) {
                CCliente cl = (CCliente) c;
                System.out.println(
                        cl.getNombres()+"\t"+
                        cl.getApellidos()+"\t"+
                        cl.getTipoDocumento()+"\t"+
                        cl.getNumDocumento()+"\t"+
                        cl.getCorreo()+"\t"+
                        cl.getEstado()+"\t"+
                        cl.getTipo());
            }
        }
        if (obj instanceof CVendedor){
            for (Object v: objetos) {
                CVendedor vl = (CVendedor) v;
                System.out.println(vl.getIDVendedor()+"\t"+
                        vl.getNombres()+"\t"+
                        vl.getApellidos()+"\t"+
                        vl.getTipoDocumento()+"\t"+
                        vl.getNumDocumento()+"\t"+
                        vl.getCorreo()+"\t"+
                        vl.getContrasenya()+"\t"+
                        vl.getEstado());
            }
        }
    }
    public static void actualizarPorPos(int posicion, List<Object> objetos){
        Object obj = objetos.get(0);
        if (posicion > objetos.size()){
            System.out.println("La posición ingresada no existe");
            System.out.println("Regresando...");
        }
        else {
            if (obj instanceof CFlor){
                System.out.println("Ingrese los datos de la flor actualizada: ");
                CFlor f = new CFlor();
                if (confimarExistencia(f.getNombre(), f.getColor(), objetos)){
                    System.out.println("Error: Esa flor ya existe");
                    System.out.println("No se actualizó la flor...");
                }
                else {
                    objetos.set(posicion, f);
                    System.out.println("Flor actualizada correctamente");
                }
            }
            if (obj instanceof CCliente){
                System.out.println("Ingrese los datos del cliente actualizado: ");
                CCliente c = new CCliente();
                if (confimarExistencia(c.getNombres(), c.getApellidos(), objetos)){
                    System.out.println("Error: Ese cliente ya existe");
                    System.out.println("No se actualizó el cliente...");
                }
                else {
                    objetos.set(posicion, c);
                    System.out.println("Cliente actualizado correctamente");
                }
            }
            if (obj instanceof CVendedor){
                System.out.println("Ingrese los datos del vendedor actualizado: ");
                CVendedor v = new CVendedor();
                if (confimarExistencia(v.getNombres(), v.getApellidos(), objetos)){
                    System.out.println("Error: Ese vendedor ya existe");
                    System.out.println("No se actualizó el vendedor...");
                }
                else {
                    objetos.set(posicion, v);
                    System.out.println("Vendedor actualizado correctamente");
                }
            }
        }
    }
    public static void actualizarPorClave(String att1, String att2, List<Object> objetos){
        Object obj = objetos.get(0);
        if (obj instanceof CFlor){
            boolean flag = true;
            for (Object f : objetos) {
                CFlor fl = (CFlor) f;
                if (fl.getNombre().equals(att1) && fl.getColor().equals(att2)) {
                    System.out.println("Ingrese los datos de la flor actualizada: ");
                    CFlor fa = new CFlor();
                    if (confimarExistencia(fa.getNombre(), fa.getColor(), objetos)){
                        System.out.println("Error: Esa flor ya existe");
                        System.out.println("No se actualizó la flor...");
                    }
                    else {
                        objetos.set(objetos.indexOf(fl), fa);
                        System.out.println("Flor actualizada correctamente");
                    }
                    flag = false;
                }
            }
            if (flag){
                System.out.println("La clave ingresada no existe");
                System.out.println("Regresando...");
            }
        }
        if (obj instanceof CCliente){
            boolean flag = true;
            for (Object c : objetos) {
                CCliente cl = (CCliente) c;
                if (cl.getNombres().equals(att1) && cl.getApellidos().equals(att2)) {
                    System.out.println("Ingrese los datos del cliente actualizado: ");
                    CCliente ca = new CCliente();
                    if (confimarExistencia(ca.getNombres(), ca.getApellidos(), objetos)){
                        System.out.println("Error: Ese cliente ya existe");
                        System.out.println("No se actualizó el cliente...");
                    }
                    else {
                        objetos.set(objetos.indexOf(cl), ca);
                        System.out.println("Cliente actualizado correctamente");
                    }
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
                if (vl.getNombres().equals(att1) && vl.getApellidos().equals(att2)) {
                    System.out.println("Ingrese los datos del vendedor actualizado: ");
                    CVendedor va = new CVendedor();
                    if (confimarExistencia(va.getNombres(), va.getApellidos(), objetos)){
                        System.out.println("Error: Ese vendedor ya existe");
                        System.out.println("No se actualizó l vendedor...");
                    }
                    else {
                        objetos.set(objetos.indexOf(vl), va);
                        System.out.println("Vendedor actualizado correctamente");
                    }
                    flag = false;
                }
            }
            if (flag){
                System.out.println("La clave ingresada no existe");
                System.out.println("Regresando...");
            }
        }
    }
    public static void actualizarTodo(List<Object> objetos){
        Object obj = objetos.get(0);
        if (obj instanceof CFlor){
            for (Object f: objetos) {
                CFlor fl = (CFlor) f;
                CFlor fa = new CFlor();
                if (confimarExistencia(fa.getNombre(), fa.getColor(), objetos)){
                    System.out.println("Error: Esa flor ya existe");
                    System.out.println("No se actualizó la flor...");
                }
                else {
                    objetos.set(objetos.indexOf(fl), fa);
                    System.out.println("Flor actualizada correctamente");
                }
            }
        }
        if (obj instanceof CCliente){
            for (Object c: objetos) {
                CCliente cl = (CCliente) c;
                CCliente ca = new CCliente();
                if (confimarExistencia(ca.getNombres(), ca.getApellidos(), objetos)){
                    System.out.println("Error: Ese cliente ya existe");
                    System.out.println("No se actualizó el cliente...");
                }
                else {
                    objetos.set(objetos.indexOf(cl), ca);
                    System.out.println("Cliente actualizado correctamente");
                }
            }
        }
        if (obj instanceof CVendedor){
            for (Object v: objetos) {
                CVendedor vl = (CVendedor) v;
                CVendedor va = new CVendedor();
                if (confimarExistencia(va.getNombres(), va.getApellidos(), objetos)){
                    System.out.println("Error: Ese vendedor ya existe");
                    System.out.println("No se actualizó el vendedor...");
                }
                else {
                    objetos.set(objetos.indexOf(vl), va);
                    System.out.println("Vendedor actualizado correctamente");
                }
            }
        }
    }
    public static void eliminarPorPos(int posicion, List<Object> objetos){
        Object obj = objetos.get(0);
        if (posicion > objetos.size()){
            System.out.println("La posición ingresada no existe");
            System.out.println("Regresando...");
        }
        else {
            if (obj instanceof CFlor){
                objetos.remove(posicion);
                System.out.println("Flor eliminada correctamente");
            }
            if (obj instanceof CCliente){
                objetos.remove(posicion);
                System.out.println("Cliente eliminado correctamente");
            }
            if (obj instanceof CVendedor){
                objetos.remove(posicion);
                System.out.println("Vendedor eliminado correctamente");
            }
        }
    }
    public static void eliminarPorClave(String att1, String att2, List<Object> objetos){
        Object obj = objetos.get(0);
        if (obj instanceof CFlor){
            boolean flag = true;
            CFlor florE = new CFlor("","","",0);
            for (Object f : objetos) {
                CFlor fl = (CFlor) f;
                if (fl.getNombre().equals(att1) && fl.getColor().equals(att2)) {
                    florE = fl;
                    System.out.println("La flor fue eliminada correctamente");
                    flag = false;
                }
            }
            objetos.remove(florE);
            if (flag){
                System.out.println("La clave ingresada no existe");
                System.out.println("Regresando...");
            }
        }
        if (obj instanceof CCliente){
            boolean flag = true;
            CCliente clienteE = new CCliente("","","","","","","");
            for (Object c : objetos) {
                CCliente cl = (CCliente) c;
                if (cl.getNombres().equals(att1) && cl.getApellidos().equals(att2)) {
                    clienteE = cl;
                    System.out.println("El cliente fue eliminado correctamente");
                    flag = false;
                }
            }
            objetos.remove(clienteE);
            if (flag){
                System.out.println("La clave ingresada no existe");
                System.out.println("Regresando...");
            }
        }
        if (obj instanceof CVendedor){
            boolean flag = true;
            CVendedor vendedorE = new CVendedor(0,"","","","","","","");
            for (Object v : objetos) {
                CVendedor vl = (CVendedor) v;
                if (vl.getNombres().equals(att1) && vl.getApellidos().equals(att2)) {
                    vendedorE = vl;
                    System.out.println("El vendedor fue eliminado correctamente");
                    flag = false;
                }
            }
            objetos.remove(vendedorE);
            if (flag){
                System.out.println("La clave ingresada no existe");
                System.out.println("Regresando...");
            }
        }
    }
    public static void eliminarTodo(List<Object> objetos){
        objetos.clear();
    }

    public static void menuPrincipal(){
        System.out.println("*********** MENU PRINCIPAL ***********");
        System.out.println("0- Salir");
        System.out.println("1- Gestionar Flores.");
        System.out.println("2- Gestionar Clientes.");
        System.out.println("3- Gestionar Vendedores.");
        System.out.println("4- Gestionar Ventas.");
        System.out.println("5- Gestionar DetalleVentas.");
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
    public static void main(String[] args) {

        flores.add(new CFlor("Rosa", "Roja", "Dulce", 15.0));
        flores.add(new CFlor("Orquidea", "Roja", "Dulce Fuerte", 20.0));
        flores.add(new CFlor("Petalo", "Morado", "Amargo", 30.0));
        flores.add(new CFlor("Rosa", "Azul", "Dulce", 17.0));


        clientes.add(new CCliente("000000001", "DNI", "Francisco", "Cardenas", "pancho@gmail.com", "activo", "regular"));
        clientes.add(new CCliente("000000002", "RUC", "Julian", "Cardenas", "julian@gmail.com", "activo", "regular"));
        clientes.add(new CCliente("000000003", "Carnet Extranjeria", "Lucia", "Sanchez", "pancho@gmail.com", "activo", "regular"));
        clientes.add(new CCliente("000000004", "DNI", "Pedro", "Carrillo", "pancho@gmail.com", "activo", "regular"));

        int opcionPrincipal;
        do{
            menuPrincipal();
            opcionPrincipal = FuncionesBasicas.leerEntero();
            switch(opcionPrincipal){
                case 0:
                    System.out.println("Adios ...");
                    break;
                case 1:
                    int opcionflor;
                    do {
                        menuClases("FLORES");
                        opcionflor = FuncionesBasicas.leerEntero();
                        switch (opcionflor){
                            case 0:
                                System.out.println("Regresando al menú principal...");
                                break;
                            case 1:
                                //Agregar
                                System.out.println("¿Cuántas Flores quieres agregar?");
                                int cantAgregar = FuncionesBasicas.leerEntero();
                                CFlor flor;
                                if (cantAgregar < 1){
                                    System.out.println("Solo se admiten numeros mayores a 0");
                                    System.out.println("Regresando al menú flores...");
                                }else {
                                    for (int i = 0; i < cantAgregar; i++) {
                                        System.out.println("Ingrese los datos de la nueva flor");
                                        flor = new CFlor();
                                        if (confimarExistencia(flor.getNombre(), flor.getColor(), flores)){
                                            System.out.println("Error: Esa flor ya existe");
                                            System.out.println("No se ingreso flor...");
                                        }
                                        else {
                                            flores.add(flor);
                                            System.out.println("Flor agregada correctamente");
                                        }
                                    }
                                }
                                break;
                            case 2:
                                //Mostrar
                                int opcionMostrarFlores;
                                do {
                                    subMenus("Flores", "Mostrar");
                                    opcionMostrarFlores = FuncionesBasicas.leerEntero();
                                    switch (opcionMostrarFlores){
                                        case 0:
                                            System.out.println("Regresando al menú flores...");
                                            break;
                                        case 1:
                                            System.out.println("Ingrese la posición de la flor buscada");
                                            int florPorPos = FuncionesBasicas.leerEntero();
                                            if (flores.size() == 0){
                                                System.out.println("La lista esta vacia");
                                            }
                                            else {
                                                mostrarPorPos(florPorPos, flores);
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Ingrese el nombre y el color de la flor buscada: ");
                                            System.out.println("Nombre: ");
                                            String n = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            n = FuncionesBasicas.validarTamanyoString(n);
                                            System.out.println("Color: ");
                                            String c = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            if (flores.size() == 0){
                                                System.out.println("La lista esta vacia");
                                            }
                                            else {
                                                mostrarPorClave(n,c,flores);
                                            }
                                            break;
                                        case 3:
                                            if (flores.size() == 0){
                                                System.out.println("La lista esta vacia");
                                            }
                                            else {
                                                mostrarTodo(flores);
                                            }
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
                                    opcionActualizarFlores = FuncionesBasicas.leerEntero();
                                    switch (opcionActualizarFlores){
                                        case 0:
                                            System.out.println("Regresando al menú flores...");
                                            break;
                                        case 1:
                                            System.out.println("Ingrese la posición de la flor a actualizar");
                                            int florPorPos = FuncionesBasicas.leerEntero();
                                            actualizarPorPos(florPorPos, flores);
                                            break;
                                        case 2:
                                            System.out.println("Ingrese el nombre y el color de la flor a actualizar: ");
                                            System.out.println("Nombre: ");
                                            String n = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            n = FuncionesBasicas.validarTamanyoString(n);
                                            System.out.println("Color: ");
                                            String c = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            actualizarPorClave(n,c,flores);
                                            break;
                                        case 3:
                                            System.out.println("Actualizando " + flores.size() + " elementos");
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
                                    opcionEliminarFlores = FuncionesBasicas.leerEntero();
                                    switch (opcionEliminarFlores){
                                        case 0:
                                            System.out.println("Regresando al menú flores...");
                                            break;
                                        case 1:
                                            System.out.println("Ingrese la posición de la flor a eliminar");
                                            int florPorPos = FuncionesBasicas.leerEntero();
                                            eliminarPorPos(florPorPos, flores);
                                            break;
                                        case 2:
                                            System.out.println("Ingrese el nombre y el color de la flor a eliminar: ");
                                            System.out.println("Nombre: ");
                                            String n = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            n = FuncionesBasicas.validarTamanyoString(n);
                                            System.out.println("Color: ");
                                            String c = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            eliminarPorClave(n,c,flores);
                                            break;
                                        case 3:
                                            System.out.println("Eliminando " + flores.size() + " elementos");
                                            eliminarTodo(flores);
                                            System.out.println("Flores eliminadas correctamente");
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
                    }while (opcionflor != 0);
                    break;
                case 2:
                    int opcioncliente;
                    do {
                        menuClases("CLIENTES");
                        opcioncliente = FuncionesBasicas.leerEntero();
                        switch (opcioncliente){
                            case 0:
                                System.out.println("Regresando al menú principal...");
                                break;
                            case 1:
                                //Agregar
                                System.out.println("¿Cuántos clientes quieres agregar?");
                                int cantAgregar = FuncionesBasicas.leerEntero();
                                CCliente cliente;
                                if (cantAgregar < 1){
                                    System.out.println("Solo se admiten numeros mayores a 0");
                                    System.out.println("Regresando al menú clientes...");
                                }else {
                                    for (int i = 0; i < cantAgregar; i++) {
                                        System.out.println("Ingrese los datos del nuevo cliente");
                                        cliente = new CCliente();
                                        if (confimarExistencia(cliente.getNombres(), cliente.getApellidos(), clientes)){
                                            System.out.println("Error: Ese cliente ya existe");
                                            System.out.println("No se ingreso cliente...");
                                        }
                                        else {
                                            clientes.add(cliente);
                                            System.out.println("Cliente agregado correctamente");
                                        }
                                    }
                                }
                                break;
                            case 2:
                                //Mostrar
                                int opcionMostrarClientes;
                                do {
                                    subMenus("Clientes", "Mostrar");
                                    opcionMostrarClientes = FuncionesBasicas.leerEntero();
                                    switch (opcionMostrarClientes){
                                        case 0:
                                            System.out.println("Regresando al menú clientes...");
                                            break;
                                        case 1:
                                            System.out.println("Ingrese la posición del cliente buscado");
                                            int clientePorPos = FuncionesBasicas.leerEntero();
                                            if (clientes.size() == 0){
                                                System.out.println("La lista esta vacia");
                                            }
                                            else {
                                                mostrarPorPos(clientePorPos, clientes);
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Ingrese los nombres y los apellidos del cliente buscado: ");
                                            System.out.println("Nombres: ");
                                            String n = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            n = FuncionesBasicas.validarTamanyoString(n);
                                            System.out.println("Apellidos: ");
                                            String a = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            if (clientes.size() == 0){
                                                System.out.println("La lista esta vacia");
                                            }
                                            else {
                                                mostrarPorClave(n,a,clientes);
                                            }
                                            break;
                                        case 3:
                                            if (clientes.size() == 0){
                                                System.out.println("La lista esta vacia");
                                            }
                                            else {
                                                mostrarTodo(clientes);
                                            }
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
                                    subMenus("Clientes", "Actualizar");
                                    opcionActualizarClientes = FuncionesBasicas.leerEntero();
                                do {
                                    switch (opcionActualizarClientes){
                                        case 0:
                                            System.out.println("Regresando al menú clientes...");
                                            break;
                                        case 1:
                                            System.out.println("Ingrese la posición del cliente a actualizar");
                                            int clientePorPos = FuncionesBasicas.leerEntero();
                                            actualizarPorPos(clientePorPos, clientes);
                                            break;
                                        case 2:
                                            System.out.println("Ingrese los nombres y los apellidos del cliente a actualizar: ");
                                            System.out.println("Nombres: ");
                                            String n = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            n = FuncionesBasicas.validarTamanyoString(n);
                                            System.out.println("Apellidos: ");
                                            String a = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            actualizarPorClave(n,a,clientes);
                                            break;
                                        case 3:
                                            System.out.println("Actualizando " + clientes.size() + " elementos");
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
                                    opcionEliminarClientes = FuncionesBasicas.leerEntero();
                                    switch (opcionEliminarClientes){
                                        case 0:
                                            System.out.println("Regresando al menú clientes...");
                                            break;
                                        case 1:
                                            System.out.println("Ingrese la posición del cliente a eliminar");
                                            int clientePorPos = FuncionesBasicas.leerEntero();
                                            eliminarPorPos(clientePorPos, clientes);
                                        case 2:
                                            System.out.println("Ingrese el nombre y el apellido del cliente a eliminar: ");
                                            System.out.println("Nombres: ");
                                            String n = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            n = FuncionesBasicas.validarTamanyoString(n);
                                            System.out.println("Apellidos: ");
                                            String a = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            eliminarPorClave(n,a,clientes);
                                            break;
                                        case 3:
                                            System.out.println("Eliminando " + clientes.size() + " elementos");
                                            eliminarTodo(clientes);
                                            System.out.println("Clientes eliminados correctamente");
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
                    }while (opcioncliente != 0);
                    break;
                case 3:
                    int opcionvendedor;
                    do {
                        menuClases("VENDEDORES");
                        opcionvendedor = FuncionesBasicas.leerEntero();
                        switch (opcionvendedor){
                            case 0:
                                System.out.println("Regresando al menú principal...");
                                break;
                            case 1:
                                //Agregar
                                System.out.println("¿Cuántos vendedores quieres agregar?");
                                int cantAgregar = FuncionesBasicas.leerEntero();
                                CVendedor vendedor;
                                if (cantAgregar < 1){
                                    System.out.println("Solo se admiten numeros mayores a 0");
                                    System.out.println("Regresando al menú vendedores...");
                                }else {
                                    for (int i = 0; i < cantAgregar; i++) {
                                        System.out.println("Ingrese los datos del nuevo vendedor");
                                        vendedor = new CVendedor();
                                        if (confimarExistencia(vendedor.getNombres(), vendedor.getApellidos(), vendedores)){
                                            System.out.println("Error: Ese vendedor ya existe");
                                            System.out.println("No se ingreso vendedor...");
                                        }
                                        else {
                                            vendedores.add(vendedor);
                                            System.out.println("Vendedor agregado correctamente");
                                        }
                                    }
                                }
                                break;
                            case 2:
                                //Mostrar
                                int opcionMostrarVendedor;
                                do {
                                    subMenus("Vendedores", "Mostrar");
                                    opcionMostrarVendedor = FuncionesBasicas.leerEntero();
                                    switch (opcionMostrarVendedor){
                                        case 0:
                                            System.out.println("Regresando al menú vendedores...");
                                            break;
                                        case 1:
                                            System.out.println("Ingrese la posición del vendedor buscado");
                                            int vendedorPorPos = FuncionesBasicas.leerEntero();
                                            if (vendedores.size() == 0){
                                                System.out.println("La lista esta vacia");
                                            }
                                            else {
                                                mostrarPorPos(vendedorPorPos, vendedores);
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Ingrese los nombres y los apellidos del vendedor buscado: ");
                                            System.out.println("Nombres: ");
                                            String n = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            n = FuncionesBasicas.validarTamanyoString(n);
                                            System.out.println("Apellidos: ");
                                            String a = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            if (vendedores.size() == 0){
                                                System.out.println("La lista esta vacia");
                                            }
                                            else {
                                                mostrarPorClave(n,a,vendedores);
                                            }
                                            break;
                                        case 3:
                                            if (vendedores.size() == 0){
                                                System.out.println("La lista esta vacia");
                                            }
                                            else {
                                                mostrarTodo(vendedores);
                                            }
                                            break;
                                        default:
                                            System.out.println("Opción fuera de rango");
                                            break;
                                    }
                                }while (opcionMostrarVendedor != 0);
                                break;
                            case 3:
                                //Actualizar
                                int opcionActualizarVendedores;
                                subMenus("Vendedores", "Actualizar");
                                opcionActualizarVendedores = FuncionesBasicas.leerEntero();
                                do {
                                    switch (opcionActualizarVendedores){
                                        case 0:
                                            System.out.println("Regresando al menú vendedores...");
                                            break;
                                        case 1:
                                            System.out.println("Ingrese la posición del vendedor a actualizar");
                                            int vendedorPorPos = FuncionesBasicas.leerEntero();
                                            actualizarPorPos(vendedorPorPos, vendedores);
                                            break;
                                        case 2:
                                            System.out.println("Ingrese los nombres y los apellidos del vendedor a actualizar: ");
                                            System.out.println("Nombres: ");
                                            String n = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            n = FuncionesBasicas.validarTamanyoString(n);
                                            System.out.println("Apellidos: ");
                                            String a = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            actualizarPorClave(n,a,vendedores);
                                            break;
                                        case 3:
                                            System.out.println("Actualizando " + vendedores.size() + " elementos");
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
                                    opcionEliminarVendedores = FuncionesBasicas.leerEntero();
                                    switch (opcionEliminarVendedores){
                                        case 0:
                                            System.out.println("Regresando al menú vendedores...");
                                            break;
                                        case 1:
                                            System.out.println("Ingrese la posición del vendedor a eliminar");
                                            int vendedorPorPos = FuncionesBasicas.leerEntero();
                                            eliminarPorPos(vendedorPorPos, vendedores);
                                            break;
                                        case 2:
                                            System.out.println("Ingrese el nombre y el apellido del vendedor a eliminar: ");
                                            System.out.println("Nombres: ");
                                            String n = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            n = FuncionesBasicas.validarTamanyoString(n);
                                            System.out.println("Apellidos: ");
                                            String a = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto());
                                            eliminarPorClave(n,a,vendedores);
                                            break;
                                        case 3:
                                            System.out.println("Eliminando " + vendedores.size() + " elementos");
                                            eliminarTodo(vendedores);
                                            System.out.println("Vendedores eliminados correctamente");
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
                    }while (opcionvendedor != 0);
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
                                System.out.println("Ingrse el DNI del cliente:");
                                String dniCliente = FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()); // 00000006
                                if(dniExiste(dniCliente))
                                    System.out.println("cliente existe");
                                else{
                                    System.out.println("cliente NO existe");
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
                                            if (confimarExistencia(cliente.getNombres(), cliente.getApellidos(), clientes)){
                                                System.out.println("Error: Ese cliente ya existe");
                                                System.out.println("No se ingreso cliente...");
                                            }
                                            else {
                                                clientes.add(cliente);
                                                System.out.println("Cliente agregado correctamente");
                                            }
                                            break;
                                    }
                                }
                                numDocumento = ingresarNumDocVenta();
                                CVenta v = new CVenta(numDocumento,
                                        tipoDocumento,
                                        numDocumento,
                                        new Date(),
                                        "",
                                        dniCliente,
                                        0,
                                        0,
                                        0,
                                        "Proceso"
                                );
                                ventas.add(v);
                                mostrarFlores(flores);
                                System.out.println("Agregar flor a la venta:");
                                String agregarFlores;
//                                List<CFlor> floresVendidas = new ArrayList<CFlor>();
                                double pTotal = 0;

                                do{
                                    System.out.println("(A) Agregar flor    (T) terminar");
                                    agregarFlores = new Scanner(System.in).nextLine();
                                    if(agregarFlores.equals("A")) {
                                        System.out.print("Seleccione posicion de la flor para vender:");
                                        int posFlorVenta = new Scanner(System.in).nextInt();

                                        // Pregunta cuantas quiere
                                        System.out.println("Cantidad: ");
                                        int cantidad = new Scanner(System.in).nextInt();

                                        CFlor f2 = (CFlor) flores.get(posFlorVenta);
//                                    f2.mostrar();
//                                    floresVendidas.add(f2);

                                        pTotal += f2.getPrecio()*cantidad;

                                        CDetalleVenta dv = new CDetalleVenta(
                                                0,
                                                tipoDocumento + " " + numDocumento,
                                                f2.getNombre() + " " + f2.getColor(),
                                                cantidad,
                                                0,
                                                f2.getPrecio()
                                        );
                                        detalleVenta.add(dv);
//                                        detalleVenta.get(detalleVenta.size()-1).setIdDetalleVenta(detalleVenta.indexOf(dv));
//                                        detalleVenta.get(detalleVenta.size()-1).setIdDetalleVenta(detalleVenta.size()-1);
                                        dv.setIDDetalleVenta(detalleVenta.size()-1);
                                    }
                                }while(agregarFlores.equals("A"));

//                                for (CDetalleVenta dv1:detalleVenta) {
//                                    if(dv1.getIdVenta()==ventas.size()-1){
//                                        pTotal+=dv1.getPrecio()* dv1.getCantidad();
//                                    }
//                                }

                                v.setIDVenta(numDocumento);
                                v.setPrecioTotal(pTotal);
                                v.setIGV(pTotal/118);
                                v.setDescuento(descuetoGlobal());

                                v.mostrarLista();
                                mostrarDetalleVenta(v.getIDVenta());
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            default:
                                break;
                        }
                    } while( opcionVentas != 0 );
                    break;
                case 5:
                    System.out.println("...Menu en proceso...");
                    break;
                default:
                    System.out.println("Opción fuera de rango");
                    break;
            }
        } while (opcionPrincipal != 0);
    }
}
