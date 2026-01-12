package com.abhiraj.module_1_hw;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1HwApplication implements CommandLineRunner {

	private final CakeBaker cakeBaker;

    public Module1HwApplication(CakeBaker cakeBaker) {
        this.cakeBaker = cakeBaker;
    }


    public static void main(String[] args)  {
		SpringApplication.run(Module1HwApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println(cakeBaker.bakeCake());
	}
}
