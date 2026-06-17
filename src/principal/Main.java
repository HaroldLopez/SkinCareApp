package principal;

import dao.ProductoDAO;
import modelo.Producto;

public class Main {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();

        // Crear producto
        Producto producto = new Producto();

        producto.setNombre("Protector Solar");
        producto.setMarca("Isdin");
        producto.setPrecio(55000);
        producto.setCategoria("Protección");

        // Insertar producto
        dao.insertarProducto(producto);

        // Consultar productos
        System.out.println("\n=== LISTA DE PRODUCTOS ===\n");
        dao.consultarProductos();

        System.out.println("\nFin de la ejecución.");
    }
}