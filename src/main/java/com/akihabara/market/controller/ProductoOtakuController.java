package com.akihabara.market.controller;

import com.akihabara.market.model.ProductoOtaku;
import com.akihabara.market.repository.ProductoOtakuRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*") // 🔓 permite peticiones desde cualquier origen
@RestController
@RequestMapping("/productos")
public class ProductoOtakuController {

    @Autowired
    private ProductoOtakuRepository repo;

    @GetMapping
    public List<ProductoOtaku> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ProductoOtaku getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public ProductoOtaku create(@Valid @RequestBody ProductoOtaku producto) {
        return repo.save(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoOtaku> update(@PathVariable Long id, @Valid @RequestBody ProductoOtaku producto) {
        return repo.findById(id)
                .map(existing -> {
                    producto.setId(id);
                    ProductoOtaku actualizado = repo.save(producto);
                    return ResponseEntity.ok(actualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable Long id) {
        repo.deleteById(id);
    }
}
