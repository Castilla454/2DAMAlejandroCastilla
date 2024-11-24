package UD3.Asociaciones.OneToOne.BiDireccionales;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App4 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Phone4 phone = new Phone4("123456789");
        em.persist(phone);

        PhoneDetails2 details = new PhoneDetails2("Movistar", "4G");
        phone.addPhoneDetails(details);
        em.persist(details);

        Phone4 phone2 = new Phone4("987654321");
        em.persist(phone2);

        PhoneDetails2 details2 = new PhoneDetails2("Vodafone", "3G");
        phone2.addPhoneDetails(details2);
        em.persist(details2);

        em.flush();
        em.getTransaction().commit();
        em.close();
    }

}