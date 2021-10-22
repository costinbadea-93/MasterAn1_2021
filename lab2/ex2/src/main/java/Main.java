import config.ProjectConfig;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.MessageService;

public class Main {
    public static void main(String[] args) {
        /**
         *  eager => default bean instantiation
         *  lazy => instantiation on the first call over bean
         */
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println("Context was created");
        MessageService messageService = context.getBean(MessageService.class);
        messageService.printMessage();
        context.close();
    }
}
