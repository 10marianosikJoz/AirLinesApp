package com.example.airlines;

import com.example.airlines.model.Flight;
import com.example.airlines.model.Role;
import com.example.airlines.repository.FlightRepository;
import com.example.airlines.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
public class AirlinesApplication implements CommandLineRunner {


	private final RoleRepository roleRepository;
	private final FlightRepository flightRepository;

	public AirlinesApplication(RoleRepository roleRepository, FlightRepository flightRepository) {
		this.roleRepository = roleRepository;
		this.flightRepository = flightRepository;
	}

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
//	addFlightsToDatabase();
	}

	public void addToDatabase() {
		roleRepository.save(new Role("ROLE_USER"));
	}

	public void addFlightsToDatabase() {

		flightRepository.save(new Flight("London",
				"Miami",
				"Bus",
				LocalDate.of(2021,11,22),
				LocalDate.of(2021,11,27),
				LocalTime.of(12,11,11),
				LocalTime.of(12,33,11),
				"11"));
	}
}
