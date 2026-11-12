# EnviaYa

Sistema de despachos para una empresa de mensajería.

## Funcionalidades

- Registro de paquetes.
- Validación de guías.
- Control de peso máximo por paquete.
- Control de peso máximo del despacho.
- Cálculo automático de costos.
- Servicios estándar, express y frágil.
- Advertencias de manejo especial.
- Generación de manifiestos.
- Ordenamiento por prioridad de entrega.

## Principios SOLID utilizados

### 1. Open/Closed Principle (OCP)

La clase abstracta Paquete permite agregar nuevos tipos de servicio sin modificar las clases existentes. Por ejemplo, en el futuro se podría crear una clase PaqueteRefrigerado heredando de Paquete.

### 2. Single Responsibility Principle (SRP)

La clase Validador solo se encarga de validar datos. La clase Despacho administra los paquetes y la generación del manifiesto. Cada clase tiene una responsabilidad específica.

## Lógica utilizada

Cada paquete conoce cómo calcular su propio costo mediante herencia y polimorfismo. El despacho almacena los paquetes en una colección, controla el peso máximo permitido y ordena los envíos según las reglas definidas por la empresa antes de imprimir el manifiesto.