package com.example.demo.repository;

import com.example.demo.model.Note;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUser_Id(int user_id);
}