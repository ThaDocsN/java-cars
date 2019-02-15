package com.thadocizn.cars;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByYear(int year);
    List<Car> findByBrand(String brand);
}
