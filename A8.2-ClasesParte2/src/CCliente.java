import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CCliente {
    List<List<String>> data = new ArrayList<>();
    private int idcliente = 0;
    private String nombres;
    private String apellidos;
    private String tipodocumento;
    private String numdocumento;
    private String correo;
    private String tipo;
    private String estado;

    public CCliente(){
        this.idcliente = 0;
        this.nombres = null;
        this.apellidos = null;
        this.tipodocumento = null;
        this.numdocumento = null;
        this.correo = null;
        this.tipo = null;
        this.estado = null;
    }

    public CCliente(int idcliente, String nombres, String apellidos, String tipodocumento, String numdocumento, String correo, String tipo, String estado) {
        this.idcliente = idcliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipodocumento = tipodocumento;
        this.numdocumento = numdocumento;
        this.correo = correo;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombre(String nombres) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void nuevo(){
        System.out.println("Ingrese los Datos del nuevo Cliente: ");
        System.out.print("Nombres : ");
        this.setNombre(Aux.leerTexto());
        System.out.print("Apellidos : ");
        this.setApellidos(Aux.leerTexto());
        System.out.print("Tipo de Documento : ");
        this.setTipodocumento(Aux.leerTexto());
        System.out.print("Número de Documento : ");
        this.setNumdocumento(Aux.leerTexto());
        System.out.print("Correo : ");
        this.setCorreo(Aux.leerTexto());
        System.out.print("Tipo : ");
        this.setTipo(Aux.leerTexto());
        System.out.print("Estado : ");
        this.setEstado(Aux.leerTexto());
        System.out.println();
    }
    public void listar(){
        System.out.println(" - ID: " + this.getIdcliente());
        System.out.println(" - Nombres: " + this.getNombres());
        System.out.println(" - Apellidos: " + this.getApellidos());
        System.out.println(" - Tipo de Documento: " + this.getTipodocumento());
        System.out.println(" - Número de Documento: " +this.getNumdocumento());
        System.out.println(" - Correo: " +this.getCorreo());
        System.out.println(" - Tipo: " +this.getTipo());
        System.out.println(" - Estado: " +this.getEstado());
        System.out.println();
    }
    public static void ListarTodo(){
        conector c = new conector();
        List<List<String>> data;
        data = c.ejecutarProcedimientoConDatos("call listarcliente()");

        System.out.print(StringFormato("ID", 5));
        System.out.print(StringFormato("NOMBRES", 25));
        System.out.print(StringFormato("APELLIDOS", 25));
        System.out.print(StringFormato("TIPO DE DOCUMENTO", 25));
        System.out.print(StringFormato("NÚMERO DE DOCUMENTO", 25));
        System.out.print(StringFormato("CORREO", 25));
        System.out.print(StringFormato("TIPO", 25));
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
        String consulta = "call crearcliente('"
                + this.nombres + "','"
                + this.apellidos +"','"
                + this.tipodocumento +"','"
                + this.numdocumento +"','"
                + this.correo +"','"
                + this.tipo +"','"
                + this.estado + "')";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public void actualizar(){
        conector c = new conector();
        System.out.println("Ingrese los nuevos datos del cliente");
        System.out.println("ID : " + this.idcliente);
        System.out.print("Nombres : ");
        this.setNombre(Aux.leerTexto());
        System.out.print("Apellidos : ");
        this.setApellidos(Aux.leerTexto());
        System.out.print("Tipo de Documento : ");
        this.setTipodocumento(Aux.leerTexto());
        System.out.print("Numero de Documento : ");
        this.setNumdocumento(Aux.leerTexto());
        System.out.print("Correo : ");
        this.setCorreo(Aux.leerTexto());
        System.out.print("Tipo : ");
        this.setTipo(Aux.leerTexto());
        System.out.print("Estado : ");
        this.setEstado(Aux.leerTexto());
        System.out.println();

        String consulta = "call actualizarcliente("
                + this.idcliente + ",'"
                + this.nombres + "','"
                + this.apellidos +"','"
                + this.tipodocumento +"','"
                + this.numdocumento +"','"
                + this.correo +"','"
                + this.tipo +"','"
                + this.estado + "')";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public void eliminar(){
        conector c = new conector();
        String consulta = "call eliminarcliente("
                + this.idcliente + ")";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public boolean existeID(){
        boolean flag;
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call cExisteID(" + this.getIdcliente() + ")");
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
        data = c.ejecutarProcedimientoConDatos("call cExisteClave('" + this.getTipodocumento() + "','" + this.getNumdocumento() + "')");
        List<String> dato = data.get(0);
        if (Integer.parseInt(dato.get(0)) == 0){
            flag = false;
        }
        else {
            flag = true;
        }
        return flag;
    }
    public CCliente recuperarpID(int ID){
        CCliente f = new CCliente();
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call crecuperarID(" + ID + ")");
        for (List<String> dato: data ) {
            f.setIdcliente(Integer.parseInt(dato.get(0)));
            f.setNombre(dato.get(1));
            f.setApellidos(dato.get(2));
            f.setTipodocumento(dato.get(3));
            f.setNumdocumento(dato.get(4));
            f.setCorreo(dato.get(5));
            f.setTipo(dato.get(6));
            f.setEstado(dato.get(7));
        }
        return f;
    }
    public CCliente recuperarID(){
        CCliente f = new CCliente();
        conector c = new conector();
        System.out.println("Ingrese el ID del cliente");
        int ID = Aux.leerEnteroPositivo();
        data = c.ejecutarProcedimientoConDatos("call crecuperarID(" + ID + ")");
        for (List<String> dato: data ) {
            f.setIdcliente(Integer.parseInt(dato.get(0)));
            f.setNombre(dato.get(1));
            f.setApellidos(dato.get(2));
            f.setTipodocumento(dato.get(3));
            f.setNumdocumento(dato.get(4));
            f.setCorreo(dato.get(5));
            f.setTipo(dato.get(6));
            f.setEstado(dato.get(7));
        }
        return f;
    }
    public CCliente recuperarClave(){
        CCliente f = new CCliente();
        conector c = new conector();
        System.out.println("Ingrese la Clave del cliente");
        System.out.print("tipo de documento: ");
        String tipodoc = Aux.leerTexto();
        System.out.print("número de documento: ");
        String numdoc = Aux.leerTexto();
        System.out.println();
        data = c.ejecutarProcedimientoConDatos("call crecuperarClave('" + tipodoc + "','" + numdoc + "')");
        for (List<String> dato: data ) {
            f.setIdcliente(Integer.parseInt(dato.get(0)));
            f.setNombre(dato.get(1));
            f.setApellidos(dato.get(2));
            f.setTipodocumento(dato.get(3));
            f.setNumdocumento(dato.get(4));
            f.setCorreo(dato.get(5));
            f.setTipo(dato.get(6));
            f.setEstado(dato.get(7));
        }
        return f;
    }
    public CCliente recuperarpClave(String tipodoc , String numdoc){
        CCliente f = new CCliente();
        conector c = new conector();
        System.out.println();
        data = c.ejecutarProcedimientoConDatos("call crecuperarClave('" + tipodoc + "','" + numdoc + "')");
        for (List<String> dato: data ) {
            f.setIdcliente(Integer.parseInt(dato.get(0)));
            f.setNombre(dato.get(1));
            f.setApellidos(dato.get(2));
            f.setTipodocumento(dato.get(3));
            f.setNumdocumento(dato.get(4));
            f.setCorreo(dato.get(5));
            f.setTipo(dato.get(6));
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
