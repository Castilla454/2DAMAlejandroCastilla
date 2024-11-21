package UD2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjercicioSeis {

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

            /*Al no tener rollback este codigo, si hubiese alguna persona que tuviese el mismo DNI que alguien de la base de datos se insertarian los registros hasta el pete,
            sin embargo si tuviesemos el rollback no se introduciria ningun registro y se volveria al estado inicial en el que se encontraba la base de datos.
             */

        } catch (SQLException e) {
            LOGGER.error("Error al insertar datos", e);

        }

    }


}
