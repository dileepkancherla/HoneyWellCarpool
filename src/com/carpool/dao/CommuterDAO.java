package com.carpool.dao;

import java.util.List;

import com.carpool.model.Commuter;
import com.carpool.model.VehicleOwner;

public interface CommuterDAO {

	public void addCommuter(Commuter p);
	public void updateCommuter(Commuter p);
	public List<Commuter> listCommuters();
	public Commuter getCommuterById(int id);
	public void removeCommuter(int id);
	public List<VehicleOwner> getVehicles();
}
