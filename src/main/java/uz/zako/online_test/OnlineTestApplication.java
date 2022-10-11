package uz.zako.online_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableJpaAuditing
@EnableSwagger2
public class OnlineTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineTestApplication.class, args);
    }

}
