package it.fp.aquariumdb;


import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class MainConfig {

	@Bean
	public DataSource dataSource() throws URISyntaxException {

		URI dbUri = new URI(System.getenv("DATABASE_URL"));
		System.out.println("#########################################");
		System.out.println(dbUri);
		System.out.println("###########################################");

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";


		return DataSourceBuilder
				.create()
				.username(username)
				.password(password)
				.url(dbUrl)
				//.driverClassName("")
				.build();
	}
}


