package com.mockito_ex.junit_ex;

import com.mockito_ex.MockitoTest;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

/**
 * Created by gnavin on 2/24/17.
 * Source:
 * http://www.vogella.com/tutorials/Mockito/article.html
 * Mockito is better
 * http://stackoverflow.com/questions/2864796/easymock-vs-mockito-design-vs-maintainability
 */
public class MockitoArgumentCaptureExamples {

    //Without this rule captor will throw null pointer exception
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Captor
    private ArgumentCaptor<List<String>> captor;

    @Test
    public void testArgumentCapture() {
        MockitoTest.testArgumentCapture(captor);
    }

}
