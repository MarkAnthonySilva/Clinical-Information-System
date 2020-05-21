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
	// Basic and Essential parameters (information) about the patient
	private int idNumber;
	private int sSN;					// Social Security Number
	private int insuranceNumber;
	
	private Date dateOfRegistration;
	private Date dateOfBirth;
	
	private String patientName;
	private String gender;
	private String address;
	private String phoneNumber;
	
	// Optional parameters
	private String occupation;
	private String isWorking;			// Can be changed to boolean
	private String education;
	
	// Additional information
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
	 * Get a HashMap representation of the data of this patient
	 * @return a HashMap representation of the data of this patient
	 */
	public HashMap<String, String> getMap()
	{
		SimpleDateFormat standardDateFormat = new SimpleDateFormat("MMMM d, yyyy");
		String dob = standardDateFormat.format(this.dateOfBirth);
		String dor = standardDateFormat.format(this.dateOfRegistration);
				
		HashMap<String, String> patientData = new HashMap<>();
		patientData.put("Name*", this.patientName);
		patientData.put("ID Number*", Integer.toString(this.idNumber));
		patientData.put("Date of Birth (mm/dd/yyyy)*", dob);
		patientData.put("Gender*", this.gender);
		patientData.put("Phone Number*", this.phoneNumber);
		patientData.put("Address*", this.address);
		patientData.put("Social Security Number*", Integer.toString(this.sSN));
		patientData.put("Insurance Number*", Integer.toString(this.insuranceNumber));
		patientData.put("Register Date (mm/dd/yyyy)*", dor);
		patientData.put("Occupation", this.occupation);
		patientData.put("Work Status", this.isWorking);
		patientData.put("Educational Degree", this.education);
		patientData.put("Notes", this.notes);
		
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
	 * Get patient's id number
	 * @return the idNumber
	 */
	public int getIdNumber()
	{
		return idNumber;
	}

	/**
	 * Get patient's phone number
	 * @return the phoneNumber
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * Get patient's social security number
	 * @return the sSN
	 */
	public int getsSN()
	{
		return sSN;
	}

	/**
	 * Get patient's insurance number
	 * @return the insuranceNumber
	 */
	public int getInsuranceNumber()
	{
		return insuranceNumber;
	}

	/**
	 * Get patient's date of registration
	 * @return the dateOfRegistration
	 */
	public Date getDateOfRegistration()
	{
		return dateOfRegistration;
	}

	/**
	 * Get patient's date of birth
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	/**
	 * Get patient's name
	 * @return the patientName
	 */
	public String getPatientName()
	{
		return patientName;
	}

	/**
	 * Get patient's gender
	 * @return the gender
	 */
	public String getGender()
	{
		return gender;
	}

	/**
	 * Get patient's address
	 * @return the address
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * Get patient's occupation
	 * @return the occupation
	 */
	public String getOccupation()
	{
		return occupation;
	}

	/**
	 * Get patient's isWorking String
	 * @return the isWorking
	 */
	public String isWorking()
	{
		return isWorking;
	}

	/**
	 * Get patient's education
	 * @return the education
	 */
	public String getEducation()
	{
		return education;
	}
	
	/**
	 * Get patient notes
	 * @return the notes
	 */
	public String getNotes()
	{
		return notes;
	}

	/**
	 * Set patient notes
	 * @param notes the notes to set
	 */
	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	/**
	 * Set patient's id number
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(int idNumber)
	{
		this.idNumber = idNumber;
	}

	/**
	 * Set patient's social security number
	 * @param sSN the sSN to set
	 */
	public void setsSN(int sSN)
	{
		this.sSN = sSN;
	}

	/**
	 * Set patient's insurance number
	 * @param insuranceNumber the insuranceNumber to set
	 */
	public void setInsuranceNumber(int insuranceNumber)
	{
		this.insuranceNumber = insuranceNumber;
	}

	/**
	 * Set patient's date of registration
	 * @param dateOfRegistration the dateOfRegistration to set
	 */
	public void setDateOfRegistration(Date dateOfRegistration)
	{
		this.dateOfRegistration = dateOfRegistration;
	}

	/**
	 * Set patient's date of birth
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Set patient's name
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName)
	{
		this.patientName = patientName;
	}

	/**
	 * Set patient's gender
	 * @param gender the gender to set
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
	}

	/**
	 * Set patient's address
	 * @param address the address to set
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * Set patient's phone number
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Set patient's occupation
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}

	/**
	 * Set isWorking String for patient
	 * @param isWorking the isWorking to set
	 */
	public void setWorking(String isWorking)
	{
		this.isWorking = isWorking;
	}

	/**
	 * Set patient's education
	 * @param education the education to set
	 */
	public void setEducation(String education)
	{
		this.education = education;
	}
	
	/**
	 * Overridden toString() for patient returns patient name
	 */
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
		private String isWorking;
		private String education;

		public Builder()
		{
		}
		
		/**
		 * Builder with id number
		 * @param idNumber Patient's id number
		 * @return Builder object with added id number
		 */
		public Builder withIdNumber(int idNumber)
		{
			this.idNumber = idNumber;
			return this;
		}
		
		/**
		 * Builder with phone number
		 * @param phoneNumber Patient's phone number
		 * @return Builder object with added phone number
		 */
		public Builder withPhoneNumber(String phoneNumber)
		{
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		/**
		 * Builder with social security number
		 * @param sSN Patient's social security number
		 * @return Builder object with added social security number
		 */
		public Builder withSSN(int sSN)
		{
			this.sSN = sSN;
			return this;
		}
		
		/**
		 * Builder with insurance number
		 * @param insuranceNumber Patient's insurance number
		 * @return Builder object with added insurance number
		 */
		public Builder withInsuranceNumber(int insuranceNumber)
		{
			this.insuranceNumber = insuranceNumber;
			return this;
		}
		
		/**
		 * Builder with date of registration
		 * @param dateOfRegistration Patient's date of registration
		 * @return Builder object with added date of registration
		 */
		public Builder withDateOfRegistration(Date dateOfRegistration)
		{
			this.dateOfRegistration = dateOfRegistration;
			return this;
		}
		
		/**
		 * Builder with date of birth
		 * @param dateOfBirth Patient's date of birth
		 * @return Builder object with added date of birth
		 */
		public Builder withDateOfBirth(Date dateOfBirth)
		{
			this.dateOfBirth = dateOfBirth;
			return this;
		}
		
		/**
		 * Builder with patient name
		 * @param patientName Patient's name
		 * @return Builder object with added name
		 */
		public Builder withPatientName(String patientName)
		{
			this.patientName = patientName;
			return this;
		}
		
		/**
		 * Builder with patient gender
		 * @param gender Patient's gender
		 * @return Builder object with added gender
		 */
		public Builder withGender(String gender)
		{
			this.gender = gender;
			return this;
		}
		
		/**
		 * Builder with patient address
		 * @param address Patient's address
		 * @return Builder object with added address
		 */
		public Builder withAddress(String address)
		{
			this.address = address;
			return this;
		}
		
		/**
		 * Builder with patient occupation
		 * @param occupation Patient's occupation
		 * @return Builder object with added occupation
		 */
		public Builder withOccupation(String occupation)
		{
			this.occupation = occupation;
			return this;
		}
		
		/**
		 * Builder with patient isWorking String
		 * @param isWorking Patient's isWorking String
		 * @return Builder object with added isWorking
		 */
		public Builder withIsWorking(String isWorking)
		{
			this.isWorking = isWorking;
			return this;
		}
		
		/**
		 * Builder with patient education
		 * @param education Patient's education
		 * @return Builder object with added education
		 */
		public Builder withEducation(String education)
		{
			this.education = education;
			return this;
		}
		
		/**
		 * Build PatientModel based on Builder
		 * @return PatientModel with information in Builder
		 */
		public PatientModel build()
		{
			return new PatientModel(this);
		}
	}
}
