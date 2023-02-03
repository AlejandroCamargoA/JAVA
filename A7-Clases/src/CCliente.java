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

    public CCliente(){
        System.out.print("Ingrese El ID: ");
        this.setIDCliente(FuncionesBasicas.leerEntero());
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
        System.out.print("Ingrese el estado: ");
        this.setEstado(FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()));
        System.out.print("Ingrese el tipo: ");
        this.setTipo(FuncionesBasicas.validarTamanyoString(FuncionesBasicas.leertexto()));
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
    public void mostrar(){
        System.out.println("ID: "+this.IDCliente);
        System.out.println("Nombres: "+this.Nombres);
        System.out.println("Apellidos: "+this.Apellidos);
        System.out.println("Tipo de Documento: "+this.TipoDocumento);
        System.out.println("Numero de Documento: "+this.NumDocumento);
        System.out.println("Correo: "+this.Correo);
        System.out.println("Estado: "+this.Estado);
        System.out.println("Tipo: "+this.Tipo);
    }
}
