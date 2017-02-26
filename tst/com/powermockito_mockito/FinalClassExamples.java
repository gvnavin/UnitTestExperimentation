package com.powermockito_mockito;

import com.test.powermock.FinalClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by gnavin on 2/26/17.
 * https://github.com/powermock/powermock/wiki/MockitoUsage
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FinalClass.class})
public class FinalClassExamples {

    @Test
    public void testFinalClass() {
        final FinalClass mockedFinalClass = PowerMockito.mock(FinalClass.class);
        Mockito.when(mockedFinalClass.method1()).thenReturn("Test");
        Assert.assertEquals("Test", mockedFinalClass.method1());

        mockedFinalClass.method1();
        mockedFinalClass.method1();

        Mockito.verify(mockedFinalClass, Mockito.times(3));
    }

}