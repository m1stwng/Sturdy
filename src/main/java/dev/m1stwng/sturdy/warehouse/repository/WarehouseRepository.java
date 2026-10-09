package dev.m1stwng.sturdy.warehouse.repository;

import dev.m1stwng.sturdy.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, UUID> {

    boolean existsByCode(String code);

    boolean existsByIdAndCodeNot(UUID id, String code);
}
