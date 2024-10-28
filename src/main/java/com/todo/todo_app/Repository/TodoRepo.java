package com.todo.todo_app.Repository;

import com.todo.todo_app.Model.To_do;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<To_do, Long> {
    List<To_do> findByDone(boolean done);
}
