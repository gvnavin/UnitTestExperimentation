package com.jmockit_ex;

import com.test.for_mocking.FinalClass;
import mockit.Expectations;
import mockit.FullVerifications;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gnavin on 2/26/17.
 */
public class FinalClassExamples {

    @Test
    public void testFinalClass(@Mocked final FinalClass finalClass) {
        new Expectations() {{
            finalClass.method1();
            result = "Test";
        }};

        Assert.assertEquals("Test", finalClass.method1());

        // verify mocked call
        new FullVerifications(finalClass) {
        };
    }

}