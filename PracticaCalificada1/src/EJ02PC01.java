import java.util.Arrays;
import java.util.Scanner;

public class EJ02PC01 {

    public static void mostrarArreglo(int[] A){
        for (int i = 0; i < A.length; i++) {
            System.out.print("[" + A[i] +"] ");
        }
        System.out.println("\n");
    }
    public static void poblarArreglo(int num, int[] A){
        for (int i = 0; i < A.length; i++) {
            A[i] = i * num;
        }
    }
    public static int buscarElemento(int elemento, int[] A){
        int posicion = -1;
        for (int i = 0; i < A.length; i++) {
            if (elemento == A[i]){
                posicion = i;
            }
        }
        return posicion;
    }
    public static int[] getPares(int[] A){
        int contador = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0){
                contador ++;
            }
        }
        int cont = 0;
        int[] Pares = new int[contador];
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0){
                Pares[cont] = A[i];
                cont++;
            }
        }
        return Pares;
    }
    public static void main(String[] args){

        Scanner leer = new Scanner(System.in);

        System.out.println("----- EJERCICIO 01 -----");
        System.out.println("Ingrese tamaño del arreglo");
        int[] A = new int[leer.nextInt()];
        System.out.println("Ingrese un numero");
        int num = leer.nextInt();
        poblarArreglo(num, A);

        mostrarArreglo(A);
        System.out.println("Ingrese un valor para buscar");
        int elemento = leer.nextInt();
        System.out.println("La posicion es: " + buscarElemento(elemento, A));
        System.out.println("El arreglo con solo pares es: ");
        mostrarArreglo(getPares(A));

        System.out.println("Fin del programa");
    }
}
