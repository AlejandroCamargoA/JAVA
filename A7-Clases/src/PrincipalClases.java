import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PrincipalClases {
    public static void mostrarFlores(List<Cflor> flores){
        System.out.println("NOMBRE\t\tAROMA\t\t\tCOLOR\t\tPRECIO");
        for (Cflor flor: flores) {
            System.out.println(flor.getNombre()+"\t\t"+
                    flor.getAroma()+"\t\t"+
                    flor.getColor()+"\t\t"+
                    flor.getPrecio());
        }
    }

    public static void mostrarFlorPos(String att1, String att2, List<Objects> objetos){

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
        System.out.println("*********** MENU " + ClaseS + " ***********");
        System.out.println("0- Salir.");
        System.out.println("1- (C) Crear (Create).");
        System.out.println("2- (R) Mostrar (Read).");
        System.out.println("3- (U) Actualizar (update).");
        System.out.println("4- (D) Eliminar (Delete).");
        System.out.println("  <<Ingrese una opción >>  ");
    }
    public static void subMenus(String ClaseS, String opcion){
        System.out.println("  Menu " + opcion + " " + ClaseS );
        System.out.println(" 0- Regresar al menu " + ClaseS);
        System.out.println(" 1- " + opcion + " por clave");
        System.out.println(" 2- " + opcion + " todo " + ClaseS);
        System.out.println("  << Ingrese una opción >>  ");
    }
    public static void main(String[] args) {
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
                                System.out.println("Ingrese la nueva flor");
                                //
                                break;
                            case 2:
                                subMenus("Flores", "Mostrar");
                                int opcionMostrarFlores;
                                do {
                                    opcionMostrarFlores = FuncionesBasicas.leerEntero();
                                    switch (opcionMostrarFlores){
                                        case 0:
                                            System.out.println("Regresando al menú flores");
                                            break;
                                        case 1:
                                            //
                                            break;
                                        case 2:
                                            //
                                            break;

                                    }
                                }while (opcionMostrarFlores != 0);

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            default:
                                System.out.println("Opción fuera de rango");
                                break;
                        }

                    }while (opcionflor != 0);

                    break;
                case 2:
                    System.out.println("Menu en proceso");
                    break;
                case 3:
                    System.out.println("Menu en proceso");
                    break;
                case 4:
                    System.out.println("Menu en proceso");
                    break;
                case 5:
                    System.out.println("Menu en proceso");
                    break;
                default:
                    System.out.println("Opción fuera de rango");
                    break;
            }
        } while (opcionPrincipal != 0);
    }
}
