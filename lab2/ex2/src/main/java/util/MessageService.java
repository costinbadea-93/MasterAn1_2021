package util;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
public class MessageService {

    public void printMessage(){
        System.out.println("Hi again on lab2!");
    }

    @PostConstruct
    public void init() {
        System.out.println("instantiating message service!!!");
    }

    @PreDestroy
    public void closing() {
        System.out.println("Bean has finished its job!!!");
    }
}
