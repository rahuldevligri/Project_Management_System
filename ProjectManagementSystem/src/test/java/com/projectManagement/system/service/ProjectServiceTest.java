package com.projectManagement.system.service;

import com.projectManagement.system.model.Project;
import com.projectManagement.system.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProject() {
        Project project = new Project();
        when(projectRepository.save(any())).thenReturn(project);

        Project createdProject = projectService.createProject(project);

        assertEquals(project, createdProject);
        verify(projectRepository, times(1)).save(any());
    }

    @Test
    void testGetAllProjects() {
        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project());
        when(projectRepository.findAll()).thenReturn(projectList);

        List<Project> retrievedProjects = projectService.getAllProjects();

        assertEquals(projectList, retrievedProjects);
        verify(projectRepository, times(1)).findAll();
    }

    @Test
    void testGetProjectById() {
        Long projectId = 1L;
        Project project = new Project();
        project.setId(projectId);
        when(projectRepository.findById(projectId)).thenReturn(Optional.of(project));

        Project retrievedProject = projectService.getProjectById(projectId);

        assertEquals(project, retrievedProject);
        verify(projectRepository, times(1)).findById(projectId);
    }

    @Test
    void testUpdateProject() {
        Long projectId = 1L;
        Project project = new Project();
        project.setId(projectId);
        when(projectRepository.findById(projectId)).thenReturn(Optional.of(project));
        when(projectRepository.save(any())).thenReturn(project);

        Project updatedProject = projectService.updateProject(projectId, project);

        assertEquals(project, updatedProject);
        verify(projectRepository, times(1)).findById(projectId);
        verify(projectRepository, times(1)).save(any());
    }

    @Test
    void testDeleteProject() {
        Long projectId = 1L;
        projectService.deleteProject(projectId);

        verify(projectRepository, times(1)).deleteById(projectId);
    }
}

