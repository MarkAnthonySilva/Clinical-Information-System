package clinicalInformationSystem.model;
import java.util.*;

/**
 * List of patients registered to this clinical information system.
 * The patients are ordered by their names.
 * @author Team 9
 *
 */
public class PatientList
{
	private TreeMap<String, PatientModel> patientList;		// Key = Patient Name; Value = Associated PatientModel
	
	/**
	 * Constructs a PatientList with an empty TreeMap
	 */
	public PatientList()
	{
		patientList = new TreeMap<>();
	}
	
	/**
	 * Add a patient to this list of Patients
	 * @param name the name of the patient to be used as the key
	 * @param p the patient to add to this list
	 */
	public void addPatient(String name, PatientModel p)
	{
		patientList.put(name, p);
	}
	
	/**
	 * Get the patient associated with the given name
	 * @param name the name of the patient to be return
	 * @return the PatientModel associated with the given name
	 */
	public PatientModel getPatient(String name)
	{
		return patientList.get(name);
	}
	
	/**
	 * Get an array representation of the patientList
	 * @return an array representation of the patientList
	 */
	public PatientModel[] getPatientArray()
	{
		Collection<PatientModel> values = patientList.values();
		return values.toArray(new PatientModel[values.size()]);
	}
	
	/**
	 * Get a tree map representation of this patient list
	 * @return a tree map representation of this patient list
	 */
	public TreeMap<String, PatientModel> getMap()
	{
		return this.patientList;
	}
}
