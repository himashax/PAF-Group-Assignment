package com.dao;

import java.util.List;

import com.models.Researcher;

public interface IResearcherDAO {

	
	/**
	 * Add researchers to the researcher table
	 * @param res
	 * @return
	 */
	public String createReseracher(Researcher res);
	
	
	/**
	 * Get all the researchers from the researcher table
	 * @return List<Researcher>
	 */
	public List<Researcher> listResearchers();
	
	
	/**
	 * Get a particular researcher by the given id
	 * @param id
	 * @return Researcher
	 */
	public Researcher getResearcherByID(int id);
	
	
	/**
	 * Update researcher details
	 * @param res
	 * @return
	 */
	public String updateResearcher(Researcher res);
	
	/**
	 * Delete researcher from the table
	 * @param id
	 * @return
	 */
	public String deleteResearcher(int id);
	
}
