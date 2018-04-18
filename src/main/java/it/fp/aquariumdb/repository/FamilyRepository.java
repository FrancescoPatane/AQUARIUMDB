package it.fp.aquariumdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fp.aquariumdb.model.Family;


public interface FamilyRepository extends JpaRepository<Family, Long>{

}
