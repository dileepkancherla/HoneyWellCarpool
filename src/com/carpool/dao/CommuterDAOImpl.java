package com.carpool.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.carpool.model.Commuter;
import com.carpool.model.VehicleOwner;

@Repository
public class CommuterDAOImpl implements CommuterDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CommuterDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addCommuter(Commuter p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Commuter saved successfully, Commuter Details="+p);
	}

	@Override
	public void updateCommuter(Commuter p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Commuter updated successfully, Commuter Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commuter> listCommuters() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Commuter> CommutersList = session.createQuery("from Commuter").list();
		for(Commuter p : CommutersList){
			logger.info("Commuter List::"+p);
		}
		return CommutersList;
	}

	@Override
	public Commuter getCommuterById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Commuter p = (Commuter) session.load(Commuter.class, new Integer(id));
		logger.info("Commuter loaded successfully, Commuter details="+p);
		return p;
	}

	@Override
	public void removeCommuter(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Commuter p = (Commuter) session.load(Commuter.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Commuter deleted successfully, Commuter details="+p);
	}

	@Override
	public List<VehicleOwner> getVehicles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<VehicleOwner> vehiclesList = session.createQuery("from VehicleOwner").list();
		for(VehicleOwner p : vehiclesList){
			logger.info("Vehicles List::"+p);
		}
		return vehiclesList;
	}

}
