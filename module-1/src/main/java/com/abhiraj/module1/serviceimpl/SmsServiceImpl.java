package com.abhiraj.module1.serviceimpl;

import com.abhiraj.module1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sms")
//@ConditionalOnProperty(name = "notification.type", havingValue = "sms")
public class SmsServiceImpl implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending sms: " + message);
    }
}
