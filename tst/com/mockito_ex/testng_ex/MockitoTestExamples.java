package com.mockito_ex.testng_ex;

import com.mockito_ex.MockitoTest;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by gnavin on 2/24/17.
 * Source:
 * http://www.vogella.com/tutorials/Mockito/article.html
 * Mockito is better
 * http://stackoverflow.com/questions/2864796/easymock-vs-mockito-design-vs-maintainability
 */
public class MockitoTestExamples {

    @Test
    public void testWhenReturn() {
        MockitoTest.testWhenReturn();
    }

    @Test
    public void testMoreThanOneReturnValue() {
        MockitoTest.testMoreThanOneReturnValue();
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

    @Test
    public void testVerifyOneCall() {
        MockitoTest.testVerifyOneCall();
    }

    @Test
    public void testVerifyOneCallWithMethodParameter() {
        MockitoTest.testVerifyOneCallWithMethodParameter();
    }

    @Test
    public void testVerifyTimes() {
        MockitoTest.testVerifyTimes();
    }

    @Test
    public void testVerifyNever() {
        MockitoTest.testVerifyNever();
    }

    @Test
    public void testVerifyAtleastOnce() {
        MockitoTest.testVerifyAtleastOnce();
    }

    @Test
    public void testVerifyAtleastTimes() {
        MockitoTest.testVerifyAtleastTimes();
    }

    @Test
    public void testVerifyAtmost() {
        MockitoTest.testVerifyAtmost();
    }

    @Test
    public void testSpy() {
        MockitoTest.testSpy();
    }

    @Captor
    private ArgumentCaptor<List<String>> captor;

    @Test
    public void testArgumentCapture() {
        MockitoAnnotations.initMocks(this);
        MockitoTest.testArgumentCapture(captor);
    }

}
