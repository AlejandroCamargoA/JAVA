package Clases;

import conexion.conector;

import java.util.List;

public class CVendedor {

    private int idVendedor;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numDocumento;
    private String correo;
    private double comision;
    private String estado;

    public CVendedor() {
        this.idVendedor = 0;
        this.nombres = "";
        this.apellidos = "";
        this.tipoDocumento = "";
        this.numDocumento = "";
        this.correo = "";
        this.comision = 0;
        this.estado = "";
    }

    public CVendedor(String nombres, String apellidos, String tipoDocumento, String numDocumento, String correo, double comision, String estado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.correo = correo;
        this.comision = comision;
        this.estado = estado;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
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

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void save(){
        conector c = new conector();
        String consulta = "call crearvendedor('"
                + this.nombres+"','"
                + this.apellidos +"','"
                + this.tipoDocumento +"','"
                + this.numDocumento +"','"
                + this.correo +"',"
                + this.comision +",'"
                + this.estado + "')";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public void update(){
        conector c = new conector();
        String consulta = "call actualizarvendedor("
                + this.idVendedor + ",'"
                + this.nombres+"','"
                + this.apellidos +"','"
                + this.tipoDocumento +"','"
                + this.numDocumento +"','"
                + this.correo +"',"
                + this.comision +",'"
                + this.estado + "')";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public static List<List<String>> mostrarVendedores(String pIdVendedor) {
        List<List<String>> data = null;
        try {
            conector conexion = new conector();
            String consulta = "";
            if (pIdVendedor.compareTo("") == 0) {
                consulta = "call listarvendedoresactivos('activo');";
            } else {
                consulta = "select * from TFlor where idFlor = '" + pIdVendedor + "';";
            }
            data = conexion.ejecutarProcedimientoConDatos(consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    public void eliminar(){
        conector c = new conector();
        String consulta = "call eliminarvendedorNuevo("
                + this.idVendedor + ")";
        System.out.printf(consulta);
        c.ejecutarProcedimientoSinDatos(consulta);
    }
}
