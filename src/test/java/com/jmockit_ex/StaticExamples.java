package com.jmockit_ex;

import com.test.powermock.StaticClassForTesting;
import mockit.Expectations;
import mockit.FullVerifications;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.anyString;

/**
 * Created by gnavin on 2/26/17.
 */
public class StaticExamples {

    @Test
    public void testStatic(@Mocked final StaticClassForTesting instance) {

        new Expectations() {{
            StaticClassForTesting.method1();
            result = "Test1";
        }};

        Assert.assertEquals("Test1", StaticClassForTesting.method1());

    }

    @Test
    public void testStaticVerify(@Mocked final StaticClassForTesting instance) {

        new Expectations() {{
            StaticClassForTesting.method2("param");
            result = "Test1";
        }};

        Assert.assertEquals("Test1", StaticClassForTesting.method2("param"));

        // verify mocked call
        new FullVerifications(StaticClassForTesting.class) {
        };
    }


    @Test
    public void testStaticVerifyMethodParam(@Mocked final StaticClassForTesting instance) {

        new Expectations() {{
            StaticClassForTesting.method2("param");
            result = "Test1";
        }};

        Assert.assertEquals("Test1", StaticClassForTesting.method2("param"));

        // verify mocked call
        new FullVerifications(StaticClassForTesting.class) {
        };

    }

    /*@Test
    public void testStaticVerifyMethodParamAny() {
        PowerMock.mockStatic(StaticClassForTesting.class);

        EasyMock.expect(StaticClassForTesting.method2(any())).andReturn("Test1");

        PowerMock.replay(StaticClassForTesting.class);

        Assert.assertEquals("Test1", StaticClassForTesting.method2(any()));

        PowerMock.verify(StaticClassForTesting.class);
    }
    */

    @Test
    public void testStaticVerifyMethodParamAnyString(@Mocked final StaticClassForTesting instance) {

        new Expectations() {{
            StaticClassForTesting.method2(anyString);
            result = "Test1";
        }};

        Assert.assertEquals("Test1", StaticClassForTesting.method2(anyString()));

        // verify mocked call
        new FullVerifications(StaticClassForTesting.class) {
        };
    }

    @Test
    public void testStaticVerifyMethodParamAnyStringTimes(@Mocked final StaticClassForTesting instance) {

        new Expectations() {{
            StaticClassForTesting.method2(anyString);
            result = "Test";
            times = 2;
        }};

        System.out.println("StaticClassForTesting.method2() : " + StaticClassForTesting.method2(""));
        Assert.assertEquals("Test", StaticClassForTesting.method2(anyString()));

        // verify mocked call
        new FullVerifications(StaticClassForTesting.class) {
        };
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testStaticThrowException(@Mocked final StaticClassForTesting instance) {
        new Expectations() {{
            StaticClassForTesting.methodThrowException(anyString);
            result = new IndexOutOfBoundsException();
        }};

        StaticClassForTesting.methodThrowException("");

        // verify mocked call
        new FullVerifications(StaticClassForTesting.class) {
        };

    }

}