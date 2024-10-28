package PracticaExamen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class EjercicioTresParteDos {
    private static final Logger LOGGER = LogManager.getLogger(EjercicioTres.class);
    private static String rutaFichero = "src/main/java/PracticaExamen/FicherosEjerTres/definitivo.txt";
    private static String rutaDestino = "src/main/java/PracticaExamen/FicherosEjerTres/definitivo_sin_numeros.txt";


    public static void main(String[] args){


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(rutaFichero));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rutaDestino));

            String linea;
            int numLinea = 1;

            while ((linea = bufferedReader.readLine()) != null) {

                String newLine = linea.replaceFirst("^\\d+\\.\\s*","");

                bufferedWriter.write(newLine);
                bufferedWriter.newLine();
                numLinea++;



            }
            bufferedWriter.close();
            bufferedReader.close();
        }catch(FileNotFoundException e){
            LOGGER.error("No se ha podido encontrar el fichero" + e.getMessage());

        }catch(IOException er){

            LOGGER.error("Error inesperado" + er.getMessage());
        }



    }

}
