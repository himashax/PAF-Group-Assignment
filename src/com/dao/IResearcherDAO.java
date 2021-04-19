package com.dao;

import java.util.ArrayList;

import com.models.Researcher;

public interface IResearcherDAO {

	public String createReseracher(Researcher res);
	
	public ArrayList<Researcher> listResearchers();
	
	public Researcher getResearcherByID(int id);
	
	public String updateResearcher(Researcher res);
	
	public String deleteResearcher(int id);
	
}
