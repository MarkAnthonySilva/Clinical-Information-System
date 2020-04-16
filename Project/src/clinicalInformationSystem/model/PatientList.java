package clinicalInformationSystem.model;
import java.util.TreeMap;

/**
 * List of patients registered to this clinical information system.
 * The patients are ordered by their names.
 * @author Team 9
 *
 */
public class PatientList
{
	private TreeMap<String, PatientModel> listOfPatients;  //Key the name of the Patient, Value the PatientModel
	
	/**
	 * Contructs a PatientList with an empty TreeMap
	 */
	public PatientList()
	{
		//To be Implemented
	}
	
	/**
	 * Add a patient to this list of Patients
	 * @param name the name of the patient to be used as the key
	 * @param p the patient to add to this list
	 */
	public void addPatient(String name, PatientModel p)
	{
		//To be Implemented
	}
	
	/**
	 * Get the patient associated with the given name
	 * @param name the name of the patient to be return
	 * @return the PatientModel associated with the given name
	 */
	public PatientModel getPatient(String name)
	{
		//To be implemented
		return null;
	}
}
