package com.powermock_easymock;

import com.test.for_mocking.ClassWithFinalMethod;
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
@PrepareForTest({ClassWithFinalMethod.class})
public class FinalMethodExamples {

    @Test(expected = ArrayStoreException.class)
    public void testFinalMethodThrowException() {
        final ClassWithFinalMethod mockClassWithFinalMethod = PowerMock.createMock(ClassWithFinalMethod.class);

        EasyMock.expect(mockClassWithFinalMethod.finalMethod()).andThrow(new ArrayStoreException("Mock error"));

        PowerMock.replay(mockClassWithFinalMethod);

        mockClassWithFinalMethod.finalMethod();

        PowerMock.verify(mockClassWithFinalMethod);
    }

    @Test
    public void testFinalMethod() {
        final ClassWithFinalMethod mockClassWithFinalMethod = PowerMock.createMock(ClassWithFinalMethod.class);

        EasyMock.expect(mockClassWithFinalMethod.finalMethod()).andReturn("Test").times(3);

        PowerMock.replay(mockClassWithFinalMethod);

        Assert.assertEquals("Test", mockClassWithFinalMethod.finalMethod());

        mockClassWithFinalMethod.finalMethod();
        mockClassWithFinalMethod.finalMethod();

        PowerMock.verify(mockClassWithFinalMethod);
    }

}