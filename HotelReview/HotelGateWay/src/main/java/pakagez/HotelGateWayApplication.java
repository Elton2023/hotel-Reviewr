package pakagez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelGateWayApplication.class, args);
		System.out.println("Hotel Reviewer's API gateway up and running ");
	}

}
/*
eureka:
  instance:
    prefer-ip-address: true
  client:
    fetch-registry: true
    register-with-eureka: true
    service-url:
      defaultZone: http://localhost:8761/eureka
 */