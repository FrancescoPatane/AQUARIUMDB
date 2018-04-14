package it.fp.aquariumdb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
	@Id 
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Long id;
	@Column(nullable = false, length = 2000)
	private String text;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String description) {
		this.text = description;
	}

	
	

}
