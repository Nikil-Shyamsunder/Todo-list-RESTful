package com.nikilshyamsunder.todo_restful.todo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos") // request mapping reduces code duplication
public class TodoController {
    private final TodoRepository todoRepository;

    // provided by Spring thanks to @Repository annotation
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @GetMapping("")
    List<Todo> findAll() {
        return todoRepository.findAll();
    }

    // {dynamic path variable}
    @GetMapping("/{id}")
    Todo findById(@PathVariable Integer id){
        Optional<Todo> opt = todoRepository.findByID(id);
        if (opt.isPresent()){
            return opt.get();
        }
        throw new TodoNotFoundException();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Todo todo){
        todoRepository.create(todo);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Todo todo, @PathVariable Integer id){
        todoRepository.update(todo, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        todoRepository.delete(id);
    }

}
