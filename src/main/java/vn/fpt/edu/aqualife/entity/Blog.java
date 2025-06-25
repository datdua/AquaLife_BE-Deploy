package vn.fpt.edu.aqualife.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Blog")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BlogID")
    private Integer blogId;

    @ManyToOne
    @JoinColumn(name = "CommentID", nullable = false)
    private Comment comment;

    @Column(name = "BlogTitle", nullable = false, length = 200)
    private String blogTitle;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "changeAt", nullable = false)
    private LocalDateTime changeAt;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;
}
