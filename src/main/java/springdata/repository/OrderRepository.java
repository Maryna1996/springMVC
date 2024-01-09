package springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springdata.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

