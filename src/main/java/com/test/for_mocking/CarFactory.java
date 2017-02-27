package com.test.for_mocking;

/**
 * Created by gnavin on 2/26/17.
 */
public class CarFactory {

    public Car constructCar(String type, String color) {
        final Car car = new Car(type, color);
        return car;
    }
}
