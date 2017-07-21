package com.qa.cdlibrary.business;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cdlibrary.persistence.CD;
import com.qa.cdlibrary.util.JSONUtil;

@Stateless
@Default
public class CDLibraryServiceDBImpl implements CDLibraryService {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllCD() {
		Query query = manager.createQuery("Select m FROM CD m");
		Collection<CD> CDList = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(CDList);
	}

	@Override
	public String createCD(String movie) {
		CD aCD = util.getObjectForJSON(movie, CD.class);
		manager.persist(aCD);
		return "{\"message\": \"cd sucessfully added\"}";
	}

	@Override
	public String updateCD(Long id, String aCD) {
		CD updatedCD = util.getObjectForJSON(aCD, CD.class);
		CD CDInDB = findCD(id);
		if (CDInDB != null) {
			CDInDB = updatedCD;
			manager.merge(CDInDB);
		}
		return "{\"message\": \"cd sucessfully updated\"}";
	}

	@Override
	public String deleteCD(Long id) {
		CD CDInDB = findCD(id);
		if (CDInDB != null) {
			manager.remove(CDInDB);
		}
		return "{\"message\": \"cd sucessfully deleted\"}";
	}

	@Override
	public String deleteAllCD() {
        Query query = manager.createQuery("DELETE FROM CD");
        query.executeUpdate();
        return "{\"message\": \"all cd sucessfully deleted\"}";
	}

	@Override
    public String findCDByID(Long id){
        String findCDByIDQuery = "Select c FROM CD c WHERE id = "+id;
        Query query = manager.createQuery(findCDByIDQuery);
        Collection<CD> results = (Collection<CD>) query.getResultList();
        return util.getJSONForObject(results);
    }

	private CD findCD(Long id) {
		return manager.find(CD.class, id);
	}
}
