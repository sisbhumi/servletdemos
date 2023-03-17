package com.studentweb.model;
public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Student(String firstname, String lastName, String email) {
		super();
		this.firstName = firstname;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Student(int id, String firstname, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastName;
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
}
