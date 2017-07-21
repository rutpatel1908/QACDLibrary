package com.qa.cdlibrary.business;

import java.util.ArrayList;
import java.util.Arrays;
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
	    try {
	        String errorMessage = "";
            CD aCD = util.getObjectForJSON(movie, CD.class);
            if (aCD.getArtistName() == null) errorMessage +="artistName, ";
            if (aCD.getGenre() == null) errorMessage += "genre, ";
            if (aCD.getAlbumTitle() == null) errorMessage +="albumTitle, ";
            if (errorMessage.contains("e")) throw new IllegalArgumentException( errorMessage +"is missing");
            manager.persist(aCD);
            return "{\"message\": \"cd sucessfully added\"}";
        }catch (IllegalArgumentException error) {
	        return  error.getMessage();
        }
	}

	@Override
	public String updateCD(Long id, String aCD) {
		CD updatedCD = util.getObjectForJSON(aCD, CD.class);
		CD cDInDB = findCD(id);
        if(cDInDB != null){
            if(updatedCD.getArtistName() != null){ cDInDB.setArtistName(updatedCD.getArtistName());}
            if(updatedCD.getGenre() != null){ cDInDB.setGenre(updatedCD.getGenre());}
            if(updatedCD.getAlbumTitle() != null){ cDInDB.setAlbumTitle(updatedCD.getAlbumTitle());}
            manager.merge(cDInDB);
			return "{\"message\": \"cd sucessfully updated\"}";
		}
		return "{\"message\": \"cd with that id doesn't exist\"}";
	}

	@Override
	public String deleteCD(Long id) {
		CD cDInDB = findCD(id);
		if (cDInDB != null) {
			manager.remove(cDInDB);
			return "{\"message\": \"cd sucessfully deleted\"}";
		}
		else{
		    return "{\"message\": \"cd with that id doesn't exist\"}";
        }

	}

	@Override
	public String deleteAllCD() {
        Query query = manager.createQuery("DELETE FROM CD");
        query.executeUpdate();
        return "{\"message\": \"all cd successfully deleted\"}";
	}

/*	@Override
    public String findCDByID(Long id){
        String findCDByIDQuery = "Select c FROM CD c WHERE id = "+id;
        Query query = manager.createQuery(findCDByIDQuery);
        Collection<CD> results = (Collection<CD>) query.getResultList();
        return util.getJSONForObject(results);
    }
*/
	@Override
    public String findCDByID(Long id){
        CD cDInDB = findCD(id);
        if (cDInDB != null) {
            return util.getJSONForObject(cDInDB);
        }
        return "{\"message\": \"cd with that id doesn't exist\"}";
    }

	private CD findCD(Long id) {
		return manager.find(CD.class, id);
	}
}
