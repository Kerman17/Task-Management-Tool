package com.raul.Collaborative_Task_Management_Tool.services;

import com.raul.Collaborative_Task_Management_Tool.domain.Task;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import com.raul.Collaborative_Task_Management_Tool.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " doesnt exist"));
    }



    public void addTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " doesnt exist"));


        taskRepository.deleteById(id);
    }

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
}
