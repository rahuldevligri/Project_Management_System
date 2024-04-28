// ProjectRepository.java
package com.projectManagement.system.repository;

import com.projectManagement.system.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
