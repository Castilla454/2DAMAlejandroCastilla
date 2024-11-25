package UD3.Asociaciones.OneToOne.UniDireccionales;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Phone3 phone = new Phone3("123456789");
        em.persist(phone);

        PhoneDetails details = new PhoneDetails("Movistar", "4G");
        phone.setPhoneDetails(details);
        em.persist(details);

        Phone3 phone2 = new Phone3("987654321");
        em.persist(phone2);

        PhoneDetails details2 = new PhoneDetails("Vodafone", "3G");
        phone2.setPhoneDetails(details2);
        em.persist(details2);

        em.flush();
        em.getTransaction().commit();
        em.close();
    }
}
