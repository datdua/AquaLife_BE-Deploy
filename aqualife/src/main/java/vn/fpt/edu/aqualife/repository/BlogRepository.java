package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
    List<Blog> findByCommentId(Integer commentId);
    List<Blog> findByBlogTitleContaining(String title);
}
