package com.op.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "client")
@Table(name = "client")
public class Client {

	@Id
	@Column(name = "client_id")
	private int client_id;

	@Column(name = "client_name")
	private String client_name;

	public Client() {

	}

	public Client(int client_id, String client_name) {
		super();
		this.client_id = client_id;
		this.client_name = client_name;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", client_name=" + client_name + "]";
	}

}
