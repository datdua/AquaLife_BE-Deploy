package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.Aquarium;

public interface AquariumRepository extends JpaRepository<Aquarium, Integer> {
    List<Aquarium> findBySize(String size); 
}
