package com.raul.Collaborative_Task_Management_Tool.dao;

import com.raul.Collaborative_Task_Management_Tool.domain.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectDao {
    List<Project> getAllProjects();
    Optional<Project> getProjectById(Long id);
    void addProject(Project project);
    void deleteProjectById(Long id);
    void updateProject(Long id,
                       String name,
                       String description);
    void saveProject(Project project);
}
