import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CFlor {
    List<List<String>> data = new ArrayList<>();
    private int idflor;
    private String nombre;
    private String aroma;
    private String color;
    private double precio;
    private int stock;
    private String fcreacion;
    private String estado;

    public CFlor(){
        this.idflor = 0;
        this.nombre = null;
        this.aroma = null;
        this.color = null;
        this.precio = 0;
        this.estado = null;
        this.fcreacion = null;
        this.stock = 0;
    }

    public CFlor(int idflor, String nombre, String aroma, String color, double precio, int stock, String fcreacion, String estado) {
        this.idflor = idflor;
        this.nombre = nombre;
        this.aroma = aroma;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
        this.fcreacion = fcreacion;
        this.estado = estado;
    }

    public int getIdflor() {
        return idflor;
    }

    public void setIdflor(int idflor) {
        this.idflor = idflor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFcreacion() {
        return fcreacion;
    }

    public void setFcreacion(String fcreacion) {
        this.fcreacion = fcreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void nuevo(){
        System.out.println("Ingrese los Datos de la nueva Flor: ");
        System.out.print("Nombre : ");
        this.setNombre(Aux.leerTexto());
        System.out.print("Aroma : ");
        this.setAroma(Aux.leerTexto());
        System.out.print("Color : ");
        this.setColor(Aux.leerTexto());
        System.out.print("Precio : ");
        this.setPrecio(Aux.leerDecimalPositivo());
        System.out.print("Stock : ");
        this.setStock(Aux.leerEnteroPositivo());
        System.out.print("Estado : ");
        this.setEstado(Aux.leerTexto());
        System.out.println();
    }
    public void listar(){
        System.out.println(" - ID: " + this.getIdflor());
        System.out.println(" - Nombre: " + this.getNombre());
        System.out.println(" - Aroma: " + this.getAroma());
        System.out.println(" - Color: " + this.getColor());
        System.out.println(" - Precio: " +this.getPrecio());
        System.out.println(" - Stock: " +this.getStock());
        System.out.println(" - Fecha de Creación: " +this.getFcreacion());
        System.out.println(" - Estado: " +this.getEstado());
        System.out.println();
    }
    public static void ListarTodo(){
        conector c = new conector();
        List<List<String>> data;
        data = c.ejecutarProcedimientoConDatos("call listarFlores()");

        System.out.print(StringFormato("ID", 5));
        System.out.print(StringFormato("NOMBRE", 25));
        System.out.print(StringFormato("AROMA", 25));
        System.out.print(StringFormato("COLOR", 25));
        System.out.print(StringFormato("PRECIO", 10));
        System.out.print(StringFormato("STOCK", 10));
        System.out.print(StringFormato("FECHA", 30));
        System.out.print(StringFormato("ESTADO", 25) + "\n");

        for (List<String> dato: data ) {
            System.out.print(StringFormato(dato.get(0), 5));
            System.out.print(StringFormato(dato.get(1), 25));
            System.out.print(StringFormato(dato.get(2), 25));
            System.out.print(StringFormato(dato.get(3), 25));
            System.out.print(StringFormato(dato.get(4), 10));
            System.out.print(StringFormato(dato.get(5), 10));
            System.out.print(StringFormato(dato.get(6), 30));
            System.out.print(StringFormato(dato.get(7), 25) + "\n");
        }
        System.out.println();
    }
    public void guardar(){
        SimpleDateFormat FechaMysql = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dtm = "" + FechaMysql.format(new Date());

        conector c = new conector();
        String consulta = "call crearFlor('"
                + this.nombre + "','"
                + this.aroma +"','"
                + this.color + "',"
                + this.precio + ","
                + this.stock + ",'"
                + dtm + "','"
                + this.estado + "')";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public void actualizar(){
        conector c = new conector();
        System.out.println("Ingrese los nuevos datos de la flor");
        System.out.println("ID : " + this.idflor);
        System.out.print("Nombre : ");
        this.setNombre(Aux.leerTexto());
        System.out.print("Aroma : ");
        this.setAroma(Aux.leerTexto());
        System.out.print("Color : ");
        this.setColor(Aux.leerTexto());
        System.out.print("Precio : ");
        this.setPrecio(Aux.leerDecimalPositivo());
        System.out.print("Stock : ");
        this.setStock(Aux.leerEnteroPositivo());
        System.out.print("Estado : ");
        this.setEstado(Aux.leerTexto());
        System.out.println();

        String consulta = "call actualizarFlor("
                + this.idflor + ",'"
                + this.nombre + "','"
                + this.aroma +"','"
                + this.color + "', "
                + this.precio + ","
                + this.stock + ",'"
                + this.fcreacion + "','"
                + this.estado + "')";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public void eliminar(){
        conector c = new conector();
        String consulta = "call eliminarFlor("
                + this.idflor + ")";
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public boolean existeID(){
        boolean flag;
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call fExisteID(" + this.getIdflor() + ")");
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
        data = c.ejecutarProcedimientoConDatos("call fExiste('" + this.getNombre() + "','" + this.getAroma() + "','" + this.getColor() + "')");
        List<String> dato = data.get(0);
        if (Integer.parseInt(dato.get(0)) == 0){
            flag = false;
        }
        else {
            flag = true;
        }
        return flag;
    }
    public CFlor recuperarpID(int ID){
        CFlor f = new CFlor();
        conector c = new conector();
        data = c.ejecutarProcedimientoConDatos("call frecuperarID(" + ID + ")");
        for (List<String> dato: data ) {
            f.setIdflor(Integer.parseInt(dato.get(0)));
            f.setNombre(dato.get(1));
            f.setAroma(dato.get(2));
            f.setColor(dato.get(3));
            f.setPrecio(Double.parseDouble(dato.get(4)));
            f.setStock(Integer.parseInt(dato.get(5)));
            f.setFcreacion(dato.get(6));
            f.setEstado(dato.get(7));
        }
        return f;
    }
    public CFlor recuperarID(){
        CFlor f = new CFlor();
        conector c = new conector();
        System.out.println("Ingrese el ID de la flor");
        int ID = Aux.leerEnteroPositivo();
        data = c.ejecutarProcedimientoConDatos("call frecuperarID(" + ID + ")");
        for (List<String> dato: data ) {
            f.setIdflor(Integer.parseInt(dato.get(0)));
            f.setNombre(dato.get(1));
            f.setAroma(dato.get(2));
            f.setColor(dato.get(3));
            f.setPrecio(Double.parseDouble(dato.get(4)));
            f.setStock(Integer.parseInt(dato.get(5)));
            f.setFcreacion(dato.get(6));
            f.setEstado(dato.get(7));
        }
        return f;
    }
    public CFlor recuperarClave(){
        CFlor f = new CFlor();
        conector c = new conector();
        System.out.println("Ingrese la Clave de la flor");
        System.out.print("nombre: ");
        String nombre = Aux.leerTexto();
        System.out.print("aroma: ");
        String aroma = Aux.leerTexto();
        System.out.print("color: ");
        String color = Aux.leerTexto();
        System.out.println();
        data = c.ejecutarProcedimientoConDatos("call frecuperarClave('" + nombre + "','" + aroma + "','" + color + "')");
        for (List<String> dato: data ) {
            f.setIdflor(Integer.parseInt(dato.get(0)));
            f.setNombre(dato.get(1));
            f.setAroma(dato.get(2));
            f.setColor(dato.get(3));
            f.setPrecio(Double.parseDouble(dato.get(4)));
            f.setStock(Integer.parseInt(dato.get(5)));
            f.setFcreacion(dato.get(6));
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
