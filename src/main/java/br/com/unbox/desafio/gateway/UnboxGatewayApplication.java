package br.com.unbox.desafio.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class UnboxGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnboxGatewayApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                    .allowedOrigins("*")
	                    .allowedMethods(HttpMethod.GET.name(), 
	                    		HttpMethod.POST.name(), 
	                    		HttpMethod.DELETE.name(),
	                    		HttpMethod.PUT.name(),
	                    		HttpMethod.PATCH.name(),
	                    		HttpMethod.OPTIONS.name(),
	                    		HttpMethod.HEAD.name());
	        }
	    };
	}

}
