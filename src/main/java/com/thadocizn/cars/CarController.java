package com.thadocizn.cars;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class CarController {

    private  CarRepository repo;
    private  RabbitTemplate rt;

    public CarController(CarRepository repo, RabbitTemplate rt) {
        this.repo = repo;
        this.rt = rt;
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return repo.findAll();
    }

    @GetMapping("/cars/id/{id}")
    public Car getCarById(@PathVariable long id) {
        return repo.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id));
    }

    @GetMapping("/cars/year/{year}")
    public List<Car> getCarByYear(@PathVariable int year) {
        List<Car> tempList = repo.findAll();
        List<Car> cars = new ArrayList<>();
        try {
            int intYear = year;
            for (Car c : tempList) {
                if (c.getYear() == intYear) {
                    cars.add(c);
                }
            }
        }catch (NumberFormatException e){
            log.info(e.getLocalizedMessage());
        }
        return cars;
    }

    @GetMapping("/cars/brand/{brand}")
    public List<Car> getCarByBrand(@PathVariable String brand) {
        List<Car> tempList = repo.findAll();
        List<Car> cars = new ArrayList<>();
        for(Car c : tempList){
            if (c.getBrand().toLowerCase().equals(brand.toLowerCase())){
                cars.add(c);
            }
        }
        return cars;    }

    @PostMapping("/cars/upload")
    public List<Car> upLoadData(@RequestBody List<Car> cars) {
        CarMessage message = new CarMessage("Uploaded car data set");
        rt.convertAndSend(CarsApplication.QUEUE_NAME, message.toString());
        log.info("Data loaded");

        return repo.saveAll(cars);    }

    @DeleteMapping("/cars/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        repo.deleteById(id);
          }
}
