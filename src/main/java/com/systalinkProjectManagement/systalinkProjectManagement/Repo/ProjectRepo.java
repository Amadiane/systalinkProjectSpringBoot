package com.systalinkProjectManagement.systalinkProjectManagement.Repo;




import com.systalinkProjectManagement.systalinkProjectManagement.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@EnableJpaRepositories
@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {
    // Ajoutez ici des méthodes de requête personnalisées si nécessaire
}




