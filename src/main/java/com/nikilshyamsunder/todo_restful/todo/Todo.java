package com.nikilshyamsunder.todo_restful.todo;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Todo(
        Integer id,

        @NotEmpty
        String title,
        LocalDateTime startedOn,
        Boolean completed,
        Integer priority) {
}
