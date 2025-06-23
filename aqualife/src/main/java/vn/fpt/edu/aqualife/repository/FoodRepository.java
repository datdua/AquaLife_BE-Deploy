package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.Food;
import vn.fpt.edu.aqualife.enums.FoodType;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    List<Food> findByFoodType(FoodType foodType);
}
