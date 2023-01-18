public class CDetalleVenta {
    private int IDDetalleVenta;
    private int IDVenta;
    private int IDProducto;
    private int Cantidad;
    private double descuento;
    private double precio;

    public CDetalleVenta(int IDDetalleVenta, int IDVenta, int IDProducto, int cantidad, double descuento, double precio) {
        this.IDDetalleVenta = IDDetalleVenta;
        this.IDVenta = IDVenta;
        this.IDProducto = IDProducto;
        Cantidad = cantidad;
        this.descuento = descuento;
        this.precio = precio;
    }

    public int getIDDetalleVenta() {
        return IDDetalleVenta;
    }

    public void setIDDetalleVenta(int IDDetalleVenta) {
        this.IDDetalleVenta = IDDetalleVenta;
    }

    public int getIDVenta() {
        return IDVenta;
    }

    public void setIDVenta(int IDVenta) {
        this.IDVenta = IDVenta;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
