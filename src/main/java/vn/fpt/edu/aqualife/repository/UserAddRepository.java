package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.UserAdd;

public interface UserAddRepository extends JpaRepository<UserAdd, Integer> {
    List<UserAdd> findByUserId(Integer userId);
    List<UserAdd> findByIsDefault(Boolean isDefault);
}
