package com.todo.todo_app.Controller;

import com.todo.todo_app.Model.To_do;
import com.todo.todo_app.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class Controller {

    @Autowired
    private Service service;
    @PostMapping
    public ResponseEntity<To_do> saveTodo(@RequestBody To_do todo){
            return new ResponseEntity<>(service.saveTodo(todo), HttpStatus.CREATED);
    }

    @GetMapping
    public List<To_do> getAllTodo(){
        return service.getAlltodo();
    }
    @GetMapping("/{id}")
    public ResponseEntity<To_do> getTodoById(@PathVariable Long id){
        return new ResponseEntity<>(service.getTodoById(id),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<To_do> updateTodo(@PathVariable Long id, @RequestBody To_do todo){
        return new ResponseEntity<>(service.updateTodo(todo,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id){
        service.deleteTodo(id);
        return new ResponseEntity<>("Todo with id "+id+" deleted Successfully.",HttpStatus.OK);
    }

    // Output check using:  /todos?done=true
    @GetMapping("/todos")
    public List<To_do> getTodosByStatus(@RequestParam boolean done){
        return service.getTodosByStatus(done);
    }

}
