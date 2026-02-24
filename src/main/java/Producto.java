// CÓDIGO LEGACY CON ERRORES INTENCIONADOS
public class Producto {

    private String nombre;
    private double precioBase;
    private int tipoProducto; // 1 = Componente, 2 = Periférico, 3 = Servicio

    public static final int TIPO_COMPONENTE = 1;
    public static final int TIPO_PERIFERICO = 2;
    public static final int TIPO_SERVICIO = 3;

    public Producto(String nombre, double precioBase, int tipoProducto) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.tipoProducto = tipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precio;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioBase(double precioBase) {
        this.precio = precio;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
