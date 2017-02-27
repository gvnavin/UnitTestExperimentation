package com.powermockito_mockito;

import com.test.for_mocking.ClassWithFinalMethod;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;

/**
 * Created by gnavin on 2/26/17.
 * https://github.com/powermock/powermock/wiki/MockitoUsage
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ClassWithFinalMethod.class})
public class FinalMethodExamples {

    @Test(expected = ArrayStoreException.class)
    public void testFinalMethodThrowException() {

        final ClassWithFinalMethod mockClassWithFinalMethod = PowerMockito.mock(ClassWithFinalMethod.class);

        Mockito.when(mockClassWithFinalMethod.finalMethod()).thenThrow(new ArrayStoreException("Mock error"));

        //PowerMockito.doThrow(new ArrayStoreException("Mock error")).when(mockClassWithFinalMethod).finalMethod();

        mockClassWithFinalMethod.finalMethod();
    }

    @Test
    public void testFinalMethod() {
        final ClassWithFinalMethod mockClassWithFinalMethod = PowerMockito.mock(ClassWithFinalMethod.class);

        Mockito.when(mockClassWithFinalMethod.finalMethod()).thenReturn("Test");

        Assert.assertEquals("Test", mockClassWithFinalMethod.finalMethod());

        mockClassWithFinalMethod.finalMethod();
        mockClassWithFinalMethod.finalMethod();

        Mockito.verify(mockClassWithFinalMethod, Mockito.times(3));
    }

}