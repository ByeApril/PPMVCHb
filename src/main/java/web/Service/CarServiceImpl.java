package web.Service;

import org.springframework.stereotype.Service;
import web.Machine.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService  {

    @Override
    public List<Car> getCars(int count) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ferrari","Red", 70000));
        cars.add(new Car("Dodge","Grey", 30000));
        cars.add(new Car("KIA","White", 22000));
        cars.add(new Car("Bugatti","Black", 500000));
        cars.add(new Car("FIAT","Purple", 11000));

        if (count >= cars.size()) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
}
