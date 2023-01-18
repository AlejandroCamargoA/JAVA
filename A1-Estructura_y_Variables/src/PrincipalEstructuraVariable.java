import java.util.Scanner;

public class PrincipalEstructuraVariable {
    public static int Limite; // Declaración
    public static int Iterador = 0; //Declaración y Asignación

    public static int leerEntero(){
        int entero = 0;
        Scanner teclado = new Scanner(System.in);
        try {
            entero = teclado.nextInt();
        }catch (Exception e){
            e.printStackTrace();
            escribir("error: el dato ingresado no es un número");
        }
        return entero;
    }

    public static void escribirLinea(String mensaje){
        System.out.println(mensaje);
    }

    public static void escribir(String mensaje){
        System.out.print(mensaje);
    }

    public static void main(String[] args) {
        Limite = 10; // Asignación
        int i = 0;
        for (i = 0; i < Limite; i++){
            System.out.println("i es: " + i + " Dentro del bucle");
        }
        System.out.println("el valor de i es: " + i + " Fuera del bucle"); // i fuera del bucle for, no existe, si no esta previamente declarada

        System.out.println("Bienvenidos, es es tu primer programa Java");

        escribirLinea("<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        escribir("Ingrese su edad");

        escribir("Tu edad es: " + leerEntero());
    }
}