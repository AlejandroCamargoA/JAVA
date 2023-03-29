import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PrincipalClases {
    //Declarar lista global
    private static List<List<String>> data = new ArrayList<>();

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
        System.out.println(" 1- " + opcion + " por ID");
        System.out.println(" 2- " + opcion + " por clave");
        System.out.println(" 3- " + opcion + " todo " + ClaseS);
        System.out.println("  << Ingrese una opción >>  ");
    }
    public static void subMenu2(String ClaseS, String opcion){
        System.out.println("***** Menú " + opcion + " " + ClaseS + " *****");
        System.out.println(" 0- Regresar al menu " + ClaseS);
        System.out.println(" 1- " + opcion + " por ID");
        System.out.println(" 2- " + opcion + " por clave");
        System.out.println("  << Ingrese una opción >>  ");
    }

    //CRUDs
    public static void CRUDFlores(){
        int opcion;
        do {
            menuClases("FLORES");
            opcion = fbasicas.leerEnteroPositivo();
            switch (opcion){
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                case 1:
                    //Agregar
                    boolean flag;
                    do {
                        CFlor f = new CFlor();
                        f.nuevo();

                        if (!f.existeClave()){
                            f.guardar();
                            System.out.println("Flor Agregada Correctamente");
                            flag = true;
                        }
                        else {
                            System.out.println("La Flor ingresada ya existe...");
                            System.out.println("¿Desea intentarlo nuevamente?");
                            System.out.println("1) Si       Otro numero) No");
                            int op = fbasicas.leerEnteroPositivo();
                            if (op == 1){
                                flag = false;
                            }
                            else {
                                flag = true;
                            }
                        }
                    }while (!flag);

                    break;
                case 2:
                    //Mostrar
                    int opcionMostrar;
                    do {
                        subMenus("Flores", "Mostrar");
                        opcionMostrar = fbasicas.leerEnteroPositivo();
                        switch (opcionMostrar){
                            case 0:
                                System.out.println("Regresando al menú flores...");
                                break;
                            case 1:
                                //Mostrar por ID
                                boolean flag1;
                                do {
                                    CFlor f = new CFlor();
                                    f = f.recuperarID();

                                    if (f.existeID()){
                                        f.listar();
                                        flag1 = true;
                                    }
                                    else {
                                        System.out.println("La Flor ingresada no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag1 = false;
                                        }
                                        else {
                                            flag1 = true;
                                        }
                                    }
                                }while (!flag1);

                                break;
                            case 2:
                                //Mostrar por Clave
                                boolean flag2;
                                do {
                                    CFlor f = new CFlor();
                                    f = f.recuperarClave();

                                    if (f.existeClave()){
                                        f.listar();
                                        flag2 = true;
                                    }
                                    else {
                                        System.out.println("La Flor ingresada no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag2 = false;
                                        }
                                        else {
                                            flag2 = true;
                                        }
                                    }
                                }while (!flag2);

                                break;
                            case 3:
                                //Mostrar Todo
                                CFlor.ListarTodo();
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionMostrar != 0);
                    break;
                case 3:
                    //Actualizar
                    int opcionActualizar;
                    do {
                        subMenu2("Flores", "Actualizar");
                        opcionActualizar = fbasicas.leerEnteroPositivo();
                        switch (opcionActualizar){
                            case 0:
                                System.out.println("Regresando al menú flores...");
                                break;
                            case 1:
                                //Actualizar por ID
                                boolean flag1;
                                do {
                                    CFlor f = new CFlor();
                                    f = f.recuperarID();

                                    if (f.existeID()){
                                        f.actualizar();
                                        System.out.println("Flor actualizada correctamente");
                                        System.out.println();
                                        flag1 = true;
                                    }
                                    else {
                                        System.out.println("La Flor ingresada no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag1 = false;
                                        }
                                        else {
                                            flag1 = true;
                                        }
                                    }
                                }while (!flag1);
                                break;
                            case 2:
                                //Actualizar por Clave
                                boolean flag2;
                                do {
                                    CFlor f = new CFlor();
                                    f = f.recuperarClave();

                                    if (f.existeID()){
                                        f.actualizar();
                                        System.out.println("Flor actualizada correctamente");
                                        System.out.println();
                                        flag2 = true;
                                    }
                                    else {
                                        System.out.println("La Flor ingresada no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag2 = false;
                                        }
                                        else {
                                            flag2 = true;
                                        }
                                    }
                                }while (!flag2);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionActualizar != 0);

                    break;
                case 4:
                    int opcionEliminar;
                    do {
                        subMenu2("Flores", "Eliminar");
                        opcionEliminar = fbasicas.leerEnteroPositivo();
                        switch (opcionEliminar){
                            case 0:
                                System.out.println("Regresando al menú flores...");
                                break;
                            case 1:
                                //Eliminar por ID
                                boolean flag1;
                                do {
                                    CFlor f = new CFlor();
                                    f = f.recuperarID();

                                    if (f.existeID()){
                                        f.eliminar();
                                        System.out.println("Flor eliminada correctamente");
                                        System.out.println();
                                        flag1 = true;
                                    }
                                    else {
                                        System.out.println("La Flor ingresada no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag1 = false;
                                        }
                                        else {
                                            flag1 = true;
                                        }
                                    }
                                }while (!flag1);
                                break;
                            case 2:
                                //Eliminar por Clave
                                boolean flag2;
                                do {
                                    CFlor f = new CFlor();
                                    f = f.recuperarClave();

                                    if (f.existeID()){
                                        f.eliminar();
                                        System.out.println("Flor eliminada correctamente");
                                        System.out.println();
                                        flag2 = true;
                                    }
                                    else {
                                        System.out.println("La Flor ingresada no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag2 = false;
                                        }
                                        else {
                                            flag2 = true;
                                        }
                                    }
                                }while (!flag2);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionEliminar != 0);

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
            opcion = fbasicas.leerEnteroPositivo();
            switch (opcion){
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                case 1:
                    //Agregar
                    boolean flag;
                    do {
                        CCliente f = new CCliente();
                        f.nuevo();

                        if (!f.existeClave()){
                            f.guardar();
                            System.out.println("Cliente Agregado Correctamente");
                            flag = true;
                        }
                        else {
                            System.out.println("El cliente ingresado ya existe...");
                            System.out.println("¿Desea intentarlo nuevamente?");
                            System.out.println("1) Si       Otro numero) No");
                            int op = fbasicas.leerEnteroPositivo();
                            if (op == 1){
                                flag = false;
                            }
                            else {
                                flag = true;
                            }
                        }
                    }while (!flag);

                    break;
                case 2:
                    //Mostrar
                    int opcionMostrar;
                    do {
                        subMenus("Clientes", "Mostrar");
                        opcionMostrar = fbasicas.leerEnteroPositivo();
                        switch (opcionMostrar){
                            case 0:
                                System.out.println("Regresando al menú clientes...");
                                break;
                            case 1:
                                //Mostrar por ID
                                boolean flag1;
                                do {
                                    CCliente f = new CCliente();
                                    f = f.recuperarID();

                                    if (f.existeID()){
                                        f.listar();
                                        flag1 = true;
                                    }
                                    else {
                                        System.out.println("El cliente ingresado no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag1 = false;
                                        }
                                        else {
                                            flag1 = true;
                                        }
                                    }
                                }while (!flag1);

                                break;
                            case 2:
                                //Mostrar por Clave
                                boolean flag2;
                                do {
                                    CCliente f = new CCliente();
                                    f = f.recuperarClave();

                                    if (f.existeClave()){
                                        f.listar();
                                        flag2 = true;
                                    }
                                    else {
                                        System.out.println("El cliente ingresado no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag2 = false;
                                        }
                                        else {
                                            flag2 = true;
                                        }
                                    }
                                }while (!flag2);

                                break;
                            case 3:
                                //Mostrar Todo
                                CCliente.ListarTodo();
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionMostrar != 0);
                    break;
                case 3:
                    //Actualizar
                    int opcionActualizar;
                    do {
                        subMenu2("Clientes", "Actualizar");
                        opcionActualizar = fbasicas.leerEnteroPositivo();
                        switch (opcionActualizar){
                            case 0:
                                System.out.println("Regresando al menú clientes...");
                                break;
                            case 1:
                                //Actualizar por ID
                                boolean flag1;
                                do {
                                    CCliente f = new CCliente();
                                    f = f.recuperarID();

                                    if (f.existeID()){
                                        f.actualizar();
                                        System.out.println("Cliente actualizado correctamente");
                                        System.out.println();
                                        flag1 = true;
                                    }
                                    else {
                                        System.out.println("El cliente ingresado no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag1 = false;
                                        }
                                        else {
                                            flag1 = true;
                                        }
                                    }
                                }while (!flag1);
                                break;
                            case 2:
                                //Actualizar por Clave
                                boolean flag2;
                                do {
                                    CCliente f = new CCliente();
                                    f = f.recuperarClave();

                                    if (f.existeID()){
                                        f.actualizar();
                                        System.out.println("Cliente actualizado correctamente");
                                        System.out.println();
                                        flag2 = true;
                                    }
                                    else {
                                        System.out.println("El cliente ingresado no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag2 = false;
                                        }
                                        else {
                                            flag2 = true;
                                        }
                                    }
                                }while (!flag2);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionActualizar != 0);

                    break;
                case 4:
                    int opcionEliminar;
                    do {
                        subMenu2("Clientes", "Eliminar");
                        opcionEliminar = fbasicas.leerEnteroPositivo();
                        switch (opcionEliminar){
                            case 0:
                                System.out.println("Regresando al menú clientes...");
                                break;
                            case 1:
                                //Eliminar por ID
                                boolean flag1;
                                do {
                                    CCliente f = new CCliente();
                                    f = f.recuperarID();

                                    if (f.existeID()){
                                        f.eliminar();
                                        System.out.println("Cliente eliminado correctamente");
                                        System.out.println();
                                        flag1 = true;
                                    }
                                    else {
                                        System.out.println("El cliente ingresado no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag1 = false;
                                        }
                                        else {
                                            flag1 = true;
                                        }
                                    }
                                }while (!flag1);
                                break;
                            case 2:
                                //Eliminar por Clave
                                boolean flag2;
                                do {
                                    CCliente f = new CCliente();
                                    f = f.recuperarClave();

                                    if (f.existeID()){
                                        f.eliminar();
                                        System.out.println("Cliente eliminado correctamente");
                                        System.out.println();
                                        flag2 = true;
                                    }
                                    else {
                                        System.out.println("El cliente ingresado no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag2 = false;
                                        }
                                        else {
                                            flag2 = true;
                                        }
                                    }
                                }while (!flag2);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionEliminar != 0);

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
            opcion = fbasicas.leerEnteroPositivo();
            switch (opcion){
                case 0:
                    System.out.println("Regresando al menú principal...");
                    break;
                case 1:
                    //Agregar
                    boolean flag;
                    do {
                        CVendedor f = new CVendedor();
                        f.nuevo();

                        if (!f.existeClave()){
                            f.guardar();
                            System.out.println("Vendedor Agregado Correctamente");
                            flag = true;
                        }
                        else {
                            System.out.println("El Vendedor ingresado ya existe...");
                            System.out.println("¿Desea intentarlo nuevamente?");
                            System.out.println("1) Si       Otro numero) No");
                            int op = fbasicas.leerEnteroPositivo();
                            if (op == 1){
                                flag = false;
                            }
                            else {
                                flag = true;
                            }
                        }
                    }while (!flag);

                    break;
                case 2:
                    //Mostrar
                    int opcionMostrar;
                    do {
                        subMenus("Vendedores", "Mostrar");
                        opcionMostrar = fbasicas.leerEnteroPositivo();
                        switch (opcionMostrar){
                            case 0:
                                System.out.println("Regresando al menú Vendedores...");
                                break;
                            case 1:
                                //Mostrar por ID
                                boolean flag1;
                                do {
                                    CVendedor f = new CVendedor();
                                    f = f.recuperarID();

                                    if (f.existeID()){
                                        f.listar();
                                        flag1 = true;
                                    }
                                    else {
                                        System.out.println("El Vendedor ingresado no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag1 = false;
                                        }
                                        else {
                                            flag1 = true;
                                        }
                                    }
                                }while (!flag1);

                                break;
                            case 2:
                                //Mostrar por Clave
                                boolean flag2;
                                do {
                                    CVendedor f = new CVendedor();
                                    f = f.recuperarClave();

                                    if (f.existeClave()){
                                        f.listar();
                                        flag2 = true;
                                    }
                                    else {
                                        System.out.println("El Vendedor ingresado no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag2 = false;
                                        }
                                        else {
                                            flag2 = true;
                                        }
                                    }
                                }while (!flag2);

                                break;
                            case 3:
                                //Mostrar Todo
                                CVendedor.ListarTodo();
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionMostrar != 0);
                    break;
                case 3:
                    //Actualizar
                    int opcionActualizar;
                    do {
                        subMenu2("Vendedores", "Actualizar");
                        opcionActualizar = fbasicas.leerEnteroPositivo();
                        switch (opcionActualizar){
                            case 0:
                                System.out.println("Regresando al menú Vendedores...");
                                break;
                            case 1:
                                //Actualizar por ID
                                boolean flag1;
                                do {
                                    CVendedor f = new CVendedor();
                                    f = f.recuperarID();

                                    if (f.existeID()){
                                        f.actualizar();
                                        System.out.println("Vendedor actualizado correctamente");
                                        System.out.println();
                                        flag1 = true;
                                    }
                                    else {
                                        System.out.println("El Vendedor ingresado no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag1 = false;
                                        }
                                        else {
                                            flag1 = true;
                                        }
                                    }
                                }while (!flag1);
                                break;
                            case 2:
                                //Actualizar por Clave
                                boolean flag2;
                                do {
                                    CVendedor f = new CVendedor();
                                    f = f.recuperarClave();

                                    if (f.existeID()){
                                        f.actualizar();
                                        System.out.println("Vendedor actualizado correctamente");
                                        System.out.println();
                                        flag2 = true;
                                    }
                                    else {
                                        System.out.println("El Vendedor ingresado no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag2 = false;
                                        }
                                        else {
                                            flag2 = true;
                                        }
                                    }
                                }while (!flag2);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionActualizar != 0);

                    break;
                case 4:
                    int opcionEliminar;
                    do {
                        subMenu2("Vendedores", "Eliminar");
                        opcionEliminar = fbasicas.leerEnteroPositivo();
                        switch (opcionEliminar){
                            case 0:
                                System.out.println("Regresando al menú Vendedores...");
                                break;
                            case 1:
                                //Eliminar por ID
                                boolean flag1;
                                do {
                                    CVendedor f = new CVendedor();
                                    f = f.recuperarID();

                                    if (f.existeID()){
                                        f.eliminar();
                                        System.out.println("Vendedor eliminado correctamente");
                                        System.out.println();
                                        flag1 = true;
                                    }
                                    else {
                                        System.out.println("El Vendedor ingresado no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag1 = false;
                                        }
                                        else {
                                            flag1 = true;
                                        }
                                    }
                                }while (!flag1);
                                break;
                            case 2:
                                //Eliminar por Clave
                                boolean flag2;
                                do {
                                    CVendedor f = new CVendedor();
                                    f = f.recuperarClave();

                                    if (f.existeID()){
                                        f.eliminar();
                                        System.out.println("Vendedor eliminado correctamente");
                                        System.out.println();
                                        flag2 = true;
                                    }
                                    else {
                                        System.out.println("El Vendedor ingresado no existe");
                                        System.out.println("¿Desea intentarlo nuevamente?");
                                        System.out.println("1) Si       Otro número) No");
                                        int op = fbasicas.leerEnteroPositivo();
                                        if (op == 1){
                                            flag2 = false;
                                        }
                                        else {
                                            flag2 = true;
                                        }
                                    }
                                }while (!flag2);
                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }
                    }while (opcionEliminar != 0);

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
            opcionPrincipal = fbasicas.leerEnteroPositivo();
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
                case 4:
                    CRUDVentas();
                    break;
                default:
                    System.out.println("Opción fuera de rango");
                    break;
            }
        } while (opcionPrincipal != 0);
    }
    public static void CRUDVentas(){
        int opcion;
        do{
            opcion = menuVentas();
            switch (opcion){
                case 0:
                    System.out.println("... Regresando al menu principal.");
                    opcion = 0;
                    break;
                case 1: // Resgistrar una venta
                    String tipoDocumento;
                    String numDocumento;
                    int idvendedor;
                    int idcliente = 0;


                    boolean t = false;
                    do {
                        System.out.println("Ingrese el ID del vendedor: ");
                        idvendedor = fbasicas.leerEnteroPositivo();
                        if (existeVendedor(idvendedor)){
                            System.out.println("Vendedor Encontrado");
                            t = true;
                        }else {
                            System.out.println("No se encontro el vendedor con ese ID");
                            System.out.println("Mostrando Lista de Vendedores...");
                            CVendedor.ListarTodo();
                            System.out.println("Intentelo nuevamente");
                            t = false;
                        }
                    }while(!t);

                    do{
                        System.out.println("Seleccione tipo de documento:");
                        System.out.println("  (F) Factura        (B) Boleta");
                        tipoDocumento = fbasicas.leerTexto();
                        if(tipoDocumento.equals("F")){
                            System.out.println("GENERANDO FACTURA");
                        }else{
                            if(tipoDocumento.equals("B"))
                                System.out.println("GENERANDO BOLETA DE VENTA");
                            else {
                                System.out.println("Intente de nuevo ...");
                                opcion = 0;
                            }
                        }
                    } while (!tipoDocumento.equals("B") && !tipoDocumento.equals("F"));
                    boolean fg = false;
                    do {
                        System.out.println("Ingrese el Tipo de Documento del cliente:");
                        String tipodocCli = fbasicas.leerTexto();
                        System.out.println("Ingrese el Número de Documento del cliente:");
                        String numdocCli = fbasicas.leerTexto();
                        if(docExiste(tipodocCli, numdocCli)){
                            System.out.println("Cliente Encontrado...");
                            CCliente f1 = new CCliente();
                            f1 = f1.recuperarpClave(tipodocCli, numdocCli);
                            idcliente = f1.getIdcliente();
                            fg = true;
                        }
                        else{
                            System.out.println("No se encontro un cliente con ese número de documento");
                            System.out.println("Por favor ingrese otro Número de documento o agrege un nuevo cliente");
                            System.out.println(" (N) Nuevo Documento     (A) Agregar cliente   (*) Para salir");
                            String accion = new Scanner(System.in).nextLine();
                            switch (accion){
                                case "N":
                                    fg = false;
                                    break;
                                case "A":
                                    boolean flag;
                                    CCliente f = new CCliente();
                                    do {
                                        f.nuevo();

                                        if (!f.existeClave()){
                                            f.guardar();
                                            System.out.println("Cliente Agregado Correctamente");
                                            flag = true;
                                        }
                                        else {
                                            System.out.println("El cliente ingresado ya existe...");
                                            System.out.println("¿Desea intentarlo nuevamente?");
                                            System.out.println("1) Si       Otro numero) No");
                                            int op = fbasicas.leerEnteroPositivo();
                                            if (op == 1){
                                                flag = false;
                                            }
                                            else {
                                                flag = true;
                                            }
                                        }
                                    }while (!flag);
                                    tipodocCli = f.getTipodocumento();
                                    numdocCli = f.getNumdocumento();

                                    f = f.recuperarpClave(f.getTipodocumento(), f.getNumdocumento());

                                    idcliente = f.getIdcliente();
                                    fg = true;
                                    break;
                            }
                        }
                    }while (!fg);


                    SimpleDateFormat FechaMysql = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String dtm = "" + FechaMysql.format(new Date());

                    numDocumento = ingresarNumDocVenta();
                    CDocumentoVenta v = new CDocumentoVenta(0,
                            tipoDocumento,
                            numDocumento,
                            dtm,
                            idvendedor,
                            idcliente,
                            0,
                            0,
                            "Proceso"
                    );
                    v.guardar();
                    System.out.println("");

                    System.out.println("Mostrando Todas las flores");
                    CFlor.ListarTodo();
                    System.out.println("Agregar flor a la venta, Seleccione la flor que quiera agregar:");
                    String agregarFlores;
                    double pTotal = 0;

                    do{
                        System.out.println("(A) Agregar flor    (otro) terminar");
                        agregarFlores = fbasicas.leerTexto();
                        if(agregarFlores.equals("A")) {
                            System.out.print("Seleccione el ID de la flor para agregar a la venta:");
                            int idfVenta = fbasicas.leerEnteroPositivo();

                            if (flornoExiste(idfVenta)){
                                System.out.println("Ese ID no existe");
                                System.out.println("Intentelo nuevamente...");
                            }else {
                                System.out.println("Cantidad: ");
                                int cantidad = fbasicas.leerEnteroPositivo();

                                System.out.print("Descuento: ");
                                double desc = fbasicas.leerDecimalPositivo();

                                CFlor f2 = new CFlor();
                                f2.setIdflor(idfVenta);
                                f2 = f2.recuperarpID(idfVenta);

                                pTotal += ((f2.getPrecio()*cantidad) - desc);


                                v = v.recuperarID(numDocumento);

                                CDetalleVenta dv = new CDetalleVenta(0,
                                        v.getIdventa(),
                                        f2.getIdflor(),
                                        f2.getPrecio()*cantidad,
                                        cantidad,
                                        desc
                                );
                                dv.guardar();
                            }
                        }
                    }while(agregarFlores.equals("A"));

                    v.setPreciototal(pTotal);
                    v.setDescuento(descuetoGlobal());
                    v.setEstado("Activo");

                    System.out.println("");
                    System.out.println("Venta registrada correctamente... ");
                    System.out.println("Mostrando documento de venta:");
                    v.Listar();
                    v.actualizar();

                    System.out.println("Detalle de la venta:");

                    CDetalleVenta.listarDVdocventa(v.getIdventa());

                    System.out.println("");
                    break;
                case 2: // Reporte de Ventas
                    CDocumentoVenta.ListarTodo();
                    break;
                default:
                    break;
            }
        } while( opcion != 0 );
    }
    public static int menuVentas(){
        System.out.println("0- Regresar al menu anterior.");
        System.out.println("1- Registrar nueva venta.");
        System.out.println("2- Reporte de ventas.");
        System.out.print("   >> Ingrese una opción: ");
        return new Scanner(System.in).nextInt();
    }
    public static String ingresarNumDocVenta(){
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call listardocumentoventa;");

        String numdoc = "";
        numdoc = "100" + data.size();
        System.out.println("Generando documento de venta Nª: " + numdoc);
        return numdoc;
    }
    public static double descuetoGlobal(){
        System.out.print("Ingrese el monto de descuento global: ");
        return new Scanner(System.in).nextDouble();
    }
    public static boolean docExiste(String tipodoc, String numdoc){
        boolean flag;

        CCliente c = new CCliente();
        c.setTipodocumento(tipodoc);
        c.setNumdocumento(numdoc);

        if (c.existeClave()){
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }
    public static boolean existeVendedor(int id){
        boolean flag;

        CVendedor c = new CVendedor();
        c.setIdvendedor(id);

        if (c.existeID()){
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }
    public static boolean flornoExiste(int id){
        boolean flag;

        CFlor c = new CFlor();
        c.setIdflor(id);

        if (!c.existeID()){
            flag = true;
        }
        else {
            flag = false;
        }

        return flag;
    }
}
