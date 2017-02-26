package com.test.powermock;

/**
 * Created by gnavin on 2/26/17.
 */
public class CarFactory {

    public Car constructCar(String type, String color) {
        return new Car(type, color);
    }
}
