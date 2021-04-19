package com.dao;

import java.util.ArrayList;

import com.models.Researcher;

public interface IResearcherDAO {

	
	
	public ArrayList<Researcher> listResearchers();
	
	public Researcher getResearcherByID(int id);
	
	public void deleteResearcher(int id);
	
}
