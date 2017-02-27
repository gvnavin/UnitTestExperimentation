package com.mockito_ex.testng_ex;

import com.mockito_ex.MockitoTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by gnavin on 2/24/17.
 * Source:
 * http://www.vogella.com/tutorials/Mockito/article.html
 * Mockito is better
 * http://stackoverflow.com/questions/2864796/easymock-vs-mockito-design-vs-maintainability
 */
public class MockitoReturnExamples {

    @Test
    public void testWhenReturn() {
        MockitoTest.testWhenReturn();
    }

    @Test
    public void testMoreThanOneTimeReturnValue() {
        MockitoTest.testMoreThanOneTimeReturnValue();
    }

    // this test demonstrates how to return values based on the input
    @Test
    public void testReturnValueDependentOnMethodParameter() {
        MockitoTest.testReturnValueDependentOnMethodParameter();
    }

    // this test demonstrates how to return values independent of the input value
    @Test
    public void testReturnValueInDependentOnMethodParameter() {
        MockitoTest.testReturnValueInDependentOnMethodParameter();
    }

    // return a value based on the type of the provide parameter
    @Test
    public void testReturnValueDependentOnClassTypeMethodParameter() {
        MockitoTest.testReturnValueDependentOnClassTypeMethodParameter();
    }

    @Test(expectedExceptions = IOException.class)
    public void testForDoThrow() throws IOException {
        MockitoTest.testForDoThrow();
    }

    @Test
    public void testForDoReturn() {
        MockitoTest.testForDoReturn();
    }

}
