package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mariadb://localhost:3306/skincare_db";

    private static final String USER = "root";

    private static final String PASSWORD = "1078266148";

    public static Connection conectar() {

        try {

            Connection conexion =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD);

            System.out.println("Conexión exitosa con MariaDB");

            return conexion;

        } catch (SQLException e) {

            System.out.println(
                    "Error de conexión: " +
                    e.getMessage());

            return null;
        }
    }
}