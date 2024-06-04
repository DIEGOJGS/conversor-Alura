import java.util.Scanner;

public class ConvertirMoneda {

    // Método para convertir de una moneda a otra
    public static void convertir(Moneda monedaBase, Moneda monedaTarget, ConsultarMoneda consulta, Scanner lectura) {
        try {
            Monedas monedas = consulta.buscarMoneda(monedaBase.codigo, monedaTarget.codigo); // Obtiene la tasa de cambio
            imprimirTasaDeConversion(monedaBase, monedaTarget, monedas.conversion_rate()); // Imprime la tasa de conversión
            double cantidad = obtenerCantidad(monedaBase, lectura); // Obtiene la cantidad a convertir
            double cantidadConvertida = cantidad * monedas.conversion_rate(); // Realiza la conversión
            imprimirResultado(monedaBase, monedaTarget, cantidad, cantidadConvertida); // Imprime el resultado
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada no válida. Por favor, ingrese un número."); // Maneja el error de entrada no numérica
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage()); // Maneja otros errores
        }
    }

    // Método para convertir entre otras monedas no predefinidas en el menú
    public static void convertirOtraMoneda(ConsultarMoneda consulta, Scanner lectura) {
        try {
            System.out.print("Ingrese el código de la moneda base: ");
            String monedaBase = lectura.nextLine().toUpperCase(); // Lee y convierte a mayúsculas el código de la moneda base
            System.out.print("Ingrese el código de la moneda objetivo: ");
            String monedaObjetivo = lectura.nextLine().toUpperCase(); // Lee y convierte a mayúsculas el código de la moneda objetivo
            convertir(new Moneda(monedaBase), new Moneda(monedaObjetivo), consulta, lectura); // Llama al método convertir con las monedas ingresadas
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); // Maneja errores
        }
    }

    // Método para imprimir la tasa de conversión
    private static void imprimirTasaDeConversion(Moneda monedaBase, Moneda monedaTarget, double tasa) {
        System.out.println("***********************************************************");
        System.out.println("Tasa de conversión actual:");
        System.out.printf("1 %s = %.4f %s%n", monedaBase.codigo, tasa, monedaTarget.codigo);
        System.out.println("***********************************************************");
    }

    // Método para obtener la cantidad a convertir del usuario
    private static double obtenerCantidad(Moneda monedaBase, Scanner lectura) {
        System.out.print("Ingrese la cantidad de " + monedaBase.codigo + ": ");
        return Double.parseDouble(lectura.nextLine());
    }

    // Método para imprimir el resultado de la conversión
    private static void imprimirResultado(Moneda monedaBase, Moneda monedaTarget, double cantidad, double cantidadConvertida) {
        System.out.println("***********************************************************");
        System.out.printf("%.2f %s = %.2f %s%n", cantidad, monedaBase.codigo, cantidadConvertida, monedaTarget.codigo);
        System.out.println("***********************************************************");
    }
}
