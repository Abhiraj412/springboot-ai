package com.abhiraj.module1.serviceimpl;

import com.abhiraj.module1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Primary
@Component
@Scope("prototype")
@Qualifier("email")
//@ConditionalOnProperty(name = "notification.type", havingValue = "email")
public class EmailServiceImpl implements NotificationService {

    public void send(String message){
        System.out.println("Sending email: " + message);
    }
}
