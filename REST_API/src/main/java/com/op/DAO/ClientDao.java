package com.op.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.op.model.Client;

public class ClientDao {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Client.class)
			.buildSessionFactory();

	public List<Client> getClients() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Client> list = session.createQuery("from client").getResultList();
		return list;
	}

	public void addClient(Client client) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(client);
		session.getTransaction().commit();
	}

	public void updateClient(Client updateClient) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		int id = updateClient.getClient_id();
		Client client = session.get(Client.class, id);
		client.setClient_name(updateClient.getClient_name());
		session.getTransaction().commit();
	}

	public void deleteClient(int client_id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Client client = session.get(Client.class, client_id);
		session.delete(client);
		session.getTransaction().commit();

	}
}
