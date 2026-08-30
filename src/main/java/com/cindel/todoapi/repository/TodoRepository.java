package com.cindel.todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cindel.todoapi.model.ToDo;
import java.util.List;

public interface TodoRepository extends JpaRepository<ToDo, String> {
    List<ToDo> findByTitleContaining(String title);

    List<ToDo> findByDone(boolean done);

    List<ToDo> findByTitleAndDone(String title, boolean done);
}
