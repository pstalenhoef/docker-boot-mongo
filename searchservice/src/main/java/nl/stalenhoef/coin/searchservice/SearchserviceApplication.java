package nl.stalenhoef.coin.searchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class SearchserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchserviceApplication.class, args);
	}
}
