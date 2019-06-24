package com.djamel;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.djamel.entities.Employe;
import com.djamel.repositories.RepoEmploye;
import com.djamel.repositories.RepoRole;
@EnableDiscoveryClient
@SpringBootApplication
public class CountriesApplication implements CommandLineRunner {
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";

	//	@Autowired
	//	private CountryRepository countryRepository;
	@Autowired
	RepoEmploye employecartenational;
	@Autowired
 
	RepoRole repoRole;
 
	public static void main(String[] args) {
		//System.out.println("##### :"+new BCryptPasswordEncoder().encode("1234"));
		new File(uploadDirectory).mkdir();

		SpringApplication.run(CountriesApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Employe e=new  Employe();
		 
		//	repoDossier.save(new Dossier());
		//employecartenational.save(e);
		//		countryRepository.save(new Country("Earth", "World"));
		//		countryRepository.save(new Country("China", "Peking"));
		//		countryRepository.save(new Country("Germany", "Berlin"));
		//		countryRepository.save(new Country("USA", "Washington DC"));
		//		countryRepository.save(new Country("Russia", "Moscow"));
		//		countryRepository.save(new Country("Namibia", "Windhoek"));
		//		countryRepository.save(new Country("India", "New Delhi"));
		//		countryRepository.save(new Country("North Korea", "Pyongyang"));
		//		countryRepository.save(new Country("Kenya", "Nairobi"));
		//		countryRepository.save(new Country("Canada", "Ottawa"));
		//		countryRepository.save(new Country("Jamaica", "Kingston"));
		//		countryRepository.save(new Country("Brazil", "Brasilia"));
		//		countryRepository.save(new Country("Egypt", "Cairo"));
		//		countryRepository.save(new Country("Nigeria", "Abuja"));
		//		countryRepository.save(new Country("Jordan", "Amman"));
		//		countryRepository.save(new Country("Curacao", "Willemstad"));
		//		countryRepository.save(new Country("Sao Tome Principe", "Sao Tome"));
	}
}
