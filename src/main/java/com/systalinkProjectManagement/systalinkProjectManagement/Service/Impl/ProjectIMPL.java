package com.systalinkProjectManagement.systalinkProjectManagement.Service.Impl;

import com.systalinkProjectManagement.systalinkProjectManagement.Dto.ProjectDTO;
import com.systalinkProjectManagement.systalinkProjectManagement.Entity.Project;
import com.systalinkProjectManagement.systalinkProjectManagement.Repo.ProjectRepo;
import com.systalinkProjectManagement.systalinkProjectManagement.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProjectIMPL implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public String addProject(ProjectDTO projectDTO) {
        validateProjectDTO(projectDTO);

        Project project = new Project(
                projectDTO.getProjectid(),
                projectDTO.getName(),
                projectDTO.getClient(),
                projectDTO.getDescription(),
                projectDTO.getWorkload()
        );

        projectRepo.save(project);
        return project.getName();
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepo.findAll();
        return projects.stream()
                .map(this::convertToProjectDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateProject(int id, ProjectDTO projectDTO) {
        validateProjectDTO(projectDTO);

        Project project = projectRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project with ID " + id + " not found."));

        project.setName(projectDTO.getName());
        project.setClient(projectDTO.getClient());
        project.setDescription(projectDTO.getDescription());
        project.setWorkload(projectDTO.getWorkload());

        projectRepo.save(project);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return false;
    }


    @Override
    @Transactional
    public boolean deleteProject(int id) {
        if (projectRepo.existsById(id)) { // Vérifier si l'entité existe
            projectRepo.deleteById(id);   // Supprimer l'entité par son ID
            return true;
        }
        return false;
    }

    private void validateProjectDTO(ProjectDTO projectDTO) {
        if (projectDTO.getName() == null || projectDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("Project name is required.");
        }
        if (projectDTO.getClient() == null || projectDTO.getClient().isEmpty()) {
            throw new IllegalArgumentException("Client name is required.");
        }
        if (projectDTO.getDescription() == null || projectDTO.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Description is required.");
        }
    }

    private ProjectDTO convertToProjectDTO(Project project) {
        return new ProjectDTO(
                project.getProjectid(),
                project.getName(),
                project.getClient(),
                project.getDescription(),
                project.getWorkload()
        );
    }
}
