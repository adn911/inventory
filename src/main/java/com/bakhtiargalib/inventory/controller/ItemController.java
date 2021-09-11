package com.bakhtiargalib.inventory.controller;

import com.bakhtiargalib.inventory.entity.Item;
import com.bakhtiargalib.inventory.exeption.ResourceNotFoundException;
import com.bakhtiargalib.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/items")
@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public ResponseEntity<List<Item>> list() {

        return ResponseEntity.ok().body(
                itemRepository.findAll(Sort.by(Sort.Order.desc("updated")))
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> get(@PathVariable long id) {

        return ResponseEntity.ok().body(
                itemRepository.findById(id)
                        .orElseThrow(ResourceNotFoundException::new)
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Item> add(@Valid @RequestBody Item item) {

        return ResponseEntity.ok().body(
                itemRepository.save(item)
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Item> update(@PathVariable long id, @Valid @RequestBody Item item) {

        return ResponseEntity.ok().body(
                itemRepository.findById(id).map(p -> itemRepository.save(item))
                        .orElseThrow(ResourceNotFoundException::new)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {

        itemRepository.delete(
                itemRepository.findById(id)
                        .orElseThrow(ResourceNotFoundException::new)
        );

        return ResponseEntity.ok().build();
    }
}
