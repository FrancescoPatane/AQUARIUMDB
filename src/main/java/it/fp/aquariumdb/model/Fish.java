package it.fp.aquariumdb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Fish {

	@Id 
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@ManyToOne
	private Family family;
	@Column(length = 500)
	private String description;
	@Column(nullable = false)
	private Integer size;
	private Integer difficulty;
	private Integer minDimensions;
	private Integer minVolume;
	@OneToMany
	@JoinColumn(name = "fish_id")
	private List<Comment> comments;

	
	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Family getFamily() {
		return family;
	}


	public void setFamily(Family family) {
		this.family = family;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getSize() {
		return size;
	}


	public void setSize(Integer size) {
		this.size = size;
	}


	public Integer getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}


	public Integer getMinDimensions() {
		return minDimensions;
	}


	public void setMinDimensions(Integer minDimensions) {
		this.minDimensions = minDimensions;
	}


	public Integer getMinVolume() {
		return minVolume;
	}


	public void setMinVolume(Integer minVolume) {
		this.minVolume = minVolume;
	}


	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	
	

}
