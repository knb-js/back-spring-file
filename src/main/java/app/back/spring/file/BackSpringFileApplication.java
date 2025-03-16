package app.back.spring.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackSpringFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackSpringFileApplication.class, args);
    }

}
