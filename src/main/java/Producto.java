// CÓDIGO LEGACY CON ERRORES INTENCIONADOS
public class Producto {

    private String nombre;
    private double precio;
    private int tipoProducto; // 1 = Componente, 2 = Periférico, 3 = Servicio

    public static final int TIPO_COMPONENTE = 1;
    public static final int TIPO_PERIFERICO = 2;
    public static final int TIPO_SERVICIO = 3;

    public Producto(String nombre, double precio, int tipoProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}