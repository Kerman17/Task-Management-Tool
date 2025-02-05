package com.raul.Collaborative_Task_Management_Tool.dao.impl;

import com.raul.Collaborative_Task_Management_Tool.dao.TaskDao;
import com.raul.Collaborative_Task_Management_Tool.domain.Project;
import com.raul.Collaborative_Task_Management_Tool.domain.Task;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import com.raul.Collaborative_Task_Management_Tool.repositories.ProjectRepository;
import com.raul.Collaborative_Task_Management_Tool.repositories.TaskRepository;
import com.raul.Collaborative_Task_Management_Tool.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskDaoImpl implements TaskDao {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public TaskDaoImpl(TaskRepository taskRepository, UserRepository userRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findByUserId(Long userId){

        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " doesnt exist"));

        return taskRepository.findByUserId(userId);
    }

    @Override
    public void findByProjectId(Long projectId){
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project with id " + projectId + " doesnt exist"));

        taskRepository.findByProjectId(projectId);
    }
}
