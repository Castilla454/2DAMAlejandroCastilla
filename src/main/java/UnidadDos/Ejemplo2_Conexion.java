package UnidadDos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.Statement;

public class Ejemplo2_Conexion {

    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();

        creaTabla(conexion);
        conexion.desconectar();
    }

    private static void creaTabla(ConexionBD conexion) {
        String sql = "CREATE TABLE CLIENTES (DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY(DNI))";
        if(conexion == null) {
            LOGGER.error("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            System.out.println("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            return;
        }

        try (Statement stmt = conexion.getConnection().createStatement();){
            stmt.execute(sql);
        } catch (Exception e) {
            LOGGER.error("Error al consultar empleados", e);
        }
    }

}
