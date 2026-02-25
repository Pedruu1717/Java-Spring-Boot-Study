package com.example.braguia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.ui.Model;
import org.springframework.jdbc.core.JdbcTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;
import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files

@SpringBootApplication
public class BraguiaApplication implements CommandLineRunner{

	private static final Logger log =
			LoggerFactory.getLogger(BraguiaApplication.class);

	private final JdbcTemplate jdbcTemplate;

	public BraguiaApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(BraguiaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Estes são os beans fornecidos pelo Spring Boot:");

			String[] beans = ctx.getBeanDefinitionNames();
			Arrays.sort(beans);
			for (String bean : beans) {
				System.out.println(bean);
			}
		};
	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("Creating tables");

		jdbcTemplate.execute("DROP TABLE IF EXISTS monuments");
		jdbcTemplate.execute("CREATE TABLE monuments(" +
				"id SERIAL, name VARCHAR(255), description VARCHAR(500))");

		File file = new File("src/main/resources/static/txt/monuments.txt");
		String data = "";

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String nextLine = scanner.nextLine();
				data = String.join(data, nextLine);
			}
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		String[] monuments = data.split("\\$");

		// Create tuples of monument's name/description.
		List<Object[]> splitUpFields = Stream.of(monuments)
				.map(monument -> monument.split("@"))
				.collect(Collectors.toList());

		// Log each monument's name and description.
		splitUpFields.forEach(monument -> log.info("Inserting monument record for {} {}", monument[0], monument[1]));

		// Bulk load data.
		jdbcTemplate.batchUpdate("INSERT INTO monuments(name, description) VALUES (?,?)", splitUpFields);

		// Query for retrieving monument named Sé de Braga.
		log.info("Query for monument where name='Sé de Braga':");
		jdbcTemplate.query(
				"SELECT id, name, description FROM monuments WHERE name = ?",
					(rs, rowNum) -> new Monument(rs.getLong("id"), rs.getString("name"),
						rs.getString("description")), "Sé de Braga")
							.forEach(monument -> log.info(monument.toString()));
	}
}
