import java.util.Scanner;

public class Principal {

    // Menú principal que muestra las opciones de conversión disponibles
    private static final String MENU =
            "***********************************************************\n" +
                    "*                   CONVERSOR DE MONEDAS                   *\n" +
                    "***********************************************************\n" +
                    "Seleccione la conversión que desea realizar:\n" +
                    "1. Dólar (USD) a Peso Argentino (ARS)\n" +
                    "2. Peso Argentino (ARS) a Dólar (USD)\n" +
                    "3. Dólar (USD) a Real Brasileño (BRL)\n" +
                    "4. Real Brasileño (BRL) a Dólar (USD)\n" +
                    "5. Dólar (USD) a Peso Colombiano (COP)\n" +
                    "6. Peso Colombiano (COP) a Dólar (USD)\n" +
                    "7. Dólar (USD) a Sol Peruano (PEN)\n" +
                    "8. Sol Peruano (PEN) a Dólar (USD)\n" +
                    "9. Convertir otra moneda\n" +
                    "10. Salir\n" +
                    "***********************************************************\n" +
                    "Ingrese una opción: ";

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in); // Inicializa el objeto Scanner para leer la entrada del usuario
        ConsultarMoneda consulta = new ConsultarMoneda(); // Inicializa la clase que consulta las tasas de cambio
        int opcion = 0; // Variable para almacenar la opción seleccionada por el usuario

        // Bucle que se ejecuta hasta que el usuario elija salir (opción 10)
        while (opcion != 10) {
            imprimirMenu(); // Muestra el menú al usuario
            if (lectura.hasNextInt()) {
                opcion = lectura.nextInt(); // Lee la opción ingresada por el usuario
                lectura.nextLine(); // Limpia el buffer del scanner

                // Switch para manejar la opción seleccionada por el usuario
                switch (opcion) {
                    case 1:
                        ConvertirMoneda.convertir(Moneda.USD, Moneda.ARS, consulta, lectura);
                        break;
                    case 2:
                        ConvertirMoneda.convertir(Moneda.ARS, Moneda.USD, consulta, lectura);
                        break;
                    case 3:
                        ConvertirMoneda.convertir(Moneda.USD, Moneda.BRL, consulta, lectura);
                        break;
                    case 4:
                        ConvertirMoneda.convertir(Moneda.BRL, Moneda.USD, consulta, lectura);
                        break;
                    case 5:
                        ConvertirMoneda.convertir(Moneda.USD, Moneda.COP, consulta, lectura);
                        break;
                    case 6:
                        ConvertirMoneda.convertir(Moneda.COP, Moneda.USD, consulta, lectura);
                        break;
                    case 7:
                        ConvertirMoneda.convertir(Moneda.USD, Moneda.PEN, consulta, lectura);
                        break;
                    case 8:
                        ConvertirMoneda.convertir(Moneda.PEN, Moneda.USD, consulta, lectura);
                        break;
                    case 9:
                        ConvertirMoneda.convertirOtraMoneda(consulta, lectura);
                        break;
                    case 10:
                        System.out.println("Saliendo..."); // Mensaje de salida
                        break;
                    default:
                        System.out.println("Opción no válida, por favor intente nuevamente."); // Mensaje de error para opción no válida
                        break;
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número."); // Mensaje de error para entrada no numérica
                lectura.next(); // Descarta la entrada no válida
            }
        }
        lectura.close(); // Cierra el Scanner al terminar
    }

    // Método para imprimir el menú
    private static void imprimirMenu() {
        System.out.print(MENU);
    }
}
