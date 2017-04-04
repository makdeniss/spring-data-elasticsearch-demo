package eu.makdeniss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "eu.makdeniss.repository")
@ComponentScan
public class SpringDataElasticsearchDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataElasticsearchDemoApplication.class, args);
    }
}
