package com.op.DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.op.model.Client;
//import com.op.model.Client;
import com.op.model.Employee;
import com.op.model.Works_with;

public class Works_withDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Works_with.class)
			.addAnnotatedClass(Employee.class).addAnnotatedClass(Client.class).buildSessionFactory();

	public List<Works_with> getEmployeeAndClientByWorks_with(int emp_id, int client_id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Works_with> works_withList;
		String HQL = "from works_with where emp_id ='" + emp_id + "' and client_id ='" + client_id + "'";

		works_withList = session.createQuery(HQL).getResultList();

		return works_withList;
	}

}
