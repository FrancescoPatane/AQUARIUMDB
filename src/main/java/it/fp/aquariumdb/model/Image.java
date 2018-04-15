package it.fp.aquariumdb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Image {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable=false)
    private String name;
 
    @Lob
    @Column(nullable=false, columnDefinition="mediumblob")
    private byte[] image;
    
    private String tableName;
    
    private Long pkeyValue;
    
    private Boolean isMainImage = false;

	public Image() {
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Long getPkeyValue() {
		return pkeyValue;
	}

	public void setPkeyValue(Long pkeyValue) {
		this.pkeyValue = pkeyValue;
	}

	public Boolean isMainImage() {
		return isMainImage;
	}

	public void setMainImage(Boolean isMainImage) {
		this.isMainImage = isMainImage;
	}
    
    

}
