package UD3.Asociaciones.ManyToMany.BiDireccionales;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App6 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person4 person = new Person4("Pepe peres");
        Person4 person2 = new Person4("Juan Lopez");

        Address2 address = new Address2("Calle 1", "1", "11111");
        Address2 address2 = new Address2("Calle 2", "2", "22222");

        person.addAddress(address);
        person.addAddress(address2);

        person2.addAddress(address);


        em.persist(person);
        em.persist(person2);
        em.flush();

        em.getTransaction().commit();
        em.close();


    }
}
