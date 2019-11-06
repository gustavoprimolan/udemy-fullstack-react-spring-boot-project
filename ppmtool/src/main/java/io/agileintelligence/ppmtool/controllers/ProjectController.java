package io.agileintelligence.ppmtool.controllers;


import io.agileintelligence.ppmtool.domains.Project;
import io.agileintelligence.ppmtool.services.MapValidationErrorService;
import io.agileintelligence.ppmtool.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;
    private final MapValidationErrorService mapValidationErrorService;

    public ProjectController(ProjectService projectService, MapValidationErrorService mapValidationErrorService) {
        this.projectService = projectService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        //PEGA OS ERRORS DO @VALID
//        result.hasErrors()
        ResponseEntity errorMap = mapValidationErrorService.mapValidationService(result);
        if(errorMap != null) return errorMap;

        Project newProject = projectService.saveOrUpdate(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<?> getProjectByIdentifier(@PathVariable String identifier){

        Project project = projectService.findByIdentifier(identifier.toUpperCase());

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping
    public Iterable<Project> getAll() {
        return projectService.findAll();
    }


    @DeleteMapping("/{identifier}")
    public ResponseEntity<?> deleteByIdentifier(@PathVariable String identifier) {
        projectService.deleteByIdentifier(identifier.toUpperCase());
        return new ResponseEntity<>("Project with ID: '" + identifier + " was deleted", HttpStatus.OK);
    }

}
