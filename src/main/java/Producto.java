// CÓDIGO LEGACY CON ERRORES INTENCIONADOS
public class Producto {

    public String n;
    public double p;
    public int t; // 1 = Componente, 2 = Periférico, 3 = Servicio

    public Producto(String n, double p, int t) {
        this.n = n;
        this.p = p;
        this.t = t;
    }
}