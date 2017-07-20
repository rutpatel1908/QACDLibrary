package com.qa.cdlibrary.business;

import com.qa.cdlibrary.business.CDLibraryService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class CDLibraryServiceMapImpl implements CDLibraryService {

	@Override
	public String getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createMovie(String movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateMovie(Long id, String movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMovie(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
