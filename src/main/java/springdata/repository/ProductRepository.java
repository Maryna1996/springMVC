package springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

