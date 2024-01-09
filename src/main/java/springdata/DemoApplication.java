package springdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springdata.model.Order;
import springdata.model.Product;
import springdata.service.OrderService;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

    private final OrderService orderService;

    @Autowired
    public DemoApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (addDatabase()) {
            List<Order> orders = (List<Order>) orderService.getAllOrders();
            if (!orders.isEmpty()) {
                LOG.info("Data has been successfully added to the database: " + orders);
            } else {
                LOG.warn("Database is empty after adding data.");
            }
        } else {
            LOG.error("An error occurred while adding data to the database!");
        }
    }

    private boolean addDatabase() {
        final List<Product> products1 = List.of(
                new Product(1L, "Product 1", 01.01),
                new Product(2L, "Product 2", 02.02),
                new Product(3L, "Product 3", 03.03),
                new Product(4L, "Product 4", 04.04),
                new Product(5L, "Product 5", 05.05));

        final List<Product> products2 = List.of(
                new Product(6L, "Product 6", 06.06),
                new Product(7L, "Product 7", 07.07),
                new Product(8L, "Product 8", 08.08),
                new Product(9L, "Product 9", 09.09),
                new Product(10L, "Product 10", 010.010));

        final Order order1 = new Order(1L, products1);
        final Order order2 = new Order(2L, products2);

        orderService.addOrder(order1);
        orderService.addOrder(order2);

        return !orderService.getAllOrders().isEmpty();
    }
}
