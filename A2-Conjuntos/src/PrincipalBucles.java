import java.util.Scanner;

public class PrincipalBucles {

    public static int Limite = 10; // Declaración

    public static int Iterador = 0; //Declaración y Asignación

    public static int leerEntero(String mensaje){
        int entero = 0;
        Scanner teclado;
        boolean flag = true;
        do {
            try {
                escribir(" " + mensaje + ": ");
                teclado = new Scanner(System.in);
                entero = teclado.nextInt();
                flag = false;
            }catch (Exception e){
                e.printStackTrace();
                escribirLinea("error: el dato ingresado no es un número \n Inténtelo nuevamente");
                flag = true;
            }
        } while (flag);
        return entero;
    }

    public static void escribirLinea(String mensaje){
        System.out.println(mensaje);
    }

    public static void escribir(String mensaje){
        System.out.print(mensaje);
    }

    public static void main(String[] args){
        do {
            escribirLinea("iterador = " + Iterador);
            Iterador += 1;
        } while (Iterador < Limite);
        int iterador2 = 0;
        int limite2 = 10;

        Boolean flag = iterador2 < limite2;

        do {
            escribirLinea("iterador2 = " + iterador2);
            iterador2++;
            if (iterador2 == limite2)
                flag = false;
        } while (flag);

        int talla = leerEntero("Ingrese su talla");
        escribirLinea("Su talla es: " + talla + " Felicidades.");
    }
}