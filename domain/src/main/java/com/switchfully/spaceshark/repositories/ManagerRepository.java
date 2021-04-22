package com.switchfully.spaceshark.repositories;

import com.switchfully.spaceshark.model.people.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {
}
