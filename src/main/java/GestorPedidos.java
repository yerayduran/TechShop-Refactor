import java.util.ArrayList;

/**
 * CÓDIGO LEGACY - PROYECTO TECHSHOP
 * * Esta clase contiene la lógica de negocio antigua que debe ser refactorizada.
 * Está llena de "Code Smells" (malas prácticas) y errores de diseño intencionados
 * para que los alumnos practiquen la limpieza de código y el uso de Linters.
 */
public class GestorPedidos {

    private static final double PRECIO_CON_IVA_COMPONENTE = 1.21;
    private static final double PRECIO_CON_IVA_PERIFERICO = 1.10;
    private static final double PRECIO_ACCESIBLE_DE_PEDIDO_GRANDE = 1000.0;

    private static final int LIMITE_ENVIO_ESTANDAR_SUPERIOR = 5;
    private static final int LIMITE_ENVIO_DESCUENTO_SUPERIOR = 10;


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

    private double calcularImporteProductoConImpuestos(Producto producto) {
        double precioBase = producto.getPrecioBase();
        int tipoProducto = producto.getTipoProducto();

        if (tipoProducto == Producto.TIPO_COMPONENTE) {
            return precioBase * PRECIO_CON_IVA_COMPONENTE;
        } else if (tipoProducto == Producto.TIPO_PERIFERICO) {
            return precioBase * PRECIO_CON_IVA_PERIFERICO;
        } else if (tipoProducto == Producto.TIPO_SERVICIO) {
            return precioBase;
        }

        return precioBase;
    }

    /**
     *
     * @param totalDelPedido
     */
    public void mostrarResumenPedido(double totalDelPedido) {

        if (totalDelPedido > PRECIO_ACCESIBLE_DE_PEDIDO_GRANDE) {
            System.out.println("Pedido Grande: " + totalDelPedido);
        } else {
            System.out.println("Pedido Normal: " + totalDelPedido);
        }

        try {
            int check = 10 / 0;
        } catch (ArithmeticException e) {
           System.err.println("Se ha producido un error al registrar el pedido en el sistema legacy: " + e.getMessage());
        }
    }

    /**
     *
     * @param numeroProductos
     * @return
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