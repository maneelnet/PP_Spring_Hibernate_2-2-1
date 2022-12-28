package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCar() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

    @Override
    public void deleteAllCars() {
        List<Car> carsList = listCar();
        for (Car car : carsList) {
            sessionFactory.getCurrentSession().delete(car);
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
            return car.getUser();
        }
        return null;
    }
}
