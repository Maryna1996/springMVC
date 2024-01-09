package springdata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springdata.model.Order;
import springdata.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll(Sort.by("id"));
    }

    @Override
    public ResponseEntity<Object> addOrder(Order order) {
        LOG.info("Call addOrder() method with order={} parameter.", order);
        orderRepository.save(order);
        LOG.info("New order {} successfully added.", order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public void deleteOrder(Long id) {
        LOG.info("Call deleteOrder() method with id={} parameter.", id);
        orderRepository.deleteById(id);
        LOG.info("Order with id={} successfully deleted.", id);
    }
}
