package jdbcSupPlanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

import interfaceSupPlanner.ProjectDao;
import managerSupPlanner.Project;

public class JdbcProjectDao implements ProjectDao {
	Scanner sc = new Scanner(System.in);
	private Connection connection;
	
	private String[] idParametre;
	
	public JdbcProjectDao(Connection c)
	{
		connection = c;
		
		this.idParametre = new String[100];
	}
	
	public Project[] displatAllProject() {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		Project[] toto = new Project[100];
		
		try
		{
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM project");
			while(rs.next())
			{	
				toto[count] = new Project();
				toto[count].setId(Integer.parseInt(rs.getString("idProject")));
				toto[count].setName(rs.getString("name"));
				toto[count].setAuthor(rs.getString("author"));
				toto[count].setStart_Time(rs.getDate("start_time"));
				toto[count].setEnd_Time(rs.getDate("end_time"));
				toto[count].setNumber_Of_Employe(Integer.parseInt(rs.getString("number_of_employe")));
				toto[count].setProject_completion(Integer.parseInt(rs.getString("project_completion")));
				count++;
			}
		}catch(Exception e)
		{
		}
		
		Project[] finale = new Project[count];
		
		for(int i = 0; i<count; i++)
		{
			finale[i] = toto[i];
		};
		return finale;
	}

	public boolean createProject(String name, String author, int number,
			int completion) {
		// TODO Auto-generated method stub
		Project compile = new Project();
		
		compile.setName(name);
		compile.setAuthor(author);
		
		compile.setProject_completion(completion);
		
		compile.setNumber_Of_Employe(number);;
		
		try
		{
			PreparedStatement pstm = connection.prepareStatement("INSERT INTO project (name, author, number_of_employe, project_completion)"
				+ "VALUES (?, ?, ?, ?)");
			pstm.setString(1, compile.getName());
			pstm.setString(2, compile.getAuthor());
			pstm.setInt(3, compile.getNumber_Of_Employe());
			pstm.setInt(4, compile.getProject_completion());
			
			pstm.executeUpdate();
		}catch(Exception e)
		{
			
		}
		
		return false;
	}
	
	
	public String[] idParametre()
	{
		int i = 0;
		try
		{
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM project");
			while(rs.next())
			{	
				idParametre[i] = rs.getString("idProject");
				i++;
			}
		}catch(Exception e)
		{
		}
		return idParametre;
	}
	
	public boolean modifyProject(int idT, String name, String author, 
			int numberX, int completionX) {
		// TODO Auto-generated method stub
		
		Project compile = new Project();
		
		compile.setName(name);
		compile.setAuthor(author);
		compile.setNumber_Of_Employe(numberX);
		compile.setProject_completion(completionX);
		
		try
		{
			PreparedStatement pstm = connection.prepareStatement("UPDATE project "
					+ "SET name = ?, author = ?, "
					+ "number_of_employe = ?, project_completion = ?"
					+ " WHERE idProject = ?");
			
			pstm.setString(1, compile.getName());
			pstm.setString(2, compile.getAuthor());
			pstm.setInt(3, compile.getNumber_Of_Employe());
			pstm.setInt(4, compile.getProject_completion());
			pstm.setInt(5, idT);
			
			pstm.executeUpdate();
			
			return true;
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean inviteOther() {
		// TODO Auto-generated method stub
		return false;
	}

}