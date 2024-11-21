package UD2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjercicioDos {

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
            int i = 1;
            ResultSet rs =  stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println("[" + (i++) + "[");
                System.out.println("DNI: " + rs.getString("DNI"));
                System.out.println("Apellidos: " + rs.getString("APELLIDOS"));
                //Uso getInt() porque es una cadena numerica y con el getInt la pasamos a un numero entero, por ultimo en caso de haber null este será reemplazado por un 0
                System.out.println("CP: " + rs.getInt("CP"));
            }

        } catch (SQLException e) {
            LOGGER.error("SQL código específico", e);
        }
    }
}
