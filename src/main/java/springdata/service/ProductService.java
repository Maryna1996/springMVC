package springdata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import springdata.model.Product;
import springdata.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Void> addProduct(Product product) {
        productRepository.save(product);
        LOG.info("New product {} successfully added.", product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<Product> getProductById(Long productId) {
        LOG.info("Call getProductById() method with productId={} parameter.", productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        return ResponseEntity.ok(product);
    }

    public ResponseEntity<List<Product>> getAllProducts() {
        LOG.info("Call getAllProducts() method.");
        List<Product> products = productRepository.findAll(Sort.by("id"));
        return ResponseEntity.ok(products);
    }

    public ResponseEntity<Void> deleteProductById(Long productId) {
        LOG.info("Call deleteProductById() method with productId={} parameter.", productId);
        productRepository.deleteById(productId);
        LOG.info("Product with id={} successfully deleted.", productId);
        return ResponseEntity.noContent().build();
    }

    public void add(Product product) {
    }

    public boolean deleteById(long id) {
        return false;
    }

    public Optional<Product> findById(long id) {
        return null;
    }

    public List<Product> findAll() {
        return null;
    }
}



