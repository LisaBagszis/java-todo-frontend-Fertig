package com.example.backend;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class Controller {


    private final ToDoService service;


    @GetMapping("/todo")
    public List<ToDo> listToDos() {
        return service.listToDos();
    }

    @GetMapping("/todo/{randomId}")
    public ToDo giveDetailsofToDo(@PathVariable String randomId) {
        return service.giveDetails(randomId);
    }

    @PostMapping("/todo")
    public ResponseEntity<ToDo> addToDo(@RequestBody ToDo toDo) {
        ToDo newToDo = service.addToDo(toDo);
        return ResponseEntity.ok(newToDo);
    }


    @PutMapping("/todo/{randomId}")
    public ToDo putToDo(@PathVariable String randomId, @RequestBody ToDo toDo) {
        return service.changeToDo(randomId, toDo);
    }

    @DeleteMapping("/todo/{randomId}")
    public ResponseEntity deleteToDo(@PathVariable String randomId) {
        service.deleteToDo(randomId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
