import java.util.Scanner;

public class FuncionesBasicas {
    public static int leerEntero(String mensaje){
        int entero = 0;
        Boolean flag = true;
        Scanner teclado;
        do {
            System.out.println("\t"+mensaje+": ");
            teclado = new Scanner(System.in);
            try{
                entero = teclado.nextInt();
                flag = false;
            }catch(Exception e){
                System.out.println("Error: Ese no es un entero válido.");
                System.out.println("Intentalo nuevamente el proximo año.");
            }
        }while (flag);
        return entero;
    }

    public static double leerDecimal(String mensaje){
        double decimal = 0;
        Boolean flag = true;
        Scanner teclado;
        do {
            System.out.println("\t"+mensaje+": ");
            teclado = new Scanner(System.in);
            try{
                decimal = teclado.nextDouble();
                flag = false;
            }catch(Exception e){
                System.out.println("Error: Ese no es un entero válido.");
                System.out.println("Intentalo nuevamente el proximo año.");
            }
        }while (flag);
        return decimal;
    }

    public static String leertexto(String mensaje){
        String texto = "";
        Scanner teclado;

        System.out.println("\t"+mensaje+": ");
        teclado = new Scanner(System.in);

        texto = teclado.nextLine();
        return texto;
    }
}