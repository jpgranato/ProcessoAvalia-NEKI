package br.com.neki.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.neki.avaliacao.model.User_skill;

@Repository
public interface User_skillRepository extends JpaRepository<User_skill, Integer>{

}
