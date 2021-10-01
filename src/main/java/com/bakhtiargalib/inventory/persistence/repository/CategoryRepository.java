package com.bakhtiargalib.inventory.persistence.repository;

import com.bakhtiargalib.inventory.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
