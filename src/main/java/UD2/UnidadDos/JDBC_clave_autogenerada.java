package UD2.UnidadDos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class JDBC_clave_autogenerada {
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

        try (CallableStatement s = conexion.getConnection().prepareCall("{call listado_parcial_clientes(?,?)}")){

            s.setString(1,"78901234X");



        } catch (SQLException e) {
            LOGGER.error("Error al insertar datos", e);

            try {
                conexion.getConnection().rollback();
                System.err.println("SE HACE ROLLBACK");

            }catch(SQLException ex){

                LOGGER.error("Error a la hora de hacer rollback" + ex);
            }
        }
    }
}
