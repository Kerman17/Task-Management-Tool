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


    // POST A NEW TASK TO USER WITH USER ID
    // ---- ENDPOINTS FOR USER - TASK RELATIONSHIP
    @PostMapping("/user/{userId}")
    public Task addTaskToUser(@PathVariable Long userId,
                              @RequestBody Task task){

       return taskService.addTaskToUser(userId, task);
    }

    // ADD EXISTING TASK TO A USER BY USER ID
    @PutMapping("{taskId}/user/{userId}")
    public void addTaskToUserByTaskId(@PathVariable Long userId,
                                      @PathVariable Long taskId){

         taskService.addTaskToUserByTaskId(userId, taskId);
    }

    // GET TASKS OF A SPECIFIC USER
    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUser(@PathVariable Long userId){

        return taskService.getTasksByUser(userId);
    }

    // MOVE TASK TO USER2 WITH USERID
    @PutMapping(path = "{taskId}/assign/{user2Id}")
    public void moveTaskFromUser1ToUser2(@PathVariable Long taskId,
                                         @PathVariable Long user2Id){

        taskService.moveTaskFromUser1ToUser2(taskId, user2Id);
    }

    // ---- ENDPOINTS FOR USER - TASK RELATIONSHIP

    // -----------------------------------------------------

    // ENDPOINTS FOR PROJECT - TASK RELATIONSHIP

    @PostMapping(path = "/project/{projectId}")
    public void addTaskToProject(@RequestBody Task task,
                                 @PathVariable Long projectId){

        taskService.addTaskToProject(task, projectId);
    }

    @PutMapping("{taskId}/project/{projectId}")
    public void addTaskToProjectByTaskId(@PathVariable Long taskId,
                                         @PathVariable Long projectId){

        taskService.addTaskToProjectByTaskId(taskId, projectId);

    }

    @GetMapping("/project/{projectId}")
    public void getTasksByProjectId(@PathVariable Long projectId){
        taskService.getTasksByProjectId(projectId);
    }


    // ENDPOINTS FOR PROJECT - TASK RELATIONSHIP


    // GET ALL TASKS
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    // GET TASK BY ID
    @GetMapping(path = "{taskId}")
    public Task getTaskById(@PathVariable Long taskId){
        return taskService.getTaskById(taskId);
    }


    // POST A NEW TASK
    @PostMapping
    public void addTask(@RequestBody Task task){
        taskService.addTask(task);
    }


    // DELETE EXISTING TASK
    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }


    // UPDATE A EXISTING TASK
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
