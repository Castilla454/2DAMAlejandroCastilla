package UD2.UnidadDos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjercicioTres {
    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();

        mostrarDatos(conexion);
        conexion.desconectar();
    }

    private static void mostrarDatos(ConexionBD conexion) {
        String sql = "SELECT * FROM CLIENTES";

        if(conexion == null) {
            LOGGER.error("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            System.out.println("No hay conexión con base de datos, no se puede ejecutar la consulta.");
            return;
        }

        try (Statement stmt = conexion.getConnection().createStatement();){
            ResultSet rs =  stmt.executeQuery(sql);

            rs.last();
            int i = rs.getRow();
            do {
                System.out.println("[" + (i--) + "]" );
                System.out.println("DNI: " + rs.getString("DNI"));
                System.out.println("APELLIDOS: " + rs.getString("APELLIDOS"));
                System.out.println("CP: " + rs.getInt("CP"));
            } while (rs.previous());

        } catch (SQLException e) {
            LOGGER.error("SQL código específico", e);
        }
    }
}
