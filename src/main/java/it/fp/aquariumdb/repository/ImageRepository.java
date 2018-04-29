package it.fp.aquariumdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.fp.aquariumdb.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{
	//Image findByTableAndId (String table_name, long pkey_value);
	
	List<Image > findByTableNameAndPkeyValueAndIsMainImage (String tableName, Long pkeyValue, Boolean isMainImage);

    @Query("select i from Image i where table_name = 'fish' and pkey_value in (select id from Fish where family_id = (:familyId))")
    List<Image> findImagesForFamily(@Param("familyId") String familyId);

}
