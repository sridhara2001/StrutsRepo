package com.struts.action;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.model.Student;

//@ResultPath(value = "/WEB-INF/content/")
public class StudentAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1209662090699382225L;
	
	private Student student;
	private List<String> hobbies;
	
	public StudentAction() {
		hobbies = Arrays.asList("sports","action");
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = Arrays.asList("sports","music");
	}
	
	public String showStudForm() {
		return "none";
	}

	public String execute() {
		if(student.getName().equals("Sridhar"))
			return "success";
		return "error";
	}
	
}
