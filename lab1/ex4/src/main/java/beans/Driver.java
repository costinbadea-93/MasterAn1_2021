package beans;

import org.springframework.stereotype.Component;

@Component
public class Driver {
    private final Car car;
    public Driver(Car car) {
        this.car = car;
    }
}
