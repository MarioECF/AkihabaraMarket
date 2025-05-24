// Paquete donde se encuentra el repositorio
package com.akihabara.market.repository;

// Importamos la entidad ProductoOtaku
import com.akihabara.market.model.ProductoOtaku;
// Importamos JpaRepository de Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

// Interfaz que define el repositorio de ProductoOtaku
// Hereda de JpaRepository para obtener métodos CRUD sin necesidad de implementarlos
public interface ProductoOtakuRepository extends JpaRepository<ProductoOtaku, Long> {
    // No es necesario definir métodos aquí a menos que quieras consultas personalizadas
    // Spring generará automáticamente métodos como save, findById, findAll, delete, etc.
}
