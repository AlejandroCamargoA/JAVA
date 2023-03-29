import java.util.Scanner;

public class fbasicas {
    //FUNCIONES Y VALIDACIONES GENERALES
    //Validar texto no numeros
    public static boolean validarNum(String Texto){
        boolean flag = false;
        if (Texto == null || Texto.equals("")) {
            flag = false;
        }
        for (int i = 0; i < Texto.length(); i++)
        {
            char c = Texto.charAt(i);
            if (Character.toString(c).matches("[0-9?]")) {
                flag = true;
            }
        }
        return flag;
    }
    //Validar enteros positivos
    public static int leerEnteroPositivo(){
        int entero = 0;
        Boolean flag = true;
        Scanner teclado;
        do {
            teclado = new Scanner(System.in);
            try{
                entero = teclado.nextInt();
                while (entero < 0) {
                    System.out.println("Error: No se admite numeros negativos");
                    System.out.println("Intentalo nuevamente.");
                    entero = teclado.nextInt();
                }
                flag = false;
            }catch(Exception e){
                System.out.println("Error: Ese no es un entero válido.");
                System.out.println("Intentalo nuevamente.");
            }
        }while (flag);
        return entero;
    }
    //Validar decimales positivos
    public static double leerDecimalPositivo(){
        double decimal = 0.0;
        Boolean flag = true;
        Scanner teclado;
        do {
            teclado = new Scanner(System.in);
            try{
                decimal = teclado.nextDouble();
                while (decimal < 0) {
                    System.out.println("Error: No se admite numeros negativos");
                    System.out.println("Intentalo nuevamente.");
                    decimal = teclado.nextDouble();
                }
                flag = false;
            }catch(Exception e){
                System.out.println("Error: Ese no es un decimal válido.");
                System.out.println("Intentalo nuevamente.");
            }
        }while (flag);
        return decimal;
    }
    //Leer texto
    public static String leerTexto(){
        String texto = "";
        Scanner teclado;
        teclado = new Scanner(System.in);
        texto = teclado.nextLine();
        return texto;
    }
}
