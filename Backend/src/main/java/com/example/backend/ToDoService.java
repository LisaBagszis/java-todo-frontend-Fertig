package com.example.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor
@Service
public class ToDoService {

    private final ToDoRepo toDoRepo;

    public List<ToDo> listToDos() {
        return toDoRepo.list();
    }

    public ToDo addToDo(ToDo toDo) {
        return toDoRepo.addToDo(toDo);
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
