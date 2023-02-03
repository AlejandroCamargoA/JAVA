import java.util.Scanner;

public class FuncionesBasicas {
    public static int leerEntero(){
        int entero = 0;
        Boolean flag = true;
        Scanner teclado;
        do {
            teclado = new Scanner(System.in);
            try{
                entero = teclado.nextInt();
                flag = false;
            }catch(Exception e){
                System.out.println("Error: Ese no es un entero válido.");
                System.out.println("Intentalo nuevamente.");
            }
        }while (flag);
        return entero;
    }
    public static double leerDecimal(){
        double decimal = 0;
        Boolean flag = true;
        Scanner teclado;
        do {
            teclado = new Scanner(System.in);
            try{
                decimal = teclado.nextDouble();
                flag = false;
            }catch(Exception e){
                System.out.println("Error: Ese no es un entero válido.");
                System.out.println("Intentalo nuevamente.");
            }
        }while (flag);
        return decimal;
    }
    public static String leertexto(){
        String texto = "";
        Scanner teclado;

        teclado = new Scanner(System.in);

        texto = teclado.nextLine();
        return texto;
    }
    public static String validarTamanyoString(String texto){
        while (texto.length() < 20){
            texto = texto + " ";
        }
        return texto;
    }
}