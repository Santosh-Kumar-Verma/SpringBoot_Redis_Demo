package com.redis.vo;

import java.io.Serializable;

public class Student  implements Serializable{

	private Long studentId;
	private String name;
	
	public Student(Long studentId, String name) {
		super();
		this.studentId = studentId;
		this.name = name;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
