import java.util.ArrayList;
import java.util.List;
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

    public static void mostrarFlorPos(int posicion, List<Cflor> flores){
        int pos = 0;
        Boolean flag = true;
        do{
            if(posicion == pos) {
                //flores.get(posicion).mostrar();
                flores.get(posicion).mostrar();
                flag = false;
            }
            pos++;
        }while (flag);
    }

    public static void menuPrincipal(){
        System.out.println("*********** MENU PRINCIPAL ***********");
        System.out.println("0- Salir");
        System.out.println("1- Gestionar Flores.");
        System.out.println("2- Gestionar Clientes.");
        System.out.println("3- Gestionar Vendedores.");
        System.out.println("4- Gestionar Ventas.");
        System.out.println("  << Ingrese una opcion >>  ");
    }
    public static void menuFlores(){
        System.out.println("*********** MENU FLORES ***********");
        System.out.println("0- Salir.");
        System.out.println("1- (C) Crear (Create).");
        System.out.println("2- (R) Mostrar (Read).");
        System.out.println("3- (U) Actualizar (update).");
        System.out.println("4- (D) Eliminar (Delete).");
        System.out.println("   Ingrese una opcion>>  ");
    }

    public static void main(String[] args) {
        List<Cflor> flores = new ArrayList<Cflor>();
        List<CCliente> clientes = new ArrayList<CCliente>();
        List<CVendedor> vendedores = new ArrayList<CVendedor>();
        List<CVenta> ventas = new ArrayList<CVenta>();
        List<CDetalleVenta> detalleVenta = new ArrayList<CDetalleVenta>();
        int opcionPrincipal;
        do{
            menuPrincipal();
            opcionPrincipal = new Scanner(System.in).nextInt();
            switch(opcionPrincipal){
                case 0:
                    System.out.println("Adios ...");
                    break;
                case 1:
                    int opcionFlores;
                    do {
                        menuFlores();
                        opcionFlores = new Scanner(System.in).nextInt();
                        switch (opcionFlores) {
                            case 0:
                                System.out.println("Regresando al menu Principal...");
                                break;
                            case 1:  // Insertar // Crear
                                Cflor flor = new Cflor();
                                flores.add(flor);
                                break;
                            case 2: // Mostrar
                                System.out.println("  Menu Mostrar Flor ");
                                System.out.println(" 0- Regresar al menu Flores");
                                System.out.println(" 1- Mostrar por posicion");
                                System.out.println(" 2- Mostrar todas las flores");
                                System.out.println("   Ingrese una opcion>>  ");
                                int opcionMostrarFlores = new Scanner(System.in).nextInt();
                                switch (opcionMostrarFlores) {
                                    case 0:
                                        System.out.println(" ... Regresando al Menu Flores");
                                        break;
                                    case 1:
                                        System.out.println("Ingrese la posicion de la flor buscada: ");
                                        int posicion = new Scanner(System.in).nextInt();
                                        mostrarFlorPos(posicion, flores);
                                        break;
                                    case 2:
                                        mostrarFlores(flores);
                                        break;
                                }
                                break;
                            case 3:  // Actualizar
                                System.out.println("  Menu Mostrar Flor ");
                                System.out.println(" 0- Regresar al menu Flores");
                                System.out.println(" 1- Actualizar un campo");
                                System.out.println(" 2- Actualizar todo");
                                System.out.println("   Ingrese una opcion>>  ");
                                int opcionActualizarFlor = new Scanner(System.in).nextInt();
                                switch (opcionActualizarFlor) {
                                    case 0:
                                        System.out.println(" ... Regresando al menu Flores");
                                        break;
                                    case 1:
                                        System.out.println("Ingrese la posicion a actualizar: ");
                                        int pos = new Scanner(System.in).nextInt();
                                        System.out.println("Ingrese campo que desea actualizar: ");
                                        String campo = new Scanner(System.in).nextLine();
                                        switch (campo){
                                            case "nombre":
                                                System.out.println("Nuevo nombre: ");
                                                flores.get(pos).setNombre(new Scanner(System.in).nextLine());
                                                break;
                                            case "aroma":
                                                System.out.println("Nuevo aroma: ");
                                                flores.get(pos).setAroma(new Scanner(System.in).nextLine());
                                                break;
                                            case "color":
                                                System.out.println("Nuevo color: ");
                                                flores.get(pos).setColor(new Scanner(System.in).nextLine());
                                                break;
                                            case "precio":
                                                System.out.println("Nuevo precio: ");
                                                flores.get(pos).setPrecio(new Scanner(System.in).nextDouble());
                                                break;
                                        }
                                        break;
                                    case 2:
                                        break;
                                }
                                break;
                            case 4:
                                // jojolete
                                break;
                            default:
                                break;
                        }
                        break;
                    } while ( opcionFlores != 0 );
                case 2: break;
                case 3: break;
                case 4: break;
                default: break;
            }
        } while (opcionPrincipal != 0);
    }
}
