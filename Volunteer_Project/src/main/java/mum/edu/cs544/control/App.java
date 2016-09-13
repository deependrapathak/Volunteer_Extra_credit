package mum.edu.cs544.control;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mum.edu.cs544.Service.IService;
import mum.edu.cs544.Service.ServiceImpl;
import mum.edu.cs544.domain.Address;
import mum.edu.cs544.domain.Beneficiary;
import mum.edu.cs544.domain.Project;
import mum.edu.cs544.domain.Role;
import mum.edu.cs544.domain.Task;
import mum.edu.cs544.domain.User;

public class App {

	public static void main(String[] args) throws IOException {
	IService service=new ServiceImpl();
	Path path=FileSystems.getDefault().getPath("smiths.jpg");
	User u = new User();
	//Create address
	Address address = new Address();
	address.setStreet("1000N 4th ST");
	address.setCity("FairField");
	address.setState("IA");
	address.setZip("52557");
	//Create user
	u.setName("Deependra Raj Pathak");
	u.setEmail("deep@gmail.com");
	u.setPassword("admin123");
	u.setRole(Role.VOLUNTEER);
	u.setAddress(address);
	
	//create project
	Project p = new Project();
	p.setProjectname("Volunteering application");
	p.setProjectStatus("incompleted");
	p.setDescription("it will help to organize volunteering service");
	p.setLocation("FairField, IA");
	p.setStartDate("2016-09-10");
	p.setEndDate("2016-09-13");
	//task1 for this project
	Task t1 = new Task();
	t1.setDescription("entity creation");
	t1.setResourceRequired("JPA, Hibernate");
	t1.setTaskStatus("incompleted");
	t1.setTimeframeToCompleteInDays(3);
	t1.setImage(Files.readAllBytes(path));
	//task2 for this project
	Task t2 = new Task();
	t2.setDescription("database mapping");
	t2.setResourceRequired("MYSQL");
	t2.setTaskStatus("incomplete");
	t2.setTimeframeToCompleteInDays(0.5);
	p.setTasks(Arrays.asList(t1,t2));
	t2.setImage(Files.readAllBytes(path));
	
	//create beneficiary
	Beneficiary b = new Beneficiary();
	b.setBeneficiaryName("MUM");
	b.setBeneficiaryDescription("This project will be used for future students");
	b.setProjects(Arrays.asList(p));
	b.setImage(Files.readAllBytes(path));
	p.setBeneficiaries(Arrays.asList(b));
	
	//persisting into database
	service.saveUserAddress(address);
	service.createUser(u);
	service.saveProjectTask(t1);
	service.saveProjectTask(t2);
	service.createBeneficiary(b);
	service.createNewProject(p);
	
	//project update i.e. assigned user to project
	Project proj = new Project();
	proj = service.getProjectByName("Volunteering application");
	proj.setUsers(Arrays.asList(u));
	service.updateProject(proj);
	System.out.println("user set to this project");
	
	//assigning user to a task based on the resource
	List<Task> tlist = new ArrayList<Task>();
	tlist = service.getTasksByResource("JPA");
	for(Task t:tlist){
		t.setUser(u);
		service.updateTask(t);
		System.out.println("user set to this task");
	}
	/*get all users*/
	List<User> userslist = new ArrayList<User>();
	userslist = service.getAllUsers();
	for(User usr:userslist){
		System.out.println(usr);
	}
	//get all projects
	System.out.println("All Projects Lists");
	List<Project> projectList = new ArrayList<Project>();
	projectList = service.getAllProjects();
	for(Project prj:projectList){
		System.out.println(prj);
		System.out.println("Tasks of the project");
		/*get all tasks of a project*/
		List<Task> taskList = new ArrayList<Task>();
		taskList = service.getAllTasksByProjectId(prj.getProjectId());
		for(Task tasks:taskList){
			System.out.println(tasks);
		}
	}
	
	//get all completed projects
	System.out.println("Get all projects by status - completed");
	List<Project> completedProject = new ArrayList<Project>();
	completedProject = service.getAllCompletedProjects();
	for(Project prj:completedProject){
		System.out.println(prj);
	}
	
	//get all incompleted projects
	System.out.println("Get all projects by status - incompleted");
	List<Project> incompletedProject = new ArrayList<Project>();
	incompletedProject = service.getAllIncompletedProjects();
	for(Project prj:incompletedProject){
		System.out.println(prj);
	}
	
	//search projects by type of resources/skill
	String resourceSkill = "JPA";
	System.out.println("All projects that requires skill - "+resourceSkill);
	List<Project> prjListBySkill = new ArrayList<Project>();
	prjListBySkill = service.getProjectsByResource(resourceSkill);
	for(Project prj:prjListBySkill){
		System.out.println(prj);
	}
	
	//search projects by type of keyword
	String keyword = "application";
	System.out.println("All projects that matches in name - "+keyword);
	List<Project> prjListByKeyword = new ArrayList<Project>();
	prjListByKeyword = service.getProjectsByKeyword(keyword);
	for(Project prj:prjListByKeyword){
		System.out.println(prj);
	}
	
	//search projects by type of keyword
	String location = "FairField";
	System.out.println("All projects that matches the location - "+location);
	List<Project> prjListByLocation = new ArrayList<Project>();
	prjListByLocation = service.getProjectsByLocation(location);
	for(Project prj:prjListByLocation){
		System.out.println(prj);
	}
	
	//get all projects and task that are offered service by volunteers
	System.out.println("All Projects Lists having Volunteer");
	List<Project> projectListInProgress = new ArrayList<Project>();
	projectListInProgress = service.getAllProjects();
	for(Project prj:projectListInProgress){
		System.out.println(prj);
		System.out.println("Tasks of the project having Volunteer");
		/*get all tasks of a project*/
		List<Task> taskListInProgress = new ArrayList<Task>();
		taskListInProgress = service.getAllTasksByProjectId(prj.getProjectId());
		for(Task tasks:taskListInProgress){
			System.out.println(tasks);
		}
	}
	
	//get all projects and beneficiaries
	System.out.println("All Projects Lists having Volunteer");
	List<Project> projectWithBeneficiaries = new ArrayList<Project>();
	projectWithBeneficiaries = service.getAllProjects();
	for(Project prj:projectListInProgress){
		System.out.println(prj);
		System.out.println("Beneficiaries of the project are - ");
		/*get all beneficiaries of the project*/
		List<Beneficiary> list = new ArrayList<Beneficiary>();
		list = service.getAllBeneficiariesOfProjectById(prj.getProjectId());
		for(Beneficiary bene:list){
			System.out.println(bene);
		}
	}
	
	}

}
