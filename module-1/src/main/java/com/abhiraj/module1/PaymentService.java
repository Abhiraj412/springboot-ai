package com.abhiraj.module1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jdk.jfr.StackTrace;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Component
//@Service
//@Repository
//@Controller
//@RestController
//@Scope("request")
public class PaymentService {

    public void pay(){
        System.out.println("Payment done!");
    }

    @PostConstruct
    public void afterInitialize(){
        System.out.println("object is instantiated...");
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("bean is going to detroy, perfrom cleanup...");
    }

}
