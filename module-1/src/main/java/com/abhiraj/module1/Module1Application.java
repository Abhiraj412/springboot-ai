package com.abhiraj.module1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {

	@Autowired
	PaymentService paymentService1;

	@Autowired
	PaymentService paymentService2;

	//Field Dependency Injection
	@Autowired
	@Qualifier("email")
	NotificationService notificationService;

	//Conctructor dependency injection
	final NotificationService notificationService2;

	//conditional on property
//	@Autowired
//	NotificationService notificationService3;

	//All beans Map
	@Autowired
	Map<String, NotificationService> notificationServiceMap = new HashMap<>();

	public Module1Application( @Qualifier("sms") NotificationService notificationService) {
		this.notificationService2 = notificationService; //this is the constructor injection
	}

	public static void main(String[] args) {
		SpringApplication.run(Module1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*Beans - lectr 1.3
		System.out.println("PaymentService1 hashcode:" + paymentService1.hashCode());
		System.out.println("PaymentService2 hashcode:" + paymentService2.hashCode());
		System.out.println("Are PaymentService1 and PaymentService2 are same: " + (paymentService1 == paymentService2));

		paymentService1.pay();
		paymentService2.pay(); */

		/* Dimodule - lectr 1.4*/
		notificationService.send("Hello");
		notificationService2.send("Namaskar!");
		//notificationService3.send("Spring Boot Java Kotlin");

		for(var notificationService: notificationServiceMap.entrySet()){
			System.out.println(notificationService.getKey());
			notificationService.getValue().send("Hello from map");
		}
	}
}
