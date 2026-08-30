package com.cindel.todoapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cindel.todoapi.model.ToDo;
import com.cindel.todoapi.repository.TodoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    public ToDo create(@RequestBody ToDo todo) {
        String id = UUID.randomUUID().toString();
        todo.setId(id);
        todoRepository.save(todo);
        return todo;
    }

    @GetMapping("/{id}")
    public Optional<ToDo> getById(@PathVariable("id") String id) {
        Optional<ToDo> todo = todoRepository.findById(id);
        return todo;
    }

    @GetMapping
    public List<ToDo> getAll() {
        List<ToDo> todos = todoRepository.findAll();
        return todos;
    }

    @GetMapping("/search")
    public List<ToDo> search(@RequestParam("title") String title) {
        // if (title != null && done != null) {
        // return todoRepository.findByTitleAndDone(title, done);
        // }

        if (title != null) {
            return todoRepository.findByTitleContaining(title);
        }

        // if (done != null) {
        // return todoRepository.findByDone(done);
        // }

        return List.of();

    }

    @PutMapping("/{id}")
    public ToDo uptade(@PathVariable("id") String id, @RequestBody ToDo todo) {
        boolean existsTodo = todoRepository.existsById(id);
        if (!existsTodo)
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "ToDo não encontrado");

        todo.setId(id);
        return todoRepository.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id) {
        todoRepository.deleteById(id);
    }

}
