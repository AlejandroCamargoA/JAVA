package Clases;

import conexion.conector;

import java.util.List;

public class CCliente {
    private int idCliente;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numDocumento;
    private String correo;
    private String tipo;
    private String estado;

    public CCliente() {
        this.idCliente = 0;
        this.nombres = "";
        this.apellidos = "";
        this.tipoDocumento = "";
        this.numDocumento = "";
        this.correo = "";
        this.tipo = "";
        this.estado = "";
    }

    public CCliente(String nombres, String apellidos, String tipoDocumento, String numDocumento, String correo, String tipo, String estado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.correo = correo;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
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

    public void save(){
        conector c = new conector();
        String consulta = "call crearcliente('"
                + this.nombres+"','"
                + this.apellidos +"','"
                + this.tipoDocumento +"','"
                + this.numDocumento +"','"
                + this.correo +"','"
                + this.tipo +"','"
                + this.estado + "')";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public void update(){
        conector c = new conector();
        String consulta = "call actualizarcliente("
                + this.idCliente + ",'"
                + this.nombres+"','"
                + this.apellidos +"','"
                + this.tipoDocumento +"','"
                + this.numDocumento +"','"
                + this.correo +"','"
                + this.tipo +"','"
                + this.estado + "')";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public static List<List<String>> mostrarClientes(String pIdCliente) {
        List<List<String>> data = null;
        try {
            conector conexion = new conector();
            String consulta = "";
            if (pIdCliente.compareTo("") == 0) {
                consulta = "call listarClientesActivos('activo');";
            } else {
                consulta = "select * from TFlor where idFlor = '" + pIdCliente + "';";
            }
            data = conexion.ejecutarProcedimientoConDatos(consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    public void eliminar(){
        conector c = new conector();
        String consulta = "call eliminarcliente("
                + this.idCliente + ")";
        System.out.printf(consulta);
        c.ejecutarProcedimientoSinDatos(consulta);
    }
}
