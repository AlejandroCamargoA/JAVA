public class Cflor {
    // Atributos - Caracterìstica - Propiedades Objeto real
    private String nombre;
    private String color;
    private String aroma;
    private double precio;
    // MÉTODOS
    // M. Constructores
    // Sobrecarga e metodos Varios metodos con el mismos nombre y diferente coleccion de parametros

    public Cflor(){
        color="";
        precio=10;
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
}
