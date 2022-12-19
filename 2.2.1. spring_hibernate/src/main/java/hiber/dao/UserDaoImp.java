package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("FROM User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public void deleteAllUsers() {
      List<User> users = listUsers();
      for (User user: users) {
         sessionFactory.getCurrentSession().delete(user);
      }
   }

   @Override
   @SuppressWarnings("unchecked")
   public User findUser(String carModel, int carSeries) {
      List<Car> carsList = sessionFactory.getCurrentSession()
              .createQuery("FROM Car WHERE model = :carModel AND series = :carSeries")
              .setParameter("carModel", carModel)
              .setParameter("carSeries", carSeries)
              .getResultList();
      if (!carsList.isEmpty()) {
         Car car = carsList.get(0);
         List<User> usersList = listUsers();
         User owner = usersList.stream()
                 .filter(user -> user.getId() == car.getId().intValue())
                 .findFirst()
                 .orElse(null);
         return owner;
      }
      return null;
   }

}
