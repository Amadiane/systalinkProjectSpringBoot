package com.systalinkProjectManagement.systalinkProjectManagement.EmployeeController;


import com.systalinkProjectManagement.systalinkProjectManagement.Dto.ProjectDTO;
import com.systalinkProjectManagement.systalinkProjectManagement.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(path = "/save")
    public String saveProject(@RequestBody ProjectDTO projectDTO)
    {
        String id = projectService.addProject(projectDTO);
        return id;
    }

    // Méthode pour récupérer tous les projets
    @GetMapping("/all")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProject(@PathVariable int id, @RequestBody ProjectDTO projectDTO) {
        try {
            projectService.updateProject(id, projectDTO);
            return ResponseEntity.ok("Project with ID " + id + " updated successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Project with ID " + id + " not found.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }


    //for delete project from database
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable int id) {
        // Appelle le service pour supprimer le projet
        boolean isDeleted = projectService.deleteProject(id);

        if (isDeleted) {
            // Renvoie une réponse 200 OK si l'employé a été supprimé
            return ResponseEntity.ok("Project with id " + id + " has been deleted successfully.");
        } else {
            // Renvoie une réponse 404 Not Found si l'employé n'existe pas
            return ResponseEntity.status(404).body("Project with id " + id + " not found.");
        }


    }



}





