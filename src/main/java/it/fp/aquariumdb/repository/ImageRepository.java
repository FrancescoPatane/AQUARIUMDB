package it.fp.aquariumdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fp.aquariumdb.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{
	//Image findByTableAndId (String table_name, long pkey_value);
	
	Image findByTableNameAndPkeyValueAndIsMainImage (String tableName, Long pkeyValue, Boolean isMainImage);

}
