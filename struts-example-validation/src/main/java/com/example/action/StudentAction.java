package com.example.action;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.example.model.Student;
import com.opensymphony.xwork2.ActionSupport;

@ResultPath(value = "/WEB-INF/content/")
@Action(value = "/studregister", results = {
		@Result(name = "success",location = "studsuccess.jsp")
})
public class StudentAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -182285059638376232L;
	private Student student;
	private List<String> hobbies;
	
	public StudentAction() {
		hobbies = Arrays.asList("sports","music");
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
		this.hobbies = hobbies;
	}
	
	@Action(value = "/studregister", results = {
			@Result(name = "success",location = "studsuccess.jsp")
	})
	@Override
	public String execute() throws Exception {
		return "success";
	}
	
	@Action(value="/studform", results = {
			@Result(name = "none",location = "/WEB-INF/content/studform.jsp")
	})
	public String studForm() {
		return NONE;
	}

	@Override
	public void validate() {
		if(student!=null) {
			if(student.getName().length()<=0)
				addFieldError("student.name", "Name is required");
			if(student.getAge()>20 | student.getAge()<70)
				addFieldError("student.age", "Age should be between 20 and 70");
			if(student.getCity().length()<=0)
				addFieldError("student.city", "City should not be empty");
			if(student.getCourse().length()<=0)
				addFieldError("student.course", "Course should not be empty");
			if(student.getEmail().length()<=0)
				addFieldError("student.email", "Email should not be empty");
			else if(!student.getEmail().contains("@"))
				addFieldError("student.email", "Email is not valid");
			if(student.getAllowance()<=0)
				addFieldError("student.allowance", "Enter Allowance");
			if(student.getHobby().length()<=0)
				addFieldError("student.hobby", "Select hobby");
			if(student.getRadio().isEmpty())
				addFieldError("student.radio", "Select gender");
		}
	}
	
	
}
