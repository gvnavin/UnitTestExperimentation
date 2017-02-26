package com.powermock_easymock;

import com.test.powermock.Car;
import com.test.powermock.CarFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.easymock.PowerMock;
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
        final Car expectedCar = PowerMock.createMock(Car.class);
        PowerMock.expectNew(Car.class,"Type", "Color").andReturn(expectedCar);

        PowerMock.replay(expectedCar, Car.class);

        // invoke testing method
        final CarFactory carFactory = new CarFactory();
        final Car actualCar = carFactory.constructCar("Type", "Color");

        Assert.assertEquals(actualCar, expectedCar);

        PowerMock.verify(expectedCar);
    }

}