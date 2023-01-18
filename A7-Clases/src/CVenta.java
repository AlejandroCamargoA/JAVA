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

}
