package com.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@RequiredArgsConstructor
@Repository
public class ToDoRepo {
    private final List<ToDo> todos = new ArrayList<>();


    public List<ToDo> list() {
        return todos;
    }

    public ToDo addToDo(ToDo toDo) {
        ToDo todo = new ToDo(UUID.randomUUID().toString(), toDo.description(), toDo.status());
        todos.add(todo);
        return toDo;
    }

    public ToDo putToDo(String randomId, ToDo toDo) {
        deleteToDo(randomId);
        ToDo newToDo = new ToDo(randomId, toDo.description(), toDo.status());
        todos.add(newToDo);
        return newToDo;
    }

    public void deleteToDo(String randomId) {
        for (ToDo toDo : todos) {
            if (toDo.id().equals(randomId)) {
                todos.remove(toDo);
            return;
            }
        }

    }

    public ToDo get(String randomId) {
        for (ToDo toDo : todos) {
            if (toDo.id().equals(randomId)) {
                return toDo;
            }
        }
        return null;
    }
}
