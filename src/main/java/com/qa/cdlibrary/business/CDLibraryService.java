package com.qa.cdlibrary.business;

public interface CDLibraryService {
	String getAllMovies();

	String createMovie(String movie);

	String updateMovie(Long id, String movie);

	String deleteMovie(Long id);
}
