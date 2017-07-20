package com.qa.cdlibrary.business;

public interface CDLibraryService {
	String getAllCD();

	String createCD(String cd);

	String updateCD(Long id, String cd);

	String deleteCD(Long id);

	String deleteAllCD();
}
