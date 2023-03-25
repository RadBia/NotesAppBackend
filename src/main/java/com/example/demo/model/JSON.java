package com.example.demo.model;

import java.sql.Date;

public class JSON {
    private int user_id;
    private String title;
    private String content;
    private boolean veryimportant;
    private boolean important;
    private boolean shopping;
    private boolean travel;
    private boolean work;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
