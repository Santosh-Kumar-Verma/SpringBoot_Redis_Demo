package com.redis.dao;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.redis.vo.Employee;
import com.redis.vo.Student;

@Repository
public class CacheDao {

	@Cacheable(value = "student",key = "#studentId",unless="#result == null")
	public Student  getStudentInfo(String name,Long studentId) {
		 try {
			 System.out.println("it's going to take 5 seconds to process");
			 Thread.sleep(1000*5);
		 } catch (Exception e) {
			 System.out.println("error occured in getStudentInfo");
		}
		 return getStudentDetails(name, studentId);
	}
	public Student getStudentDetails(String name,Long studentId) {
		return new Student(studentId, name);
	}
	@Cacheable(value = "student",key = "#name",unless="#result == null")
	public Employee  employeeDtls(String name,Long studentId) {
		 try {
			 System.out.println("it's going to take 5 seconds to process");
			 Thread.sleep(1000*5);
		 } catch (Exception e) {
			 System.out.println("error occured in employeeDtls");
		}
		 return getEmployeeDetails(name, studentId);
	}
	@CachePut(value = "student",key = "#name")
	public Employee  updateEmployee(String name,Long studentId) {
		 try {
			 System.out.println("it's going to take 5 seconds to process");
		 } catch (Exception e) {
			 System.out.println("error occured in updateEmployee");
		}
		 return getEmployeeDetails(name, studentId);
	}
	public Employee getEmployeeDetails(String name,Long studentId) {
		return new Employee(name, studentId);
	}
	@CacheEvict(value = "student",allEntries = true)
	public void clearCache() {
		System.out.println("Cache is going to clear");
	}
}
