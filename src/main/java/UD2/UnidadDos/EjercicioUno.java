package UD2.UnidadDos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;

public class EjercicioUno {

    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();

        actualizarDatos(conexion);
        borrarDatos(conexion);
        conexion.desconectar();
    }

    private static void actualizarDatos(ConexionBD conexion) {
        String sql = "UPDATE CLIENTES SET APELLIDOS = 'ROJAS', CP = null WHERE DNI = '89012345E';";

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

    private static void borrarDatos(ConexionBD conexion) {

        String sql = "DELETE FROM CLIENTES WHERE DNI = '09876543K';";
        if(conexion == null) {
            LOGGER.error("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            System.out.println("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            return;
        }

        try (Statement stmt = conexion.getConnection().createStatement();){
            int nFilas = stmt.executeUpdate(sql);
            System.out.println(nFilas + " Filas eliminadas.");

        } catch (Exception e) {
            LOGGER.error("Error al crear tabla", e);
        }
    }




}
