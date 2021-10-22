package ex3lab2.ex3lab2.config;

import ex3lab2.ex3lab2.aspects.MyAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Config {
    @Bean
    public MyAspect myAspect(){
        return new MyAspect();
    }
}
