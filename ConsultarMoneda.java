import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpConnectTimeoutException;
import java.io.IOException;

public class ConsultarMoneda {

    // Constantes para la clave de API y URL base de la API
    private static final String API_KEY = "6d17cc3b1aa58e6d86442f08";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    // Método para buscar la tasa de cambio entre dos monedas
    public Monedas buscarMoneda(String monedaBase, String monedaTarget) {
        URI direccion = URI.create(API_URL + monedaBase + "/" + monedaTarget); // Construye la URL de la solicitud
        HttpClient client = HttpClient.newHttpClient(); // Crea un cliente HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Envía la solicitud y obtiene la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) { // Verifica si la respuesta es exitosa
                // Convierte la respuesta JSON a un objeto Monedas usando Gson
                return new Gson().fromJson(response.body(), Monedas.class);
            } else {
                throw new RuntimeException("Error en la respuesta del servidor: " + response.statusCode());
            }
        } catch (HttpConnectTimeoutException e) {
            throw new RuntimeException("Error: Tiempo de conexión agotado. Verifique su conexión a Internet.", e);
        } catch (IOException e) {
            throw new RuntimeException("Error: Problema de E/S. No se pudo obtener la tasa de cambio.", e);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error: La solicitud fue interrumpida.", e);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener la tasa de cambio: " + e.getMessage(), e);
        }
    }
}
