package clinicalInformationSystem.model;
import java.util.Date;

/**
 * The model for visits for a clinical information system.
 * Holds the patient, date of visit, and the visit sequence number.
 * @author Team 9
 *
 */
public class VisitModel
{
	private PatientModel patient;
	private Date dateOfvisit;
	private int sequenceNumber;		//0-initial visit, 1-first visit, 2-second visit, etc.
	
	/**
	 * Creates a new visit with the given parameters.
	 * @param patient the patient tied to this visit
	 * @param dateOfVisit the date of the visit of the patient
	 * @param sequenceNumber the sequence number of this visit
	 */
	public VisitModel(PatientModel patient, Date dateOfVisit, int sequenceNumber)
	{
		this.patient = patient;
		this.dateOfvisit = dateOfVisit;
		this.sequenceNumber = sequenceNumber;
	}
	
	/**
	 * Get the Patient associated with this visit
	 * @return Patient
	 */
	public PatientModel getPatient()
	{
		return patient;
	}
	
	/**
	 * Get the date of this visit
	 * @return Date
	 */
	public Date getDateOfVisit()
	{
		return dateOfvisit;
	}
	
	/**
	 * Get the sequence number associated with this visit
	 * @return Sequence number
	 */
	public int getSequenceNumber()
	{
		return sequenceNumber;
	}
	
	/**
	 * Set the patient for this visit
	 * @param patient Patient Model of Visit
	 */
	public void setPatient(PatientModel patient)
	{
		this.patient = patient;
	}
	
	/**
	 * Set the date of this visit
	 * @param dateOfvisit Date of Visit
	 */
	public void setDateOfvisit(Date dateOfvisit)
	{
		this.dateOfvisit = dateOfvisit;
	}
	
	/**
	 * Set the sequence number of this visit
	 * @param sequenceNumber Sequence Number of visit
	 */
	public void setSequenceNumber(int sequenceNumber)
	{
		this.sequenceNumber = sequenceNumber;
	}
}
