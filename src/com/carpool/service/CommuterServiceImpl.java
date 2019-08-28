package com.carpool.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carpool.dao.CommuterDAO;
import com.carpool.model.Commuter;
import com.carpool.model.VehicleOwner;

@Service
public class CommuterServiceImpl implements CommuterService {
	
	private CommuterDAO commuterDAO;

	public void setCommuterDAO(CommuterDAO commuterDAO) {
		this.commuterDAO = commuterDAO;
	}

	@Override
	@Transactional
	public void addCommuter(Commuter p) {
		this.commuterDAO.addCommuter(p);
	}

	@Override
	@Transactional
	public void updateCommuter(Commuter p) {
		this.commuterDAO.updateCommuter(p);
	}

	@Override
	@Transactional
	public List<Commuter> listCommuters() {
		return this.commuterDAO.listCommuters();
	}

	@Override
	@Transactional
	public Commuter getCommuterById(int id) {
		return this.commuterDAO.getCommuterById(id);
	}

	@Override
	@Transactional
	public void removeCommuter(int id) {
		this.commuterDAO.removeCommuter(id);
	}

	@Override
	@Transactional
	public List<VehicleOwner> getVehicles() {
		// TODO Auto-generated method stub
		return this.commuterDAO.getVehicles();
	}

}
