import beans.Book;
import beans.Library;
import config.BookService;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // doua posibilitati de a prelua beanurile din context:
        // 1. dupa nume(moment in care trebuie sa facem noi cast)
        // 2. dupa clasa
        Book book = (Book) context.getBean("b1");
        Library library = context.getBean(Library.class);

        System.out.println(book);
        System.out.println(library);


        BookService bookService = new BookService();
        Book book1 = bookService.b1();
        System.out.println(book1);
    }
}
