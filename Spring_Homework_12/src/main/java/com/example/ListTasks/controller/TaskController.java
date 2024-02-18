package com.example.ListTasks.controller;

import com.example.ListTasks.model.Task;
import com.example.ListTasks.service.FileGateway;
import com.example.ListTasks.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final FileGateway fileGateway;

    @Autowired
    private final TaskService taskService;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        fileGateway.writeToFile(task.getTitleTask() + ".txt", task.toString());
        return taskService.add(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return taskService.findTasksByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateById(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.delete(id);
    }
}
