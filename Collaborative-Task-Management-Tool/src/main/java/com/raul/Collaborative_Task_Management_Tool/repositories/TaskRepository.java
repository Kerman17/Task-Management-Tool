package com.raul.Collaborative_Task_Management_Tool.repositories;

import com.raul.Collaborative_Task_Management_Tool.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
        List<Task> findByUserId(Long userId);

        List<Task> findByProjectId(Long projectId);
}
