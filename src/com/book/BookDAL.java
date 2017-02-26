package com.book;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gnavin on 2/24/17.
 */
public class BookDAL {

    public static final Book BOOK = new Book("8131721019",
            "Compilers Principles",
            Arrays.asList("D. Jeffrey Ulman", "Ravi Sethi", "Alfred V. Aho", "Monica S. Lam"),
            "Pearson Education Singapore Pte Ltd",
            2008,
            1009,
            "BOOK_IMAGE");


    private static final BookDAL BOOK_DAL = new BookDAL();

    public List<Book> getAllBooks() {
        return Collections.EMPTY_LIST;
    }

    public Book getBook(String isbn) {
        return BOOK;
    }

    public String getBookName(String isbn) {
        return "";
    }

    public String addBook(Book book) {
        return book.getIsbn();
    }

    public String updateBook(Book book) {
        return book.getIsbn();
    }

    public static BookDAL getInstance() {
        return BOOK_DAL;
    }
}
