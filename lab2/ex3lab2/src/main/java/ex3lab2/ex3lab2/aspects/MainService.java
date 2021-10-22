package ex3lab2.ex3lab2.aspects;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    public String getLowerCaseName(String name) {
        return name.toLowerCase();
    }

    public String getUpperCaseName(String name) {
        return name.toUpperCase();
    }
}
