package clinicalInformationSystem.model;

import java.util.HashMap;

/**
 * The Model for the Tinnitus Handicap Inventory(THI).
 * It holds all the answers to the THI and also calculates the THI Score which indicates how
 * Tinnitus handicaps a patient. 
 * @author Team 9
 *
 */
public class THIModel
{
	private HashMap<Integer, Integer> answers; //The key is the number of the Question, Value is the answer
	
	/**
	 * Constructs a THI Model with an empty HashMap
	 */
	public THIModel()
	{
		//To be implemented
	}
	
	/**
	 * Answer the question corresponding to the question number with the given response
	 * @param question the question to answer (1 - 25)
	 * @param response the answer to the question (0, 2, 4)
	 */
	public void answerQuestion(int questionNumber, int response)
	{
		//To be implemented
	}
	
	/**
	 * Calculates the severity of the handicap of the Tinnitus depending on the answers to the
	 * questionnaire
	 * @return the THI score from the questionnaire 
	 */
	public int calculateSeverity()
	{
		//To be implemented
		return 0;
		
	}
}
