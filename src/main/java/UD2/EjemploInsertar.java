package UD2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;

public class EjemploInsertar {

    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();

       insertarDatos(conexion);
        conexion.desconectar();
    }

    private static void insertarDatos(ConexionBD conexion) {
        String sql = "INSERT INTO CLIENTES (DNI, APELLIDOS, CP) VALUES" +
                "('78901234X','NADALES','44126')," +
                "('89012345E','HOJAS',NULL)," +
                "('56789012B','SAMPER','29730')," +
                "('09876543K','LAMIQUIZ',null)";

        if(conexion == null) {
            LOGGER.error("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            System.out.println("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            return;
        }

        try (Statement stmt = conexion.getConnection().createStatement();){
           int nFil =  stmt.executeUpdate(sql);

            System.out.println(nFil + " Filas insertadas.");
        } catch (SQLException e) {
            LOGGER.error("SQL código específico", e);
        }
    }
}
