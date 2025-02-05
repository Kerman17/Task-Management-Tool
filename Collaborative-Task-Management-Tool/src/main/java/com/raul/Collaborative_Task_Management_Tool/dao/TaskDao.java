package com.raul.Collaborative_Task_Management_Tool.dao;

import com.raul.Collaborative_Task_Management_Tool.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TaskDao {

    List<Task> findAllTasks();
    Optional<Task> findTaskById(Long id);
    Task saveTask(Task task);
    void deleteTask(Long id);
    List<Task> findByUserId(Long userId);

    void findByProjectId(Long projectId);



}
