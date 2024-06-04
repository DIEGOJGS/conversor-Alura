# Conversor de Monedas-Alura

Este proyecto es un conversor de monedas que utiliza la API de ExchangeRate-API para obtener las tasas de cambio actuales entre diferentes monedas. El programa permite convertir entre varias monedas, incluidas USD, ARS, BRL, COP y PEN, y también permite la conversión entre otras monedas especificadas por el usuario.

## Estructura del Proyecto

El proyecto consta de las siguientes clases:

1. **Principal**: La clase principal que contiene el menú y la lógica de control del programa.
2. **ConsultarMoneda**: Clase que maneja las solicitudes HTTP a la API de ExchangeRate-API y obtiene las tasas de cambio.
3. **ConvertirMoneda**: Clase que maneja la lógica de conversión de monedas y la interacción con el usuario.
4. **Monedas**: Clase `record` que representa la estructura de datos de la tasa de cambio obtenida de la API.
5. **Moneda**: Clase que define constantes para los códigos de moneda.

## Requisitos

- Java 11 o superior.
- Conexión a Internet para acceder a la API de ExchangeRate-API.

## Configuración y Ejecución

1. Clona este repositorio en tu máquina local:
    ```sh
    git clone https://github.com/tu-usuario/conversor-de-monedas.git
    cd conversor-de-monedas
    ```

2. Asegúrate de tener Java instalado y configurado en tu sistema.

3. Compila y ejecuta el programa:
    ```sh
    javac Principal.java
    java Principal
    ```

## Uso del Programa

1. Al ejecutar el programa, verás un menú con las opciones disponibles para la conversión de monedas.

2. Selecciona la conversión deseada ingresando el número correspondiente.

3. Ingresa la cantidad que deseas convertir cuando se te solicite.

4. El programa mostrará el resultado de la conversión y te devolverá al menú principal.

5. Puedes elegir otra conversión o salir del programa ingresando la opción correspondiente.

## Manejo de Errores

- El programa maneja entradas no válidas y muestra mensajes de error apropiados.
- En caso de problemas con la conexión a la API, se proporcionarán mensajes de error detallados.

## Explicación de las Clases

### Principal
Contiene el menú principal y la lógica de control para ejecutar el programa. Utiliza un bucle `while` para mostrar el menú y manejar las opciones ingresadas por el usuario.

### ConsultarMoneda
Esta clase se encarga de realizar solicitudes HTTP a la API de ExchangeRate-API para obtener las tasas de cambio. Maneja las respuestas y errores de la API.

### ConvertirMoneda
Maneja la lógica de conversión de monedas. Solicita la cantidad a convertir al usuario, realiza la conversión usando la tasa de cambio obtenida y muestra el resultado.

### Monedas
Es un `record` que representa la estructura de los datos de la tasa de cambio obtenidos de la API.

### Moneda
Define constantes para los códigos de moneda para evitar errores tipográficos y mejorar la legibilidad del código.

## Ejemplo de Uso
    CONVERSOR DE MONEDAS                   *
    1.	Dólar (USD) a Peso Argentino (ARS)
    2.	Peso Argentino (ARS) a Dólar (USD)
    3.	Dólar (USD) a Real Brasileño (BRL)
    4.	Real Brasileño (BRL) a Dólar (USD)
    5.	Dólar (USD) a Peso Colombiano (COP)
    6.	Peso Colombiano (COP) a Dólar (USD)
    7.	Dólar (USD) a Sol Peruano (PEN)
    8.	Sol Peruano (PEN) a Dólar (USD)
    9.	Convertir otra moneda
    10.	Salir

Elige una opción y sigue las instrucciones para convertir la moneda deseada.

## Contribuciones

Las contribuciones son bienvenidas. Si tienes alguna mejora o corrección, por favor envía un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Ver el archivo [LICENSE](./LICENSE) para más detalles.


