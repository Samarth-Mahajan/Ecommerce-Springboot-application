package DistributedApplications2026.com.example.demo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	private final List<Product> products = List.of(
			new Product(1, "Classic T-Shirt", new BigDecimal("19.99"), "M", "White"),
			new Product(2, "Denim Jeans", new BigDecimal("49.99"), "32", "Blue"),
			new Product(3, "Running Shoes", new BigDecimal("79.99"), "42", "Black"),
			new Product(4, "Hooded Sweatshirt", new BigDecimal("39.99"), "L", "Grey"),
			new Product(5, "Summer Dress", new BigDecimal("59.99"), "S", "Red"));

	@GetMapping("/products")
	public List<Product> getProducts() {
		return products;
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		return products.stream()
				.filter(product -> product.getId() == id)
				.findFirst()
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
