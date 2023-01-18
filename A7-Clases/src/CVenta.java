import java.util.Date;

public class CVenta {
    private String IDVenta;
    private String NroDocumento;
    private String TipoDocumento;
    private Date FechaVenta;
    private int IDVendedor;
    private int IDCliente;
    private double PrecioTotal;
    private double IGV;
    private double Descuento;
    private String Estado;

    public CVenta(String IDVenta, String nroDocumento, String tipoDocumento, Date fechaVenta, int IDVendedor, int IDCliente, double precioTotal, double IGV, double descuento, String estado) {
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

    public int getIDVendedor() {
        return IDVendedor;
    }

    public void setIDVendedor(int IDVendedor) {
        this.IDVendedor = IDVendedor;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
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
}
