package library;

import java.util.ArrayList;

public class Reader {

    private ArrayList<Book> books;

    public Reader() {
        books = new ArrayList<>();
    }

    public void takeBook(Library library, Book book) {
        if (library.getBook(book) != null) {
            this.books.add(library.getBook(book));
        }
    }

    public void returnBook(Library library, Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (this.books.get(i).equals(book)) {
                this.books.remove(i);
                break;
            }
        }
    }
}