package com.lakshyabhardwaj.NoteTakerAI.entity;

import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

import jakarta.persistence.*;
import lombok.*;
@Data
@Entity(name = "note")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "notes")
public class Note {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String summary;

    private String createdDate;
    private String updatedDate;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}