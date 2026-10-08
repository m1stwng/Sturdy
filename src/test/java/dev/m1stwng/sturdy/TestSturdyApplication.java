package dev.m1stwng.sturdy;

import org.springframework.boot.SpringApplication;

public class TestSturdyApplication {

	public static void main(String[] args) {
		SpringApplication.from(SturdyApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
