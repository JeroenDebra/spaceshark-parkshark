package com.switchfully.spaceshark.repositories;

import com.switchfully.spaceshark.model.people.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository <Director, Integer> {
}
