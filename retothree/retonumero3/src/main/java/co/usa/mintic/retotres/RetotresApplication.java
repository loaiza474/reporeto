package co.usa.mintic.retotres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan(basePackages = {"co.usa.mintic.retotres.model"})
@SpringBootApplication
public class RetotresApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetotresApplication.class, args);
	}

}
