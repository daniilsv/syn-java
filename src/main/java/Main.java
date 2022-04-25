import models.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        User user1 = new User();
        user1.setName("Eric");

        var entityManagerFactory = Persistence.createEntityManagerFactory("some");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user1);
        em.getTransaction().commit();
        em.close();
    }
}
