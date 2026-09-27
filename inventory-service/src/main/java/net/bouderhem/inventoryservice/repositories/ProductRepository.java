package net.bouderhem.inventoryservice.repositories;

import net.bouderhem.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository <Product,Long> {
}
