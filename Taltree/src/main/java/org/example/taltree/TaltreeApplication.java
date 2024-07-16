package org.example.taltree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TaltreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaltreeApplication.class, args);
    }

}
