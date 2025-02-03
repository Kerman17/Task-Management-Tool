package com.raul.Collaborative_Task_Management_Tool.services;

import com.raul.Collaborative_Task_Management_Tool.domain.Project;
import com.raul.Collaborative_Task_Management_Tool.domain.Task;
import com.raul.Collaborative_Task_Management_Tool.domain.User;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import com.raul.Collaborative_Task_Management_Tool.repositories.ProjectRepository;
import com.raul.Collaborative_Task_Management_Tool.repositories.TaskRepository;
import com.raul.Collaborative_Task_Management_Tool.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    private final ProjectRepository projectRepository;

    // CONSTRUCTOR

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    // ---- ENDPOINTS FOR USER - TASK RELATIONSHIP
    // ADDS NEW TASK TO USER, TASK BODY NEEDS TO BE PROVIDED AS JSON
    public Task addTaskToUser(Long userId, Task task){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " doesnt exist"));

        task.setUser(user);

        task.setAssigned_to(user.getName());

        return taskRepository.save(task);
    }

    // ADDS EXISTING TASK TO A EXISTING USER USING TASK_ID AND USER_ID
    public void addTaskToUserByTaskId(Long userId, Long taskId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " doesnt exist"));

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + taskId + " doesnt exist"));

        task.setUser(user);

        task.setAssigned_to(user.getName());

        taskRepository.save(task);
    }

    // GETS ALL TASKS OF THE USER BY USER ID
    public List<Task> getTasksByUser(Long userId){

        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " doesnt exist"));

        return taskRepository.findByUserId(userId);
    }

    // MOVE TASK FROM USER1 TO USER2

    @Transactional
    public void moveTaskFromUser1ToUser2(Long taskId, Long userid2){

        User user2 = userRepository.findById(userid2)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userid2 + " doesnt exist"));

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + taskId + " doesnt exist"));

        task.setUser(user2);

    }

    // ---- ENDPOINTS FOR USER - TASK RELATIONSHIP

    // -----------------------------------------------------------------------

    // ---- ENDPOINTS FOR PROJECT - TASK RELATIONSHIP

    public void addTaskToProject(Task task, Long projectId){
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project with id " + projectId + " doesnt exist"));

        task.setProject(project);

        taskRepository.save(task);
    }

    public void addTaskToProjectByTaskId(Long taskId, Long projectId){

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + taskId + " doesnt exist"));

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project with id " + projectId + " doesnt exist"));

        task.setProject(project);

        taskRepository.save(task);

    }

    public List<Task> getTasksByProjectId(Long projectId){
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project with id " + projectId + " doesnt exist"));

        return taskRepository.findByProjectId(projectId);
    }



    // ---- ENDPOINTS FOR TASK
    // GETS ALL EXISTING TASKS
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }


    // GETS TASK BY ID
    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " doesnt exist"));
    }


    // ADDS A NEW TASK
    public void addTask(Task task){
        taskRepository.save(task);
    }

    // DELETES A TASK IF EXISTS
    public void deleteTask(Long id){
        taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " doesnt exist"));


        taskRepository.deleteById(id);
    }

    // UPDATES A TASK IF EXISTS AND IF PARAMETERS ARE VALID
    @Transactional
    public void updateTask(Long id,
                           String description,
                           String status,
                           String priority,
                           String assigned_to,
                           Date due_date){

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " doesnt exist"));

        task.setDescription(description);
        task.setStatus(status);
        task.setPriority(priority);
        task.setAssigned_to(assigned_to);
        task.setDue_date(due_date);
    }

    // ---- ENDPOINTS FOR TASK


}
