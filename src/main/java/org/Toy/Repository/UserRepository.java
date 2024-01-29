package org.Toy.Repository;

import org.Toy.Domain.USER;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<USER,Long> {
    Optional<USER> findById(Long id);
}
