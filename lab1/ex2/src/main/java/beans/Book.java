package beans;

import org.springframework.stereotype.Component;

@Component
public class Book {
    private String title = "Book1";
    private String author = "Author1";

//    public Book(String title, String author) {
//        this.title = title;
//        this.author = author;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
