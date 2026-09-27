package net.bouderhem.billingservice;

import net.bouderhem.billingservice.entities.Bill;
import net.bouderhem.billingservice.entities.ProductItem;
import net.bouderhem.billingservice.model.Product;
import net.bouderhem.billingservice.repositories.BillRepository;
import net.bouderhem.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(BillRepository billRepository, ProductItemRepository productItemRepository){
        return args -> {
            List<Long> customerIds = List.of(1L,2L,3L);
            List<Long> productIds = List.of(1L,2L,3L);
            customerIds.forEach(clientId->{
               Bill bill = new Bill();
                bill.setBilligDate(new Date());
                bill.setCustomerId(clientId);
                billRepository.save(bill);
                productIds.forEach(productId ->{
                    ProductItem productItem = new ProductItem();
                    productItem.setPrice(1200*Math.random()+700);
                    productItem.setQuantity(1+new Random().nextInt(30));
                    productItem.setProductId(productId);
                    productItem.setBill(bill);
                    productItemRepository.save(productItem);
                });
            });
        };
    }
}
