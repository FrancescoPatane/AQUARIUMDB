package it.fp.aquariumdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fp.aquariumdb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
