package library;

import java.util.Arrays;

public class Library {
    private Book[] books;

    public Library(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            books[i] = ;
        }
    }

    public Book getBook(Book book) {
        boolean flag = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i].equals(book)) {
                flag = true;
            }
        }
        if (flag) {
            return book;
        } else {
            return null;
        }
    }
}