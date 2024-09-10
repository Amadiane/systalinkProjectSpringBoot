package com.systalinkProjectManagement.systalinkProjectManagement.Service;

import com.systalinkProjectManagement.systalinkProjectManagement.Dto.EmployeeDTO;
import com.systalinkProjectManagement.systalinkProjectManagement.Dto.LoginDTO;
import com.systalinkProjectManagement.systalinkProjectManagement.Response.LoginResponse;

import java.util.List;


public interface EmployeeService {

        String addEmployee(EmployeeDTO employeeDTO);

        LoginResponse loginEmployee(LoginDTO loginDTO);

        // Nouvelle méthode pour obtenir tous les employés
        List<EmployeeDTO> getAllEmployees();

        void updateEmployee(int id, EmployeeDTO employeeDTO);

        boolean deleteEmployee(int id); // Retourne un booléen indiquant si la suppression a réussi


}
