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

import br.com.neki.avaliacao.model.User_skill;
import br.com.neki.avaliacao.service.User_skillService;

@RestController
@RequestMapping("/user_skill")
public class User_skillController {

	@Autowired
	private User_skillService user_skillService;

	@GetMapping("/{id}")

	public ResponseEntity<User_skill> getById(@PathVariable Integer id) {
		User_skill user_skill = user_skillService.findById(id);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(user_skill, headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User_skill>> getAll() {
		List<User_skill> user_skills = user_skillService.findAll();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(user_skills, headers, HttpStatus.OK);
	}

	@PostMapping

	public ResponseEntity<User_skill> post(@RequestBody User_skill user_skill) {
		User_skill e = user_skillService.insert(user_skill);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getId()).toUri();
		return ResponseEntity.created(uri).body(e);
	}

	@PutMapping("/{id}")

	public ResponseEntity<User_skill> update(@PathVariable Integer id, @RequestBody User_skill user_skill) {
		return user_skillService.update(id, user_skill);
	}

	@DeleteMapping("{id}")

	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		if (!user_skillService.delete(id)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
