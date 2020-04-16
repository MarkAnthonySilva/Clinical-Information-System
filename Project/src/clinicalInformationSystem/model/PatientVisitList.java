package clinicalInformationSystem.model;

import java.util.Date;

/**
 * List of visits registered to this specific Patient
 * The visits are ordered by their date of visit
 * @author Team 9
 *
 */

public class PatientVisitList
{
	private VisitList visits;
	
	/**
	 * Creates a Patient Visit List object to store all visits for a particular client
	 * @param visits VisitList to store for patient
	 */
	public PatientVisitList(VisitList visits)
	{
		this.visits = visits;
	}
	
	/**
	 * Add a visit to this list of visits as well as the main visit list for all patients
	 * @param d the date of the visit
	 * @param v the visitModel to add to this list
	 */
	public void addVisit(Date d, VisitModel v)
	{
		//To be Implemented
	}
}
