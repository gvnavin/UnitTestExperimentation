package com.testng_ex.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Vector;

/**
 * Created by gnavin on 2/25/17.
 * http://www.mkyong.com/unittest/junit-4-vs-testng-comparison/
 */
public class TestNGDataClassStringArrayProvider {

    @Test(dataProvider = "Data-Provider-Function")
    public void parameterIntTest(Class clzz, String[] number) {
        System.out.println("clzz = " + clzz);
        System.out.println("Parameterized Number is : " + number[0]);
        System.out.println("Parameterized Number is : " + number[1]);
    }

    //This function will provide the patameter data
    @DataProvider(name = "Data-Provider-Function")
    public Object[][] parameterIntTestProvider() {
        return new Object[][]{
                {Vector.class, new String[]{"java.util.AbstractList", "java.util.AbstractCollection"}},
                {String.class, new String[]{"1", "2"}},
                {Integer.class, new String[]{"1", "2"}}
        };
    }

}
