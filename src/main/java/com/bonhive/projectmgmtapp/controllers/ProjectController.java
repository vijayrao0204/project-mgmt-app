package com.bonhive.projectmgmtapp.controllers;

import com.bonhive.projectmgmtapp.domain.Project;
import com.bonhive.projectmgmtapp.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@RequestBody Project project){
        projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProjects(){
        List<Project> projectsList = projectService.getAllProjects();
        return new ResponseEntity<List<Project>>(projectsList, HttpStatus.CREATED);
    }
    @GetMapping("/{projectCode}")
    public ResponseEntity<Project> getByProjectCode(@PathVariable String projectCode){
        Project project = projectService.findByProjectCode(projectCode);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }
    @DeleteMapping("/{projectCode}")
    public ResponseEntity<?> deleteByProjectCode(@PathVariable String projectCode){
        projectService.deleteByProjectCode(projectCode);
        return new ResponseEntity<String>("Project with code: '"+projectCode+"' was deleted", HttpStatus.OK);
    }


}