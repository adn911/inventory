package com.bakhtiargalib.inventory.api;

import com.bakhtiargalib.inventory.entity.Category;
import com.bakhtiargalib.inventory.exeption.ResourceNotFoundException;
import com.bakhtiargalib.inventory.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/categories")
@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public ResponseEntity<List<Category>> list() {

        return ResponseEntity.ok().body(
                categoryRepository.findAll(Sort.by(Sort.Order.desc("updated")))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable long id) {

        return ResponseEntity.ok().body(
                categoryRepository.findById(id)
                        .orElseThrow(ResourceNotFoundException::new)
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Category> add(@Valid @RequestBody Category category) {

        return ResponseEntity.ok().body(
                categoryRepository.save(category)
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@PathVariable long id, @Valid @RequestBody Category category) {

        return ResponseEntity.ok().body(
                categoryRepository.findById(id).map(p -> categoryRepository.save(category))
                        .orElseThrow(ResourceNotFoundException::new)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {

        categoryRepository.delete(
                categoryRepository.findById(id)
                        .orElseThrow(ResourceNotFoundException::new)
        );

        return ResponseEntity.ok().build();
    }
}
