package UD3.Avanzado.Colecciones.Bags;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App9 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("colecciones");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        Person6 person = new Person6("Juan");
        em.persist(person);

        person.getPhones().add("123456789");
        person.getPhones().add("987654321");
        person.getPhones().add("123123123");
        person.getPhones().add("456456456");
        person.getPhones().add("789789789");
        person.getPhones().add("321321321");
        person.getPhones().add("654654654");
        person.getPhones().add("987987987");
        person.getPhones().add("654987321");
        person.getPhones().add("321654987");

        em.flush();
        em.getTransaction().commit();

        em.close();


    }
}
