/**
 * Clase ArbolInventario
 * ----------------------
 * Implementa la logica del Arbol Binario de Busqueda (ABB) que
 * organiza los productos del inventario a partir de su ID.
 *
 * Regla de un ABB: para cualquier nodo del arbol, todos los IDs de
 * su subarbol izquierdo son MENORES que su propio ID, y todos los
 * IDs de su subarbol derecho son MAYORES. Gracias a esta regla, se
 * puede insertar, buscar y recorrer el arbol de forma RECURSIVA: en
 * cada paso solo hay que decidir "¿voy a la izquierda o a la
 * derecha?", y se repite exactamente el mismo proceso sobre un
 * subarbol cada vez mas pequeno, hasta llegar a un punto donde ya
 * no hay mas nodos (el puntero vale null). Ese punto sin hijos es
 * el "caso base" que detiene la recursividad.
 */
public class ArbolInventario {

    private Producto raiz;

    public ArbolInventario() {
        this.raiz = null;
    }

    // ---------------------------------------------------------------
    // INSERTAR
    // ---------------------------------------------------------------

    /**
     * Insertar (metodo publico): punto de entrada para agregar un
     * producto nuevo. Delega el trabajo real al metodo recursivo,
     * comenzando siempre desde la raiz del arbol.
     */
    public void insertar(int id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    /**
     * insertarRecursivo:
     *
     * Caso base -> si el nodo actual es null, significa que llegamos
     * al lugar exacto del arbol donde debe quedar el nuevo producto.
     * Ahi se crea el nodo y se retorna para conectarlo con su padre.
     *
     * Caso recursivo -> si el ID nuevo es menor que el del nodo
     * actual, hay que seguir bajando por la izquierda; si es mayor,
     * por la derecha. El resultado de esa llamada recursiva se
     * vuelve a asignar al puntero correspondiente, reconstruyendo
     * el camino de vuelta hacia la raiz.
     */
    private Producto insertarRecursivo(Producto nodoActual, int id, String nombre) {
        if (nodoActual == null) {
            return new Producto(id, nombre);
        }

        if (id < nodoActual.getId()) {
            nodoActual.setIzquierdo(insertarRecursivo(nodoActual.getIzquierdo(), id, nombre));
        } else if (id > nodoActual.getId()) {
            nodoActual.setDerecho(insertarRecursivo(nodoActual.getDerecho(), id, nombre));
        }
        // Si el ID ya existe en el arbol, no se inserta un duplicado
        // y el arbol se deja tal como estaba.

        return nodoActual;
    }

    // ---------------------------------------------------------------
    // BUSCAR
    // ---------------------------------------------------------------

    /**
     * Buscar (metodo publico): punto de entrada para buscar un
     * producto por su ID. Retorna el Producto si existe, o null si
     * no se encuentra en el arbol.
     */
    public Producto buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    /**
     * buscarRecursivo:
     *
     * Caso base 1 -> si el nodo actual es null, ya no quedan mas
     * nodos por revisar en esa rama, asi que el producto no existe.
     *
     * Caso base 2 -> si el ID del nodo actual coincide con el
     * buscado, se encontro el producto.
     *
     * Caso recursivo -> si no coincide, se aprovecha la regla del
     * ABB para descartar la mitad del arbol en cada paso: si el ID
     * buscado es menor, solo puede estar a la izquierda; si es
     * mayor, solo puede estar a la derecha.
     */
    private Producto buscarRecursivo(Producto nodoActual, int id) {
        if (nodoActual == null) {
            return null;
        }

        if (id == nodoActual.getId()) {
            return nodoActual;
        }

        if (id < nodoActual.getId()) {
            return buscarRecursivo(nodoActual.getIzquierdo(), id);
        } else {
            return buscarRecursivo(nodoActual.getDerecho(), id);
        }
    }

    // ---------------------------------------------------------------
    // RECORRIDO INORDEN
    // ---------------------------------------------------------------

    /**
     * mostrarInorden (metodo publico): imprime todo el inventario
     * ordenado de menor a mayor ID.
     */
    public void mostrarInorden() {
        if (raiz == null) {
            System.out.println("El inventario esta vacio.");
            return;
        }
        recorridoInorden(raiz);
    }

    /**
     * recorridoInorden (recursivo): un recorrido "inorden" visita,
     * para cada nodo, primero TODO su subarbol izquierdo, despues
     * imprime el nodo actual, y por ultimo visita TODO su subarbol
     * derecho. Como en un ABB la izquierda siempre tiene IDs menores
     * y la derecha IDs mayores, seguir este orden de visita produce
     * automaticamente la lista de productos ordenada de menor a
     * mayor, sin necesidad de ordenarla aparte.
     */
    private void recorridoInorden(Producto nodoActual) {
        if (nodoActual == null) {
            return;
        }
        recorridoInorden(nodoActual.getIzquierdo());
        System.out.println(nodoActual);
        recorridoInorden(nodoActual.getDerecho());
    }
}