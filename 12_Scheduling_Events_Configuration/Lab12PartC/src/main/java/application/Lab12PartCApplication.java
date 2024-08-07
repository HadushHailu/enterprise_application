package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MyConfigProperties.class)
public class Lab12PartCApplication implements CommandLineRunner {

	@Autowired
	private MyConfigProperties myConfigProperties;

	public static void main(String[] args) {
		SpringApplication.run(Lab12PartCApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println("Application name: " + myConfigProperties.getApplication_Name());
		System.out.println("version: " + myConfigProperties.getVersion());
		System.out.println("url: " + myConfigProperties.getUrl());
		System.out.println("server name: " + myConfigProperties.getServer_Name());
		System.out.println("first name: " + myConfigProperties.getUser().getFirst_name());
		System.out.println("last name: " + myConfigProperties.getUser().getLast_name());
		System.out.println("user name: " + myConfigProperties.getUser().getUser_name());
		System.out.println("password: " + myConfigProperties.getUser().getPassword());
		System.out.println("countries: " + myConfigProperties.getCoverage().getCountries());
	}

}
