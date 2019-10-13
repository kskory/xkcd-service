package kskory.xkcd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class XkcdServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(XkcdServiceApplication.class, args);
	}

}
