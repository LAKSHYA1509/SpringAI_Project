package com.lakshyabhardwaj.NoteTakerAI.repository;

import com.lakshyabhardwaj.NoteTakerAI.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
