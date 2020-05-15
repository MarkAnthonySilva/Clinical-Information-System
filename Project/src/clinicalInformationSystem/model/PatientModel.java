package clinicalInformationSystem.model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
	private int sSN;					//Social Security Number
	private int insuranceNumber;
	
	private Date dateOfRegistration;
	private Date dateOfBirth;
	
	private String patientName;
	private String gender;
	private String address;
	private String phoneNumber;
	
	//Optional parameters
	private String occupation;
	private boolean isWorking;			//Can be changed to boolean
	private String education;
	
	//Addtional information
	private String notes;
	
	/**
	 * Creates a patient using the builder pattern
	 * @param builder the builder to create the patient out off
	 */
	public PatientModel(Builder builder)
	{
		this.idNumber = builder.idNumber;
		this.phoneNumber = builder.phoneNumber;
		this.sSN = builder.sSN;
		this.insuranceNumber = builder.insuranceNumber;
		this.dateOfRegistration = builder.dateOfRegistration;
		this.dateOfBirth = builder.dateOfBirth;
		this.patientName = builder.patientName;
		this.gender = builder.gender;
		this.address = builder.address;
		this.occupation = builder.occupation;
		this.isWorking = builder.isWorking;
		this.education = builder.education;
		
	}
	
	/**
	 * Get a hashmap representation of the data of this patient
	 * @return a hashmap representation of the data of this patient
	 */
	public HashMap<String, String> getMap()
	{
		SimpleDateFormat standardDateFormat = new SimpleDateFormat("MMMM d, yyyy");
		String dob = standardDateFormat.format(this.dateOfBirth);
		String dor = standardDateFormat.format(this.dateOfRegistration);
				
		HashMap<String, String> patientData = new HashMap<>();
		patientData.put("Name", this.patientName);
		patientData.put("ID Number", Integer.toString(this.idNumber));
		patientData.put("Date of Birth", dob);
		patientData.put("Gender", this.gender);
		patientData.put("Phone Number", this.phoneNumber);
		patientData.put("Address", this.address);
		patientData.put("Social Security Number", Integer.toString(this.sSN));
		patientData.put("Insurance Number", Integer.toString(this.insuranceNumber));
		patientData.put("Register Date", dor);
		
		return patientData;
	}
	
	/**
	 * Builds a Patient using the Builder Context Pattern
	 * @return created builder
	 */
	public static Builder builder()
	{
		return new Builder();
	}
	
	/**
	 * @return the idNumber
	 */
	public int getIdNumber()
	{
		return idNumber;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * @return the sSN
	 */
	public int getsSN()
	{
		return sSN;
	}

	/**
	 * @return the insuranceNumber
	 */
	public int getInsuranceNumber()
	{
		return insuranceNumber;
	}

	/**
	 * @return the dateOfRegistration
	 */
	public Date getDateOfRegistration()
	{
		return dateOfRegistration;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	/**
	 * @return the patientName
	 */
	public String getPatientName()
	{
		return patientName;
	}

	/**
	 * @return the gender
	 */
	public String getGender()
	{
		return gender;
	}

	/**
	 * @return the address
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * @return the occupation
	 */
	public String getOccupation()
	{
		return occupation;
	}

	/**
	 * @return the isWorking
	 */
	public boolean isWorking()
	{
		return isWorking;
	}

	/**
	 * @return the education
	 */
	public String getEducation()
	{
		return education;
	}
	
	/**
	 * @return the notes
	 */
	public String getNotes()
	{
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	/**
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(int idNumber)
	{
		this.idNumber = idNumber;
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
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}

	/**
	 * @param isWorking the isWorking to set
	 */
	public void setWorking(boolean isWorking)
	{
		this.isWorking = isWorking;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(String education)
	{
		this.education = education;
	}

	public String toString()
	{
		return patientName;
	}

	/**
	 * Actual Builder class to be used to construct Patient
	 * @author marksilvajr
	 *
	 */
	public static class Builder
	{
		private int idNumber;
		private int sSN;
		private int insuranceNumber;
		private Date dateOfRegistration;
		private Date dateOfBirth;
		private String patientName;
		private String gender;
		private String address;
		private String occupation;
		private String phoneNumber;
		private boolean isWorking;
		private String education;

		public Builder()
		{
		}

		public Builder withIdNumber(int idNumber)
		{
			this.idNumber = idNumber;
			return this;
		}

		public Builder withPhoneNumber(String phoneNumber)
		{
			this.phoneNumber = phoneNumber;
			return this;
		}

		public Builder withSSN(int sSN)
		{
			this.sSN = sSN;
			return this;
		}

		public Builder withInsuranceNumber(int insuranceNumber)
		{
			this.insuranceNumber = insuranceNumber;
			return this;
		}

		public Builder withDateOfRegistration(Date dateOfRegistration)
		{
			this.dateOfRegistration = dateOfRegistration;
			return this;
		}

		public Builder withDateOfBirth(Date dateOfBirth)
		{
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder withPatientName(String patientName)
		{
			this.patientName = patientName;
			return this;
		}

		public Builder withGender(String gender)
		{
			this.gender = gender;
			return this;
		}

		public Builder withAddress(String address)
		{
			this.address = address;
			return this;
		}

		public Builder withOccupation(String occupation)
		{
			this.occupation = occupation;
			return this;
		}

		public Builder withIsWorking(boolean isWorking)
		{
			this.isWorking = isWorking;
			return this;
		}

		public Builder withEducation(String education)
		{
			this.education = education;
			return this;
		}

		public PatientModel build()
		{
			return new PatientModel(this);
		}
	}
}
