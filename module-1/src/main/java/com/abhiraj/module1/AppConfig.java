package com.abhiraj.module1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    /*The @Bean annotation has higher priority than Stereotype annotation like @Component, @Service, @Repository,
    @Controller etc to create a bean */
    @Bean
    @Scope("prototype")
    PaymentService paymentService(){
        //more logic
        return new PaymentService();
    }

}
