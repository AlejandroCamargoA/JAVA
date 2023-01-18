public class PrincipalClases {
    public static void main(String[] args) {
        Cflor flor1;            // Instanciar
        flor1 = new Cflor();    // Inicializar

        System.out.println("Nombre: "+ flor1.getNombre() );
        System.out.println("Color: "+ flor1.getColor() );
        System.out.println("Aroma: "+ flor1.getAroma() );
        System.out.println("Precio: "+ flor1.getPrecio() );
        System.out.println();

        flor1.setNombre("Dalia");

        System.out.println("Nombre cambiado: "+ flor1.getNombre() );

        if (flor1.getNombre().equals((String)""))
            System.out.println("Color es una cadena vacia");
        else
            System.out.println("Color no una cadena vacia");

    }
}
