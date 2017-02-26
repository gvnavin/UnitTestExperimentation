package com.mockito_ex.junit_ex.book;

import com.book.Book;
import com.book.BookDAL;
import org.junit.BeforeClass;

import java.util.Arrays;
import java.util.List;

import org.mockito.Mockito;
import org.junit.Assert;


/**
 * Created by gnavin on 2/24/17.
 * Source: https://dzone.com/articles/getting-started-mocking-java
 * Mockito is better
 * http://stackoverflow.com/questions/2864796/easymock-vs-mockito-design-vs-maintainability
 */
public class BookDALTest {

    private static BookDAL mockedBookDAL;
    private static Book book1;
    private static Book book2;

    @BeforeClass
    public static void setUp() {
        //Create mock object of BookDAL
        mockedBookDAL = Mockito.mock(BookDAL.class);

        //Create few instances of Book class.
        book1 = new Book("8131721019", "Compilers Principles",
                Arrays.asList("D. Jeffrey Ulman", "Ravi Sethi", "Alfred V. Aho", "Monica S. Lam"),
                "Pearson Education Singapore Pte Ltd", 2008, 1009, "BOOK_IMAGE");

        book2 = new Book("9788183331630", "Let Us C 13th Edition",
                Arrays.asList("Yashavant Kanetkar"), "BPB PUBLICATIONS", 2012, 675, "BOOK_IMAGE");

        //Stubbing the methods of mocked BookDAL with mocked data.
        Mockito.when(mockedBookDAL.getAllBooks()).thenReturn(Arrays.asList(book1, book2));
        Mockito.when(mockedBookDAL.getBook("8131721019")).thenReturn(book1);
        Mockito.when(mockedBookDAL.addBook(book1)).thenReturn(book1.getIsbn());
        Mockito.when(mockedBookDAL.updateBook(book1)).thenReturn(book1.getIsbn());
    }

    public void testGetAllBooks() throws Exception {
        List<Book> allBooks = mockedBookDAL.getAllBooks();
        Assert.assertEquals(2, allBooks.size());
        Book myBook = allBooks.get(0);
        Assert.assertEquals("8131721019", myBook.getIsbn());
        Assert.assertEquals("Compilers Principles", myBook.getTitle());
        Assert.assertEquals(4, myBook.getAuthors().size());
        Assert.assertEquals((Integer)2008, myBook.getYearOfPublication());
        Assert.assertEquals((Integer) 1009, myBook.getNumberOfPages());
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", myBook.getPublication());
        Assert.assertEquals("BOOK_IMAGE", myBook.getImage());
    }

    public void testGetBook() throws Exception {
        String isbn = "8131721019";

        Book myBook = mockedBookDAL.getBook(isbn);

        Assert.assertNotNull(myBook);
        Assert.assertEquals(isbn, myBook.getIsbn());
        Assert.assertEquals("Compilers Principles", myBook.getTitle());
        Assert.assertEquals(4, myBook.getAuthors().size());
        Assert.assertEquals("Pearson Education Singapore Pte Ltd", myBook.getPublication());
        Assert.assertEquals((Integer)2008, myBook.getYearOfPublication());
        Assert.assertEquals((Integer)1009, myBook.getNumberOfPages());
    }

    public void testAddBook() throws Exception {
        String isbn = mockedBookDAL.addBook(book1);
        Assert.assertNotNull(isbn);
        Assert.assertEquals(book1.getIsbn(), isbn);
    }

    public void testUpdateBook() throws Exception {
        String isbn = mockedBookDAL.updateBook(book1);
        Assert.assertNotNull(isbn);
        Assert.assertEquals(book1.getIsbn(), isbn);
    }

}
