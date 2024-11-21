package UD3;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        //Ejemplo JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        User user = new User();
        user.setId(1);
        user.setUserName("Pepe");
        user.setUserMessage("Hello World de Pepe");

        User user2 = new User();
        user2.setId(2);
        user2.setUserName("Juan");
        user2.setUserMessage("Hello World de Juan");

        em.getTransaction().begin();
        em.persist(user);
        em.persist(user2);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
