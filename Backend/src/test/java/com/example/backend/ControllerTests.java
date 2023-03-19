package com.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;


import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@SpringBootTest
class ControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ToDoRepo toDoRepo;

    @Test
    @DirtiesContext
    void getToDos_shouldReturnEmptyListWhenListIsEmpty() throws Exception {


        mockMvc.perform(get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                []
                                 """));
    }

    @Test
    @DirtiesContext
    void ShouldReturnListWhenListIsFilled() throws Exception {
        ToDo todo = new ToDo("123", "test" ,Status.OPEN);
        toDoRepo.addToDo(todo);

        mockMvc.perform(get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                [
                                
                                    {
                                    "id": "123",
                                     "description": "test",
                                     "status": "OPEN"
                                    }
                                    ]

                        
                            
                                        """));
    }


    @Test
    void giveDetailsofToDo() {
    }

    @Test
    void addToDo() {
    }

    @Test
    void putToDo() {
    }

    @Test
    void deleteToDo() {
    }
}