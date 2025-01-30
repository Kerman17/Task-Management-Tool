package com.raul.Collaborative_Task_Management_Tool.controllers;

import com.raul.Collaborative_Task_Management_Tool.domain.Project;
import com.raul.Collaborative_Task_Management_Tool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(path = {"{projectId}"})
    public Project getProjectById(@PathVariable Long projectId){
        return projectService.getProjectById(projectId);
    }

    @GetMapping
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @PostMapping
    public void addNewProject(@RequestBody Project project){
        projectService.addProject(project);
    }

    @DeleteMapping(path = "{projectId}")
    public void deleteProjectById(@PathVariable Long projectId){
        projectService.deleteProjectById(projectId);
    }

    @PutMapping(path = "{projectId}")
    public void updateProject(@PathVariable Long projectId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String description){

        projectService.updateProject(projectId, name, description);

    }




}
