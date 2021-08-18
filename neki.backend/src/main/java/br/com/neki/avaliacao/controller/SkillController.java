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

import br.com.neki.avaliacao.model.Skill;
import br.com.neki.avaliacao.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;

	@GetMapping("/{id}")

	public ResponseEntity<Skill> getById(@PathVariable Integer id) {
		Skill skill = skillService.findById(id);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(skill, headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Skill>> getAll() {
		List<Skill> skills = skillService.findAll();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(skills, headers, HttpStatus.OK);
	}

	@PostMapping

	public ResponseEntity<Skill> post(@RequestBody Skill skill) {
		Skill e = skillService.insert(skill);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getId()).toUri();
		return ResponseEntity.created(uri).body(e);
	}

	@PutMapping("/{id}")

	public ResponseEntity<Skill> update(@PathVariable Integer id, @RequestBody Skill skill) {
		return skillService.update(id, skill);
	}

	@DeleteMapping("{id}")

	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		if (!skillService.delete(id)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
