package com.qa.cdlibrary.business;

import com.qa.cdlibrary.business.CDLibraryService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class CDLibraryServiceMapImpl implements CDLibraryService {

	@Override
	public String getAllCD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createCD(String cd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCD(Long id, String cd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCD(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAllCD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String FindCDBLong(Long id){
		// TODO Auto-generated method stub
		return null;
	}

}
