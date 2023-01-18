import java.util.Scanner;

public class scan {
    @SuppressWarnings("resource")
    protected static int LeerEntero(String mensaje) {
        escribirLinea(mensaje);
        Boolean flagEntero = true;
        int entero = 0;
        do {
            try {
                Scanner lector = new Scanner(System.in);
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

    @SuppressWarnings("resource")
    protected static double LeerReal() {
        // jojolete
        Boolean flagReal = true;
        double real = 0;
        do {
            try {
                Scanner lector = new Scanner(System.in);
                System.out.println("Infrese un número real: ");
                real = lector.nextDouble();
                flagReal = false;
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número real: ");
                flagReal = true;
                System.out.print("Intentelo nuevamente: ");
            }
        } while (flagReal);
        return real;
    }

    @SuppressWarnings("resource")
    protected static String LeerTexto(String mensaje) {
        Scanner lector = new Scanner(System.in);
        System.out.println(mensaje);
        String texto = lector.nextLine();
        return texto;
    }
    public static String leerTexto(String mensaje){
        String texto = "";
        Scanner teclado;
        escribir("\t" + mensaje + ":");
        teclado = new Scanner(System.in);
        texto = teclado.nextLine();
        return texto;
    }
    protected static void escribir(String texto) {
        System.out.print(texto);
    }

    protected static void escribirLinea(String texto) {
        System.out.println(texto);
    }
}