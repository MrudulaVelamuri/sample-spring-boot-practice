package com.example.student.profile.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentsDetails {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String studentId;
	private String firstName;
	private String lastName;
	private String address;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Alien [employeeId=" + studentId + ", FirstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + "]";
	}
	
	
	
	
	

}
