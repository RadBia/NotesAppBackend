package com.example.demo.controller;

import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;


// @CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/{noteId}")
    public ResponseEntity<Note> getNote(@PathVariable(value = "noteId") Long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow();
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<?> deleteNote(@PathVariable("noteId") long id) {
        LinkedHashMap<String, String> map_res = new LinkedHashMap<>();
        map_res.put("msg", "Usunięto"); // deleted msg
        noteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
