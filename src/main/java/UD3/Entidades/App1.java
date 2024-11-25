package UD3.Entidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Calendar;

public class App1 {


        public static void main(String[] args) {


            //Ejemplo JPA
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Calendar calendar = Calendar.getInstance();

            User1 user = new User1();
            user.setUserName("Pepe");
            calendar.set(1990, 1, 1);
            user.setBirthDate(calendar.getTime());
            user.setDireccion(new Direccion("Calle Mayor", "28080", "Madrid", "Madrid"));
            user.setBillingAddress(new Direccion("Calle Menor", "28081", "Madrid", "Madrid"));

            User1 user2 = new User1();
            user2.setUserName("Juan");
            calendar.set(1995, 1, 1);
            user2.setBirthDate(calendar.getTime());
            user2.setDireccion(new Direccion("Calle Mayor", "28080", "Madrid", "Madrid"));
            user2.setBillingAddress(new Direccion("Calle Mayor", "28081", "Madrid", "Madrid"));

            em.persist(user);
            em.persist(user2);
            em.getTransaction().commit();

            em.close();
            emf.close();

        }
    }

