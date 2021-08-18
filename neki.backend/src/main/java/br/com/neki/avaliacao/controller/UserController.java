package br.com.neki.avaliacao.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.neki.avaliacao.model.User;
import br.com.neki.avaliacao.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")

	public ResponseEntity<User> getById(@PathVariable Integer id) {
		User user = userService.findById(id);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(user, headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userService.findAll();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(users, headers, HttpStatus.OK);
	}

	@PostMapping

	public ResponseEntity<User> post(@RequestBody User user) {
		User e = userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getId()).toUri();
		return ResponseEntity.created(uri).body(e);
	}

	@PutMapping("/{id}")

	public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
		return userService.update(id, user);
	}

	@DeleteMapping("{id}")

	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		if (!userService.delete(id)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
