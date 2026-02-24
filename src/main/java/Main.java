public class Main {
    public static void main(String[] args) {
        GestorPedidos gestorPedidos  = new GestorPedidos();

        Producto[] lista = new Producto[3];

        lista[0] = new Producto("Intel i9", 450, 1);
        lista[1] = new Producto("Razer Mouse", 50, 2);
        // lista[2] es NULL

        System.out.println("Iniciando procesamiento...");

        double totalPedido = gestorPedidos.calcularImporteTotalConImpuestos(lista);
        gestorPedidos.mostrarResumenPedido(totalPedido);

        int numeroProductos = 2;
        String tipoEnvio = gestorPedidos.evaluarEnvio(numeroProductos);
        System.out.println("Tipo de envío aplicado: " + tipoEnvio);
    }
}