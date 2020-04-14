package clinicalInformationSystem;
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
	public int getIdNumber()
	{
		return idNumber;
	}
	public void setIdNumber(int idNumber)
	{
		this.idNumber = idNumber;
	}
	public int getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public int getsSN()
	{
		return sSN;
	}
	public void setsSN(int sSN)
	{
		this.sSN = sSN;
	}
	public int getInsuranceNumber()
	{
		return insuranceNumber;
	}
	public void setInsuranceNumber(int insuranceNumber)
	{
		this.insuranceNumber = insuranceNumber;
	}
	public Date getDateOfRegistration()
	{
		return dateOfRegistration;
	}
	public void setDateOfRegistration(Date dateOfRegistration)
	{
		this.dateOfRegistration = dateOfRegistration;
	}
	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	public String getPatientName()
	{
		return patientName;
	}
	public void setPatientName(String patientName)
	{
		this.patientName = patientName;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getOccupation()
	{
		return occupation;
	}
	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}
	public String getWorkStatus()
	{
		return workStatus;
	}
	public void setWorkStatus(String workStatus)
	{
		this.workStatus = workStatus;
	}
	public String getEducation()
	{
		return education;
	}
	public void setEducation(String education)
	{
		this.education = education;
	}
	
	
}
