import java.util.ArrayList;
import java.util.List;

public class CVendedor {
    List<List<String>> data = new ArrayList<>();
    private int idvendedor = 0;
    private String nombres;
    private String apellidos;
    private String tipodocumento;
    private String numdocumento;
    private String correo;
    private Double comision;
    private String estado;

    public CVendedor() {
        this.idvendedor = 0;
        this.nombres = null;
        this.apellidos = null;
        this.tipodocumento = null;
        this.numdocumento = null;
        this.correo = null;
        this.comision = null;
        this.estado = null;
    }

    public CVendedor(int idvendedor, String nombres, String apellidos, String tipodocumento, String numdocumento, String correo, Double comision, String estado) {
        this.idvendedor = idvendedor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipodocumento = tipodocumento;
        this.numdocumento = numdocumento;
        this.correo = correo;
        this.comision = comision;
        this.estado = estado;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void nuevo(){
        System.out.println("Ingrese los Datos del nuevo Vendedor: ");
        System.out.print("Nombres : ");
        this.setNombres(Aux.leerTexto());
        System.out.print("Apellidos : ");
        this.setApellidos(Aux.leerTexto());
        System.out.print("Tipo de Documento : ");
        this.setTipodocumento(Aux.leerTexto());
        System.out.print("Número de Documento : ");
        this.setNumdocumento(Aux.leerTexto());
        System.out.print("Correo : ");
        this.setCorreo(Aux.leerTexto());
        System.out.print("Comision : ");
        this.setComision(Aux.leerDecimalPositivo());
        System.out.print("Estado : ");
        this.setEstado(Aux.leerTexto());
        System.out.println();
    }
    public void listar(){
        System.out.println(" - ID: " + this.getIdvendedor());
        System.out.println(" - Nombres: " + this.getNombres());
        System.out.println(" - Apellidos: " + this.getApellidos());
        System.out.println(" - Tipo de Documento: " + this.getTipodocumento());
        System.out.println(" - Número de Documento: " +this.getNumdocumento());
        System.out.println(" - Correo: " +this.getCorreo());
        System.out.println(" - Comision: " +this.getComision());
        System.out.println(" - Estado: " +this.getEstado());
        System.out.println();
    }
    public static void ListarTodo(){
        conector c = new conector();
        List<List<String>> data;
        data = c.ejecutarProcedimientoConDatos("call listarvendedor()");

        System.out.print(StringFormato("ID", 5));
        System.out.print(StringFormato("NOMBRES", 25));
        System.out.print(StringFormato("APELLIDOS", 25));
        System.out.print(StringFormato("TIPO DE DOCUMENTO", 25));
        System.out.print(StringFormato("NÚMERO DE DOCUMENTO", 25));
        System.out.print(StringFormato("CORREO", 25));
        System.out.print(StringFormato("COMISION", 25));
        System.out.print(StringFormato("ESTADO", 25) + "\n");

        for (List<String> dato: data ) {
            System.out.print(StringFormato(dato.get(0), 5));
            System.out.print(StringFormato(dato.get(1), 25));
            System.out.print(StringFormato(dato.get(2), 25));
            System.out.print(StringFormato(dato.get(3), 25));
            System.out.print(StringFormato(dato.get(4), 25));
            System.out.print(StringFormato(dato.get(5), 25));
            System.out.print(StringFormato(dato.get(6), 25));
            System.out.print(StringFormato(dato.get(7), 25) + "\n");
        }
        System.out.println();
    }
    public void guardar(){
        conector c = new conector();
        String consulta = "call crearvendedor('"
                + this.nombres + "','"
                + this.apellidos +"','"
                + this.tipodocumento +"','"
                + this.numdocumento +"','"
                + this.correo +"',"
                + this.comision +",'"
                + this.estado + "')";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public void actualizar(){
        conector c = new conector();
        System.out.println("Ingrese los nuevos datos del vendedor");
        System.out.println("ID : " + this.idvendedor);
        System.out.print("Nombres : ");
        this.setNombres(Aux.leerTexto());
        System.out.print("Apellidos : ");
        this.setApellidos(Aux.leerTexto());
        System.out.print("Tipo de Documento : ");
        this.setTipodocumento(Aux.leerTexto());
        System.out.print("Numero de Documento : ");
        this.setNumdocumento(Aux.leerTexto());
        System.out.print("Correo : ");
        this.setCorreo(Aux.leerTexto());
        System.out.print("Comisión : ");
        this.setComision(Aux.leerDecimalPositivo());
        System.out.print("Estado : ");
        this.setEstado(Aux.leerTexto());
        System.out.println();

        String consulta = "call actualizarvendedor("
                + this.idvendedor + ",'"
                + this.nombres + "','"
                + this.apellidos +"','"
                + this.tipodocumento +"','"
                + this.numdocumento +"','"
                + this.correo +"',"
                + this.comision +",'"
                + this.estado + "')";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public void eliminar(){
        conector c = new conector();
        String consulta = "call eliminarvendedor("
                + this.idvendedor + ")";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public boolean existeID(){
        boolean flag;
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call vExisteID(" + this.getIdvendedor() + ")");
        List<String> dato = data.get(0);
        if (Integer.parseInt(dato.get(0)) == 0){
            flag = false;
        }
        else {
            flag = true;
        }
        return flag;
    }
    public boolean existeClave(){
        boolean flag;
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call vExisteClave('" + this.getTipodocumento() + "','" + this.getNumdocumento() + "')");
        List<String> dato = data.get(0);
        if (Integer.parseInt(dato.get(0)) == 0){
            flag = false;
        }
        else {
            flag = true;
        }
        return flag;
    }
    public CVendedor recuperarpID(int ID){
        CVendedor f = new CVendedor();
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call vrecuperarID(" + ID + ")");
        for (List<String> dato: data ) {
            f.setIdvendedor(Integer.parseInt(dato.get(0)));
            f.setNombres(dato.get(1));
            f.setApellidos(dato.get(2));
            f.setTipodocumento(dato.get(3));
            f.setNumdocumento(dato.get(4));
            f.setCorreo(dato.get(5));
            f.setComision(Double.parseDouble(dato.get(6)));
            f.setEstado(dato.get(7));
        }
        return f;
    }
    public CVendedor recuperarID(){
        CVendedor f = new CVendedor();
        conector c = new conector();
        System.out.println("Ingrese el ID del vendedor");
        int ID = Aux.leerEnteroPositivo();
        data = c.ejecutarProcedimientoConDatos("call vrecuperarID(" + ID + ")");
        for (List<String> dato: data ) {
            f.setIdvendedor(Integer.parseInt(dato.get(0)));
            f.setNombres(dato.get(1));
            f.setApellidos(dato.get(2));
            f.setTipodocumento(dato.get(3));
            f.setNumdocumento(dato.get(4));
            f.setCorreo(dato.get(5));
            f.setComision(Double.parseDouble(dato.get(6)));
            f.setEstado(dato.get(7));
        }
        return f;
    }
    public CVendedor recuperarClave(){
        CVendedor f = new CVendedor();
        conector c = new conector();
        System.out.println("Ingrese la Clave del vendedor");
        System.out.print("tipo de documento: ");
        String tipodoc = Aux.leerTexto();
        System.out.print("número de documento: ");
        String numdoc = Aux.leerTexto();
        System.out.println();
        data = c.ejecutarProcedimientoConDatos("call vrecuperarClave('" + tipodoc + "','" + numdoc + "')");
        for (List<String> dato: data ) {
            f.setIdvendedor(Integer.parseInt(dato.get(0)));
            f.setNombres(dato.get(1));
            f.setApellidos(dato.get(2));
            f.setTipodocumento(dato.get(3));
            f.setNumdocumento(dato.get(4));
            f.setCorreo(dato.get(5));
            f.setComision(Double.parseDouble(dato.get(6)));
            f.setEstado(dato.get(7));
        }
        return f;
    }
    public static String StringFormato(String texto, int tamanio){
        while (texto.length() < tamanio){
            texto = texto + " ";
        }
        return texto;
    }
}
