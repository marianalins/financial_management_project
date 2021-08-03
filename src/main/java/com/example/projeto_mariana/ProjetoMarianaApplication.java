package com.example.projeto_mariana;

import com.example.projeto_mariana.business.PersonBusiness;
import com.example.projeto_mariana.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class ProjetoMarianaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoMarianaApplication.class, args);
	}

	/*@Bean
	CommandLineRunner init(PersonBusiness personBusiness) {
		return args -> {
			personBusiness.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						Person p = new Person();
						p.setFirstName("FirstName "+ i);
						p.setLastName("LastName" + i);
						return p;
					})
					.map(v -> personBusiness.save(v))
					.forEach(System.out::println);
		};
	}*/

}
