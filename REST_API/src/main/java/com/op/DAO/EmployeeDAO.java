package com.op.DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.op.model.Employee;

public class EmployeeDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
			.buildSessionFactory();

	public List<Employee> getEmployees() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		// @SuppressWarnings("unchecked")
		List<Employee> list = session.createQuery("from employee").getResultList();
		
		return list;
	}

	public void addEmployee(Employee emp) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
	}

	public void updateEmployee(Employee updateEmp) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		int id = updateEmp.getEmp_id();
		Employee employee = session.get(Employee.class, id);

		employee.setFirst_name(updateEmp.getFirst_name());
		employee.setLast_name(updateEmp.getLast_name());
		employee.setBirth_day(updateEmp.getBirth_day());
		employee.setSex(updateEmp.getSex());
		employee.setSalary(updateEmp.getSalary());
		session.getTransaction().commit();
	}

	public void deleteEmployee(int emp_id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, emp_id);
		session.delete(employee);
		session.getTransaction().commit();
	}

}
