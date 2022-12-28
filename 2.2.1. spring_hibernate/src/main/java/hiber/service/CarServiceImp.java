package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void add(Car car) {
        carDao.addCar(car);
    }

    @Transactional
    @Override
    public void deleteAllUsers() {
        carDao.deleteAllCars();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() {
        return carDao.listCar();
    }

    @Transactional
    @Override
    public User findUser(String carModel, int carSeries) {
        return carDao.findUser(carModel, carSeries);
    }
}
