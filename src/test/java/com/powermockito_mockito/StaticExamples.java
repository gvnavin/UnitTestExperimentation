package com.powermockito_mockito;

import com.test.powermock.StaticClassForTesting;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.anyString;

/**
 * Created by gnavin on 2/26/17.
 * https://github.com/powermock/powermock/wiki/MockitoUsage
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({StaticClassForTesting.class})
public class StaticExamples {

    @Test
    public void testStatic() {
        PowerMockito.mockStatic(StaticClassForTesting.class);
        Mockito.when(StaticClassForTesting.method1()).thenReturn("Test1");
        //System.out.println("StaticClassForTesting.method1() : " + StaticClassForTesting.method1());
        Assert.assertEquals("Test1", StaticClassForTesting.method1());
    }

    @Test
    public void testStaticVerify() {
        PowerMockito.mockStatic(StaticClassForTesting.class);
        Mockito.when(StaticClassForTesting.method1()).thenReturn("Test1");

        Assert.assertEquals("Test1", StaticClassForTesting.method1());

        PowerMockito.verifyStatic();
        StaticClassForTesting.method1();
    }


    @Test
    public void testStaticVerifyMethodParam() {
        PowerMockito.mockStatic(StaticClassForTesting.class);
        Mockito.when(StaticClassForTesting.method2("param")).thenReturn("Test1");

        Assert.assertEquals("Test1", StaticClassForTesting.method2("param"));

        PowerMockito.verifyStatic();
        StaticClassForTesting.method2("param");
    }

    /*@Test
    public void testStaticVerifyMethodParamAny() {
        PowerMockito.mockStatic(StaticClassForTesting.class);
        Mockito.when(StaticClassForTesting.method2(any())).thenReturn("Test1");

        Assert.assertEquals("Test1", StaticClassForTesting.method2(any()));

        PowerMockito.verifyStatic();
        StaticClassForTesting.method2(any());
    }*/

    @Test
    public void testStaticVerifyMethodParamAnyString() {
        PowerMockito.mockStatic(StaticClassForTesting.class);
        Mockito.when(StaticClassForTesting.method2(anyString())).thenReturn("Test1");

        Assert.assertEquals("Test1", StaticClassForTesting.method2(anyString()));

        PowerMockito.verifyStatic();
        StaticClassForTesting.method2(anyString());
    }

    @Test
    public void testStaticVerifyMethodParamAnyStringTimes() {
        PowerMockito.mockStatic(StaticClassForTesting.class);
        Mockito.when(StaticClassForTesting.method2(anyString())).thenReturn("Test");

        System.out.println("StaticClassForTesting.method2() : " + StaticClassForTesting.method2(""));
        Assert.assertEquals("Test", StaticClassForTesting.method2(anyString()));

        PowerMockito.verifyStatic(Mockito.times(2));
        StaticClassForTesting.method2(anyString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testStaticThrowException() {
        PowerMockito.mockStatic(StaticClassForTesting.class);
        PowerMockito.doThrow(new IndexOutOfBoundsException("Mock error")).when(StaticClassForTesting.class);
        StaticClassForTesting.methodThrowException("");

        StaticClassForTesting.methodThrowException("");

    }

}