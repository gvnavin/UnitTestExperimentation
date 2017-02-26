package com.easymock_ex;

import com.book.BookDAL;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

/**
 * Created by gnavin on 2/26/17.
 */
public class EasyMockBookDALTest {

    @Test
    public void testExpectReplayVerify() {

        // EasyMock.createNiceMock() creates a mock and sets the
        // default implementation of each method of the mock.
        // If EasyMock.createMock() is used, then invoking the mock method throws assertion error.
        BookDAL bookDAL = createNiceMock(BookDAL.class);
        expect(bookDAL.getBookName("isbn_1")).andReturn("Book1").times(2);
        expect(bookDAL.getBookName("isbn_2")).andReturn("Book2");

        //make the mock available
        replay(bookDAL);

        Assert.assertEquals("Book1", bookDAL.getBookName("isbn_1"));
        Assert.assertEquals("Book1", bookDAL.getBookName("isbn_1"));

        Assert.assertEquals("Book2", bookDAL.getBookName("isbn_2"));

        verify(bookDAL);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testException() {
        //activate the mock
        BookDAL bookDAL = createNiceMock(BookDAL.class);
        expect(bookDAL.getBookName("isbn_1")).andThrow(new IndexOutOfBoundsException());

        //make the mock available
        replay(bookDAL);

        bookDAL.getBookName("isbn_1");

        //verify call is made or not
        verify(bookDAL);

    }

    @Test
    public void testTimes() {

        // EasyMock.createNiceMock() creates a mock and sets the
        // default implementation of each method of the mock.
        // If EasyMock.createMock() is used, then invoking the mock method throws assertion error.
        BookDAL bookDAL = createNiceMock(BookDAL.class);
        expect(bookDAL.getBookName("isbn_1")).andReturn("Book1").times(2);
        expect(bookDAL.getBookName("isbn_2")).andReturn("Book2");

        //times
        EasyMock.expectLastCall().times(1,3);

        //make the mock available
        replay(bookDAL);

        Assert.assertEquals("Book1", bookDAL.getBookName("isbn_1"));
        Assert.assertEquals("Book1", bookDAL.getBookName("isbn_1"));

        Assert.assertEquals("Book2", bookDAL.getBookName("isbn_2"));

        verify(bookDAL);

    }

    @Test
    public void testAtleastOnceAnyTimes() {

        // EasyMock.createNiceMock() creates a mock and sets the
        // default implementation of each method of the mock.
        // If EasyMock.createMock() is used, then invoking the mock method throws assertion error.
        BookDAL bookDAL = createNiceMock(BookDAL.class);

        expect(bookDAL.getBookName("isbn_1")).andReturn("Book1");
        //at least once
        EasyMock.expectLastCall().atLeastOnce();

        expect(bookDAL.getBookName("isbn_2")).andReturn("Book2");
        //any times
        EasyMock.expectLastCall().anyTimes();

        //make the mock available
        replay(bookDAL);

        Assert.assertEquals("Book1", bookDAL.getBookName("isbn_1"));
        Assert.assertEquals("Book2", bookDAL.getBookName("isbn_2"));
        verify(bookDAL);
    }
}
