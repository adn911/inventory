package com.bakhtiargalib.inventory.repository;

import com.bakhtiargalib.inventory.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
