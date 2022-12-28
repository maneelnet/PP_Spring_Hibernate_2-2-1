package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarService {

    void add(Car car);
    void deleteAllUsers();
    List<Car> listCars();
    User findUser(String carModel, int carSeries);
}
