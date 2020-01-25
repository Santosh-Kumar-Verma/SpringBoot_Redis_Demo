package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.redis.service.StudentService;
import com.redis.vo.Employee;
import com.redis.vo.Student;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping(value = "studentDetails/{name}/{studentId}")
	public Student getStudentDetls(@PathVariable String name,@PathVariable Long studentId) {
		System.out.println("StudentId :"+studentId);
		Student student = service.getStudentInfo(name, studentId);
		return student;
	}
	@GetMapping(value = "employeeDtls/{name}/{studentId}")
	public Employee employeeDtls(@PathVariable String name,@PathVariable Long studentId) {
		System.out.println("StudentId :"+studentId);
		Employee employee = service.employeeDtls(name, studentId);
		return employee;
	}
	@GetMapping(value = "updateEmployee/{name}/{studentId}")
	public void updateEmployee(@PathVariable String name,@PathVariable Long studentId) {
		System.out.println("StudentId :"+studentId);
		service.updateEmployee(name, studentId);
	}
	@GetMapping(value = "clearCache/{name}/{studentId}")
	public void clearCache(@PathVariable String name,@PathVariable Long studentId) {
	     service.clearCache();
	}
}
