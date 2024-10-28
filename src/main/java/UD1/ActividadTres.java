package UD1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class ActividadTres {

    static final Logger LOGGER = LogManager.getRootLogger();
    static String rutaFicheroOriginal = "src/FicherosJava/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduzca el nombre de su fichero con su extension: ");

        String nombre = sc.nextLine();
        File fichero = new File(rutaFicheroOriginal+nombre);

        escribirFicheroByte(fichero, nombre);

    }


    public static void escribirFicheroByte(File fichero, String nombre) {

        try {
            int lineas = 1;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fichero));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/FicherosJava/copia" + nombre));
            String linea;
            while( (linea = bufferedReader.readLine()) != null ) {
                bufferedWriter.write(lineas + "." + linea+"\n");
                lineas++;
            }
            bufferedReader.close();
            bufferedWriter.close();





        } catch (FileNotFoundException e) {
            LOGGER.error("ERROR " + "\n" + "El fichero no ha sido encontrado" + e.getMessage());

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
    }
}
