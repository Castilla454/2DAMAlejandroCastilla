package UD3.Asociaciones.ManyToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person person = new Person("Pepe");
        em.persist(person);

        Phone phone = new Phone("123456789");
        phone.setPerson(person);
        em.persist(phone);

        em.flush();
        //phone.setPerson(null);

        em.getTransaction().commit();
        em.close();

    }
}
