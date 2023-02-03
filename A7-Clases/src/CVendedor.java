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

    public CVendedor(){
        System.out.print("Ingrese El ID: ");
        this.setIDVendedor(FuncionesBasicas.leerEntero());
        System.out.print("Ingrese los nombres: ");
        this.setNombres(FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()));
        System.out.print("Ingrese los apellidos: ");
        this.setApellidos(FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()));
        System.out.print("Ingrese el tipo de documento: ");
        this.setTipoDocumento(FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()));
        System.out.print("Ingrese el numero de documento: ");
        this.setNumDocumento(FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()));
        System.out.print("Ingrese el correo: ");
        this.setCorreo(FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()));
        System.out.print("Ingrese la contraseña: ");
        this.setContrasenya(FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()));
        System.out.print("Ingrese el estado: ");
        this.setEstado(FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()));
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

    public void mostrar(){
        System.out.println("ID: "+this.IDVendedor);
        System.out.println("Nombres: "+this.Nombres);
        System.out.println("Apellidos: "+this.Apellidos);
        System.out.println("Tipo de Documento: "+this.TipoDocumento);
        System.out.println("Numero de Documento: "+this.NumDocumento);
        System.out.println("Correo: "+this.Correo);
        System.out.println("Contraseña: "+this.Contrasenya);
        System.out.println("Estado: "+this.Estado);
    }
}
