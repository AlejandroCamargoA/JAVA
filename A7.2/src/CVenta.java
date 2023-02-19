import java.text.DecimalFormat;
import java.util.Date;

public class CVenta {
    private String IDVenta; //Index de la lista
    private String NroDocumento; //Factura - Boleta
    private String TipoDocumento; //001-12093
    private Date FechaVenta; //
    private String IDVendedor; //
    private String IDCliente; // DNI cliente
    private double PrecioTotal; //Suma de precios unitarios   Detalle
    private double IGV; //se calcula
    private double Descuento; //descuento global
    private String Estado; //activo

    public CVenta(String IDVenta, String tipoDocumento, String nroDocumento, Date fechaVenta, String IDVendedor, String IDCliente, double precioTotal, double IGV, double descuento, String estado) {
        this.IDVenta = IDVenta;
        NroDocumento = nroDocumento;
        TipoDocumento = tipoDocumento;
        FechaVenta = fechaVenta;
        this.IDVendedor = IDVendedor;
        this.IDCliente = IDCliente;
        PrecioTotal = precioTotal;
        this.IGV = IGV;
        Descuento = descuento;
        Estado = estado;
    }

    public String getIDVenta() {
        return IDVenta;
    }

    public void setIDVenta(String IDVenta) {
        this.IDVenta = IDVenta;
    }

    public String getNroDocumento() {
        return NroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        NroDocumento = nroDocumento;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        TipoDocumento = tipoDocumento;
    }

    public Date getFechaVenta() {
        return FechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        FechaVenta = fechaVenta;
    }

    public String getIDVendedor() {
        return IDVendedor;
    }

    public void setIDVendedor(String IDVendedor) {
        this.IDVendedor = IDVendedor;
    }

    public String getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(String IDCliente) {
        this.IDCliente = IDCliente;
    }

    public double getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        PrecioTotal = precioTotal;
    }

    public double getIGV() {
        return IGV;
    }

    public void setIGV(double IGV) {
        this.IGV = IGV;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double descuento) {
        Descuento = descuento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public void mostrarLista(){
        if (this.TipoDocumento.equals("B")){
            System.out.println("- tipoDocumento: Boleta");
        }else if (this.TipoDocumento.equals("F")){
            System.out.println("- tipoDocumento: Factura");
        }
        System.out.println("- nroDocumento: "+this.NroDocumento);
        System.out.println("- fechaVenta: "+this.FechaVenta);
        System.out.println("- idVendedor: "+this.IDVendedor);
        System.out.println("- idCliente: "+this.IDCliente);
        System.out.println("- precioTotal: "+this.PrecioTotal);
        DecimalFormat formato1 = new DecimalFormat("#.00");
        System.out.println("- igv: "+formato1.format(this.IGV));
        System.out.println("- descuento: "+this.Descuento);
        System.out.println("- estado: "+this.Estado);
    }
    public void mostrarCLista(){
        if (this.TipoDocumento.equals("B")){
            System.out.print(PrincipalClases.validarATexto("Boleta", 20));
        }else if (this.TipoDocumento.equals("F")){
            System.out.print(PrincipalClases.validarATexto("Factura", 20));
        }
        System.out.print(PrincipalClases.validarATexto(this.NroDocumento, 20));
        System.out.print(PrincipalClases.validarATexto("" + this.FechaVenta, 30));
        System.out.print(PrincipalClases.validarATexto(this.IDVendedor, 20));
        System.out.print(PrincipalClases.validarATexto(this.IDCliente, 20));
        System.out.print(PrincipalClases.validarATexto("" + this.PrecioTotal, 20));
        DecimalFormat formato1 = new DecimalFormat("#.00");
        System.out.print(PrincipalClases.validarATexto(formato1.format(this.IGV), 20));
        System.out.print(PrincipalClases.validarATexto("" + this.Descuento, 20));
        System.out.print(PrincipalClases.validarATexto(this.Estado, 20));
    }
}
