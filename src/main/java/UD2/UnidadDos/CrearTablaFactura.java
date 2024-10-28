package UD2.UnidadDos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Statement;

public class CrearTablaFactura {


    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();

        creaTablaFactura(conexion);
        creaTablaLineaFactura(conexion);
        conexion.desconectar();
    }

    private static void creaTablaFactura(ConexionBD conexion) {
        String sql = "CREATE TABLE FACTURAS (" +
                "NUM_FACTURA INTEGER AUTO_INCREMENT NOT NULL," +
                " DNI_CLIENTE CHAR(9) NOT NULL," +
                " PRIMARY KEY(NUM_FACTURA)," +
                " FOREIGN KEY FK_FACT_DNI_CLIENTES (DNI_CLIENTE) REFERENCES CLIENTES(DNI))";

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

    private static void creaTablaLineaFactura(ConexionBD conexion) {
        String sql = "CREATE TABLE LINEAS_FACTURA (" +
                "NUM_FACTURA INTEGER NOT NULL," +
                " LINEA_FACTURA SMALLINT NOT NULL," +
                "CONCEPTO VARCHAR(32) NOT NULL," +
                "CANTIDAD SMALLINT NOT NULL," +
                " PRIMARY KEY(NUM_FACTURA, LINEA_FACTURA)," +
                " FOREIGN KEY FK_LINEAFACT_NUM_FACTURA (NUM_FACTURA) REFERENCES FACTURAS(NUM_FACTURA))";

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
