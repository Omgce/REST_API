package com.op.services;

import java.util.List;

import com.op.DAO.Works_withDAO;
import com.op.model.Works_with;

public class Works_withService {

	Works_withDAO dao = new Works_withDAO();

	public List<Works_with> getWorks_withByEmployeeAndClientAndTotalsales(int emp_id, int client_id) {
		List<Works_with> works_withList = dao.getEmployeeAndClientByWorks_with(emp_id, client_id);
		return works_withList;
	}
}
