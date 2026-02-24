/**
 * Representa un producto dentro del inventario de TechShop.
 * Contiene la información básica como el nombre, el precio sin impuestos
 * y la categoría a la que pertenece.
 *
 * @author Yeray, Rubén, Daniel y Manuel
 */
public class Producto {

    private String nombre;
    private double precioBase;
    private int tipoProducto;

    public static final int TIPO_COMPONENTE = 1;
    public static final int TIPO_PERIFERICO = 2;
    public static final int TIPO_SERVICIO = 3;

    /**
     * Constructor para crear un nuevo Producto.
     *
     * @param nombre       El nombre comercial o descripción del producto.
     * @param precioBase   El precio del producto antes de aplicar cualquier impuesto.
     * @param tipoProducto El identificador de la categoría del producto (1, 2 o 3).
     */
    public Producto(String nombre, double precioBase, int tipoProducto) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.tipoProducto = tipoProducto;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Una cadena de texto con el nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio base del producto.
     *
     * @return El valor numérico del precio sin impuestos.
     */
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Obtiene el tipo o categoría del producto.
     *
     * @return Un número entero que representa si es componente, periférico o servicio.
     */
    public int getTipoProducto() {
        return tipoProducto;
    }

    /**
     * Modifica el nombre del producto.
     *
     * @param nombre El nuevo nombre que se le asignará al producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Modifica el precio base del producto.
     *
     * @param precioBase El nuevo precio sin impuestos.
     */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Modifica la categoría del producto.
     *
     * @param tipoProducto El nuevo identificador de la categoría.
     */
    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}