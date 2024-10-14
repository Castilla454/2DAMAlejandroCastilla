package UnidadDos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjercicioCuatro {
    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();
        contarFilas(conexion);
        conexion.desconectar();
    }

    private static void contarFilas(ConexionBD conexion) {

        String sql = "SELECT * FROM CLIENTES";
        if (conexion == null) {
            LOGGER.error("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            System.out.println("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            return;
        }

        try (Statement stmt = conexion.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.last()) {
                int numFilas = rs.getRow();
                System.out.println("Número total de filas: " + numFilas);
            }

        } catch (SQLException e) {
            LOGGER.error("Error al ejecutar la consulta.", e);
        } catch (Exception e) {
            LOGGER.error("Error", e);
        }
    }

}
