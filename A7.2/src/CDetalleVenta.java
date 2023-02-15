public class CDetalleVenta {
    private int IDDetalleVenta;
    private String IDVenta;
    private String IDProducto;
    private int Cantidad;
    private double descuento;
    private double precio;

    public CDetalleVenta(int IDDetalleVenta, String IDVenta, String IDProducto, int cantidad, double descuento, double precio) {
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

    public String getIDVenta() {
        return IDVenta;
    }

    public void setIDVenta(String IDVenta) {
        this.IDVenta = IDVenta;
    }

    public String getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(String IDProducto) {
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

    public void mostrar(){
        System.out.println("idDetalleVenta: "+this.getIDDetalleVenta());
        System.out.println("idVenta: "+this.IDVenta);
        System.out.println("idProducto: "+this.IDProducto);
        System.out.println("cantidad: "+this.Cantidad);
        System.out.println("descuento: "+this.descuento);
        System.out.println("precio: "+this.precio);
    }

    public void mostrarLista(){
        System.out.print("\t"+this.getIDDetalleVenta());
        System.out.print("\t"+this.IDVenta);
        System.out.print("\t"+this.IDProducto);
        System.out.print("\t"+this.Cantidad);
        System.out.print("\t"+this.descuento);
        System.out.print("\t"+this.precio);
    }
}
