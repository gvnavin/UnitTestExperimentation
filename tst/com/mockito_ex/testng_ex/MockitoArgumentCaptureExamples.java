package com.mockito_ex.testng_ex;

import com.mockito_ex.MockitoTest;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by gnavin on 2/24/17.
 * Source:
 * http://www.vogella.com/tutorials/Mockito/article.html
 * Mockito is better
 * http://stackoverflow.com/questions/2864796/easymock-vs-mockito-design-vs-maintainability
 */
public class MockitoArgumentCaptureExamples {

    @Captor
    private ArgumentCaptor<List<String>> captor;

    @Test
    public void testArgumentCapture() {
        MockitoAnnotations.initMocks(this);
        MockitoTest.testArgumentCapture(captor);
    }

}
