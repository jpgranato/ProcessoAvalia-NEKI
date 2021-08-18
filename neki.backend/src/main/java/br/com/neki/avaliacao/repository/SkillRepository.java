package br.com.neki.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.neki.avaliacao.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{

}
