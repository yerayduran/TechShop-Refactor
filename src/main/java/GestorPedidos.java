/**
 * Clase que gestiona la lógica de negocio de los pedidos.
 * Se encarga de calcular importes totales aplicando impuestos según el tipo
 * de producto y de determinar las condiciones de envío.
 *
 * @author Yeray, Rubén, Daniel y Manuel
 */
public class GestorPedidos {

    private static final double PRECIO_CON_IVA_COMPONENTE = 1.21;
    private static final double PRECIO_CON_IVA_PERIFERICO = 1.10;
    private static final double PRECIO_ACCESIBLE_DE_PEDIDO_GRANDE = 1000.0;

    private static final int LIMITE_ENVIO_ESTANDAR_SUPERIOR = 5;
    private static final int LIMITE_ENVIO_DESCUENTO_SUPERIOR = 10;

    /**
     * Calcula el coste total de un pedido, iterando sobre un array de productos
     * y sumando el importe de cada uno con sus respectivos impuestos aplicados.
     *
     * @param productos Un array de objetos Producto que forman el pedido.
     * @return El importe total del pedido con todos los impuestos incluidos.
     * Devuelve 0.0 si el array es nulo.
     */
    public double calcularImporteTotalConImpuestos(Producto[] productos) {
        double totalPedido = 0.0;

        if (productos == null) {
            return 0.0;
        }

        for (Producto producto : productos) {
            if (producto == null) {
                continue;
            }

            double importeProducto = calcularImporteProductoConImpuestos(producto);
            totalPedido += importeProducto;
        }

        return totalPedido;
    }

    /**
     * Calcula el importe de un único producto aplicando el IVA correspondiente
     * según su categoría. Es un método auxiliar interno.
     *
     * @param producto El objeto Producto sobre el que calcular el importe.
     * @return El precio base del producto multiplicado por su impuesto correspondiente.
     */
    private double calcularImporteProductoConImpuestos(Producto producto) {
        double precioBase = producto.getPrecioBase();
        int tipoProducto = producto.getTipoProducto();

        if (tipoProducto == Producto.TIPO_COMPONENTE) {
            return precioBase * PRECIO_CON_IVA_COMPONENTE;
        } else if (tipoProducto == Producto.TIPO_PERIFERICO) {
            return precioBase * PRECIO_CON_IVA_PERIFERICO;
        } else if (tipoProducto == Producto.TIPO_SERVICIO) {
            return precioBase; // Sin IVA
        }

        return precioBase;
    }

    /**
     * Muestra por consola un resumen indicando si el pedido es de tamaño normal
     * o grande en función de su coste total.
     *
     * @param totalPedido El coste total calculado del pedido.
     */
    public void mostrarResumenPedido(double totalPedido) {

        if (totalPedido > PRECIO_ACCESIBLE_DE_PEDIDO_GRANDE) {
            System.out.println("Pedido Grande: " + totalPedido);
        } else {
            System.out.println("Pedido Normal: " + totalPedido);
        }

        try {
            int check = 10 / 0; // Legacy exception intencionada
        } catch (ArithmeticException e) {
            System.err.println("Se ha producido un error al registrar el pedido en el sistema legacy: " + e.getMessage());
        }
    }

    /**
     * Determina la categoría del envío basándose en el número total de artículos
     * comprados. A mayor número de artículos, mejores condiciones de envío.
     *
     * @param numeroProductos La cantidad total de productos en el carrito.
     * @return Una cadena de texto indicando el tipo de envío ("Envio Estandar",
     * "Envio Descuento" o "Envio Premium").
     */
    public String evaluarEnvio(int numeroProductos) {
        if (numeroProductos <= LIMITE_ENVIO_ESTANDAR_SUPERIOR) {
            return "Envio Estandar";
        } else if (numeroProductos > LIMITE_ENVIO_ESTANDAR_SUPERIOR && numeroProductos < LIMITE_ENVIO_DESCUENTO_SUPERIOR) {
            return "Envio Descuento";
        } else {
            return "Envio Premium";
        }
    }
}