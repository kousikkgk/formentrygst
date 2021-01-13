package com.kousik.formentrygst.service;

import java.util.List;

import com.kousik.formentrygst.model.Student;

public class StudentListContainer {
	private List<Student> student;

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentListContainer [student=" + student + "]";
	}
	
	
	
}
