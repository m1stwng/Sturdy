package dev.m1stwng.sturdy.product.repository;

import dev.m1stwng.sturdy.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    boolean existsBySku(String sku);

    boolean existsByIdAndSkuNot(UUID id, String sku);
}
