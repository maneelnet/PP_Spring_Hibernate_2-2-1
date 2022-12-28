package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarDao {

    void addCar(Car car);

    void deleteAllCars();

    List<Car> listCar();

    User findUser(String carModel, int carSeries);
}
