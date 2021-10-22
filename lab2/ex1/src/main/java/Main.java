import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import utils.MessageService;

public class Main {
    public static void main(String[] args) {
        /**
         * singleton => default scope
         * prototype => new bean for any new call;
         * ===========================================
         * request => bean per request
         * session => bean per session
         * application => bean per application
         */
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println("Context was created!!!");
        MessageService messageService1 = context.getBean(MessageService.class);
        messageService1.setMessage("Hello on second lab!!!!");
        System.out.println("Msg1 " + messageService1.getMessage());
        System.out.println(messageService1.hashCode());

        MessageService messageService2 = context.getBean(MessageService.class);
        System.out.println(messageService2.hashCode());
        System.out.println("Msg2 " + messageService2.getMessage());
    }
}
