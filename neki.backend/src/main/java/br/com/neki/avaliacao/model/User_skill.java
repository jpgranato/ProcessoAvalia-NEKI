package br.com.neki.avaliacao.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User_skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_skill-id", nullable = false)
	private Integer id;
	
	@Column(name = "knowledge_level", nullable = false)
	private Integer knowledgeLevel;
	

	@Column(name = "user_id", nullable = false)
	private Integer user_id;
	
	@Column(name = "skill_id", nullable = false)
	private Integer skill_id;

	@Column(name = "created_at", nullable = false)
	private Timestamp dataCriacao;

	@Column(name = "updated_at", nullable = false)
	private Timestamp dataAtualizacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKnowledgeLevel() {
		return knowledgeLevel;
	}

	public void setKnowledgeLevel(Integer knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Integer skill_id) {
		this.skill_id = skill_id;
	}

	public Timestamp getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Timestamp dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Timestamp getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Timestamp dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	


	
	
}
	