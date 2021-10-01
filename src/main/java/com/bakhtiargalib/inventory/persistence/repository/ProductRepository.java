package com.bakhtiargalib.inventory.persistence.repository;

import com.bakhtiargalib.inventory.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
