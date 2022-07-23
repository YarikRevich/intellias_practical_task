package com.example.practicaltask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.practicaltask.util.dataloader.DataLoader;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class PracticaltaskApplication {
	@Autowired
	private DataLoader dataLoader;

	public static void main(String[] args) {
		SpringApplication.run(PracticaltaskApplication.class, args);
	}
}
