public class CFlor {
    // Atributos - Caracterìstica - Propiedades Objeto real
    private String nombre;
    private String color;
    private String aroma;
    private double precio;
    // MÉTODOS
    // M. Constructores
    // Sobrecarga e metodos Varios metodos con el mismos nombre y diferente coleccion de parametros

    public CFlor(){
        System.out.print("Ingrese el nombre: ");
        this.setNombre(FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()));
        System.out.print("Ingrese el Color: ");
        this.setColor(FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()));
        System.out.print("Ingrese el Aroma: ");
        this.setAroma(FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()));
        System.out.print("Ingrese el Precio: ");
        this.setPrecio(FuncionesBasicas.leerDecimal());
    }

    public CFlor(String nombre, String color, String aroma, double precio) {
        this.nombre = FuncionesBasicas.validarTamanyoString(nombre);
        this.color = FuncionesBasicas.validarTamanyoString(color);
        this.aroma = FuncionesBasicas.validarTamanyoString(aroma);
        this.precio = precio;
    }
    // M. Getters

    public String getNombre() {
        return this.nombre;
    }

    public String getColor() {
        return color;
    }

    public String getAroma() {
        return this.aroma;
    }

    public double getPrecio() {
        return this.precio;
    }

    // M. Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    // M. Generales - Funcion - Comportamiento
    public void mostrar(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Color: "+this.color);
        System.out.println("Aroma: "+this.aroma);
        System.out.println("Precio: S/ "+this.precio);
    }
}
