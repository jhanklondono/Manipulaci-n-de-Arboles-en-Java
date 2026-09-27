# Tree-Stock

Sistema de inventario en consola que organiza productos usando un
**Árbol Binario de Búsqueda (ABB)** implementado manualmente en Java.

## Autor(es)

Jhank Dair Londoño Cifuentes

## Objetivo

Comprender el concepto de árbol binario de búsqueda y su estructura
lógica, aplicándolo en un sistema de inventario que permite
registrar, listar y buscar productos usando recursividad.

## 1. ¿Qué es un Árbol Binario de Búsqueda y cómo se aplica aquí?

Un **Árbol Binario de Búsqueda (ABB)** es una estructura de datos
formada por **nodos**. Cada nodo tiene como máximo dos hijos: un
**hijo izquierdo** y un **hijo derecho**. La regla que define un ABB
es la siguiente:

> Para cualquier nodo del árbol, todos los valores del subárbol
> izquierdo son **menores** que el valor de ese nodo, y todos los
> valores del subárbol derecho son **mayores**.

En Tree-Stock, cada nodo es un objeto `Producto`, y el valor que se
compara es su `id`. Los punteros `izquierdo` y `derecho` dentro de
`Producto` no son flechas físicas: son simplemente referencias a
otros objetos `Producto`, y son los que le dan forma de árbol a la
estructura completa.

### ¿Por qué se usa recursividad?

Gracias a la regla del ABB, cada operación se puede resolver
respondiendo la misma pregunta una y otra vez: **"¿el dato que busco
va a la izquierda o a la derecha del nodo actual?"**. Esa pregunta
se repite sobre un subárbol cada vez más pequeño, hasta llegar a un
punto donde ya no hay más nodos (`null`). Ese punto se llama **caso
base**, y es el que detiene la recursividad:

- **Insertar**: se compara el nuevo ID con el del nodo actual. Si es
  menor, se repite el proceso en el subárbol izquierdo; si es mayor,
  en el derecho. Cuando se llega a un lugar vacío (`null`), ahí se
  crea el nuevo nodo.
- **Buscar**: se compara el ID buscado con el del nodo actual. Si
  coincide, se encontró. Si es menor, se sigue buscando a la
  izquierda; si es mayor, a la derecha. Si se llega a `null`, el
  producto no existe.
- **Recorrido Inorden**: consiste en visitar primero todo el
  subárbol izquierdo, luego el nodo actual, y por último todo el
  subárbol derecho. Como la izquierda siempre tiene IDs menores y la
  derecha IDs mayores, este orden de visita imprime automáticamente
  el inventario ordenado de menor a mayor ID, sin necesidad de
  ordenarlo aparte.

## 2. Arquitectura del proyecto

```
TreeStock/
├── capturas/
│   ├── Captura buscar producto.png
│   ├── Captura mostrar inventario.png
│   └── Captura Registro de producto.png
├── src/
│   ├── Producto.java          -> Nodo del arbol (id, nombre, punteros izquierdo/derecho)
│   ├── ArbolInventario.java   -> Logica del ABB: insertar, buscar, recorrido inorden
│   └── Main.java              -> Menu interactivo en consola
├── .gitignore
└── README.md
```

- **Producto.java**: representa un nodo del árbol. Contiene los
  datos (`id`, `nombre`) y los punteros hacia sus hijos
  (`izquierdo`, `derecho`).
- **ArbolInventario.java**: contiene toda la lógica del árbol:
  `insertar()` (recursivo), `buscar()` (recursivo) y
  `mostrarInorden()` (recorrido recursivo).
- **Main.java**: contiene el menú de consola que conecta al usuario
  con `ArbolInventario`.

## 3. Instrucciones de ejecución

Requisitos: tener instalado el JDK (se usó **Eclipse Temurin**),
versión 8 o superior.

1. Clonar o descargar este repositorio.
2. Abrir una terminal dentro de la carpeta `TreeStock/src`.
3. Compilar todos los archivos:
   ```
   javac *.java
   ```
4. Ejecutar el programa:
   ```
   java Main
   ```
5. Usar el menú interactivo:
   - **1** para registrar un producto (se pedirá ID y nombre).
   - **2** para mostrar el inventario completo, ordenado por ID.
   - **3** para buscar un producto por su ID.
   - **0** para salir del programa.

## 4. Prueba de ejecución (menú, inserción y búsqueda)

**Registro de productos:**

![Registro de producto](capturas/Captura%20Registro%20de%20producto.png)

**Inventario ordenado (recorrido inorden):**

![Mostrar inventario](capturas/Captura%20mostrar%20inventario.png)

**Búsqueda de producto por ID:**

![Buscar producto](capturas/Captura%20buscar%20producto.png)

## 5. Video de sustentación

Video explicativo individual (máximo 3 minutos), donde se explica la
lógica de los punteros en el árbol y se demuestra el uso del sistema:

https://youtu.be/1-efaiqNVCU?si=ID_TgAil2PmM9saz

## 6. Restricciones cumplidas

- ✅ El árbol se implementó manualmente con nodos (clase `Producto`),
  sin usar ninguna librería de árboles de Java.
- ✅ Se dividió el proyecto estrictamente en tres clases:
  `Producto`, `ArbolInventario` y `Main`.
- ✅ `insertar()`, `buscar()` y el recorrido inorden se implementaron
  de forma recursiva.
- ✅ El menú de consola cubre las 4 opciones pedidas (Registrar,
  Mostrar Inventario, Buscar, Salir).