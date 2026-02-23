import java.util.ArrayList;

/**
 * CÓDIGO LEGACY - PROYECTO TECHSHOP
 * * Esta clase contiene la lógica de negocio antigua que debe ser refactorizada.
 * Está llena de "Code Smells" (malas prácticas) y errores de diseño intencionados
 * para que los alumnos practiquen la limpieza de código y el uso de Linters.
 */
public class GestorPedidos {

    /**
     * ERROR 1: Naming (Nombrado) - El nombre 'calcular' es muy genérico.
     * FUNCIONALIDAD: Este método recibe una lista de productos, recorre cada uno, determina su tipo,
     * le aplica el impuesto correspondiente (IVA) y suma todos los importes para obtener el coste final del pedido.
     * DEBERÍA HACERSE: Renombrar el método para que refleje esta operación de cálculo total con impuestos.
     */
    public void calcular(Producto[] productos) {

        // ERROR 2: Variables poco descriptivas - La variable 't' es críptica.
        // FUNCIONALIDAD: Esta variable actúa como un acumulador. Empieza en 0 y guarda la suma progresiva
        // del precio de cada producto más su IVA. Al final del método, representa el dinero total a pagar.
        // DEBERÍA HACERSE: Darle un nombre que indique que almacena el importe total acumulado.
        double t = 0;

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

        // ERROR 5: Responsabilidad Única / Salida por Consola
        // Este método mezcla la lógica de cálculo con la presentación de datos por consola.
        // Esto limita la reutilización del código, ya que no permite obtener el resultado para usarlo en otra parte.
        // DEBERÍA HACERSE: Modificar el método para que devuelva el dato calculado en lugar de imprimirlo.
        if (t > 1000) {
            System.out.println("Pedido Grande: " + t);
        } else {
            System.out.println("Pedido Normal: " + t);
        }

        try {
            // Simulación de envío a base de datos legacy
            // Esto provocará una ArithmeticException (división por cero) intencionada
            int check = 10 / 0;
        } catch (Exception e) {
            // ERROR 6: Silenciamiento de Excepciones (Swallowed Exception)
            // Se captura la excepción pero no se hace nada con ella. El error pasa desapercibido.
            // DEBERÍA HACERSE: Gestionar la excepción adecuadamente, registrando el error (Log) o notificándolo.
        }
    }

    // ERROR 7: Código Muerto (Dead Code)
    // El análisis del código revela que este método nunca es invocado desde ninguna parte del proyecto.
    // DEBERÍA HACERSE: Eliminar el código innecesario para mantener el proyecto limpio.
    public boolean checkStock(String n) {
        return true;
    }

    /**
     * ERROR 8: Bug Lógico en Límites (Boundary Testing)
     * La lógica condicional deja un caso sin cubrir explícitamente, provocando un comportamiento erróneo.
     * Analiza qué ocurre exactamente cuando el número de productos coincide con el valor frontera (5).
     * * DEBERÍA HACERSE: Ajustar los operadores de comparación para asegurar que todos los casos posibles están cubiertos correctamente.
     */
    public String evaluarEnvio(int numeroProductos) {
        if (numeroProductos < 5) {
            return "Envio Estandar";
        } else if (numeroProductos > 5 && numeroProductos < 10) {
            return "Envio Descuento";
        } else {
            return "Envio Premium";
        }
    }
}