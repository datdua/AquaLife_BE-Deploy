package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.Fish;

public interface FishRepository extends JpaRepository<Fish, Integer> {
    List<Fish> findByFishType(String fishType);
    List<Fish> findByColor(String color);
}
