package com.example.demo.repository;


import com.example.demo.domain.Technic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicRepository extends JpaRepository<Technic, Integer> {
    Technic findByModelContaining(String model);
}
