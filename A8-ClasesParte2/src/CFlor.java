import java.time.*;

public class CFlor {
    private int idflor;
    private String nombre;
    private String aroma;
    private String color;
    private double precio;
    private int stock;
    private LocalDateTime fcreacion;
    private String estado;

    public CFlor(String nombre, String aroma, String color, double precio, int stock, LocalDateTime fcreacion, String estado) {

        conector c = new conector();
        c.ejecutarProcedimientoSinDatos("call crearFlor('" + nombre + "', '" + aroma + "', '" + color + "', " + precio + ", " + stock + ",'" + fcreacion + "','" + estado + "')");

    }

    public int getIdflor() {
        return idflor;
    }

    public void setIdflor(int idflor) {
        this.idflor = idflor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDateTime getFcreacion() {
        return fcreacion;
    }

    public void setFcreacion(LocalDateTime fcreacion) {
        this.fcreacion = fcreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
