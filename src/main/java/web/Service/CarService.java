package web.Service;

import web.Machine.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars(int count);
}
