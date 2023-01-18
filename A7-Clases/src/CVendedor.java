public class CVendedor {
    private int IDVendedor;
    private String Nombres;
    private String Apellidos;
    private String TipoDocumento;
    private String NumDocumento;
    private String Correo;
    private String Contrasenya;
    private String Estado;

    public CVendedor(int IDVendedor, String nombres, String apellidos, String tipoDocumento, String numDocumento, String correo, String contrasenya, String estado) {
        this.IDVendedor = IDVendedor;
        Nombres = nombres;
        Apellidos = apellidos;
        TipoDocumento = tipoDocumento;
        NumDocumento = numDocumento;
        Correo = correo;
        Contrasenya = contrasenya;
        Estado = estado;
    }

    public int getIDVendedor() {
        return IDVendedor;
    }

    public void setIDVendedor(int IDVendedor) {
        this.IDVendedor = IDVendedor;
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

    public String getContrasenya() {
        return Contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        Contrasenya = contrasenya;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
