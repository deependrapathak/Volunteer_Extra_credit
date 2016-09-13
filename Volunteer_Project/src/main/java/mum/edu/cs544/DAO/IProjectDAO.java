package mum.edu.cs544.DAO;

import java.util.List;

import mum.edu.cs544.domain.Project;
public interface IProjectDAO {
	void createProject(Project project);
	void updateProjectAssignedToUser(Project project);
	List<Project> getAllProjects();
	List<Project> getAllCompletedProjects();
	List<Project> getAllIncompletedProjects();
	List<Project> searchProjectByResource(String resource);
	List<Project> searchProjectByKeyword(String keyword);
	List<Project> searchProjectByLocation(String location);
	List<Project> getAllProjectsHavingVolunteer();
	Project getProjectById(String projectId);
}
