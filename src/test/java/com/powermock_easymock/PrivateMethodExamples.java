package com.powermock_easymock;

import com.test.for_mocking.ClassWithPrivateMethod;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
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
    public void testPrivateMethodViaPublicMethod() throws Exception {

        final ClassWithPrivateMethod mockedClassWithPrivateMethod = PowerMock.createPartialMock(ClassWithPrivateMethod.class, "privateMethod");

        PowerMock.expectPrivate(mockedClassWithPrivateMethod, "privateMethod").andReturn("Test");

        PowerMock.replay(mockedClassWithPrivateMethod);

        Assert.assertEquals("Test", mockedClassWithPrivateMethod.method1());

        PowerMock.verify(ClassWithPrivateMethod.class);
    }

}