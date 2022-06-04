package library;

public class Book {

    private String author;
    private String name;

    public Book(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public boolean equals(Book book) {
        return this.author.equals(book.author) && this.name.equals(book.name);
    }
}
