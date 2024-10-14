package FicherosJava.EjercicioDos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EjercicioDos {
    static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {
        File directorio = new File("src/main/java/FicherosJava/EjercicioDos/ficheros");


        if (mergearFicheros(directorio)) {
            System.out.println("Ficheros mergeados correctamente");

        } else {
            System.out.println("Los ficheros no se pudieron mergear correctamente");
        }
    }


    public static boolean mergearFicheros(File directorio) {
        File[] ficheros = directorio.listFiles();

        try (FileWriter fileMergeado = new FileWriter("src/main/java/FicherosJava/EjercicioDos/ficheros/mergeado.txt")) {
            int caracter;
            for (File file : ficheros) {
                try (FileReader fileReader = new FileReader(file)) {
                    while ((caracter = fileReader.read()) != -1) {
                        fileMergeado.write(caracter);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("ERROR " + "\n" + "El fichero no ha sido encontrado" + e.getMessage());
            return Boolean.FALSE;
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

