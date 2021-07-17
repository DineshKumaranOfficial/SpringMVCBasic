package com.ndk.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ndk.springmvc.models.Employee;

@Component
public class EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Employee> getEmployees(){
		Session session = sessionFactory.getCurrentSession();
		List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
		
		return employees;
	}

	@Transactional
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
	}

	@Transactional
	public Employee getEmployee(int empId) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = session.get(Employee.class, empId);
		
		return employee;
	}
}
