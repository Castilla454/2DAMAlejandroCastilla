package FicherosJava.EjercicioUno;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class EjercicioUno {
    static final Logger LOGGER = LogManager.getRootLogger();

    static String rutaFicheroOriginal = "src/main/java/FicherosJava/";
    public static final int NUM_BYTES = 32;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduzca el nombre de su fichero con su extension: ");

        String nombre = sc.nextLine();
        File fichero = new File(rutaFicheroOriginal+nombre);

        escribirFicheroByte(fichero, nombre);

    }


    public static void escribirFicheroByte(File fichero, String nombre) {

        byte[] bloqueBytes = new byte[NUM_BYTES];
        try {

            FileInputStream fileInput  = new FileInputStream(fichero);
            FileOutputStream fileOutput = new FileOutputStream("src/main/java/FicherosJava/copia" + nombre);
            int bytesLeidos;
            while ((bytesLeidos = fileInput.read(bloqueBytes)) != -1) {
                System.out.print((char) bytesLeidos);
                fileOutput.write(bloqueBytes, 0, bytesLeidos);
            }
            fileInput.close();
            fileOutput.close();


        } catch (FileNotFoundException e) {
            LOGGER.error("ERROR " + "\n" + "El fichero no ha sido encontrado" + e.getMessage());

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
    }


}





