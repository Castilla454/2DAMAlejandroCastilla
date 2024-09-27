package EjercicioOcho;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjercicioOcho {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            FileReader fr = new FileReader("src/main/java/EjercicioOcho/SW.json");
            PersonajesWrapper personaje = gson.fromJson(fr, PersonajesWrapper.class);
            fr.close();

            for(Personaje p: PersonajesWrapper.getPersonajes()){



            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }








}
