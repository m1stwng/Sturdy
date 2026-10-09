package dev.m1stwng.sturdy.warehouse.entity;

import dev.m1stwng.sturdy.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "warehouses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Warehouse extends BaseEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(length = 50)
    private String alias;
}
