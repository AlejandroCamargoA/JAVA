package Clases;

import conexion.conector;

public class CVendedor {

    private int idVendedor;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numDocumento;
    private String correo;
    private int comision;
    private String estado;

    public CVendedor() {
        this.idVendedor = 0;
        this.nombres = null;
        this.apellidos = null;
        this.tipoDocumento = null;
        this.numDocumento = null;
        this.correo = null;
        this.comision = 0;
        this.estado = null;
    }

    public CVendedor(int idVendedor, String nombres, String apellidos, String tipoDocumento, String numDocumento, String correo, int comision, String estado) {
        this.idVendedor = idVendedor;
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

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
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
                + this.correo +"',"
                + this.comision +",'"
                + this.estado + "')";
        System.out.println(consulta);
        c.ejecutarProcedimientoSinDatos(consulta);
    }

}
