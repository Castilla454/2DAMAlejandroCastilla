package UnidadDos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class EjercicioCinco {
    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();

        if (conexion.getConnection() == null) {
            LOGGER.error("No se pudo establecer la conexión con la base de datos.");
            System.out.println("No se pudo establecer la conexión con la base de datos.");
            return;
        }

        mostrarDatos(conexion);
        conexion.desconectar();
    }

    private static void mostrarDatos(ConexionBD conexion) {
        try (Statement stmt = conexion.getConnection().createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT DNI FROM CLIENTES1")) {


            while (resultSet.next()) {
                String dni = resultSet.getString("DNI");
                mostrarClientePorDNI(conexion, dni);
            }
        } catch (SQLException e) {
            LOGGER.error("Error al obtener los DNIs de la base de datos", e);
        }
    }

    private static void mostrarClientePorDNI(ConexionBD conexion, String dni) {
        String sql = "SELECT * FROM CLIENTES1 WHERE DNI = ?";
        try (PreparedStatement stmt = conexion.getConnection().prepareStatement(sql)) {
            stmt.setString(1, dni);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {

                    String apellidos = resultSet.getString("Apellidos");
                    String cp = resultSet.getString("CP");
                    System.out.println("Datos del cliente:");
                    System.out.println("DNI: " + dni);
                    System.out.println("Codigo Postal: " + cp);
                    System.out.println("Apellidos: " + apellidos + "\n");

                } else {
                    LOGGER.error("No se encontró ningún cliente con el DNI: " + dni);
                    System.out.println("No se encontró ningún cliente con el DNI: " + dni);
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Error al obtener datos del cliente con DNI: " + dni, e);
        }
    }
}