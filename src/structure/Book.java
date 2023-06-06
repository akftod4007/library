package structure;

public class Book {
    private String bookTitle;
    private String author;
    private String publisher;

    public Book() {
    }

    public void Book(String bookTitle, String author, String publisher) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
