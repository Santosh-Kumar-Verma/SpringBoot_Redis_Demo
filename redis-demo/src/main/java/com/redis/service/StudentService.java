
package com.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.dao.CacheDao;
import com.redis.vo.Employee;
import com.redis.vo.Student;

@Service
public class StudentService {

	@Autowired CacheDao cacheDao;
	
	
	public Student getStudentInfo(String name,Long studentId) {
		 try {
			 cacheDao.getStudentInfo(name, studentId);
		 } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println("error occured in getStudentInfo while calling redis cache data");
			 return cacheDao.getStudentDetails("TestStudent", studentId);
		 }
		 return new Student(studentId, name);
	}
	public void updateEmployee(String name,Long studentId) {
		 try {
			 cacheDao.updateEmployee(name, studentId);
		 } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println("error occured in updateEmployee while calling redis cache data");
		 }
	}
	public Employee  employeeDtls(String name,Long studentId) {
		 try {
			 return cacheDao.employeeDtls(name, studentId);
		 } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println("error occured in employeeDtls while calling redis cache data");
			 return cacheDao.getEmployeeDetails("TestEmployee", studentId);
		 }
	}
	public void clearCache() {
		cacheDao.clearCache();
	}
}
