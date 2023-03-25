package com.example.demo.controller;

import com.example.demo.model.JSON;
import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
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

    private ResponseEntity<Note> getNoteResponseEntity(Note note, String title, String content, boolean veryimportant, boolean important, boolean shopping, boolean travel, boolean work, @RequestBody JSON request_) {
        note.setTitle(title);
        note.setContent(content);
        note.setVeryimportant(veryimportant);
        note.setImportant(important);
        note.setShopping(shopping);
        note.setTravel(travel);
        note.setWork(work);
        return new ResponseEntity<>(noteRepository.save(note), HttpStatus.OK);
    }

    @PatchMapping("/{noteId}")
    public ResponseEntity<Note> updateNote(@PathVariable("noteId") long id, @RequestBody JSON request_) {
        System.out.println(id);
        Note note = noteRepository.findById(id).orElseThrow();
        return getNoteResponseEntity(note, request_.getTitle(), request_.getContent(), request_.isVeryimportant(), request_.isImportant(), request_.isShopping(), request_.isTravel(), request_.isWork(), request_);
    }

    @PostMapping("/create")
    public ResponseEntity<Note> createNote(@RequestBody JSON request_) {
        Note note = new Note();
        System.out.println(request_.getUser_id());
        note.setUser(userRepository.findById(request_.getUser_id()));
        return getNoteResponseEntity(note, request_.getTitle(), request_.getContent(), request_.isVeryimportant(), request_.isImportant(), request_.isShopping(), request_.isTravel(), request_.isWork(), request_);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Note>> getAllNotes(@PathVariable(value = "id") int id) {
        List<Note> notes = noteRepository.findByUser_Id(id);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }
}
