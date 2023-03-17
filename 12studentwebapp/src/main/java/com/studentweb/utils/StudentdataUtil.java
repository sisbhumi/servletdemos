package com.studentweb.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.studentweb.model.Student;

public class StudentdataUtil {
	
	List<Student> students = new ArrayList<>();
	Connection con = null;
	Statement stmt = null ;
	ResultSet rs = null;
	
	public StudentdataUtil(Connection con) {
		this.con = con;
	}

	public List<Student> getStudents(){
		
		try {
			stmt = con.createStatement();
			ResultSet resultset = stmt.executeQuery("Select * from student order by id");
			while(resultset.next()) {
				int id = resultset.getInt("id");
				String fname = resultset.getString("first_name");
				String lname = resultset.getString("last_name");
				String email = resultset.getString("email");
				Student student = new Student(id,fname,lname,email);
				students.add(student);	
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,stmt,rs);
			
		}
		return students;
	}
	
	private void close(Connection con2, Statement stmt2, ResultSet rs2) {
		try {
			if(rs!=null) {
				rs.close();
			}
			
			if(stmt != null) {
				stmt.close();
			}
			
			if(con != null) {
				con.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
