package ch.martin.k8s.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"ch.martin.k8s.be", "com.adazes.k8s.demo.be.controller"})
public class BurnBabyBurn {
	public static void main(String[] args) {
		SpringApplication.run(BurnBabyBurn.class, args);
	}
}
