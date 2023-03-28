import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CDocumentoVenta {
    List<List<String>> data = new ArrayList<>();
    private int idventa;
    private String tipodocumento;
    private String numdocumento;
    private String fechaventa;
    private int idvendedor;
    private int idcliente;
    private double preciototal;
    private double descuento;
    private String estado;

    public CDocumentoVenta() {
        this.idventa = 0;
        this.tipodocumento = null;
        this.numdocumento = null;
        this.fechaventa = null;
        this.idvendedor = 0;
        this.idcliente = 0;
        this.preciototal = 0;
        this.descuento = 0;
        this.estado = null;
    }

    public CDocumentoVenta(int idventa, String tipodocumento, String numdocumento, String fechaventa, int idvendedor, int idcliente, double preciototal, double descuento, String estado) {
        this.idventa = idventa;
        this.tipodocumento = tipodocumento;
        this.numdocumento = numdocumento;
        this.fechaventa = fechaventa;
        this.idvendedor = idvendedor;
        this.idcliente = idcliente;
        this.preciototal = preciototal;
        this.descuento = descuento;
        this.estado = estado;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(String numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(String fechaventa) {
        this.fechaventa = fechaventa;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void Listar(){
        if (this.tipodocumento.equals("B")){
            System.out.println("- tipoDocumento: Boleta");
        }else if (this.tipodocumento.equals("F")){
            System.out.println("- tipoDocumento: Factura");
        }
        System.out.println("- Número de Documento: "+this.numdocumento);
        System.out.println("- Fecha de Venta: "+this.fechaventa);
        System.out.println("- Id del Vendedor: "+this.idvendedor);
        System.out.println("- Id del Cliente: "+this.idcliente);
        System.out.println("- Fecha de Venta: "+this.fechaventa);
        System.out.println("- Descuento: "+this.descuento);
        System.out.println("- Estado: "+this.estado);
        System.out.println("- Precio total: " + preciototal);
    }
    public void guardar(){
        conector c = new conector();
        String consulta = "call creardocumentoventa('"
                + this.tipodocumento + "','"
                + this.numdocumento + "',"
                + this.idcliente + ","
                + this.idvendedor + ",'"
                + this.fechaventa + "',"
                + this.preciototal + ","
                + this.descuento + ",'"
                + this.estado + "')";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public CDocumentoVenta recuperarID(String numdocventa){
        CDocumentoVenta f = new CDocumentoVenta();
        conector c = new conector();

        data = c.ejecutarProcedimientoConDatos("call dvrecuperarID(" + numdocventa + ")");
        for (List<String> dato: data ) {

            f.setIdventa(Integer.parseInt(dato.get(0)));
            f.setTipodocumento(dato.get(1));
            f.setNumdocumento(dato.get(2));
            f.setIdcliente(Integer.parseInt(dato.get(3)));
            f.setIdvendedor(Integer.parseInt(dato.get(4)));
            f.setFechaventa(dato.get(5));
            f.setPreciototal(Double.parseDouble(dato.get(6)));
            f.setDescuento(Double.parseDouble(dato.get(7)));
            f.setEstado(dato.get(8));
        }
        return f;
    }
    public static void ListarTodo(){
        conector c = new conector();
        List<List<String>> data;
        data = c.ejecutarProcedimientoConDatos("call listarDVdocventa()");

        System.out.print(StringFormato("ID", 10));
        System.out.print(StringFormato("TIPO DE DOCUMENTO", 25));
        System.out.print(StringFormato("NÚMERO DE DOCUMENTO", 30));
        System.out.print(StringFormato("DOCUMENTO CLIENTE", 20));
        System.out.print(StringFormato("DOCUMENTO VENDEDOR", 20));
        System.out.print(StringFormato("FECHA DE VENTA", 30));
        System.out.print(StringFormato("PRECIO TOTAL", 15));
        System.out.print(StringFormato("DESCUENTO", 15));
        System.out.print(StringFormato("ESTADO", 15) + "\n");

        for (List<String> dato: data ) {
            System.out.print(StringFormato(dato.get(0), 10));
            if (dato.get(1).equals("B")){
                System.out.print(StringFormato("Boleta", 25));
            }else if (dato.get(1).equals("F")){
                System.out.print(StringFormato("Factura", 25));
            }
            System.out.print(StringFormato(dato.get(2), 30));

            CCliente cli = new CCliente();
            cli = cli.recuperarpID(Integer.parseInt(dato.get(3)));
            System.out.print(StringFormato(cli.getNumdocumento(), 20));

            CVendedor ven = new CVendedor();
            ven = ven.recuperarpID(Integer.parseInt(dato.get(4)));
            System.out.print(StringFormato(ven.getNumdocumento(), 20));

            System.out.print(StringFormato(dato.get(5), 30));
            System.out.print(StringFormato(dato.get(6), 15));
            System.out.print(StringFormato(dato.get(7), 15));
            System.out.print(StringFormato(dato.get(8), 15) + "\n");
        }
        System.out.println();
    }
    public static String StringFormato(String texto, int tamanio){
        while (texto.length() < tamanio){
            texto = texto + " ";
        }
        return texto;
    }
    public void actualizar(){
        conector c = new conector();

        String consulta = "call actualizardocumentoventa("
                + this.idventa + ",'"
                + this.tipodocumento + "','"
                + this.numdocumento +"',"
                + this.idcliente +","
                + this.idvendedor +",'"
                + this.fechaventa +"',"
                + this.preciototal +","
                + this.descuento +",'"
                + this.estado + "')";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
}
