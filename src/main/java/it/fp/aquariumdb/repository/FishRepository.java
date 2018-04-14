package it.fp.aquariumdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fp.aquariumdb.model.Fish;

public interface FishRepository extends JpaRepository<Fish, Long>{

}
