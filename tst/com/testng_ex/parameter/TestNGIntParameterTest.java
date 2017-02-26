package com.testng_ex.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by gnavin on 2/25/17.
 */
public class TestNGIntParameterTest {

    @Test
    @Parameters(value = "number")
    public void parameterIntTest(int number) {
        System.out.println("Parameterized Number is : " + number);
    }

}
