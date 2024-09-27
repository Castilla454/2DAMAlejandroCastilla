import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EjercicioTres {

    static final Logger LOGGER = LogManager.getRootLogger();
    static String rutaFicheroOriginal = "src/FicherosJava/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduzca el nombre de su fichero con su extension: ");

        String nombre = sc.nextLine();
        File fichero = new File(rutaFicheroOriginal+nombre);

        eliminarNumerosLinea(fichero, nombre);

    }


    public static void eliminarNumerosLinea(File fichero, String nombre) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fichero));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/FicherosJava/sinNumeros_" + nombre));

            String line;
            Pattern pattern = Pattern.compile("^\\d+\\.\\s*");

            while ((line = bufferedReader.readLine()) != null) {

                String newLine = pattern.matcher(line).replaceFirst("");

                bufferedWriter.write(newLine);
                bufferedWriter.newLine();
            }

            System.out.println("Archivo copiado y modificado correctamente.");

            bufferedReader.close();
            bufferedWriter.close();
            System.out.println("El archivo sin números de línea ha sido creado.");

        } catch (FileNotFoundException e) {
            LOGGER.error("ERROR: El fichero no ha sido encontrado: " + e.getMessage());
        } catch (IOException ex) {
            LOGGER.error("ERROR: Ocurrió un error de I/O: " + ex.getMessage());
        }
    }
}
