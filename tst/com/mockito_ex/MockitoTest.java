package com.mockito_ex;

import com.test.mockito.ArticleManager;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by gnavin on 2/24/17.
 * Source:
 * http://www.vogella.com/tutorials/Mockito/article.html
 * Mockito is better
 * http://stackoverflow.com/questions/2864796/easymock-vs-mockito-design-vs-maintainability
 */
public class MockitoTest {

    public static void testWhenReturn() {
        //  create mock
        final List list = mock(List.class);

        when(list.size()).thenReturn(20);

        // use mock in test
        org.testng.Assert.assertEquals(20, list.size());
        org.junit.Assert.assertEquals(20, list.size());

    }

    // Demonstrates the return of multiple values
    public static void testMoreThanOneReturnValue() {
        final Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result = i.next() + " " + i.next();

        //assert
        org.testng.Assert.assertEquals("Mockito rocks", result);
        org.junit.Assert.assertEquals("Mockito rocks", result);
    }


    // this test demonstrates how to return values based on the input
    public static void testReturnValueDependentOnMethodParameter() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);

        //assert
        org.testng.Assert.assertEquals(1, c.compareTo("Mockito"));
        org.junit.Assert.assertEquals(1, c.compareTo("Mockito"));
    }

    // this test demonstrates how to return values independent of the input value
    public static void testReturnValueInDependentOnMethodParameter() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);

        //assert
        org.testng.Assert.assertEquals(-1, c.compareTo(9));
        org.junit.Assert.assertEquals(-1, c.compareTo(9));
    }

    // return a value based on the type of the provide parameter


    public static void testReturnValueDependentOnClassTypeMethodParameter() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo(isA(String.class))).thenReturn(0);

        //assert
        org.testng.Assert.assertEquals(0, c.compareTo(new String("1")));
        org.junit.Assert.assertEquals(0, c.compareTo(new String("1")));
    }

    public static void testForDoThrow() throws IOException {
        // create an configure mock
        OutputStream mockStream = mock(OutputStream.class);
        doThrow(new IOException()).when(mockStream).close();

        // use mock
        OutputStreamWriter streamWriter = new OutputStreamWriter(mockStream);
        streamWriter.close();

    }


    public static void testForDoReturn() {
        //  create mock
        final List list = mock(List.class);

        doReturn(20).when(list).size();

        org.testng.Assert.assertEquals(20, list.size());
        org.junit.Assert.assertEquals(20, list.size());
    }


    public static void testVerifyOneCall() {
        // create and configure mock
        List mockedList = Mockito.mock(List.class);

        when(mockedList.size()).thenReturn(20);

        // call method testing on the mock with parameter 12
        System.out.println("mockedList.size() = " + mockedList.size());
        verify(mockedList).size();
    }


    public static void testVerifyOneCallWithMethodParameter() {
        // create and configure mock
        List mockedList = Mockito.mock(List.class);

        when(mockedList.add(10)).thenReturn(true);
        System.out.println("mockedList.add(10) : " + mockedList.add(10));

        // now check if method testing was called with the parameter 12
        verify(mockedList).add(Matchers.eq(10));
    }


    public static void testVerifyTimes() {
        // create and configure mock
        List mockedList = Mockito.mock(List.class);

        when(mockedList.add(10)).thenReturn(true);

        System.out.println("mockedList.add(10) : " + mockedList.add(10));
        System.out.println("mockedList.add(10) : " + mockedList.add(10));

        // was the method called twice?
        verify(mockedList, times(2)).add(10);
    }


    public static void testVerifyNever() {
        // create and configure mock
        List mockedList = Mockito.mock(List.class);
        verify(mockedList, never()).isEmpty();
    }


    public static void testVerifyAtleastOnce() {
        List mockedList = Mockito.mock(List.class);

        when(mockedList.add(10)).thenReturn(true);

        System.out.println("mockedList.add(10) : " + mockedList.add(10));
        System.out.println("mockedList.add(10) : " + mockedList.add(10));
        verify(mockedList, atLeastOnce()).add(10);
    }


    public static void testVerifyAtleastTimes() {
        List mockedList = Mockito.mock(List.class);

        when(mockedList.add(10)).thenReturn(true);

        System.out.println("mockedList.add(10) : " + mockedList.add(10));
        System.out.println("mockedList.add(10) : " + mockedList.add(10));

        verify(mockedList, atLeast(2)).add(10);
    }


    public static void testVerifyAtmost() {
        List mockedList = Mockito.mock(List.class);

        when(mockedList.add(10)).thenReturn(true);

        System.out.println("mockedList.add(10) : " + mockedList.add(10));
        System.out.println("mockedList.add(10) : " + mockedList.add(10));

        verify(mockedList, atMost(2)).add(10);
    }


    public static void testSpy() {
        // Lets mock a LinkedList
        List list = new LinkedList();
        List spy = Mockito.spy(list);

        //You have to use doReturn() for stubbing
        doReturn("foo").when(spy).get(0);

        System.out.println("spy.isEmpty() = " + spy.isEmpty());
        System.out.println("spy.get(0) = " + spy.get(0));

    }

    public static void testArgumentCapture(final ArgumentCaptor<List<String>> captor) {
        List<String> asList = Arrays.asList("someElement_test", "someElement");
        final List<String> mockedList = mock(List.class);
        mockedList.addAll(asList);

        verify(mockedList).addAll(captor.capture());
        final List<String> capturedArgument = captor.<List<String>>getValue();
        assertThat(capturedArgument, hasItem("someElement"));
    }

}
