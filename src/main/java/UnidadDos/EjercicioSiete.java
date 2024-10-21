package UnidadDos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class EjercicioSiete {

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
                mostrarDatosPorDNI(conexion, dni);
            }
        } catch (SQLException e) {
            LOGGER.error("Error al obtener los DNIs de la base de datos", e);
        }
    }

    private static void mostrarDatosPorDNI(ConexionBD conexion, String dni) {
        String sql = "{? = CALL obtener_apellidos(?)}";
        try (CallableStatement stmt = conexion.getConnection().prepareCall(sql)) {

            stmt.registerOutParameter(1, Types.VARCHAR);
            stmt.setString(2, dni);

            stmt.execute();


            String apellidos = stmt.getString(1);
            if (apellidos != null && !apellidos.isEmpty()) {
                System.out.println("Datos del cliente:");
                System.out.println("DNI: " + dni);
                System.out.println("Apellidos: " + apellidos + "\n");
            } else {
                LOGGER.warn("No se encontró ningún cliente con el DNI: " + dni);
                System.out.println("No se encontró ningún cliente con el DNI: " + dni);
            }
        } catch (SQLException e) {
            LOGGER.error("Error al obtener apellidos del cliente con DNI: " + dni, e);
        }
    }
}