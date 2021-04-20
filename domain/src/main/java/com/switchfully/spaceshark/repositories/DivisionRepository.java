package com.switchfully.spaceshark.repositories;

import com.switchfully.spaceshark.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {

}
