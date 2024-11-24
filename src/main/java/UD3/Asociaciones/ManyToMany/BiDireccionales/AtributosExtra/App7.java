package UD3.Asociaciones.ManyToMany.BiDireccionales.AtributosExtra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App7 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person5 person = new Person5("Pepe Perez");
        Person5 person2 = new Person5("Juan Lopez");

        Address3 address = new Address3("Calle 1", "1", "41010");
        Address3 address2 = new Address3("Calle 2", "2" , "41011");

        em.persist(person);
        em.persist(person2);
        em.persist(address);
        em.persist(address2);

        em.flush();

        person.addAddress(address, "Casa");
        person.addAddress(address2, "Trabajo");

        person2.addAddress(address, "Casa");



        em.getTransaction().commit();


        em.close();
        emf.close();
    }
}
