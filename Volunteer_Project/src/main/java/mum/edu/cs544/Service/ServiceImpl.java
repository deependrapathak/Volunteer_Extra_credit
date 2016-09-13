package mum.edu.cs544.Service;

import java.util.List;

import mum.edu.cs544.DAO.BeneficiaryDAO;
import mum.edu.cs544.DAO.IBeneficiaryDAO;
import mum.edu.cs544.DAO.IProjectDAO;
import mum.edu.cs544.DAO.ITaskDAO;
import mum.edu.cs544.DAO.IUserDAO;
import mum.edu.cs544.DAO.ProjectDAO;
import mum.edu.cs544.DAO.TaskDAO;
import mum.edu.cs544.DAO.UserDAO;
import mum.edu.cs544.domain.Address;
import mum.edu.cs544.domain.Beneficiary;
import mum.edu.cs544.domain.Project;
import mum.edu.cs544.domain.Task;
import mum.edu.cs544.domain.User;



public class ServiceImpl implements IService {
	IUserDAO userDAO = new UserDAO();
	IProjectDAO projectDAO = new ProjectDAO();	
	ITaskDAO taskDAO = new TaskDAO();
	IBeneficiaryDAO beneficiaryDAO = new BeneficiaryDAO();

	public void createUser(User user) {
		userDAO.create(user);
	}

	public void createNewProject(Project project) {
		projectDAO.createProject(project);
	}

	public void saveUserAddress(Address address) {
		userDAO.saveNewAddress(address);
	}

	public void saveProjectTask(Task task) {
		taskDAO.createTask(task);
	}

	public void createBeneficiary(Beneficiary beneficiary) {
		beneficiaryDAO.createBeneficiary(beneficiary);
	}

	public Project getProjectByName(String name) {
		return projectDAO.getProjectById(name);
	}

	public void updateProject(Project project) {
		projectDAO.updateProjectAssignedToUser(project);
		
	}

	public List<Task> getTasksByResource(String str) {
		return taskDAO.getTaskBySkill(str);
	}

	public void updateTask(Task t) {
		taskDAO.updateTask(t);
	}

	public List<User> getAllUsers() {
		return userDAO.getAllUser();
	}

	public List<Project> getAllProjects() {
		return projectDAO.getAllProjects();
	}

	public List<Task> getAllTasksByProjectId(int projectId) {
		return taskDAO.getAllTaskByProjectId(projectId);
	}

	public List<Project> getAllCompletedProjects() {
		return projectDAO.getAllCompletedProjects();
	}

	public List<Project> getAllIncompletedProjects() {
		return projectDAO.getAllIncompletedProjects();
	}

	public List<Project> getProjectsByResource(String resources) {
		return projectDAO.searchProjectByResource(resources);
	}

	public List<Project> getProjectsByKeyword(String keyword) {
		return projectDAO.searchProjectByKeyword(keyword);
	}

	public List<Project> getProjectsByLocation(String location) {
		return projectDAO.searchProjectByLocation(location);
	}

	public List<Project> getAllProjectsAndTaskHavingVolunteer() {
		return projectDAO.getAllProjectsHavingVolunteer();
	}

	public List<Beneficiary> getAllBeneficiariesOfProjectById(int projectId) {
		return beneficiaryDAO.getAllBeneficiariesByProjectId(projectId);
	}	
}
