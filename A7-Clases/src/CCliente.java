public class CCliente {
    private int IDCliente;
    private String Nombres;
    private String Apellidos;
    private String TipoDocumento;
    private String NumDocumento;
    private String Correo;
    private String Estado;
    private String Tipo;

    public CCliente(int IDCliente, String nombres, String apellidos, String tipoDocumento, String numDocumento, String correo, String estado, String tipo) {
        this.IDCliente = IDCliente;
        Nombres = nombres;
        Apellidos = apellidos;
        TipoDocumento = tipoDocumento;
        NumDocumento = numDocumento;
        Correo = correo;
        Estado = estado;
        Tipo = tipo;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        TipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return NumDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        NumDocumento = numDocumento;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
