package com.testng_ex.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by gnavin on 2/25/17.
 * http://www.mkyong.com/unittest/junit-4-vs-testng-comparison/
 */
public class DataProviderByModel {

    @Test(dataProvider = "Data-Provider-Function")
    public void parameterObjectTest(Model clzz) {
        System.out.println("Parameterized Number is : " + clzz.getMsg());
        System.out.println("Parameterized Number is : " + clzz.getNumber());
    }

    //This function will provide the patameter data
    @DataProvider(name = "Data-Provider-Function")
    public Object[][] parameterObjectTestProvider() {
        Model obj = new Model();
        obj.setMsg("Hello");
        obj.setNumber(123);

        return new Object[][]{
                {obj}
        };
    }


}
