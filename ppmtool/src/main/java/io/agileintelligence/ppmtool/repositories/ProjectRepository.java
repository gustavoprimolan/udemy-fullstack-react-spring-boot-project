package io.agileintelligence.ppmtool.repositories;

import io.agileintelligence.ppmtool.domains.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByIdentifier(String identifier);

}
