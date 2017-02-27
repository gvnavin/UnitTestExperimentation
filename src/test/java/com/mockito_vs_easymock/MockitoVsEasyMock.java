package com.mockito_vs_easymock;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.List;

import static org.easymock.EasyMock.createNiceMock;

/**
 * Created by gnavin on 2/26/17.
 * https://github.com/mockito/mockito/wiki/Mockito-vs-EasyMock
 */
public class MockitoVsEasyMock {

    @Test
    public void testExample() {

        List easyMocklist = createNiceMock(List.class);

        EasyMock.expect(easyMocklist.get(0)).andStubReturn("one");
        EasyMock.expect(easyMocklist.get(1)).andStubReturn("two");
        easyMocklist.clear();

        EasyMock.replay(easyMocklist);

        Assert.assertEquals("one", easyMocklist.get(0));
        Assert.assertEquals("two", easyMocklist.get(1));
        easyMocklist.clear();

        EasyMock.verify(easyMocklist);

        //----------------------------------------------------------------

        List mockitoMockList = Mockito.mock(List.class);

        Mockito.when(mockitoMockList.get(0)).thenReturn("one");
        Mockito.when(mockitoMockList.get(1)).thenReturn("two");

        Assert.assertEquals("one", mockitoMockList.get(0));
        Assert.assertEquals("two", mockitoMockList.get(1));

        mockitoMockList.clear();

        Mockito.verify(mockitoMockList).clear();
    }


    @Test
    public void testVerificationOrder() {
        IMocksControl control = EasyMock.createStrictControl();

        List easyMocklistOne = control.createMock(List.class);
        List easyMocklistTwo = control.createMock(List.class);

        EasyMock.expect(easyMocklistOne.add("one")).andReturn(true);
        EasyMock.expect(easyMocklistTwo.add("two")).andReturn(true);

        control.replay();

        Assert.assertTrue(easyMocklistOne.add("one"));
        Assert.assertTrue(easyMocklistTwo.add("two"));

        control.verify();

        //----------------------------------------------------------------

        List mockitoMockListOne = Mockito.mock(List.class);
        List mockitoMockListTwo = Mockito.mock(List.class);

        //Mockito.when(mockitoMockListOne.add("one")).thenReturn(true);
        //Mockito.when(mockitoMockListTwo.add("two")).thenReturn(true);

        //Assert.assertTrue(mockitoMockListOne.add("one"));
        //Assert.assertTrue(mockitoMockListTwo.add("two"));

        Assert.assertFalse(mockitoMockListOne.add("one"));
        Assert.assertFalse(mockitoMockListTwo.add("two"));

        InOrder inOrder = Mockito.inOrder(mockitoMockListOne, mockitoMockListTwo);

        inOrder.verify(mockitoMockListOne).add("one");
        inOrder.verify(mockitoMockListTwo).add("two");
    }

    @Test(expected = RuntimeException.class)
    public void testEasyMockStubVoid() {
        List mock = EasyMock.createNiceMock(List.class);

        mock.clear();
        EasyMock.expectLastCall().andThrow(new RuntimeException());

        EasyMock.replay(mock);

        mock.clear();

        EasyMock.verify(mock);

    }

    @Test(expected = RuntimeException.class)
    public void testMockitoStubVoid() {
        List mock = Mockito.mock(List.class);
        Mockito.doThrow(new RuntimeException()).when(mock).clear();

        mock.clear();
    }

    @Test
    public void testNoOfTimeVerification() {
        List easyMockList = EasyMock.createNiceMock(List.class);

        easyMockList.clear();
        EasyMock.expectLastCall().times(3);

        EasyMock.expect(easyMockList.add(EasyMock.anyObject())).andReturn(true).atLeastOnce();

        EasyMock.replay(easyMockList);

        easyMockList.clear();
        easyMockList.clear();
        easyMockList.clear();

        easyMockList.add("String");

        EasyMock.verify(easyMockList);

        //----------------------------------------------------------------

        List mockitoList = Mockito.mock(List.class);

        mockitoList.clear();
        mockitoList.clear();
        mockitoList.clear();

        mockitoList.add("String");

        Mockito.verify(mockitoList, Mockito.times(3)).clear();
        Mockito.verify(mockitoList, Mockito.atLeastOnce()).add(Matchers.anyObject());
    }
}
