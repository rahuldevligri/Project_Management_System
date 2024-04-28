package com.projectManagement.system.service;

import com.projectManagement.system.model.Project;
import com.projectManagement.system.repository.ProjectRepository;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        return projectOptional.orElse(null);
    }

    @Override
    public Project updateProject(Long id, Project project) {
        Optional<Project> existingProjectOptional = projectRepository.findById(id);
        if (existingProjectOptional.isPresent()) {
            project.setId(id);
            return projectRepository.save(project);
        }
        return null;
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
