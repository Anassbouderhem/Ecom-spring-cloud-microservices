package net.bouderhem.customerservice;

import net.bouderhem.customerservice.config.CustomerConfigParams;
import net.bouderhem.customerservice.entities.Customer;
import net.bouderhem.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder()
                            .name("anass")
                            .email("anass@gmail.com").build());

            customerRepository.save(Customer.builder()
                    .name("sanae")
                    .email("sanae@gmail.com").build());

            customerRepository.save(Customer.builder()
                    .name("hassan")
                    .email("hassan@gmail.com").build());
        };
    }
}
