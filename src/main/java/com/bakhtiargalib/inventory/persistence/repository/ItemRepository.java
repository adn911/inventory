package com.bakhtiargalib.inventory.persistence.repository;

import com.bakhtiargalib.inventory.persistence.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
