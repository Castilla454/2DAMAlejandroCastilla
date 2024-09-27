import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class EjercicioCuatro implements Serializable {
    private static final long serialVersionUID = 5126642041982425623L;
    final static String rutaModulosGuardados = "src/FicherosJava/modulosguardados.txt";


    static ArrayList<Modulo> modulos = new ArrayList<Modulo>();

    public static void main(String[] args) {
        String[] moduls = {"Accés a Dades", "Programació de serveis i processos", "Desenvolupament d'interfícies", "Programació Multimédia i dispositiud mòbils", "Sistemes de Gestió Empresarial", "Empresa i iniciativa emprenedora"};
        int[] hores = {6, 3, 6, 5, 5, 3};
        double[] notes = {8.45, 9.0, 8.0, 7.34, 8.2, 7.4};
        for (int i = 0; i < moduls.length; i++) {

            modulos.add(new Modulo(moduls[i], hores[i], notes[i]));


        }
        guardarDatos();
        cargarDatos();
        leerModulos();
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

}


