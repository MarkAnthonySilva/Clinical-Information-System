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
	private static final int YES_SCORE = 4;
	private static final int SOMETIMES_SCORE = 2;
	private static final int NO_SCORE = 0;
	
	private int THIScore;
	
	public enum THIScoreGrade{
		GRADE_1("0-16: Slight or no handicap", 0, 16),
		GRADE_2("18-36: Mild handicap", 18, 36),
		GRADE_3("38-56: Moderate handicap", 38, 56),
		GRADE_4("58-76: Severe handicap", 58, 76),
		GRADE_5("78-100: Catastrophic handicap", 78, 100);
		
		THIScoreGrade(String description, int minScore, int maxScore)
		{
			this.description = description;
			this.minScore = minScore;
			this.maxScore = maxScore;
		}
		
		public String getDescription()
		{
			return description;
		}
		
		public int getMinScore()
		{
			return minScore;
		}
		
		public int getMaxScore()
		{
			return maxScore;
		}
		
		private String description;
		private int minScore;
		private int maxScore;
	}
	
	private HashMap<Integer, Integer> answers; //The key is the number of the Question, Value is the answer
	
	private static final String[] questionBank = {
			"Because of your tinnitus, is it difficult for you to concentrate?",
			"Does the loudness of your tinnitus make it difficult for you to hear people?",
			"Does your tinnitus make you angry?",
			"Does your tinnitus make you feel confused?",
			"Because of your tinnitus, do you feel desperate?",
			"Do you complain a great deal about your tinnitus?",
			"Because of your tinnitus, do you have trouble falling to sleep at night?",
			"Do you feel as though you cannot escape your tinnitus?",
			"Does your tinnitus interfere with your ability to enjoy your social activities (such as going out to dinner, to the movies)?",
			"Because of your tinnitus, do you feel frustrated?",
			"Because of your tinnitus, do you feel that you have a terrible disease?",
			"Does your tinnitus make it difficult for you to enjoy life?",
			"Does your tinnitus interfere with your job or household responsibilities?",
			"Because of your tinnitus, do you find that you are often irritable?",
			"Because of your tinnitus, is it difficult for you to read?",
			"Does your tinnitus make you upset?",
			"Do you feel that your tinnitus problem has placed stress on your relationships with members of your family and friends?",
			"Do you find it difficult to focus your attention away from your tinnitus and on other things?",
			"Do you feel that you have no control over your tinnitus?",
			"Because of your tinnitus, do you often feel tired?",
			"Because of your tinnitus, do you feel depressed?",
			"Does your tinnitus make you feel anxious?",
			"Do you feel that you can no longer cope with your tinnitus?",
			"Does your tinnitus get worse when you are under stress?",
			"Does your tinnitus make you feel insecure?"
	};
	
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
