package com.test.powermock;

/**
 * Created by gnavin on 2/26/17.
 */
public class CarFactory {

    public Car constructCar(String type, String color) {
        final Car car = new Car(type, color);
        final String print = car.getName();
        System.out.println("getName = " + print);
        return car;
    }
}
