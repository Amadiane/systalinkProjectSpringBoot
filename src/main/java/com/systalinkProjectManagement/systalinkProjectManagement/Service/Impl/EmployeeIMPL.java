package com.systalinkProjectManagement.systalinkProjectManagement.Service.Impl;

import com.systalinkProjectManagement.systalinkProjectManagement.Dto.EmployeeDTO;
import com.systalinkProjectManagement.systalinkProjectManagement.Dto.LoginDTO;
import com.systalinkProjectManagement.systalinkProjectManagement.Entity.Employee;
import com.systalinkProjectManagement.systalinkProjectManagement.Repo.EmployeeRepo;
import com.systalinkProjectManagement.systalinkProjectManagement.Response.LoginResponse;
import com.systalinkProjectManagement.systalinkProjectManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        // Valider tous les champs nécessaires
        if (employeeDTO.getCin() == null) {
            throw new IllegalArgumentException("CIN is required");
        }
        if (employeeDTO.getEmployeename() == null || employeeDTO.getEmployeename().isEmpty()) {
            throw new IllegalArgumentException("Employee name is required");
        }
        if (employeeDTO.getEmail() == null || employeeDTO.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        // Créez et enregistrez l'employé
        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getSurname(),
                employeeDTO.getCin(),
                employeeDTO.getBirthdate(),
                employeeDTO.getDiplomayear(),
                employeeDTO.getJoinyear(),
                employeeDTO.getLeavebalance(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())
        );

        employeeRepo.save(employee);

        return employee.getEmployeename();
    }





    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        Employee employee = employeeRepo.findByEmail(loginDTO.getEmail());

        if (employee != null) {
            // Vérifiez si le mot de passe fourni correspond au mot de passe encodé
            boolean isPwdRight = passwordEncoder.matches(loginDTO.getPassword(), employee.getPassword());

            if (isPwdRight) {
                return new LoginResponse("Login Success", true);
            } else {
                return new LoginResponse("Password does not match", false);
            }
        } else {
            return new LoginResponse("Email does not exist", false);
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        // Récupérer tous les employés et les convertir en EmployeeDTO
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream()
                .map(employee -> new EmployeeDTO(
                        employee.getEmployeeid(),
                        employee.getEmployeename(),
                        employee.getSurname(),
                        employee.getCin(),
                        employee.getBirthdate(),
                        employee.getDiplomayear(),
                        employee.getJoinyear(),
                        employee.getLeavebalance(),
                        employee.getEmail(),
                        employee.getPassword()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void updateEmployee(int id, EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);

        if (!employeeOptional.isPresent()) {
            throw new IllegalArgumentException("Employee with ID " + id + " not found.");
        }

        Employee employee = employeeOptional.get();
        employee.setEmployeename(employeeDTO.getEmployeename());
        employee.setSurname(employeeDTO.getSurname());
        employee.setCin(employeeDTO.getCin());
        employee.setBirthdate(employeeDTO.getBirthdate());
        employee.setDiplomayear(employeeDTO.getDiplomayear());
        employee.setJoinyear(employeeDTO.getJoinyear());
        employee.setLeavebalance(employeeDTO.getLeavebalance());
        employee.setEmail(employeeDTO.getEmail());

        if (employeeDTO.getPassword() != null && !employeeDTO.getPassword().isEmpty()) {
            employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
        }

        employeeRepo.save(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        // Vérifie si l'employé existe par son ID
        if (employeeRepo.existsById(id)) {
            // Supprime l'employé si trouvé
            employeeRepo.deleteById(id);
            return true; // Renvoie 'true' si l'employé a été supprimé
        } else {
            return false; // Renvoie 'false' si l'employé n'existe pas
        }
    }

}