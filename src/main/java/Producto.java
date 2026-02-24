// CÓDIGO LEGACY CON ERRORES INTENCIONADOS
public class Producto {

    public String nombre;
    public double precio;
    public int dineroTotal; // 1 = Componente, 2 = Periférico, 3 = Servicio

    public Producto(String nombre, double precio, int dineroTotal) {
        this.nombre = nombre;
        this.precio = precio;
        this.dineroTotal = dineroTotal;
    }
}