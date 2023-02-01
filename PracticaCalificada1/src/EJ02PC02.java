import java.util.Arrays;
import java.util.Scanner;

public class EJ02PC02 {
    public static void mostrarArreglo(int[] A){
        for (int i = 0; i < A.length; i++) {
            System.out.print("[" + A[i] +"] ");
        }
        System.out.println("\n");
    }
    public static int[] poblarPares(int[] arreglo){
        int[] Pares = new int[arreglo.length];
        int cont = 0;
        for (int i = 0; i < arreglo.length; i++) {
            Pares[i] = cont;
            cont+=2;
        }
        return Pares;
    }
    public static void poblarImpares(int[] arreglo){
        int cont = 1;
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = cont;
            cont+=2;
        }
    }
    public static int[] ordenar(int[] arreglo){
        int temporal;
        for (int i = 0; i < arreglo.length; i++) {
                for (int j = 1; j < (arreglo.length - i); j++) {
                    if (arreglo[j - 1] > arreglo[j]) {
                        temporal = arreglo[j - 1];
                        arreglo[j - 1] = arreglo[j];
                        arreglo[j] = temporal;
                    }
                }
        }
        return arreglo;
    }
    public static void main(String[] args){

        Scanner leer = new Scanner(System.in);

        System.out.println("----- EJERCICIO 02 -----");
        System.out.println("Ingrese el tamaño del primer arreglo");
        int[] primero = new int[leer.nextInt()];
        primero = poblarPares(primero);

        System.out.println("Ingrese el tamaño del segundo arreglo");
        int[] segundo = new int[leer.nextInt()];
        poblarImpares(segundo);

        System.out.println("El primer arreglo es: ");
        mostrarArreglo(primero);
        System.out.println("El segundo arreglo es: ");
        mostrarArreglo(segundo);

        int[] tercero = new int[primero.length+segundo.length];
        int contador = 0;
        for (int i = 0; i < primero.length; i++) {
            tercero[contador] = primero[i];
            contador++;
        }
        for (int i = 0; i < segundo.length; i++) {
            tercero[contador] = segundo[i];
            contador++;
        }
        System.out.println("el tercer arreglo ORDENADO es: ");
        mostrarArreglo(ordenar(tercero));
        System.out.println("Fin del programa");
    }
}
