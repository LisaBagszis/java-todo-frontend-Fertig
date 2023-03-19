package com.example.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class ToDoService {

    private final ToDoRepo toDoRepo;

    public List<ToDo> listToDos() {
        return toDoRepo.list();
    }

    public ToDo addToDo(ToDo toDo) {
        String id = UUID.randomUUID().toString();
        ToDo todo = new ToDo(id, toDo.description(), toDo.status());
        return toDoRepo.addToDo(todo);
    }


    public ToDo changeToDo(String randomId, ToDo toDo) {
        return toDoRepo.putToDo(randomId, toDo);
    }

    public void deleteToDo(String randomId) {
        toDoRepo.deleteToDo(randomId);
    }

    public ToDo giveDetails(String randomId) {
        return toDoRepo.get(randomId);
    }
}
