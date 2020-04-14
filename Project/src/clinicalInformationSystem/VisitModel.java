package clinicalInformationSystem;
import java.util.Date;
/**
 * The model for visits for a clinical information system.
 * Holds the patient, date of visit, and the visit sequence number.
 * Able to update the visit sequence number.
 * @author Team 9
 *
 */
public class VisitModel
{
	private int sequenceNumber;		//0-intial vist, 1-first visit, 2-second visit, etc.
	private PatientModel patient;
	private Date dateOfvisit;
	
	/**
	 * Creates a new visit with the given parameters. Sets the sequence number initially to 0.
	 * @param patient the patient tied to this visit
	 * @param dateOfVisit the date of the visit of the patient
	 * @param sequenceNumber the sequence number of this visit
	 */
	public VisitModel(PatientModel patient, Date dateOfVisit, int sequenceNumber)
	{
		//To be implemented
	}

	//List of getters and setters for the parameters of Visit Model
	/**
	 * @return the sequenceNumber
	 */
	public int getSequenceNumber()
	{
		return sequenceNumber;
	}

	/**
	 * @return the patient
	 */
	public PatientModel getPatient()
	{
		return patient;
	}

	/**
	 * @return the dateOfvisit
	 */
	public Date getDateOfvisit()
	{
		return dateOfvisit;
	}

	/**
	 * @param sequenceNumber the sequenceNumber to set
	 */
	public void setSequenceNumber(int sequenceNumber)
	{
		this.sequenceNumber = sequenceNumber;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(PatientModel patient)
	{
		this.patient = patient;
	}

	/**
	 * @param dateOfvisit the dateOfvisit to set
	 */
	public void setDateOfvisit(Date dateOfvisit)
	{
		this.dateOfvisit = dateOfvisit;
	}
	
	
}
