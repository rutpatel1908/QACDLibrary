package com.qa.cdlibrary.business;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cdlibrary.business.CDLibraryService;
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
		Collection<CD> movies = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(movies);
	}

	@Override
	public String createCD(String movie) {
		CD aMovie = util.getObjectForJSON(movie, CD.class);
		manager.persist(aMovie);
		return "{\"message\": \"cd sucessfully added\"}";
	}

	@Override
	public String updateCD(Long id, String movie) {
		CD updatedMovie = util.getObjectForJSON(movie, CD.class);
		CD movieInDB = findMovie(id);
		if (movieInDB != null) {
			movieInDB = updatedMovie;
			manager.merge(movieInDB);
		}
		return "{\"message\": \"cd sucessfully updated\"}";
	}

	@Override
	public String deleteCD(Long id) {
		CD movieInDB = findMovie(id);
		if (movieInDB != null) {
			manager.remove(movieInDB);
		}
		return "{\"message\": \"cd sucessfully deleted\"}";
	}

	@Override
	public String deleteAllCD() {
        Query query = manager.createQuery("DELETE FROM CD");
        query.executeUpdate();
        return "{\"message\": \"all cd sucessfully deleted\"}";
	}

	private CD findMovie(Long id) {
		return manager.find(CD.class, id);
	}

}
