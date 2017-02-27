package com.jmockit_ex;

import com.test.for_mocking.Car;
import com.test.for_mocking.CarFactory;
import com.test.for_mocking.StaticClassForTesting;
import mockit.Expectations;
import mockit.FullVerifications;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gnavin on 2/26/17.
 */
public class ConstructorExamples {

    //http://dontpanic.42.nl/2013/04/mockito-powermock-vs-jmockit.html
    @Test
    public void testConstructorObjectCreation(@Mocked(stubOutClassInitialization = false) final Car expectedCar) throws Exception {

        new Expectations() {
            {
                new Car("Type", "Color"); // expect constructor
                result = expectedCar;
                expectedCar.getName();
                result = "BMW";

            }
        };

        final Car car = new CarFactory().constructCar("Type", "Color");
        Assert.assertEquals("BMW", car.getName());

        // verify mocked call
        new FullVerifications(StaticClassForTesting.class) {
        };

    }


    //http://abhinandanmk.blogspot.in/2012/06/jmockit-tutoriallearn-it-today-with.html
    @Test
    public void testConstructorMocking() {
        new MockUp<Car>() {
            @Mock
            public void $init(final String type, final String color) {
                //Dont assign name variable at all
                //Leave it null
            }
        };

        final Car car = new Car("Type", "Color");

        Assert.assertNull(car.getColor());

        // verify mocked call
        new FullVerifications(StaticClassForTesting.class) {
        };
    }

}