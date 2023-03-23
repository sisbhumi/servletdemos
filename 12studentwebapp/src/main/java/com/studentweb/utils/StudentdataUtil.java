package com.studentweb.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.studentweb.model.Student;

public class StudentdataUtil {

	private DataSource datasource;

	public StudentdataUtil(DataSource datasource2) {
		this.datasource = datasource2;
	}

	public List<Student> getStudents() {

		List<Student> students = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = this.datasource.getConnection();
			stmt = con.createStatement();
			ResultSet resultset = stmt.executeQuery("Select * from student order by id");
			while (resultset.next()) {
				int id = resultset.getInt("id");
				String fname = resultset.getString("first_name");
				String lname = resultset.getString("last_name");
				String email = resultset.getString("email");
				Student student = new Student(id, fname, lname, email);
				students.add(student);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return students;
	}

	private void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(int studentId) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = this.datasource.getConnection();
			String sql = "delete from student where id = ?";
			
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, studentId);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(con, stmt, null);
		}
	}

	public void updateStudent(int studentId) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = this.datasource.getConnection();
			String sql = "update student set email = ? where id = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, studentId);
			stmt.setString(2, email);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(con, stmt, null);
		}
	}

}
