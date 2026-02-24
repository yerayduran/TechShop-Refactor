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


    public void calcularImporteTotalConImpuestos(Producto[] productos) {

        // ERROR 2: Variables poco descriptivas - La variable 't' es críptica.
        // FUNCIONALIDAD: Esta variable actúa como un acumulador. Empieza en 0 y guarda la suma progresiva
        // del precio de cada producto más su IVA. Al final del método, representa el dinero total a pagar.
        // DEBERÍA HACERSE: Darle un nombre que indique que almacena el importe total acumulado.
        double t = 0.0;

        // ERROR 3: Robustez (NullPointerException)
        // El bucle accede directamente a las propiedades de cada elemento sin verificar si existen.
        // Si el array contiene posiciones vacías (huecos), el programa fallará al intentar leer datos de un nulo.
        // DEBERÍA HACERSE: Implementar una comprobación defensiva para asegurarse de que el objeto no es nulo antes de usarlo.
        for (int i = 0; i < productos.length; i++) {

            // ERROR 4: Números Mágicos (Magic Numbers)
            // El código utiliza números literales ('1', '2', '3') para identificar tipos y ('1.21', '1.10') para impuestos.
            // Esto hace que el código sea difícil de leer y muy costoso de mantener si los valores cambian.
            // DEBERÍA HACERSE: Sustituir estos números por Constantes con nombres que expliquen el significado de negocio de cada valor.

            if (productos[i].t == 1) {
                // Componentes tienen 21% de IVA
                t += productos[i].p * 1.21;
            } else if (productos[i].t == 2) {
                // Periféricos tienen 10% de IVA (Lógica antigua)
                t += productos[i].p * 1.10;
            } else if (productos[i].t == 3) {
                // Servicios exentos de IVA
                t += productos[i].p;
            }
        }
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