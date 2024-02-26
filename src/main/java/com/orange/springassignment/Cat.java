package com.orange.springassignment;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
class Cat {
    @Id
    @GeneratedValue
    UUID id;
    String name;
    Integer age;

    public Cat(String name, Integer age) {
        this(UUID.randomUUID(), name, age);
    }
}
