package com.raul.Collaborative_Task_Management_Tool.services;

import com.raul.Collaborative_Task_Management_Tool.dao.TaskDao;
import com.raul.Collaborative_Task_Management_Tool.dao.UserDao;
import com.raul.Collaborative_Task_Management_Tool.domain.Project;
import com.raul.Collaborative_Task_Management_Tool.domain.Task;
import com.raul.Collaborative_Task_Management_Tool.domain.User;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import com.raul.Collaborative_Task_Management_Tool.repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    private final TaskDao taskDao;

    private final UserDao userDao;

    private final ProjectRepository projectRepository;

    // CONSTRUCTOR

    public TaskService(TaskDao taskDao, UserDao userDao, ProjectRepository projectRepository) {
        this.taskDao = taskDao;
        this.userDao = userDao;
        this.projectRepository = projectRepository;
    }


    // ---- ENDPOINTS FOR USER - TASK RELATIONSHIP
    // ADDS NEW TASK TO USER, TASK BODY NEEDS TO BE PROVIDED AS JSON
    public Task addTaskToUser(Long userId, Task task){

        User user = userDao.findUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " doesnt exist"));

        task.setUser(user);

        task.setAssigned_to(user.getName());

        return taskDao.saveTask(task);
    }

    // ADDS EXISTING TASK TO A EXISTING USER USING TASK_ID AND USER_ID
    public void addTaskToUserByTaskId(Long userId, Long taskId){
        User user = userDao.findUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " doesnt exist"));

        Task task = taskDao.findTaskById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + taskId + " doesnt exist"));

        task.setUser(user);

        task.setAssigned_to(user.getName());

        taskDao.saveTask(task);
    }

    // GETS ALL TASKS OF THE USER BY USER ID
    public List<Task> getTasksByUser(Long userId){

        userDao.findUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " doesnt exist"));

        return taskDao.findByUserId(userId);
    }

    // MOVE TASK FROM USER1 TO USER2

    @Transactional
    public void moveTaskFromUser1ToUser2(Long taskId, Long userid2){

        User user2 = userDao.findUserById(userid2)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userid2 + " doesnt exist"));

        Task task = taskDao.findTaskById(taskId)
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

        taskDao.saveTask(task);
    }

    public void addTaskToProjectByTaskId(Long taskId, Long projectId){

        Task task = taskDao.findTaskById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + taskId + " doesnt exist"));

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project with id " + projectId + " doesnt exist"));

        task.setProject(project);

        taskDao.saveTask(task);

    }

    public void getTasksByProjectId(Long projectId){
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project with id " + projectId + " doesnt exist"));

        taskDao.findByProjectId(projectId);
    }

    // ---- ENDPOINTS FOR TASK
    // GETS ALL EXISTING TASKS
    public List<Task> getAllTasks(){
        return taskDao.findAllTasks();
    }


    // GETS TASK BY ID
    public Task getTaskById(Long id){
        return taskDao.findTaskById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " doesnt exist"));
    }


    // ADDS A NEW TASK
    public void addTask(Task task){
        taskDao.saveTask(task);
    }

    // DELETES A TASK IF EXISTS
    public void deleteTask(Long id){
        taskDao.findTaskById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " doesnt exist"));


        taskDao.deleteTask(id);
    }

    // UPDATES A TASK IF EXISTS AND IF PARAMETERS ARE VALID
    @Transactional
    public void updateTask(Long id,
                           String description,
                           String status,
                           String priority,
                           String assigned_to,
                           Date due_date){

        Task task = taskDao.findTaskById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " doesnt exist"));

        task.setDescription(description);
        task.setStatus(status);
        task.setPriority(priority);
        task.setAssigned_to(assigned_to);
        task.setDue_date(due_date);

        taskDao.saveTask(task);
    }

    // ---- ENDPOINTS FOR TASK


}
