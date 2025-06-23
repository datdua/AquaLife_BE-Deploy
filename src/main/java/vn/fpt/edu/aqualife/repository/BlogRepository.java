package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.fpt.edu.aqualife.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
    // List<Blog> findByCommentID(Integer commentId);
    @Query("SELECT b FROM Blog b WHERE b.comment.commentId = :commentId")
    List<Blog> findByCommentID(@Param("commentId") Integer commentId);
    List<Blog> findByBlogTitleContaining(String title);
}
