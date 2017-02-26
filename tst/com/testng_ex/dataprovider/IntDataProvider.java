package com.testng_ex.dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by gnavin on 2/25/17.
 */
public class IntDataProvider {

    @Test(dataProvider = "provideNumbers")
    public void test(int number, int expected) {
        Assert.assertEquals(number + 10, expected);
    }

    @DataProvider(name = "provideNumbers")
    public Object[][] provideData() {

        return new Object[][] {
                { 10, 20 },
                { 100, 110 },
                { 200, 210 }
        };
    }

}
