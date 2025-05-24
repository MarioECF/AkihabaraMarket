// Paquete donde se encuentra el controlador
package com.akihabara.market.controller;

// Importaciones necesarias
import com.akihabara.market.model.ProductoOtaku;
import com.akihabara.market.repository.ProductoOtakuRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 🔓 Permite peticiones desde cualquier origen (CORS), útil para el frontend si se aloja en otro dominio
@CrossOrigin(origins = "*")

// Indica que esta clase es un controlador REST
@RestController

// Define la ruta base para todas las peticiones (http://localhost:8080/productos)
@RequestMapping("/productos")
public class ProductoOtakuController {

    // Inyectamos el repositorio para acceder a la base de datos
    @Autowired
    private ProductoOtakuRepository repo;

    // GET /productos → devuelve todos los productos
    @GetMapping
    public List<ProductoOtaku> getAll() {
        return repo.findAll();
    }

    // GET /productos/{id} → devuelve un producto por ID
    @GetMapping("/{id}")
    public ProductoOtaku getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null); // Devuelve null si no se encuentra
    }

    // POST /productos → crea un nuevo producto (con validación de campos)
    @PostMapping
    public ProductoOtaku create(@Valid @RequestBody ProductoOtaku producto) {
        return repo.save(producto);
    }

    // PUT /productos/{id} → actualiza un producto existente si existe
    @PutMapping("/{id}")
    public ResponseEntity<ProductoOtaku> update(@PathVariable Long id, @Valid @RequestBody ProductoOtaku producto) {
        return repo.findById(id)
                .map(existing -> {
                    producto.setId(id); // Aseguramos que se actualiza el producto correcto
                    ProductoOtaku actualizado = repo.save(producto);
                    return ResponseEntity.ok(actualizado); // Devuelve 200 OK con el producto actualizado
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // Devuelve 404 si no existe
    }

    // DELETE /productos/{id} → elimina un producto por ID
    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable Long id) {
        repo.deleteById(id);
    }
}
