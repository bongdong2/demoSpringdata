package me.seungui.demospringdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemoSpringdataApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoSpringdataApplication.class, args);
  }
}
