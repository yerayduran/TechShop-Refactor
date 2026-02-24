import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class GestorPedidosTest {

    private GestorPedidos gestorPedidos;

    @BeforeEach
    void setUp() {
        gestorPedidos = new GestorPedidos();
    }


    @Test
    void calcularImporteTotalConImpuestos_componente() {
        Producto[] productos = {
                new Producto("CPU i9", 450.0, Producto.TIPO_COMPONENTE)
        };

        double total = gestorPedidos.calcularImporteTotalConImpuestos(productos);

        assertEquals(544.5, total, 0.001, "CPU i9: 450 * 1.21 = 544.5");
    }

    @Test
    void calcularImporteTotalConImpuestos_periferico() {
        Producto[] productos = {
                new Producto("Razer Mouse", 50.0, Producto.TIPO_PERIFERICO)
        };

        double total = gestorPedidos.calcularImporteTotalConImpuestos(productos);

        assertEquals(55.0, total, 0.001, "Mouse: 50 * 1.10 = 55.0");
    }

    @Test
    void calcularImporteTotalConImpuestos_servicio() {
        Producto[] productos = {
                new Producto("Soporte técnico", 100.0, Producto.TIPO_SERVICIO)
        };

        double total = gestorPedidos.calcularImporteTotalConImpuestos(productos);

        assertEquals(100.0, total, 0.001, "Servicio sin IVA");
    }

    @Test
    void calcularImporteTotalConImpuestos_variosTipos() {
        Producto[] productos = {
                new Producto("CPU", 450.0, Producto.TIPO_COMPONENTE),
                new Producto("Teclado", 80.0, Producto.TIPO_PERIFERICO),
                new Producto("Instalación", 120.0, Producto.TIPO_SERVICIO)
        };

        double total = gestorPedidos.calcularImporteTotalConImpuestos(productos);

        assertEquals(752.5, total, 0.001);
    }

    @Test
    void calcularImporteTotalConImpuestos_arrayVacio() {
        Producto[] productos = new Producto[0];

        double total = gestorPedidos.calcularImporteTotalConImpuestos(productos);

        assertEquals(0.0, total);
    }

    @Test
    void calcularImporteTotalConImpuestos_arrayNulo() {
        double total = gestorPedidos.calcularImporteTotalConImpuestos(null);

        assertEquals(0.0, total);
    }

    @Test
    void calcularImporteTotalConImpuestos_conNulls() {
        Producto[] productos = {
                new Producto("CPU", 450.0, Producto.TIPO_COMPONENTE),
                null,
                new Producto("Mouse", 50.0, Producto.TIPO_PERIFERICO),
                null
        };

        double total = gestorPedidos.calcularImporteTotalConImpuestos(productos);

        assertEquals(599.5, total, 0.001);
    }

    @Test
    void calcularImporteTotalConImpuestos_tipoDesconocido() {
        Producto[] productos = {
                new Producto("Producto raro", 200.0, 99) // tipo inválido
        };

        double total = gestorPedidos.calcularImporteTotalConImpuestos(productos);

        assertEquals(200.0, total);
    }

    @ParameterizedTest
    @CsvSource({
            "4,  'Envio Estandar'",
            "5,  'Envio Estandar'",   // (BUG CORREGIDO)
            "6,  'Envio Descuento'",
            "9,  'Envio Descuento'",
            "10, 'Envio Premium'",
            "11, 'Envio Premium'"
    })

    void evaluarEnvio_fronteras(int numeroProductos, String tipoEsperado) {
        String tipoEnvio = gestorPedidos.evaluarEnvio(numeroProductos);
        assertEquals(tipoEsperado, tipoEnvio);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void evaluarEnvio_estandar(int numeroProductos) {
        String tipoEnvio = gestorPedidos.evaluarEnvio(numeroProductos);
        assertEquals("Envio Estandar", tipoEnvio);
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8, 9})
    void evaluarEnvio_descuento(int numeroProductos) {
        String tipoEnvio = gestorPedidos.evaluarEnvio(numeroProductos);
        assertEquals("Envio Descuento", tipoEnvio);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 15, 20, 50})
    void evaluarEnvio_premium(int numeroProductos) {
        String tipoEnvio = gestorPedidos.evaluarEnvio(numeroProductos);
        assertEquals("Envio Premium", tipoEnvio);
    }

    @Test
    @DisplayName("Evaluar envío con número negativo aplica estándar")
    void evaluarEnvio_negativo() {
        String tipoEnvio = gestorPedidos.evaluarEnvio(-1);
        assertEquals("Envio Estandar", tipoEnvio);
    }


    @Test
    void mostrarResumenPedido_grande() {
        assertDoesNotThrow(() -> gestorPedidos.mostrarResumenPedido(1500.0));
    }

    @Test
    void mostrarResumenPedido_normal() {
        assertDoesNotThrow(() -> gestorPedidos.mostrarResumenPedido(500.0));
    }

    @Test
    void mostrarResumenPedido_manejaExcepcion() {
        assertDoesNotThrow(() -> gestorPedidos.mostrarResumenPedido(500.0));
    }
}