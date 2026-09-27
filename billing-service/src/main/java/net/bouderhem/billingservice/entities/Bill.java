package net.bouderhem.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.bouderhem.billingservice.model.Customer;

import java.util.Date;
import java.util.List;
@Entity
@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter
public class Bill {
    @Id @GeneratedValue
    private Long id;
    private Date billigDate;
    private long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}
