package clinicalInformationSystem;

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
	 * @param visits
	 */
	public PatientVisitList(VisitList visits)
	{
		this.visits = visits;
	}
}
