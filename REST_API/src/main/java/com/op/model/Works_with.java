package com.op.model;

import java.io.Serializable;

//import javax.persistence.Access;
//import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "works_with")
@Table(name = "works_with")

public class Works_with implements Serializable {

	@Id
	@ManyToOne(targetEntity = Employee.class)
	@JoinColumn(name = "emp_id")
	Employee employee;

	@Id
	@ManyToOne(targetEntity = Client.class)
	@JoinColumn(name = "client_id")
	Client client;

	@Column(name = "total_sales")
	private int total_sales;

	public Works_with() {

	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getTotal_sales() {
		return total_sales;
	}

	public void setTotal_sales(int total_sales) {
		this.total_sales = total_sales;
	}

}
