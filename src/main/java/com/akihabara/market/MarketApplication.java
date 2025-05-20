package com.akihabara.market;

import com.akihabara.market.model.ProductoOtaku;
import com.akihabara.market.repository.ProductoOtakuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(ProductoOtakuRepository repo) {
        return args -> {
            repo.save(new ProductoOtaku(null, "Figura de Luffy", "Figura", 29.99, 10));
            repo.save(new ProductoOtaku(null, "Manga de Naruto", "Manga", 7.99, 50));
            repo.save(new ProductoOtaku(null, "Póster de One Piece", "Póster", 4.99, 20));
        };
    }
}
