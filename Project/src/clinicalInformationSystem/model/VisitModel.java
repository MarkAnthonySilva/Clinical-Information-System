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
	
	private THIModel THI;
	private TFIModel TFI;
	
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
	 * Get the THI Model associated with this visit
	 * @return THI Model
	 */
	public THIModel getTHIModel()
	{
		return THI;
	}
	
	/**
	 * Get the TFI Model associated with this visit
	 * @return TFI Model
	 */
	public TFIModel getTFIModel()
	{
		return TFI;
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
	
	/**
	 * Set the THI Model for this visit
	 * @param THI THIModel of the visit
	 */
	public void setTHIModel(THIModel THI)
	{
		this.THI = THI;
	}
	
	/**
	 * Set the TFI Model for this visit
	 * @param TFI TFIModel of the visit
	 */
	public void setTFIModel(TFIModel TFI)
	{
		this.TFI = TFI;
	}
}
