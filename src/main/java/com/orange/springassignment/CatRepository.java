package com.orange.springassignment;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

interface CatRepository extends JpaRepository<Cat, UUID> {

}
