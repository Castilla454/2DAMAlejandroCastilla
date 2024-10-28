package UD1.PracticaExamen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class EjercicioDos {


    private static final Logger LOGGER = LogManager.getLogger(EjercicioDos.class);
    private static String rutaDirectorio = "src/main/java/PracticaExamen/Ficheros";
    private static File junte = new File("src/main/java/PracticaExamen/junte.txt");


    public static void main(String[] args) {

        File directorio = new File(rutaDirectorio);
        File[] ficheros = directorio.listFiles();

        try (FileWriter fileWriter = new FileWriter(junte)){
            int caracter;
            for (File fichero : ficheros) {

                try (FileReader fileReader = new FileReader(fichero)) {

                    while ((caracter = fileReader.read()) != -1) {

                        fileWriter.write(caracter);
                    }
                }
            }
        }catch (FileNotFoundException e) {

            LOGGER.error("No se ha encontrado el fichero" + e.getMessage());

        } catch (IOException er) {
            LOGGER.error("Error inesperado" + er.getMessage());

        }
    }
}


