package web.Service;

import org.springframework.stereotype.Component;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService{
    private final List<Car> carslist;

    {
        carslist = new ArrayList<>();

        carslist.add(new Car(1,"BMW", 2022, 10));
        carslist.add(new Car(2,"Putinka", 228, 1));
        carslist.add(new Car(3,"Volga", 1980, 3));
        carslist.add(new Car(4,"Pi door", 228, 1488));
        carslist.add(new Car(5,"Wolk s Wagin", 69, 69));
    }

    public List<Car> index(){
        return carslist;
    }

    public List<Car> show(int id){
        return carslist.stream().filter(car -> car.getId() <= id).collect(Collectors.toList());
    }
}
