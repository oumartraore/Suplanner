package managerSupPlanner;

import java.util.*;

public class Task {
	private int id;
	private int task_completion;
	private int employe_working;
	private String name;
	private Date start_Time;
	private Date end_Time;
	
	public Task()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTask_completion() {
		return task_completion;
	}

	public void setTask_completion(int task_completion) {
		this.task_completion = task_completion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart_Time() {
		return start_Time;
	}

	public void setStart_Time(Date start_Time) {
		this.start_Time = start_Time;
	}

	public Date getEnd_Time() {
		return end_Time;
	}

	
	public void setEnd_Time(Date end_Time) {
		this.end_Time = end_Time;
	}

	public int getEmploye_working() {
		return employe_working;
	}

	public void setEmploye_working(int employe_working) {
		this.employe_working = employe_working;
	}
	
	
}
