public class PrincipalConjuntos {

    public static Boolean existe(int elem, int[] conj){
        Boolean flag = false;
        for (int i = 0; i < conj.length; i++) {
            if(conj[i] == elem)
                flag = true;
        }
        return flag;
    }
    public static int[] unir(int[] A, int[] B){
        int dup = 0;
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                if (A[i] == B[j]){
                    dup++;
                }
            }
        }
        int[] union = new int[A.length + B.length - dup];

        // COPIAR LOS ELEMENTOS DE A EN UNION
        for (int i = 0; i < A.length; i++) {
            union[i] = A[i];
        }
        // COPIAR LOS ELEMENTOS DE B EN UNION AUQ AUN NO ESTAN EN UNION
        int cont = 0;
        for (int i = 0; i < B.length; i++) {
            if (existe(B[i],union)) {
                union[cont + A.length] = B[i];
                cont++;
            }
        }
        return union;
    }
    public static int menu(){
        scan.escribirLinea("#########       MENU PRINCIPAL      #########");
        scan.escribirLinea("######### OPERACIONES CON CONJUNTOS #########");
        scan.escribirLinea("0- Salir");
        scan.escribirLinea("1- Union");
        scan.escribirLinea("2- Interseccion");
        scan.escribirLinea("3- Diferencia");
        scan.escribirLinea("4- Diferencia Simétrica");
        scan.escribirLinea("5- Cambiar conjuntos");
        return scan.LeerEntero(">> Ingrese una opcion (0 - 5)");
    }
    public static int[] leerConjunto(String nombre, int tam){
        int[] a = new int[tam];
        for (int i = 0; i < a.length; i++) {
            a[i] = scan.LeerEntero(nombre+"["+i+"]");
        }
        return a;
    }

    public static void mostrarConjunto(String nombre, int[] conj){
        scan.escribir(nombre+" = { ");
        for (int i = 0; i < conj.length; i++) {
            if ( i == conj.length-1 )
                scan.escribir(conj[i]+"");
            else
                scan.escribir(conj[i] + ", ");
        }
        scan.escribirLinea(" }");
    }
    public static void main(String[] args) {
        scan.escribirLinea("######### OPERACIONES CON CONJUNTOS #########");
        String nombre1 = scan.leerTexto("Nombre de primer Conjunto");
        int tam1 = scan.LeerEntero("Tamaño de "+nombre1);
        int[] A = leerConjunto(nombre1,tam1);
        mostrarConjunto(nombre1,A);

        String nombre2 = scan.leerTexto("Nombre de segundo Conjunto");
        int tam2 = scan.LeerEntero("Tamaño de "+nombre2);
        int[] B = leerConjunto(nombre2,tam2);
        mostrarConjunto(nombre2,B);
        int opcion = 0;
        do {
            opcion = menu();
            switch ( opcion ){
                case 0:
                    scan.escribirLinea("Adios ...");

                    break;
                case 1:
                    scan.escribirLinea("Vamos a UNIR los conjuntos");
                    mostrarConjunto(nombre1,A);
                    mostrarConjunto(nombre2,B);
                    int[] union = unir(A, B);
                    mostrarConjunto("Union",union);
                    break;
                case 2:
                    scan.escribirLinea("Vamos a INTERSECTAR los conjuntos");
                    mostrarConjunto(nombre1,A);
                    mostrarConjunto(nombre2,B);
                    break;
                case 3:
                    scan.escribirLinea("Vamos a hallar la DIFERENCIA de los conjuntos");
                    mostrarConjunto(nombre1,A);
                    mostrarConjunto(nombre2,B);
                    break;
                case 4:
                    scan.escribirLinea("Vamos a hallar la DIFERENCIA SIMÉTRICA de los conjuntos");
                    mostrarConjunto(nombre1,A);
                    mostrarConjunto(nombre2,B);
                    break;
                case 5:
                    scan.escribirLinea("Vamos a CAMBIAR los conjuntos");

                    nombre1 = scan.leerTexto("Nombre de primer Conjunto");
                    tam1 = scan.LeerEntero("Tamaño de "+nombre1);
                    A = leerConjunto(nombre1,tam1);
                    mostrarConjunto(nombre1,A);

                    nombre2 = scan.leerTexto("Nombre de segundo Conjunto");
                    tam2 = scan.LeerEntero("Tamaño de "+nombre2);
                    B = leerConjunto(nombre2,tam2);
                    mostrarConjunto(nombre2,B);
                    break;
                default:
                    scan.escribirLinea("Opcion fuera de rango (0 - 5)");
                    break;
            }
        } while(opcion != 0);
    }
}
