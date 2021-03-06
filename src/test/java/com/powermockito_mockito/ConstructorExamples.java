package com.powermockito_mockito;

import com.test.for_mocking.Car;
import com.test.for_mocking.CarFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by gnavin on 2/26/17.
 * https://lkrnac.net/blog/2014/01/mock-constructor/#mock-constructor
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({CarFactory.class})
public class ConstructorExamples {

    @Test
    public void testConstructorObjectCreation() throws Exception {
        final Car expectedCar = Mockito.mock(Car.class);
        PowerMockito.whenNew(Car.class)
                .withArguments("Type", "Color")
                .thenReturn(expectedCar);

        // invoke testing method
        final CarFactory carFactory = new CarFactory();
        final Car actualCar = carFactory.constructCar("Type", "Color");

        Assert.assertEquals(actualCar, expectedCar);
        // verify other logic in constructCar() method
        PowerMockito.verifyNew(Car.class, Mockito.times(1)).withArguments(
                "Type", "Color");
    }

}