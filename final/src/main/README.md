# EnvíaYa

Programa en Java para registrar paquetes y organizar los despachos de una empresa de mensajería.

## ¿Qué hace el programa?

- Crea despachos con un código consecutivo y el nombre del mensajero.
- Registra paquetes estándar, express y frágiles.
- Valida la guía, el peso y los datos de cada paquete.
- Evita que se repitan las guías y que la moto supere los 30 kg.
- Calcula el costo de cada envío.
- Ordena los paquetes según el servicio y la ruta.
- Imprime el manifiesto con el peso, el costo total y las advertencias.

## Cómo ejecutar

Se necesita Java 17 o una versión superior y Maven.

Desde la carpeta del proyecto, ejecutar:

```bash
mvn clean package
java -cp target/classes com.enviaya.Main
```

También se puede abrir el proyecto en IntelliJ IDEA y ejecutar la clase `Main`.

## Clases principales

- `Main`: ejecuta los casos de prueba.
- `ManifiestoObligatorio`: registra los paquetes, controla el peso y muestra el manifiesto.
- `Paquete`: contiene los datos comunes de los paquetes.
- `PaqueteEstandar`, `PaqueteExpress` y `PaqueteFragil`: representan los tres servicios y calculan sus costos.
- `Zona`: guarda las tarifas y el orden de las zonas.
- `CostoCalculable`: interfaz para el cálculo del costo.
- `ValidadorPaquete`: contiene las validaciones.
- `excepciones`: contiene los errores personalizados del programa.

## ¿Cómo funciona?

Primero se crea un despacho y se registra el mensajero. Después se agregan los paquetes. Cada paquete valida sus datos antes de ser aceptado. Si la guía está repetida o se supera el peso máximo de 30 kg, el paquete no se agrega y se muestra un mensaje.

Al imprimir el manifiesto, los paquetes express aparecen primero. Luego se ordenan por la ruta Centro, Norte, Sur y Oriente. Si dos paquetes están en la misma zona, se ordenan por número de guía.

## Principios SOLID

**Responsabilidad Única (SRP):** cada clase tiene una función. Por ejemplo, `ValidadorPaquete` valida datos, `ManifiestoObligatorio` administra el despacho y `Main` ejecuta las pruebas.

**Abierto/Cerrado (OCP):** los tipos de paquete heredan de `Paquete` y cada uno calcula su propio costo. Así se puede agregar otro tipo de servicio creando una nueva clase, sin cambiar la lógica principal del despacho para calcular los costos.

## Excepciones personalizadas

El programa utiliza excepciones para informar estos errores:

- Guía con formato incorrecto.
- Peso inválido o superior al permitido para un paquete.
- Contenido vacío en un paquete frágil.
- Guía repetida.
- Peso total del despacho superior a 30 kg.
- Nombre del mensajero vacío.

## Pruebas

La clase `Main` ejecuta los cuatro casos evaluadores del enunciado, incluyendo registros correctos y datos inválidos.
