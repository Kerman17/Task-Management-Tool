package com.raul.Collaborative_Task_Management_Tool.services;

import com.raul.Collaborative_Task_Management_Tool.domain.Project;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import com.raul.Collaborative_Task_Management_Tool.repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

//    private Long id;
//    private String name;
//    private String description;
//    private String created_by;
//    private Date created_at;

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Project getProjectById(Long projectId){

        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project with id: " + projectId + " does not exist"));
    }

    public void addProject(Project project){
        projectRepository.save(project);
    }

    public void deleteProjectById(Long id){
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The Project with id " + id + " does not exist"));

        projectRepository.deleteById(id);

    }

    @Transactional
    public void updateProject(Long id,
                              String name,
                              String description){

        Project project = projectRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Project with id " + id + " does not exist"));

        if(name!=null && name.length()>0 &&
           description!=null && description.length()>0){
            project.setName(name);
            project.setDescription(description);
        }

    }





}
