# Sistema de Gestión de Paquetes Turísticos

Este proyecto consiste en el desarrollo de un sistema orientado a objetos en **Java (JavaSE-21)**
diseñado para calcular el costo final de paquetes turísticos personalizados.
La solución ha sido construida bajo el enfoque de **Desarrollo Guiado por Pruebas (TDD)** utilizando **JUnit 4**, garantizando un diseño extensible, simple y robusto que cumple con las buenas prácticas de la programación orientada a objetos.

---

## 📌 Contexto del Problema

Una agencia de turismo requiere automatizar el cálculo de los costos de sus paquetes turísticos según el destino, la duración y el tipo de hospedaje, permitiendo además la adición de múltiples servicios complementarios no repetidos. Adicionalmente, el negocio exige la flexibilidad de aplicar diferentes estrategias de descuentos y una restricción estricta sobre el presupuesto máximo permitido.

---

## 🛠️ Tecnologías y Conceptos Utilizados

* **Lenguaje:** Java (Versión 21)
* **IDE:** Eclipse
* **Pruebas Unitarias:** JUnit 4 con enfoque TDD (Test-Driven Development)
* **Estructuras de Datos:** Colecciones (`Set` / `HashSet`) para asegurar elementos sin duplicados en los servicios.
* **Patrones de Diseño y POO:** 
  * **Clases Abstractas e Interfaces:** Utilizadas para estructurar las estrategias de cálculo y la lógica extensible de servicios.
  * **Patrón Strategy:** Implementado de manera efectiva para desacoplar el cálculo del costo final del paquete turístico, facilitando la adición de nuevos tipos de descuentos sin alterar la estructura del paquete.

---

## 🚀 Arquitectura y Reglas de Negocio

### 1. Paquetes Turísticos
Cada paquete almacena un costo base, cantidad de días, destino (local o internacional), tipo de alojamiento (hostel, 3 estrellas o 5 estrellas) y una colección de servicios complementarios únicos.
* **Inmutabilidad:** La cantidad de días y el destino no se pueden modificar luego de instanciado el paquete.
* **Paquete Premium:** Se clasifica automáticamente si es internacional Y cumple con (alojamiento 5 estrellas O duración mayor a 7 días).
* **Paquete Extendido:** Se clasifica automáticamente si la estancia es mayor a 14 días.

### 2. Servicios Complementarios
Se modelaron bajo una estructura común los siguientes 3 servicios que impactan el costo final:
* **Seguro de Viaje:** Precio fijo por día. Si el destino es internacional, el costo del seguro se incrementa en un 20% (multiplicador 1.20).
* **Traslado Aeropuerto-Hotel:** Precio base fijo. Si el paquete es catalogado como Premium, se le suman $35.000 adicionales.
* **Excursiones Guiadas:** Precio base fijo. Si el paquete es Extendido, su precio se duplica automáticamente.

### 3. Estrategias de Cálculo de Costo (Patrón Strategy)
El sistema implementa tres tipos de liquidaciones:
* `CostoFinal`: Retorna el costo base del paquete más la suma de los servicios aplicados.
* `CostoFinalConDescuentoPorcentaje`: Aplica un descuento porcentual sobre el total acumulado.
* `CostoFinalConDescuentoFijo`: Resta un monto fijo en pesos al total acumulado.

---

## 📊 Caso de Simulación Obligatorio

El repositorio incluye la resolución del ejercicio obligatorio que simula el costo de un **Paquete Premium** con los siguientes datos base:
* **Costo base:** $520.000 | **Días:** 12 | **Destino:** Internacional | **Alojamiento:** 5 estrellas
* **Servicios:** Seguro de viaje ($4.000/día), Traslados ($30.000 base) y Excursiones ($15.000 base).

### Resultados validados mediante Pruebas Unitarias

---

## 🧪 Pruebas Significativas Realizadas (TDD)

El archivo de pruebas unitarias (`PaqueteTuristicoTest.java`) cubre los requisitos mínimos exigidos mediante escenarios críticos:
1. **Detección Automática de Categorías:** Verificación de las condiciones lógicas para clasificar paquetes como *Premium* y *Extendido*.
2. **Cálculo de Servicios Individuales:** Comprobación del correcto comportamiento y penalizaciones del Seguro, Traslados y Excursiones según el contexto del paquete.
3. **Cálculo Final Integrado:** Validación de la sumatoria total del paquete sin descuentos.
4. **Validación de Estrategias con Descuento:** Ejecución exacta de los escenarios matemáticos con descuentos fijos y porcentuales de la simulación.
---
Desarrollado por [Emanuel Ruiz Díaz](https://github.com/emanuelruizdiazok).
