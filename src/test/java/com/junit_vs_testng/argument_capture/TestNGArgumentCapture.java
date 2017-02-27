package com.junit_vs_testng.argument_capture;

import com.mockito_ex.MockitoTest;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by gnavin on 2/26/17.
 */
public class TestNGArgumentCapture {

    @Captor
    private ArgumentCaptor<List<String>> captor;

    @Test
    public void testArgumentCapture() {
        //Without this rule captor will throw null pointer exception
        //In Junit this rule will mock the Captor
        //In TestNG, MockitoAnnotations.initMocks() will mock all the Mockito Annotations like @Mock, @InjectMocks, @Captor
        MockitoAnnotations.initMocks(this);
        MockitoTest.testArgumentCapture(captor);
    }

}
