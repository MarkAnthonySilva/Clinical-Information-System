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
	private boolean isWorking;			//Can be changed to boolean
	private String education;
	
	
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
	public int getPhoneNumber()
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
		private int phoneNumber;
		private int sSN;
		private int insuranceNumber;
		private Date dateOfRegistration;
		private Date dateOfBirth;
		private String patientName;
		private String gender;
		private String address;
		private String occupation;
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

		public Builder withPhoneNumber(int phoneNumber)
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
