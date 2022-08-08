package com.op.services;

import java.util.List;

import com.op.DAO.EmployeeDAO;
import com.op.model.Employee;

public class EmployeeService {

	EmployeeDAO dao = new EmployeeDAO();

	public List<Employee> getEmployees() {
		List<Employee> list = dao.getEmployees();
		return list;
	}

	public void addEmployee(Employee employee) {
		dao.addEmployee(employee);
	}

	public void updateEmployee(Employee updateEmp) {
		dao.updateEmployee(updateEmp);
	}

	public void deleteEmployee(int emp_id) {
		dao.deleteEmployee(emp_id);
	}

}
