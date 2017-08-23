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

//  @Bean
//  public MongoDbFactory mongoDbFactory(){
//    return new SimpleMongoDbFactory(new MongoClient("localhost", 27017), "audience_profile");
//  }
//
//  @Bean
//  public MongoTemplate mongoTemplate(){
//    return new MongoTemplate(mongoDbFactory());
//  }
}
