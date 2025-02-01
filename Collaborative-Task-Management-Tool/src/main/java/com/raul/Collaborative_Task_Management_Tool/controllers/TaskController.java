package com.raul.Collaborative_Task_Management_Tool.controllers;

import com.raul.Collaborative_Task_Management_Tool.domain.Task;
import com.raul.Collaborative_Task_Management_Tool.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/user/{userId}")
    public Task addTaskToUser(@PathVariable Long userId,
                              @RequestBody Task task){

       return taskService.addTaskToUser(userId, task);
    }

    @PutMapping("{taskId}/user/{userId}")
    public void addTaskToUserByTaskId(@PathVariable Long userId,
                                      @PathVariable Long taskId){

         taskService.addTaskToUserByTaskId(userId, taskId);
    }



    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUser(@PathVariable Long userId){

        return taskService.getTasksByUser(userId);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping(path = "{taskId}")
    public Task getTaskById(@PathVariable Long taskId){
        return taskService.getTaskById(taskId);
    }

    @PostMapping
    public void addTask(@RequestBody Task task){
        taskService.addTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }

    @PutMapping(path = "{taskId}")
    public void updateTask(@PathVariable Long taskId,
                           @RequestParam(required = false) String description,
                           @RequestParam(required = false) String status,
                           @RequestParam(required = false) String priority,
                           @RequestParam(required = false) String assigned_to,
                           @RequestParam(required = false) Date due_date){


        taskService.updateTask(taskId,
                description,
                status,
                priority,
                assigned_to,
                due_date);

    }

}
