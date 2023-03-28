import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CDetalleVenta {
    private int iddetalleVenta;
    private int idventa;
    private int idflor;
    private double precio;
    private int cantidad;
    private double descuento;


    public CDetalleVenta() {
        this.iddetalleVenta = 0;
        this.idventa = 0;
        this.idflor = 0;
        this.cantidad = 0;
        this.descuento = 0;
        this.precio = 0;
    }

    public CDetalleVenta(int iddetalleVenta, int idventa, int idflor, double precio, int cantidad, double descuento) {
        this.iddetalleVenta = iddetalleVenta;
        this.idventa = idventa;
        this.idflor = idflor;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public int getIddetalleVenta() {
        return iddetalleVenta;
    }

    public void setIddetalleVenta(int iddetalleVenta) {
        this.iddetalleVenta = iddetalleVenta;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdflor() {
        return idflor;
    }

    public void setIdflor(int idflor) {
        this.idflor = idflor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public void guardar(){
        conector c = new conector();
        String consulta = "call creardetadelleventa("
                + this.idventa + ","
                + this.idflor +","
                + this.precio + ","
                + this.cantidad +","
                + this.descuento + ")";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public static void listarDVdocventa(int iddocventa){
        conector c = new conector();
        List<List<String>> data;
        data = c.ejecutarProcedimientoConDatos("call listarDVdocventaID(" + iddocventa + ")");

        System.out.print(StringFormato("ID", 15));
        System.out.print(StringFormato("DOCUMENTO DE VENTA", 25));
        System.out.print(StringFormato("FLOR", 20));
        System.out.print(StringFormato("PRECIO UNITARIO", 20));
        System.out.print(StringFormato("CANTIDAD", 20));
        System.out.print(StringFormato("DESCUENTO", 20));
        System.out.println();

        for (List<String> dato: data ) {
            System.out.print(StringFormato(dato.get(0), 15));
            System.out.print(StringFormato(dato.get(1), 25));

            CFlor f = new CFlor();
            f = f.recuperarpID(Integer.parseInt(dato.get(2)));
            System.out.print(StringFormato(f.getNombre(), 20));

            System.out.print(StringFormato(dato.get(3), 20));
            System.out.print(StringFormato(dato.get(4), 20));
            System.out.print(StringFormato(dato.get(5), 20));
            System.out.println();
        }
    }


    public static String StringFormato(String texto, int tamanio){
        while (texto.length() < tamanio){
            texto = texto + " ";
        }
        return texto;
    }
}
