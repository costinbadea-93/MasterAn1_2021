package beans;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private final Driver driver;
    public Car(Driver driver){
        this.driver = driver;
    }
}
