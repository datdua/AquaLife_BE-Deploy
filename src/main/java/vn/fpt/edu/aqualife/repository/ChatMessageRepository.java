package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.fpt.edu.aqualife.entity.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer>{
    // List<ChatMessage> findByUserID(Integer userId);  
    @Query("SELECT cm FROM ChatMessage cm WHERE cm.account.accountId = :accountId")
    List<ChatMessage> findByUserID(@Param("accountId") Integer accountId);
}
