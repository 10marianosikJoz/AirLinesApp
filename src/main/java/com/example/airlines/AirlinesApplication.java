package com.example.airlines;

import com.example.airlines.model.Role;
import com.example.airlines.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirlinesApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(AirlinesApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper () {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
//		addToDatabase();
	}

	public void addToDatabase() {
		roleRepository.save(new Role("ROLE_USER"));
	}
}
