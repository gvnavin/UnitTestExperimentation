package com.test.powermock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by gnavin on 2/26/17.
 */
@AllArgsConstructor
@Getter
@Setter
public class Car {

    private final String type;
    private final String color;

    public String getName() {
        return "Honda";
    }
}
