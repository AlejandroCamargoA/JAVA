public class CCliente {
    private String TipoDocumento;
    private String NumDocumento;
    private String Nombres;
    private String Apellidos;
    private String Correo;
    private String Estado;
    private String Tipo;

    public CCliente(String tipoDocumento, String numDocumento, String nombres, String apellidos, String correo, String estado, String tipo) {
        this.TipoDocumento = tipoDocumento;
        this.NumDocumento = numDocumento;
        this.Nombres = nombres;
        this.Apellidos = apellidos;
        this.Correo = correo;
        this.Estado = estado;
        this.Tipo = tipo;
    }

    public CCliente(){
        System.out.print("Ingrese el tipo de documento: ");
        this.TipoDocumento = PrincipalClases.leerTexto();
        System.out.print("Ingrese el número de documento: ");
        this.NumDocumento = PrincipalClases.leerTexto();
        System.out.print("Ingrese los nombres: ");
        this.Nombres = PrincipalClases.leerTexto();
        System.out.print("Ingrese los apellidos: ");
        this.Apellidos = PrincipalClases.leerTexto();
        System.out.print("Ingrese el correo: ");
        this.Correo = PrincipalClases.leerTexto();
        System.out.print("Ingrese el estado: ");
        this.Estado = PrincipalClases.leerTexto();
        System.out.print("Ingrese el tipo: ");
        this.Tipo = PrincipalClases.leerTexto();
    }

    public void mostrar(){
        System.out.println("Tipo de Documento: "+this.TipoDocumento);
        System.out.println("Numero de Documento: "+this.NumDocumento);
        System.out.println("Nombres: "+this.Nombres);
        System.out.println("Apellidos: "+this.Apellidos);
        System.out.println("Correo: "+this.Correo);
        System.out.println("Estado: "+this.Estado);
        System.out.println("Tipo: "+this.Tipo);
    }

    public void mostrarCLista(){
        int tamaño = 25;
        System.out.print(PrincipalClases.validarATexto(this.TipoDocumento, tamaño));
        System.out.print(PrincipalClases.validarATexto(this.NumDocumento, tamaño));
        System.out.print(PrincipalClases.validarATexto(this.Nombres, tamaño));
        System.out.print(PrincipalClases.validarATexto(this.Apellidos, tamaño));
        System.out.print(PrincipalClases.validarATexto(this.Correo, tamaño));
        System.out.print(PrincipalClases.validarATexto(this.Estado, tamaño));
        System.out.print(PrincipalClases.validarATexto(this.Tipo, tamaño));
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
