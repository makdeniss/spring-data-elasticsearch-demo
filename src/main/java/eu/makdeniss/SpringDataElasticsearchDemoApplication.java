package eu.makdeniss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "eu.makdeniss.search")
@EnableJpaRepositories(basePackages = "eu.makdeniss.repository")
public class SpringDataElasticsearchDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataElasticsearchDemoApplication.class, args);
    }
}
