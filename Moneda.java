// Clase para definir constantes de códigos de moneda
public class Moneda {
    public final String codigo;

    public Moneda(String codigo) {
        this.codigo = codigo;
    }

    public static final Moneda USD = new Moneda("USD");
    public static final Moneda ARS = new Moneda("ARS");
    public static final Moneda BRL = new Moneda("BRL");
    public static final Moneda COP = new Moneda("COP");
    public static final Moneda PEN = new Moneda("PEN");
}
