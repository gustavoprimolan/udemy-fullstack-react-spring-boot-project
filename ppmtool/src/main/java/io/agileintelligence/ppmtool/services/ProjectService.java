package io.agileintelligence.ppmtool.services;

import io.agileintelligence.ppmtool.domains.Project;
import io.agileintelligence.ppmtool.exceptions.ProjectIdException;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveOrUpdate(Project project){
        try{
            project.setIdentifier(project.getIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch(Exception e){
            throw new ProjectIdException("Project ID '" + project.getIdentifier().toUpperCase() + "' already exists");
        }
    }

    public Project findByIdentifier(String identifier) {
        Project project = projectRepository.findByIdentifier(identifier);

        if(Objects.isNull(project)){
            throw new ProjectIdException("Project ID '" + identifier + "' does not exist");
        }

        return project;
    }

    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    public void deleteByIdentifier(String identifier) {
        Project project = projectRepository.findByIdentifier(identifier);

        if(Objects.isNull(project)){
            throw new ProjectIdException("Cannot delete Project with ID '" + identifier + "'. This project does not exist.");
        }

        projectRepository.delete(project);
    }

}
