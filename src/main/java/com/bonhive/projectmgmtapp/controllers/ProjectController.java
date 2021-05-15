package com.bonhive.projectmgmtapp.controllers;

import com.bonhive.projectmgmtapp.domain.Project;
import com.bonhive.projectmgmtapp.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@RequestBody @Valid Project project, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            Map<String,String> errorMap = new HashMap<>();
            for(FieldError fieldError:fieldErrors){
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProjects(){
        List<Project> projectsList = projectService.getAllProjects();
        return new ResponseEntity<List<Project>>(projectsList, HttpStatus.OK);
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