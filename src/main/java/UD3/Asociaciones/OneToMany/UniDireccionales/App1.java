package UD3.Asociaciones.OneToMany.UniDireccionales;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person1 person = new Person1("John Doe");
        Phone1 phone = new Phone1("123456780");
        Phone1 phone2 = new Phone1("123456781");

        person.getPhones().add(phone);
        person.getPhones().add(phone2);
        em.persist(person);
        em.flush();

       // person.getPhones().remove(phone);

        em.getTransaction().commit();
        em.close();


    }
}

