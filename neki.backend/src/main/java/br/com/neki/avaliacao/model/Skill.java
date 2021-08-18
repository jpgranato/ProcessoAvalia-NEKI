package br.com.neki.avaliacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill-id", nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "version", nullable = false)
	private String version;

	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "image_url", nullable = false)
	private String image_url;
	
	@ManyToOne
	@JoinColumn(name = "skill_id", referencedColumnName = "user_skill-id", nullable = false)
	private User_skill userSkill;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public User_skill getUserSkill() {
		return userSkill;
	}

	public void setUserSkill(User_skill userSkill) {
		this.userSkill = userSkill;
	}


	

	

}
	
