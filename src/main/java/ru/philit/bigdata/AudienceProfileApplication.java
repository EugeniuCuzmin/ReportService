package ru.philit.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class AudienceProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudienceProfileApplication.class, args);
	}

	@Bean
	public LocalValidatorFactoryBean validator(){
	    return new LocalValidatorFactoryBean();
    }

  @Bean
  public ValidatingMongoEventListener validatingMongoEventListener(){
    return new ValidatingMongoEventListener(validator());
  }

}
