import java.util.Scanner;

/**
 * Clase Main
 * -----------
 * Es la interfaz de consola del sistema Tree-Stock. Se encarga de
 * mostrar el menu y conectar lo que escribe el usuario con la
 * logica implementada en ArbolInventario. No contiene logica de
 * arbol propiamente dicha: solo pide datos, los valida y llama a
 * los metodos correspondientes.
 */
public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(teclado);

            switch (opcion) {
                case 1:
                    registrarProducto(teclado, inventario);
                    break;
                case 2:
                    mostrarInventario(inventario);
                    break;
                case 3:
                    buscarProducto(teclado, inventario);
                    break;
                case 0:
                    System.out.println("Cerrando Tree-Stock. Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion invalida, intenta de nuevo.");
            }

            System.out.println();

        } while (opcion != 0);

        teclado.close();
    }

    private static void mostrarMenu() {
        System.out.println("===== TREE-STOCK: Sistema de Inventario =====");
        System.out.println("1. Registrar Producto");
        System.out.println("2. Mostrar Inventario");
        System.out.println("3. Buscar Producto");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static int leerOpcion(Scanner teclado) {
        try {
            return Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void registrarProducto(Scanner teclado, ArbolInventario inventario) {
        System.out.print("ID del producto: ");
        int id;
        try {
            id = Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("ID invalido. Debe ser un numero entero.");
            return;
        }

        System.out.print("Nombre del producto: ");
        String nombre = teclado.nextLine();

        inventario.insertar(id, nombre);
        System.out.println("Producto registrado con exito.");
    }

    private static void mostrarInventario(ArbolInventario inventario) {
        System.out.println("--- Inventario ordenado por ID (recorrido inorden) ---");
        inventario.mostrarInorden();
    }

    private static void buscarProducto(Scanner teclado, ArbolInventario inventario) {
        System.out.print("ID a buscar: ");
        int id;
        try {
            id = Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("ID invalido. Debe ser un numero entero.");
            return;
        }

        Producto encontrado = inventario.buscar(id);
        if (encontrado != null) {
            System.out.println("Producto encontrado -> " + encontrado);
        } else {
            System.out.println("No existe ningun producto con ese ID.");
        }
    }
}