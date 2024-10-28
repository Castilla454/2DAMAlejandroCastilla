package UD1.EjercicioOcho;

import java.util.List;
import java.util.Objects;

public class PersonajesWrapper {

  private List<Personaje> personatges;

  public PersonajesWrapper(){
      super();
  }

  public PersonajesWrapper(List<Personaje> personatges){

      this.personatges=personatges;
  }

public  List<Personaje> getPersonajes() {
    return personatges;
}

    public void setPersonajes(List<Personaje> personatges) {
    this.personatges = personatges;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonajesWrapper that = (PersonajesWrapper) o;
        return Objects.equals(personatges, that.personatges);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personatges);
    }

    @Override
    public String toString() {
        return "PersonajesWrapper{" +
                "personatges=" + personatges +
                '}';
    }
}
