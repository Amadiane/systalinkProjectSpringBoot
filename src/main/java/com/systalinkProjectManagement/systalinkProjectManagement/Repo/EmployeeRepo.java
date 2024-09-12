package com.systalinkProjectManagement.systalinkProjectManagement.Repo;

import com.systalinkProjectManagement.systalinkProjectManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    // Méthode personnalisée pour trouver un employé par email
    Employee findByEmail(String email);
}




