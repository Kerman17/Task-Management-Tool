package com.raul.Collaborative_Task_Management_Tool.dao.impl;

import com.raul.Collaborative_Task_Management_Tool.dao.ProjectDao;
import com.raul.Collaborative_Task_Management_Tool.domain.Project;
import com.raul.Collaborative_Task_Management_Tool.repositories.ProjectRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    private final ProjectRepository projectRepository;

    public ProjectDaoImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public void addProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void updateProject(Long id, String name, String description) {
        
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }
}
