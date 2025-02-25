package com.nikilshyamsunder.todo_restful.todo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepository {
    private List<Todo> todos = new ArrayList<>();

    List<Todo> findAll() {
        return todos;
    }

    @PostConstruct
    private void init() {
        todos.add(new Todo(1, "first run", LocalDateTime.now(),
                false, 3));
        todos.add(new Todo(2, "second run", LocalDateTime.now().plusDays(1),
                true, 6));
    }

    public Optional<Todo> findByID(int id) {
        return todos.stream().filter(todos -> todos.id() == id)
                .findFirst();
    }

    public void create(Todo t){
        todos.add(t);
    }

    public void update(Todo t, int id){
        Optional<Todo> curr = todos.stream().filter(todos -> todos.id() == id)
                .findFirst();
        curr.ifPresent(todo -> todos.remove(curr.get()));
        todos.add(t);
    }

    public void delete(int id){
        Optional<Todo> t = todos.stream().filter(todos -> todos.id() == id)
                .findFirst();
        t.ifPresent(todo -> todos.remove(todo));

    }
}
