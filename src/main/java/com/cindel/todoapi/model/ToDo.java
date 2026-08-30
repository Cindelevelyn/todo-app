package com.cindel.todoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class ToDo {
    @Column
    @Id
    private String id;
    @Column
    private String title;
    @Column
    private boolean done;

    // public ToDo(String title, boolean done) {
    // this.title = title;
    // this.done = done;
    // }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ToDo [title=" + title + ", done=" + done + "]";
    }
}
