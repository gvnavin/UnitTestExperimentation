package com.jmockit_ex;

import com.test.for_mocking.ClassWithFinalMethod;
import mockit.Expectations;
import mockit.FullVerifications;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gnavin on 2/26/17.
 */
public class FinalMethodExamples {

    @Test(expected = ArrayStoreException.class)
    public void testFinalMethodThrowException(@Mocked final ClassWithFinalMethod mockClassWithFinalMethod) {

        new Expectations() {{
            mockClassWithFinalMethod.finalMethod();
            result = new ArrayStoreException("Mock error");
        }};

        mockClassWithFinalMethod.finalMethod();

        // verify mocked call
        new FullVerifications(mockClassWithFinalMethod) {
        };
    }


    @Test
    public void testFinalMethod(@Mocked final ClassWithFinalMethod mockClassWithFinalMethod) {

        new Expectations() {{
            mockClassWithFinalMethod.finalMethod();
            result = "Test";
        }};

        Assert.assertEquals("Test", mockClassWithFinalMethod.finalMethod());

        // verify mocked call
        new FullVerifications(mockClassWithFinalMethod) {
        };
    }

}