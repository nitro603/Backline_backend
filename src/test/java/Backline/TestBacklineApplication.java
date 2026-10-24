package Backline;

import org.springframework.boot.SpringApplication;

public class TestBacklineApplication {

	public static void main(String[] args) {
		SpringApplication.from(BacklineApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
