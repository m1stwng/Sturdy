package dev.m1stwng.sturdy.common.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.util.UUID;

@MappedSuperclass
@Getter
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private UUID id;
}
