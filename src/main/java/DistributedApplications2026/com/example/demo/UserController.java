package DistributedApplications2026.com.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private final List<User> users = List.of(
			new User(1, "Alice"),
			new User(2, "Bob"),
			new User(3, "Charlie"));

	@GetMapping("/users")
	public List<User> getUsers() {
		return users;
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		return users.stream()
				.filter(user -> user.getId() == id)
				.findFirst()
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
