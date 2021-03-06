package com.bakhtiargalib.inventory.persistence.repository;

import com.bakhtiargalib.inventory.persistence.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
