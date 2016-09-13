package mum.edu.cs544.DAO;

import java.util.List;

import mum.edu.cs544.domain.Task;

public interface ITaskDAO {
	void createTask(Task task);
	List<Task> getAllTaskByProjectId(int projectId);
	void updateTask(Task task);
	List<Task> getAllTaskOfferedByVolunteer();
	List<Task> getTaskBySkill(String skill);

}
