package dao;

import conexion.ConexionBD;
import modelo.Producto;

import java.sql.*;

public class ProductoDAO {

    public void insertarProducto(Producto producto) {

        String sql =
                "INSERT INTO producto(nombre, marca, precio, categoria) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setDouble(3, producto.getPrecio());
            ps.setString(4, producto.getCategoria());

            ps.executeUpdate();

            System.out.println("Producto insertado");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    public void consultarProductos() {

        String sql = "SELECT * FROM producto";

        try (Connection con = ConexionBD.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("nombre") + " | " +
                        rs.getString("marca") + " | " +
                        rs.getDouble("precio") + " | " +
                        rs.getString("categoria")
                );
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    public void actualizarProducto(Producto producto) {

        String sql =
                "UPDATE producto SET nombre=?, marca=?, precio=?, categoria=? WHERE id=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setDouble(3, producto.getPrecio());
            ps.setString(4, producto.getCategoria());
            ps.setInt(5, producto.getId());

            ps.executeUpdate();

            System.out.println("Producto actualizado");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    public void eliminarProducto(int id) {

        String sql =
                "DELETE FROM producto WHERE id=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Producto eliminado");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }
}