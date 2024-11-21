package UD2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjemploCommit {
    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();

        insertarDatos(conexion);
        conexion.desconectar();
    }

    private static void insertarDatos(ConexionBD conexion) {

        if (conexion == null) {
            LOGGER.error("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            System.out.println("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            return;
        }

        try (PreparedStatement stmt = conexion.getConnection().prepareStatement(
                "INSERT INTO CLIENTES1(DNI,APELLIDOS,CP) VALUES(?,?,?)")) {

            conexion.getConnection().setAutoCommit(false);

            int i = 0;

            stmt.setString(++i, "54320198V");
            stmt.setString(++i, "CARVAJAL");
            stmt.setString(++i, "10109");
            stmt.executeUpdate();

            stmt.setString(i = 1, "76543210S");
            stmt.setString(++i, "MARQUEZ");
            stmt.setString(++i, "46987");
            stmt.executeUpdate();

            stmt.setString(i = 1, "90123456A");
            stmt.setString(++i, "MOLINA");
            stmt.setString(++i, "35153");
            stmt.executeUpdate();

            conexion.getConnection().commit();

        } catch (SQLException e) {
            LOGGER.error("Error al insertar datos", e);
            try {
                conexion.getConnection().rollback();
                System.err.println("Se hace ROLLBACK");
            } catch (SQLException er) {
                System.err.println("ERROR haciendo ROLLBACK");
                LOGGER.error("Error al insertar datos", e);
            }
        }

    }
}
