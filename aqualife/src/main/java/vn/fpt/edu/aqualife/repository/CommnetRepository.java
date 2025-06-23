package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.Comment;

public interface CommnetRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByUserId(Integer userId);
}
