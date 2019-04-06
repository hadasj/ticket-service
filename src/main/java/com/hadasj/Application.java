package com.hadasj;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Bean
    DozerBeanMapper mapper() {
        return new DozerBeanMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
