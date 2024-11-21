package UD2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class EjemploInsertarComplejo {
    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();

       insertarDatos(conexion);
        conexion.desconectar();
    }
    private static void insertarDatos(ConexionBD conexion) {

        if(conexion == null) {
            LOGGER.error("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            System.out.println("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            return;
        }

        try (PreparedStatement stmt = conexion.getConnection().prepareStatement(
                "INSERT INTO CLIENTES1(DNI,APELLIDOS,CP) VALUES(?,?,?)")){
            stmt.setString(1,"78901234X");
            stmt.setString(2,"NADALES");
            stmt.setInt(3,44126);
            stmt.executeUpdate();

            int i =1;

            stmt.setString(i++,"89012345E");
            stmt.setString(i++,"ROJAS");
            stmt.setNull(i++, Types.INTEGER);
            stmt.executeUpdate();

            i =1;

            stmt.setString(i++,"56789012B");
            stmt.setString(i++,"SAMPER");
            stmt.setInt(i++, 29730);
            stmt.executeUpdate();


        } catch (SQLException e) {
            LOGGER.error("SQL código específico", e);
        }
    }
}

