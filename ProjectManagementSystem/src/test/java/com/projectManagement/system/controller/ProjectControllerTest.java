package com.projectManagement.system.controller;

import com.projectManagement.system.model.Project;
import com.projectManagement.system.service.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProjectControllerTest {

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private ProjectController projectController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProject() {
        Project project = new Project();
        project.setId(1L);
        when(projectService.createProject(any())).thenReturn(project);

        ResponseEntity<Project> response = projectController.createProject(project);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(project, response.getBody());
        verify(projectService, times(1)).createProject(any());
    }

    @Test
    void testGetAllProjects() {
        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project());
        when(projectService.getAllProjects()).thenReturn(projectList);

        ResponseEntity<List<Project>> response = projectController.getAllProjects();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(projectList, response.getBody());
        verify(projectService, times(1)).getAllProjects();
    }

    @Test
    void testGetProjectById() {
        Long projectId = 1L;
        Project project = new Project();
        project.setId(projectId);
        when(projectService.getProjectById(projectId)).thenReturn(project);

        ResponseEntity<Project> response = projectController.getProjectById(projectId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(project, response.getBody());
        verify(projectService, times(1)).getProjectById(projectId);
    }

    @Test
    void testUpdateProject() {
        Long projectId = 1L;
        Project project = new Project();
        project.setId(projectId);
        when(projectService.updateProject(eq(projectId), any())).thenReturn(project);

        ResponseEntity<Project> response = projectController.updateProject(projectId, project);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(project, response.getBody());
        verify(projectService, times(1)).updateProject(eq(projectId), any());
    }

    @Test
    void testDeleteProject() {
        Long projectId = 1L;
        ResponseEntity<Void> response = projectController.deleteProject(projectId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(projectService, times(1)).deleteProject(projectId);
    }
}

