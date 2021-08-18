package br.com.neki.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.neki.avaliacao.model.User_skill;
import br.com.neki.avaliacao.repository.User_skillRepository;

@Service
public class User_skillService {
	@Autowired
	private User_skillRepository user_SkillRepository;

	public User_skill findById(Integer id) {
		return user_SkillRepository.findById(id).get();
	}

	public List<User_skill> findAll() {
		List<User_skill> user_skill = user_SkillRepository.findAll();
		return user_skill;
	}

	public User_skill insert(User_skill user_skill) {
		return user_SkillRepository.save(user_skill);
	}

	public ResponseEntity<User_skill> update(Integer id, User_skill user_skill) {
		if (!user_SkillRepository.existsById(id))
			return ResponseEntity.notFound().build();

		user_skill.setId(id);
		user_skill = user_SkillRepository.save(user_skill);
		return ResponseEntity.ok(user_skill);
	}

	public boolean delete(Integer Id) {
		if (!user_SkillRepository.existsById(Id)) {
			return false;
		} else {
			user_SkillRepository.deleteById(Id);
			return true;
		}
	}

}
