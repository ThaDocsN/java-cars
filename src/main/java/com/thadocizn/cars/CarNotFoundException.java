package com.thadocizn.cars;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(Long id)  {
        super("Could not find Car with id: " + id);
    }

}
