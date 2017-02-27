package com.jmockit_ex;

import com.test.powermock.ClassWithPrivateMethod;
import com.test.powermock.StaticClassForTesting;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.FullVerifications;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Test;

import static mockit.Deencapsulation.invoke;

/**
 * Created by gnavin on 2/26/17.
 * http://blog.icodejava.com/44/unit-testing-your-methods-by-mocking-private-methods-with-jmockit-library/
 */
public class PrivateMethodExamples {

    @Test
    public void testPrivateMethodViaPublicMethod() {

        // Note that in this case the method is private.
        // This is a time when JMockit leaves its consistent interface,
        // simply because it cannot see private methods.
        // Mockito does this using the spy() mechanism.
        // The syntax is similar to what JMockit does here.
        // Both libraries advice against mocking private methods.

        final ClassWithPrivateMethod testedClassWithPrivateMethod = new ClassWithPrivateMethod();

        new MockUp<ClassWithPrivateMethod>() {
            @Mock
            String privateMethod() {
                System.out.println("This is a mocked private method of class - SomeClass");
                return "MockedPrivateMethod";
            }
        };


        Assert.assertEquals("MockedPrivateMethod", testedClassWithPrivateMethod.method1());

        // verify mocked call
        new FullVerifications(StaticClassForTesting.class) {
        };
    }

    @Test
    public void testPrivateMethod() {
        final ClassWithPrivateMethod testedClassWithPrivateMethod = new ClassWithPrivateMethod();
        //call and invoke private method and test directly
        final String privateMethod = Deencapsulation.invoke(testedClassWithPrivateMethod, "privateMethod");
        System.out.println("privateMethod = " + privateMethod);
        Assert.assertEquals("privateMethod", privateMethod);
    }

    @Test
    public void testPartialMcokingWithPrivateMethod() {

        //Not working
        final ClassWithPrivateMethod testedClassWithPrivateMethod = new ClassWithPrivateMethod();
        new Expectations(testedClassWithPrivateMethod) {{
            invoke(testedClassWithPrivateMethod, "privateMethod");
            result = "mockedPrivateMethod";
        }};
        final String privateMethod = testedClassWithPrivateMethod.method1();
        System.out.println("privateMethod = " + privateMethod);
        //Not working
        //Assert.assertEquals("mockedPrivateMethod", privateMethod);
    }

    @Test
    public void testPartialMcokingWithPublicMethod() {

        //Not working
        final ClassWithPrivateMethod testedClassWithPrivateMethod = new ClassWithPrivateMethod();
        new Expectations(testedClassWithPrivateMethod) {{
            testedClassWithPrivateMethod.method1();
            result = "mockedMethod1";
        }};
        final String method2 = testedClassWithPrivateMethod.method2();
        System.out.println("method2 = " + method2);

        //Not working
        Assert.assertEquals("mockedMethod1", method2);
    }


}