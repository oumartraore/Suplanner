package interfaceSupPlanner;

import managerSupPlanner.Project;

public interface ProjectDao {
	public Project[] displatAllProject();
	public boolean createProject(String name, String author, int number,
			int completion);
	public boolean modifyProject(int id, String name, String author, int numberX, int completionX);
	public boolean inviteOther();
}
