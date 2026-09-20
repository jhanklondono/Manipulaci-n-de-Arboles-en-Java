/**
 * Clase Producto
 * ---------------
 * Representa un nodo del arbol binario de busqueda (ABB) que usa
 * Tree-Stock para organizar el inventario.
 *
 * Cada producto guarda su informacion (id, nombre) y dos punteros:
 * izquierdo y derecho. Estos punteros no son "flechas" fisicas, son
 * simplemente referencias a otros objetos Producto. El puntero
 * izquierdo apunta al hijo que tiene un ID menor, y el puntero
 * derecho apunta al hijo que tiene un ID mayor. Esa relacion entre
 * padres e hijos es lo que le da forma de arbol a la estructura.
 */
public class Producto {

    private int id;
    private String nombre;

    // Punteros hacia los hijos del nodo dentro del arbol.
    // Al crear un producto nuevo, ambos empiezan en null porque
    // todavia no tiene hijos.
    private Producto izquierdo;
    private Producto derecho;

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null;
        this.derecho = null;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Producto izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Producto getDerecho() {
        return derecho;
    }

    public void setDerecho(Producto derecho) {
        this.derecho = derecho;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - " + nombre;
    }
}