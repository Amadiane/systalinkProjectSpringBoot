package com.systalinkProjectManagement.systalinkProjectManagement.EmployeeController;

import com.systalinkProjectManagement.systalinkProjectManagement.Dto.EmployeeDTO;
import com.systalinkProjectManagement.systalinkProjectManagement.Dto.LoginDTO;
import com.systalinkProjectManagement.systalinkProjectManagement.Service.EmployeeService;
import com.systalinkProjectManagement.systalinkProjectManagement.Response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }

    // Méthode pour récupérer tous les employés
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }


    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO) {
        try {
            // Appel du service pour la connexion de l'employé
            LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);

            // Si tout est OK, retour de la réponse avec un statut HTTP 200
            return ResponseEntity.ok(loginResponse);
        } catch (IllegalArgumentException e) {
            // Gérer les exceptions pour les données incorrectes (par exemple, email ou mot de passe manquant)
            return ResponseEntity.badRequest().body("Invalid login details: " + e.getMessage());
        } catch (Exception e) {
            // Gérer les autres exceptions (par exemple, problème côté serveur)
            return ResponseEntity.status(500).body("An error occurred while processing the login: " + e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        try {
            employeeService.updateEmployee(id, employeeDTO);
            return ResponseEntity.ok("Employee with ID " + id + " updated successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body("Employee with ID " + id + " not found.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }

    //for delete employee from database
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        // Appelle le service pour supprimer l'employé
        boolean isDeleted = employeeService.deleteEmployee(id);

        if (isDeleted) {
            // Renvoie une réponse 200 OK si l'employé a été supprimé
            return ResponseEntity.ok("Employee with id " + id + " has been deleted successfully.");
        } else {
            // Renvoie une réponse 404 Not Found si l'employé n'existe pas
            return ResponseEntity.status(404).body("Employee with id " + id + " not found.");
        }


}
}


