import java.io.*;
import java.util.ArrayList;

public class ActividadCuatro implements Serializable {
    private static final long serialVersionUID = 5126642041982425623L;
    final static String rutaModulosGuardados = "src/FicherosJava/modulosguardados.txt";


    static ArrayList<Modulo> modulos = new ArrayList<Modulo>();

    public static void main(String[] args) {
         String[] moduls = {"Accés a Dades", "Programació de serveis i processos", "Desenvolupament d'interfícies", "Programació Multimédia i dispositiud mòbils", "Sistemes de Gestió Empresarial", "Empresa i iniciativa emprenedora"};
       int[] hores = {6, 3, 6, 5, 5, 3};
        double[] notes = {8.45, 9.0, 8.0, 7.34, 8.2, 7.4};
        for(int i = 0; i < moduls.length; i++) {
            modulos.add(new Modulo(moduls[i],hores[i],notes[i]));

        }
        guardarPartida();

        cargarPartida();
    }

    public static void guardarPartida() {
        System.out.println("Guardando partida...");
        File file = new File(rutaModulosGuardados);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(modulos);
            oos.close();
        } catch (Exception e) {
            System.out.println("hola cambiar urgente");
        }
    }
    public static void cargarPartida() {
        System.out.println("Cargando partida...");
        File file = new File(rutaModulosGuardados);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
          modulos = (ArrayList<Modulo>) ois.readObject();


        } catch (Exception pito) {
            System.out.println("hola cambiar urgente");
        }
    }
}
