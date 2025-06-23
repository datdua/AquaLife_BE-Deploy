package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.fpt.edu.aqualife.entity.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Integer>{
    List<ChatMessage> findByUserId(Integer userId);  
}
