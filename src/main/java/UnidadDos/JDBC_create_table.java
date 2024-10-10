package UnidadDos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_create_table {

    private static final Logger LOGGER = LogManager.getRootLogger();
   static  String url = "jdbc:mariadb://localhost:3306/Empresa?user=root&password=root";
    static String user = "root";
    static String password = "root";


    public static void main(String[] args){

        try{

            Connection c= DriverManager.getConnection(url, user, password);

            Statement s = c.createStatement();

            s.execute("CREATE TABLE CLIENTES (DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY(DNI))");

        } catch (SQLException e) {
            LOGGER.error("Error connecting database", e);
        }


    }
}
