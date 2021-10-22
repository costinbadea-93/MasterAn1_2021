package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.MainRepository;

@Component
public class MainService {
    private final MainRepository mainRepository;
    /**
     *  1.@Autowired pe field
     *  2.@Autowired pe constructor
     *  3.@Autowired pe setter
     */
    @Autowired
    public MainService(MainRepository mainRepository){
        this.mainRepository = mainRepository;
    }

    public String sayHello() {
        return mainRepository.sayHello();
    }
}
