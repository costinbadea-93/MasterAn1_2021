package config;

import beans.Book;

public class BookService {
    public Book b1() {
         return new Book("Book 1", "Author 1");
    }
}
