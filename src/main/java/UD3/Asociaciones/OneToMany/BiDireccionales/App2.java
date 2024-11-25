package UD3.Asociaciones.OneToMany.BiDireccionales;

import UD3.Asociaciones.OneToMany.UniDireccionales.Person1;
import UD3.Asociaciones.OneToMany.UniDireccionales.Phone1;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person2 person = new Person2("John Doe");
        Phone2 phone = new Phone2("123456780");
        Phone2 phone2 = new Phone2("123456781");


        person.addPhone(phone);
        person.addPhone(phone2);
        em.persist(person);
        em.flush();

        // person.getPhones().remove(phone);

        em.getTransaction().commit();
        em.close();


    }
}
