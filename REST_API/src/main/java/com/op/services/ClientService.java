package com.op.services;

import java.util.List;

import com.op.DAO.ClientDao;
import com.op.model.Client;
import com.op.model.Works_with;

public class ClientService {

	ClientDao dao = new ClientDao();

	public List<Client> getClients() {
		List<Client> list = dao.getClients();
		return list;
	}

	public void addClient(Client client) {
		dao.addClient(client);
	}

	public void updateClient(Client updateClient) {
		dao.updateClient(updateClient);

	}

	public void deleteClient(int client_id) {
		dao.deleteClient(client_id);
	}
}
