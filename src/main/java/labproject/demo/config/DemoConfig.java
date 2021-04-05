package labproject.demo.config;

import labproject.demo.lab.A;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Bean
    public A a() {
        return new A();
    }
}
