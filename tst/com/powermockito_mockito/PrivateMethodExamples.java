package com.powermockito_mockito;

import com.test.powermock.ClassWithPrivateMethod;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by gnavin on 2/26/17.
 * http://lkrnac.net/blog/2014/01/18/mock-private-method#mock-private-method
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ClassWithPrivateMethod.class})
public class PrivateMethodExamples {

    @Test
    public void testPrivateMethod() throws Exception {
        final ClassWithPrivateMethod actualClassWithPrivateMethod = new ClassWithPrivateMethod();
        final ClassWithPrivateMethod mockedClassWithPrivateMethod = PowerMockito.spy(actualClassWithPrivateMethod);

        PowerMockito.when(mockedClassWithPrivateMethod, "privateMethod").thenReturn("Test");

        //PowerMockito.doReturn("Test").when(mockedClassWithPrivateMethod, "privateMethod");
        Assert.assertEquals("Test", mockedClassWithPrivateMethod.method1());
    }

}