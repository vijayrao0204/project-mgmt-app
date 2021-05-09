package com.bonhive.projectmgmtapp.services;

import com.bonhive.projectmgmtapp.domain.Project;
import com.bonhive.projectmgmtapp.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        return projectRepository.save(project);
    }
}