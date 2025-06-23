package vn.fpt.edu.aqualife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.fpt.edu.aqualife.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    // List<Notification> findByUserID(Integer userId);
    @Query("SELECT n FROM Notification n WHERE n.account.accountId = :accountId")
    List<Notification> findByUserID(@Param("accountId") Integer accountId);
    List<Notification> findByIsRead(Boolean isRead);
}
