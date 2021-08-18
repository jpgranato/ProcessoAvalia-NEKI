
package br.com.neki.avaliacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.neki.avaliacao.model.User;
import br.com.neki.avaliacao.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findById(Integer id) {
		return userRepository.findById(id).get();
	}

	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public User insert(User user) {
		return userRepository.save(user);
	}

	public ResponseEntity<User> update(Integer id, User user) {
		if (!userRepository.existsById(id))
			return ResponseEntity.notFound().build();

		user.setId(id);
		user = userRepository.save(user);
		return ResponseEntity.ok(user);
	}

	public boolean delete(Integer Id) {
		if (!userRepository.existsById(Id)) {
			return false;
		} else {
			userRepository.deleteById(Id);
			return true;
		}
	}
}
