package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Optional;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @Column(name="title")
    private String title;

    @Size(min = 0, max = 1000)
    @Column(name="content", length = 1000)
    private String content;

    @Column(name="veryimportant")
    private boolean veryimportant;

    @Column(name="important")
    private boolean important;

    @Column(name="shopping")
    private boolean shopping;

    @Column(name="travel")
    private boolean travel;

    @Column(name="work")
    private boolean work;

    public Note(User user, String title, String content, boolean veryimportant, boolean important, boolean shopping, boolean travel, boolean work) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.veryimportant = veryimportant;
        this.important = important;
        this.shopping = shopping;
        this.travel = travel;
        this.work = work;
    }

    public Note() {

    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isVeryimportant() {
        return veryimportant;
    }

    public void setVeryimportant(boolean veryimportant) {
        this.veryimportant = veryimportant;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public boolean isShopping() {
        return shopping;
    }

    public void setShopping(boolean shopping) {
        this.shopping = shopping;
    }

    public boolean isTravel() {
        return travel;
    }

    public void setTravel(boolean travel) {
        this.travel = travel;
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }
}