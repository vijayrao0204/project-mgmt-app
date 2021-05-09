package com.bonhive.projectmgmtapp.repositories;

import com.bonhive.projectmgmtapp.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);
}
