package mum.edu.cs544.Service;

import java.util.List;

import mum.edu.cs544.domain.Address;
import mum.edu.cs544.domain.Beneficiary;
import mum.edu.cs544.domain.Project;
import mum.edu.cs544.domain.Task;
import mum.edu.cs544.domain.User;



public interface IService {
	void createUser(User user);
	void saveUserAddress(Address address);
	void createNewProject(Project project);
	void saveProjectTask(Task task);
	void createBeneficiary(Beneficiary beneficiary);
	Project getProjectByName(String name);
	void updateProject(Project project);
	List<Task> getTasksByResource(String str);
	void updateTask(Task t);
	List<User> getAllUsers();
	List<Project> getAllProjects();
	List<Task> getAllTasksByProjectId(int projectId);
	List<Project> getAllCompletedProjects();
	List<Project> getAllIncompletedProjects();
	List<Project> getProjectsByResource(String resources);
	List<Project> getProjectsByKeyword(String keyword);
	List<Project> getProjectsByLocation(String location);
	List<Project> getAllProjectsAndTaskHavingVolunteer();
	List<Beneficiary> getAllBeneficiariesOfProjectById(int projectId);
}
