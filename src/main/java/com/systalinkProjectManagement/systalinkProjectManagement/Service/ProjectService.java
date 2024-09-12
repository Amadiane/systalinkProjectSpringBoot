package com.systalinkProjectManagement.systalinkProjectManagement.Service;

import com.systalinkProjectManagement.systalinkProjectManagement.Dto.EmployeeDTO;
import com.systalinkProjectManagement.systalinkProjectManagement.Dto.LoginDTO;
import com.systalinkProjectManagement.systalinkProjectManagement.Dto.ProjectDTO;
import com.systalinkProjectManagement.systalinkProjectManagement.Response.LoginResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectService {

    String addProject(ProjectDTO projectDTO);

    // Nouvelle méthode pour obtenir tous les employés
    List<ProjectDTO> getAllProjects();

    void updateProject(int id, ProjectDTO projectDTO);

    boolean deleteEmployee(int id); // Retourne un booléen indiquant si la suppression a réussi

    @Transactional
    boolean deleteProject(int id);
}


