package PracticaExamen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class EjercicioUno {
    static final Logger LOGGER = LogManager.getRootLogger();

    private static String rutaFicheroOriginal = "src/main/java/FicherosJava/";

    private static final int NUM_BYTES = 32;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        System.out.println("Introduzca el nombre del fichero junto a la extension:");

        nombre = sc.nextLine();
        File fichero = new File(rutaFicheroOriginal+nombre);

        if(copiarFichero(fichero,nombre)){


            System.out.println("Se ha creado la copia del fichero correctamente");
        } else {

            System.out.println("Error al crear la copai del fichero");
        }


    }


    public static boolean copiarFichero(File fichero, String nombre) {
        byte[] bloqueBytes = new byte[NUM_BYTES];
        try{
            FileInputStream fileInput = new FileInputStream(fichero);

            FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/FicherosJava/copia" + nombre);

            int numBytesLeidos;

            while((numBytesLeidos=fileInput.read(bloqueBytes)) != -1){
                System.out.println((char) numBytesLeidos);

                fileOutputStream.write(bloqueBytes,0,numBytesLeidos);

            }


        } catch(FileNotFoundException e){

            LOGGER.error("Fichero no encontrado" + e.getMessage());
            return Boolean.FALSE;

        }catch(IOException er){


            LOGGER.error("Error inesperado" + er.getMessage());

            return Boolean.FALSE;
        }


        return Boolean.TRUE;

    }


}
