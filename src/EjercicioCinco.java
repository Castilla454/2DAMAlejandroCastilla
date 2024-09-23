import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EjercicioCinco implements Serializable {
    private static final long serialVersionUID = 5126642041982425623L;
    final static String rutaModulosGuardados = "src/FicherosJava/modulosguardados.txt";

    static final Logger LOGGER = LogManager.getRootLogger();

    static ArrayList<Modulo> modulos = new ArrayList<Modulo>();

    public static void main(String[] args) {
        File ficheroCSV = new File("src/FicherosJava/modulosguardados.csv");
        String[] moduls = {"Accés a Dades", "Programació de serveis i processos", "Desenvolupament d'interfícies", "Programació Multimédia i dispositiud mòbils", "Sistemes de Gestió Empresarial", "Empresa i iniciativa emprenedora"};
        int[] hores = {6, 3, 6, 5, 5, 3};
        double[] notes = {8.45, 9.0, 8.0, 7.34, 8.2, 7.4};
        for (int i = 0; i < moduls.length; i++) {

            modulos.add(new Modulo(moduls[i], hores[i], notes[i]));

        }

        guardarDatos();
        cargarDatos();
        leerModulos();
        crearFicheroCsv(modulos, ficheroCSV);
        leerFicheroCSV(ficheroCSV);

    }

    public static void guardarDatos() {
        System.out.println("Guardando datos...");
        File file = new File(rutaModulosGuardados);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(modulos);

        } catch (FileNotFoundException e) {
            System.err.println("ERROR: El archivo no se encontró para guardar los datos " + e.getMessage());
        } catch (IOException e) {
            System.err.println("ERROR: Ocurrió un error de entrada/salida al guardar los datos " + e.getMessage());
        }
    }

    public static void cargarDatos() {
        System.out.println("Cargando datos...");
        File file = new File(rutaModulosGuardados);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            modulos = (ArrayList<Modulo>) ois.readObject();


        } catch (FileNotFoundException e) {
            System.err.println("ERROR: El archivo no se encontró para cargar los datos. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("ERROR: Ocurrió un error de entrada/salida al cargar los datos. " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: La clase 'Modulo' no se encontró al cargar los datos " + e.getMessage());
        }
    }

    public static void leerModulos() {
        System.out.println("Lista ordenada por nombre, horas y nota respectivamente");
        Collections.sort(modulos);
        System.out.println(modulos.toString());

    }

    public static void crearFicheroCsv(List<Modulo> modulos, File fichero) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {


            bw.write("Modulo;Horas;Notas");
            bw.newLine();


            for (Modulo moduloActual : modulos) {
                bw.write(moduloActual.getNombre() + ";" + moduloActual.getNumHoras() + ";" + moduloActual.getNota());
                bw.newLine();
            }
        } catch (IOException e) {

            LOGGER.error("Error a la hora de escribir datos");
        }

    }

    public static void leerFicheroCSV(File fichero) {

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

            String linea;
            while ((linea = br.readLine()) != null) {


                System.out.println(linea);

            }


        } catch (IOException e) {

            LOGGER.error("Error a la hora de leer datos");

        }


    }


}
