package es.uah.lti.ltiformacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Unversidad de Alcalá
 * Made for the project springboot-lti-advantage-tool
 */
@SpringBootApplication
@EnableCaching
public class FormacionLTIApplication {
    public static void main(String[] args) {
        SpringApplication.run(FormacionLTIApplication.class, args);
    }
}
