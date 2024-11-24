package UD3.Asociaciones.ManyToMany.UniDireccionales;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App5 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person3 person = new Person3();
        Person3 person2 = new Person3();

        Address address = new Address("Main Street", "123");
        Address address2 = new Address("Second Street", "456");

        person.getAddresses().add(address);
        person.getAddresses().add(address2);

        person2.getAddresses().add(address);

        em.persist(person);
        em.persist(person2);
        em.flush();

        em.getTransaction().commit();
        em.close();
    }
}
