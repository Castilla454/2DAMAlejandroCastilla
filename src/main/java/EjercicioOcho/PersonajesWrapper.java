package EjercicioOcho;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonajesWrapper {

@SerializedName("personatges")
    static private List<Personaje> personajes;

public static List<Personaje> getPersonajes() {
    return personajes;
}

    public void setPersonajes(List<Personaje> personajes) {
    this.personajes = personajes;
    }



}
