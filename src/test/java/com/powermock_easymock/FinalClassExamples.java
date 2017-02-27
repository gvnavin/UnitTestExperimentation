package com.powermock_easymock;

import com.test.powermock.FinalClass;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
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
        final FinalClass mockedFinalClass = PowerMock.createMock(FinalClass.class);

        EasyMock.expect(mockedFinalClass.method1()).andReturn("Test").atLeastOnce();

        PowerMock.replay(mockedFinalClass);

        Assert.assertEquals("Test", mockedFinalClass.method1());

        PowerMock.verify(mockedFinalClass);
    }

}