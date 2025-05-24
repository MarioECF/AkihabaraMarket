// Paquete principal de la aplicación
package com.akihabara.market;

// Importaciones de clases necesarias
import com.akihabara.market.model.ProductoOtaku;
import com.akihabara.market.repository.ProductoOtakuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// Anotación principal que indica que esta es una aplicación Spring Boot
@SpringBootApplication
public class MarketApplication {

    // Método principal que arranca la aplicación Spring Boot
    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }

    // Bean que se ejecuta automáticamente al iniciar la aplicación
    // Sirve para insertar datos de ejemplo en la base de datos
    @Bean
    public CommandLineRunner initData(ProductoOtakuRepository repo) {
        return args -> {
            // Guardamos tres productos otaku de ejemplo en el repositorio
            repo.save(new ProductoOtaku(null, "Figura de Luffy", "Figura", 29.99, 10));
            repo.save(new ProductoOtaku(null, "Manga de Naruto", "Manga", 7.99, 50));
            repo.save(new ProductoOtaku(null, "Póster de One Piece", "Póster", 4.99, 20));
        };
    }
}
