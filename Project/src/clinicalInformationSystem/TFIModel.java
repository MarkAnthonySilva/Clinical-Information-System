package clinicalInformationSystem;

import java.util.HashMap;

/**
 * The Model for the Tinnitus Functional Inventory(TFI).
 * It holds all the answers to the TFI and also calculates the TFI Overall and Subscale Scores 
 * from the questionnaire
 * @author Team 9
 *
 */
public class TFIModel
{
	private HashMap<Integer, Integer> answers; //The key is the number of the Question, Value is the answer
	
	/**
	 * Constructs a TFI Model with an empty HashMap
	 */
	public TFIModel()
	{
		//To be implemented
	}
	
	/**
	 * Answer the question corresponding to the question number with the given response
	 * @param question the question to answer (1 - 25)
	 * @param response the answer to the question (0 - 10)
	 */
	public void answerQuestion(int questionNumber, int response)
	{
		//To be implemented
	}
	
	/**
	 * Calculates the severity of the handicap of the Tinnitus depending on the answers to the
	 * questionnaire. Requires that only 7 of the questions have been ommited from the 25 questions.
	 * In other words, at least 19 questions (76%) must be answered.
	 * @return the overall TFI score from the questionnaire 
	 */
	public int calculateSeverity()
	{
		//To be implemented
		return 0;
		
	}
	
	//Subscale scores calculations
	
	/**
	 * Calculate the subscale score for INTRUSIVE using the questions #1, 2, 3.
	 * @return the subscale score for INTRUSIVE. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateI()
	{
		//To be implemented
		return 0;
	}
	
	/**
	 * Calculate the subscale score for SENSE OF CONTROL using the questions #4, 5, 6.
	 * @return the subscale score for SENSE OF CONTROL. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateSC()
	{
		//To be implemented
		return 0;
	}
	
	/**
	 * Calculate the subscale score for COGNITIVE using the questions #7, 8, 9.
	 * @return the subscale score for COGNITIVE. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateC()
	{
		//To be implemented
		return 0;
	}
	
	/**
	 * Calculate the subscale score for SLEEP using the questions #10, 11, 12.
	 * @return the subscale score for SLEEP. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateSL()
	{
		//To be implemented
		return 0;
	}
	
	/**
	 * Calculate the subscale score for AUDITORY using the questions #13, 14, 15.
	 * @return the subscale score for AUDITORY. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateA()
	{
		//To be implemented
		return 0;
	}
	
	/**
	 * Calculate the subscale score for RELAXIATION using the questions #16, 17, 18.
	 * @return the subscale score for RELAXIATION. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateR()
	{
		//To be implemented
		return 0;
	}
	
	/**
	 * Calculate the subscale score for QUALITY OF LIFE using the questions #19, 20, 21, 22.
	 * @return the subscale score for QUALITY OF LIFE. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateQ()
	{
		//To be implemented
		return 0;
	}
	
	/**
	 * Calculate the subscale score for EMOTIONAL using the questions #19, 20, 21, 22.
	 * @return the subscale score for EMOTIONAL. Only one question can be omitted
	 * to calculate the subscale score.
	 */
	public int calculateE()
	{
		//To be implemented
		return 0;
	}
}
