package com.bakhtiargalib.inventory.repository;

import com.bakhtiargalib.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}