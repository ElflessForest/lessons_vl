package library;

import java.util.ArrayList;

public class Reader {

    private ArrayList<Book> books;

    public Reader() {

    }

    public void takeBook(Library library, Book book) {
        this.books.add(library.getBook(null));
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
