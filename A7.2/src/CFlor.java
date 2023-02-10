public class CFlor {
    private String Nombre;
    private String Color;
    private String Aroma;
    private double Precio;

    public CFlor(String nombre, String color, String aroma, double precio) {
        Nombre = nombre;
        Color = color;
        Aroma = aroma;
        Precio = precio;
    }

    public CFlor() {
        System.out.print("Ingrese el nombre: ");
        Nombre = PrincipalClases.leerTexto();
        System.out.print("Ingrese el color: ");
        Color = PrincipalClases.leerTexto();
        System.out.print("Ingrese el aroma: ");
        Aroma = PrincipalClases.leerTexto();
        System.out.print("Ingrese el precio: ");
        Precio = PrincipalClases.leerDecimalPositivo();
    }

    public void mostrar(){
        System.out.println("Nombre: "+this.Nombre);
        System.out.println("Color: "+this.Color);
        System.out.println("Aroma: "+this.Aroma);
        System.out.println("Precio: S/ "+this.Precio);
    }

    public void mostrarCLista(){
        int tamaño = 20;
        System.out.print(PrincipalClases.validarATexto(this.Nombre, tamaño));
        System.out.print(PrincipalClases.validarATexto(this.Color, tamaño));
        System.out.print(PrincipalClases.validarATexto(this.Aroma, tamaño));
        System.out.print(PrincipalClases.validarATexto(this.Precio + "", tamaño));
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getAroma() {
        return Aroma;
    }

    public void setAroma(String aroma) {
        Aroma = aroma;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }
}
