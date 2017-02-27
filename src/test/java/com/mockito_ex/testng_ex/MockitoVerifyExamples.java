package com.mockito_ex.testng_ex;

import com.mockito_ex.MockitoTest;
import org.testng.annotations.Test;

/**
 * Created by gnavin on 2/24/17.
 * Source:
 * http://www.vogella.com/tutorials/Mockito/article.html
 * Mockito is better
 * http://stackoverflow.com/questions/2864796/easymock-vs-mockito-design-vs-maintainability
 */
public class MockitoVerifyExamples {

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

}
