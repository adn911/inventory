package com.bakhtiargalib.inventory.api;

import com.bakhtiargalib.inventory.persistence.entity.Manufacturer;
import com.bakhtiargalib.inventory.exeption.ResourceNotFoundException;
import com.bakhtiargalib.inventory.persistence.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/manufacturers")
@RestController
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/")
    public ResponseEntity<List<Manufacturer>> list() {

        return ResponseEntity.ok().body(
                manufacturerRepository.findAll(Sort.by(Sort.Order.desc("updated")))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> get(@PathVariable long id) {

        return ResponseEntity.ok().body(
                manufacturerRepository.findById(id)
                        .orElseThrow(ResourceNotFoundException::new)
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Manufacturer> add(@Valid @RequestBody Manufacturer manufacturer) {

        return ResponseEntity.ok().body(
                manufacturerRepository.save(manufacturer)
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Manufacturer> update(@PathVariable long id, @Valid @RequestBody Manufacturer manufacturer) {

        return ResponseEntity.ok().body(
                manufacturerRepository.findById(id).map(p -> manufacturerRepository.save(manufacturer))
                        .orElseThrow(ResourceNotFoundException::new)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {

        manufacturerRepository.delete(
                manufacturerRepository.findById(id)
                        .orElseThrow(ResourceNotFoundException::new)
        );

        return ResponseEntity.ok().build();
    }
}
