package UD3.Avanzado.Colecciones.Maps;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("colecciones");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person person = new Person("Marco");
        em.persist(person);

        person.getPhones().put("912930900", "Casa");
        person.getPhones().put("625610603", "Movil");
        person.getPhones().put("320311390", "Trabajo");

        em.flush();
        em.getTransaction().commit();

        System.out.println("Nombre: " + person.getName());
        for (String phone : person.getPhones().keySet()) {
            System.out.println("Telefono: " + phone + " - Tipo: " + person.getPhones().get(phone));
        }

        em.close();
        emf.close();


    }
}
