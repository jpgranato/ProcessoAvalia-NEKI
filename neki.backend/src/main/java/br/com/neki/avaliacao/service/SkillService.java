package br.com.neki.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.neki.avaliacao.model.Skill;
import br.com.neki.avaliacao.repository.SkillRepository;

@Service
public class SkillService {
	@Autowired
	private SkillRepository skillRepository;

	public Skill findById(Integer id) {
		return skillRepository.findById(id).get();
	}

	public List<Skill> findAll() {
		List<Skill> skills = skillRepository.findAll();
		return skills;
	}

	public Skill insert(Skill skill) {
		return skillRepository.save(skill);
	}

	public ResponseEntity<Skill> update(Integer id, Skill skill) {
		if (!skillRepository.existsById(id))
			return ResponseEntity.notFound().build();

		skill.setId(id);
		skill = skillRepository.save(skill);
		return ResponseEntity.ok(skill);
	}

	public boolean delete(Integer Id) {
		if (!skillRepository.existsById(Id)) {
			return false;
		} else {
			skillRepository.deleteById(Id);
			return true;
		}
	}

}
