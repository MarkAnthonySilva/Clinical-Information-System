package clinicalInformationSystem.model;
import java.util.TreeMap;
import java.util.Date;

/**
 * List of visits registered to this clinical information system.
 * The visits are ordered by their date of visit
 * @author Team 9
 *
 */
public class VisitList
{
	//Maybe implement VisitModel with a list since there could be multiple Visits in a single day
	private TreeMap<Date, VisitModel> listOfPatients;  //Key the date of visit, Value the VisitModel

	/**
	 * Constructs a VisitList with an empty TreeMap
	 */
	public VisitList()
	{
		//To be Implemented
	}
	
	/**
	 * Add a visit to this list of visits
	 * @param v the visitModel to add to this list
	 */
	public void addVisit(VisitModel v)
	{
		//To be Implemented
	}
	
	/**
	 * Get the visit associated with the given date
	 * @param d the date of the visit to be returned
	 * @return the VisitModel associated with the given date
	 */
	public PatientModel getVisit(Date d)
	{
		//To be implemented
		return null;
	}
}
