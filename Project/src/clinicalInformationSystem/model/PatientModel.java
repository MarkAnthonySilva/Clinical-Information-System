package clinicalInformationSystem.model;
import java.util.Date;

/**
 * The Model for a patient undergoing Tinnitus treatment
 * Hold the basic information about the patient with the edition of getters and setters to be 
 * able to access and edit the information.
 * @author Team 9
 *
 */
public class PatientModel
{
	//Basic and Essential parameters (information) about the patient
	private int idNumber;
	private int phoneNumber;
	private int sSN;					//Social Security Number
	private int insuranceNumber;
	
	private Date dateOfRegistration;
	private Date dateOfBirth;
	
	private String patientName;
	private String gender;
	private String address;
	
	//Optional parameters
	private String occupation;
	private String workStatus;			//Can be changed to boolean
	private String education;
	
	//List of getters and setters for all the parameters of a patient
	/**
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(int idNumber)
	{
		this.idNumber = idNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @param sSN the sSN to set
	 */
	public void setsSN(int sSN)
	{
		this.sSN = sSN;
	}
	/**
	 * @param insuranceNumber the insuranceNumber to set
	 */
	public void setInsuranceNumber(int insuranceNumber)
	{
		this.insuranceNumber = insuranceNumber;
	}
	/**
	 * @param dateOfRegistration the dateOfRegistration to set
	 */
	public void setDateOfRegistration(Date dateOfRegistration)
	{
		this.dateOfRegistration = dateOfRegistration;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName)
	{
		this.patientName = patientName;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}
	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}
	/**
	 * @param workStatus the workStatus to set
	 */
	public void setWorkStatus(String workStatus)
	{
		this.workStatus = workStatus;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(String education)
	{
		this.education = education;
	}
	
	
}
