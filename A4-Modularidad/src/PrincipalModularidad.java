import java.util.Scanner;

public class PrincipalModularidad {

    protected static int leerEntero() {
        Boolean flagEntero = true;
        int entero = 0;
        do {
            try {
                Scanner lector = new Scanner(System.in);
                System.out.println("Infrese un número entero: ");
                entero = lector.nextInt();
                flagEntero = false;
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número entero: ");
                flagEntero = true;
                System.out.print("Intentelo nuevamente: ");
            }
        } while (flagEntero);
        return entero;
    }
    public static String leerTexto(){
        String e = "";
        Scanner sc;
        sc = new Scanner(System.in); // Ingreso de datos del teclado
        e = sc.nextLine();  // Convierte el dato en Entero
        return e;
    }

    public static int leerEnt(){
        return new Scanner(System.in).nextInt();
    }

    public static int sumar(int num1, int num2){
        int suma = num1 + num2;
        return suma;
    }

    public static int restar(int num1, int num2){
        int dif = num1 - num2;
        return dif;
    }

    public static int multiplicar(int num1, int num2){
        int prod = num1 * num2;
        return prod;
    }

    public static int dividir(int num1, int num2){
        int cos = num1 / num2;
        return cos;
    }

    public static int potencia(int num1, int num2){
        int cos = num1 / num2;
        return cos;
    }

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("###### MENU ######");
            System.out.println("  0- Salir.");
            System.out.println("  1- Sumar.");
            System.out.println("  2- Restar.");
            System.out.println("  3- Multiplicar.");
            System.out.println("  4- Dividir.");
            System.out.print("  >> Ingrese una opción: ");
            opcion = leerEntero();
            int num1 = 0;
            int num2 = 0;
            switch ( opcion ){
                case 0:
                    System.out.println("Gracias por usar esta triste calculadora. Vuelva pronto");
                    break;
                    case 1: System.out.print("Ingrese sumando1 entero: ");
                    num1 = leerEntero();
                    System.out.print("Ingrese sumando2 entero: ");
                    num2 = leerEntero();
                        System.out.println("La suma de " + num1 + " y " + num2 + " es: " + sumar(num1, num2));
                        break;
                    case 2:
                    System.out.print("Ingrese minuendo entero: ");
                    num1 = leerEntero();
                    System.out.print("Ingrese sustraendo entero: ");
                    num2 = leerEntero();
                        System.out.println("La diferencia de " + num1 + " y " + num2 + " es: " + restar(num1, num2));
                        break;
                    case 3:
                  System.out.print("Ingrese un numero entero: ");
                    num1 = leerEntero();
                    System.out.print("Ingrese otro numero entero: ");
                    num2 = leerEntero();
                        System.out.println("El producto de " + num1 + " y " + num2 + " es: " + multiplicar(num1, num2));
                        break;
                    case 4:
                  System.out.print("Ingrese un numero entero: ");
                    num1 = leerEntero();
                    System.out.print("Ingrese otro numero entero: ");
                    num2 = leerEntero();
                    while (num2==0){
                        System.out.println("la division entre el numero 0 es imposible");
                        System.out.println("Intentelo nuevamente");
                        num2 = leerEntero();
                    }
                    System.out.println("La division de " + num1 + " y " + num2 + " es: " + dividir(num1, num2));
                        break;
                    default:
                        System.out.println("Esa opcion no es válida.");
                        break;
                }
            }while ( opcion > 0 );
        }
    }

