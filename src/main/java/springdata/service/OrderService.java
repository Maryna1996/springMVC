package springdata.service;

import org.springframework.http.ResponseEntity;
import springdata.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<Order> getOrderById(Long id);

    List<Order> getAllOrders();

    ResponseEntity<Object> addOrder(Order order);

    void deleteOrder(Long id);
}

