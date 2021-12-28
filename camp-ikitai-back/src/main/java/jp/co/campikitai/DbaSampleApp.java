package jp.co.campikitai;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class DbaSampleApp {
  public static void main(String[] args) {
    SpringApplication.run(DbaSampleApp.class, args);
  }

  @Bean
  @Primary
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
