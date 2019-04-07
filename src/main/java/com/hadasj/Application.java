package com.hadasj;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static java.util.Arrays.asList;

@SpringBootApplication
public class Application {

    @Bean
    DozerBeanMapper mapper() {
        return new DozerBeanMapper(asList("dozer.xml"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
