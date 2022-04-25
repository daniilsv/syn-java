import com.querydsl.jpa.impl.JPAQuery;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        User user1 = new User();
        user1.setName("from JPA");

        var entityManagerFactory = Persistence.createEntityManagerFactory("some");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user1);
        var r = new JPAQuery<User>(em)
                .join(QUser.cocktail)
                .on(QCocktail.cocktail.name.eq(QRecipe.recipe.cocktail)).fetch();
        em.createQuery("from User", User.class)
                .getResultList()
                .forEach(System.out::println);
        em.getTransaction().commit();
        em.close();
    }
}
