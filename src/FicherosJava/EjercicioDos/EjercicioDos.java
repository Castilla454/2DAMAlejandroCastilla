package FicherosJava.EjercicioDos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EjercicioDos {
    public static void main(String[] args) {
        File directorio = new File("src/FicherosJava/EjercicioDos/ficheros");
        ArrayList<File> ficheros = new ArrayList<>(List.of(directorio.listFiles()));
        Iterator<File> iterator = ficheros.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        mergearFicheros(ficheros);
    }


    public static void mergearFicheros(ArrayList<File> ficheros) {
        try {
            FileWriter fileWriter = new FileWriter("src/FicherosJava/EjercicioDos/ficheros/mergeado.txt");
            int caracter;

            for (int i = 0; i < ficheros.size(); i++) {
                FileReader fileReader = new FileReader(ficheros.get(i));


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

