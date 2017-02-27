package com.powermock_easymock;

import com.test.powermock.StaticClassForTesting;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
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
        PowerMock.mockStatic(StaticClassForTesting.class);

        EasyMock.expect(StaticClassForTesting.method1()).andReturn("Test1");

        PowerMock.replay(StaticClassForTesting.class);
        //System.out.println("StaticClassForTesting.method1() : " + StaticClassForTesting.method1());

        Assert.assertEquals("Test1", StaticClassForTesting.method1());

        PowerMock.verify(StaticClassForTesting.class);

    }

//    @Test
//    public void testStaticVerify() {
//        PowerMock.mockStatic(StaticClassForTesting.class);
//
//        EasyMock.expect(StaticClassForTesting.method1()).andReturn("Test1");
//
//        PowerMock.replay(StaticClassForTesting.class);
//
//        Assert.assertEquals("Test1", StaticClassForTesting.method1());
//
//        PowerMock.verify(StaticClassForTesting.class);
//    }


    @Test
    public void testStaticVerifyMethodParam() {
        PowerMock.mockStatic(StaticClassForTesting.class);

        EasyMock.expect(StaticClassForTesting.method2("param")).andReturn("Test1");

        PowerMock.replay(StaticClassForTesting.class);

        Assert.assertEquals("Test1", StaticClassForTesting.method2("param"));

        PowerMock.verify(StaticClassForTesting.class);
    }

    /*
    @Test
    public void testStaticVerifyMethodParamAny() {
        PowerMock.mockStatic(StaticClassForTesting.class);

        EasyMock.expect(StaticClassForTesting.method2(any())).andReturn("Test1");

        PowerMock.replay(StaticClassForTesting.class);

        Assert.assertEquals("Test1", StaticClassForTesting.method2(any()));

        PowerMock.verify(StaticClassForTesting.class);
    }
    */

    @Test
    public void testStaticVerifyMethodParamAnyString() {
        PowerMock.mockStatic(StaticClassForTesting.class);

        EasyMock.expect(StaticClassForTesting.method2(anyString())).andReturn("Test1");

        PowerMock.replay(StaticClassForTesting.class);

        Assert.assertEquals("Test1", StaticClassForTesting.method2(anyString()));

        PowerMock.verify(StaticClassForTesting.class);
    }

    @Test
    public void testStaticVerifyMethodParamAnyStringTimes() {
        PowerMock.mockStatic(StaticClassForTesting.class);

        EasyMock.expect(StaticClassForTesting.method2(anyString())).andReturn("Test").times(2);

        PowerMock.replay(StaticClassForTesting.class);

        System.out.println("StaticClassForTesting.method2() : " + StaticClassForTesting.method2(""));
        Assert.assertEquals("Test", StaticClassForTesting.method2(anyString()));

        PowerMock.verify(StaticClassForTesting.class);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testStaticThrowException() {
        PowerMock.mockStatic(StaticClassForTesting.class);

        EasyMock.expect(StaticClassForTesting.methodThrowException("")).andThrow(new IndexOutOfBoundsException());

        PowerMock.replay(StaticClassForTesting.class);

        StaticClassForTesting.methodThrowException("");

        PowerMock.verify(StaticClassForTesting.class);

    }

}