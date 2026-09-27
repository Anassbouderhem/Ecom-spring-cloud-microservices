package net.bouderhem.inventoryservice;

import net.bouderhem.inventoryservice.entities.Product;
import net.bouderhem.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
@Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
           productRepository.save(Product.builder()
                           .name("Computer")
                           .price(12000)
                           .quantity(9)
                   .build());

            productRepository.save(Product.builder()
                    .name("Printer")
                    .price(2000)
                    .quantity(20)
                    .build());

            productRepository.save(Product.builder()
                    .name("Mouse")
                    .price(300)
                    .quantity(50)
                    .build());
        };
    }
}
