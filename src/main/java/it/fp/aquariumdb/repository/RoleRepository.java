package it.fp.aquariumdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fp.aquariumdb.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}