package com.bakhtiargalib.inventory.api;

import com.bakhtiargalib.inventory.persistence.entity.Product;
import com.bakhtiargalib.inventory.exeption.ResourceNotFoundException;
import com.bakhtiargalib.inventory.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public ResponseEntity<List<Product>> list() {

        return ResponseEntity.ok().body(
                productRepository.findAll(Sort.by(Sort.Order.desc("updated")))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable long id) {

        return ResponseEntity.ok().body(
                productRepository.findById(id)
                        .orElseThrow(ResourceNotFoundException::new)
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Product> add(@Valid @RequestBody Product product) {

        return ResponseEntity.ok().body(
                productRepository.save(product)
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable long id, @Valid @RequestBody Product product) {

        return ResponseEntity.ok().body(
                productRepository.findById(id).map(p -> productRepository.save(product))
                        .orElseThrow(ResourceNotFoundException::new)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {

        productRepository.delete(
                productRepository.findById(id)
                        .orElseThrow(ResourceNotFoundException::new)
        );

        return ResponseEntity.ok().build();
    }
}
