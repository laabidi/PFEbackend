package smartup.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableDiscoveryClient
@SpringBootApplication
public class PortailRHApplication {
	@Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

	public static void main(String[] args) {
		SpringApplication.run(PortailRHApplication.class, args);
	}

}
