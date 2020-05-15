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
		GRADE_1("Grade 1: Slight or no handicap", 0, 16),
		GRADE_2("Grade 2: Mild handicap", 18, 36),
		GRADE_3("Grade 3: Moderate handicap", 38, 56),
		GRADE_4("Grade 4: Severe handicap", 58, 76),
		GRADE_5("Grade 5: Catastrophic handicap", 78, 100);
		
		THIScoreGrade(String description, int minScore, int maxScore)
		{
			this.description = description;
			this.minScore = minScore;
			this.maxScore = maxScore;
		}
		
		public static final THIScoreGrade getGrade(int score)
		{
			if (score > THIScoreGrade.GRADE_5.getMaxScore() || score < THIScoreGrade.GRADE_1.getMinScore())
				return null;
			else if ((score % 2) != 0)
				return null;
			else if (score >= THIScoreGrade.GRADE_5.getMinScore())
				return THIScoreGrade.GRADE_5;
			else if (score >= THIScoreGrade.GRADE_4.getMinScore())
				return THIScoreGrade.GRADE_4;
			else if (score >= THIScoreGrade.GRADE_3.getMinScore())
				return THIScoreGrade.GRADE_3;
			else if (score >= THIScoreGrade.GRADE_2.getMinScore())
				return THIScoreGrade.GRADE_2;
			else if (score >= THIScoreGrade.GRADE_1.getMinScore())
				return THIScoreGrade.GRADE_1;
			else
				return null;
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
	
	private HashMap<Integer, Integer> answers;			// Key = question number; Value = answer
	
	public static final String[] THIQuestionBank = {
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
	 * Constructs a THI Model with an empty HashMap for answers
	 */
	public THIModel()
	{
		answers = new HashMap<Integer, Integer>();
	}
	
	/**
	 * Answer the question corresponding to the question number with the given response
	 * @param question the question to answer (1 - 25)
	 * @param response the answer to the question (0, 2, 4)
	 * @return True = question answered; False = question not answered
	 */
	public boolean answerQuestion(int questionNumber, int response)
	{
		if (questionNumber > THIQuestionBank.length || questionNumber < 1)
			return false;
		else if (response == YES_SCORE || response == SOMETIMES_SCORE || response == NO_SCORE)
		{
			answers.put(questionNumber, response);
			return true;
		}
		return false;
	}
	
	/**
	 * Check if all questions have been answered
	 * @return True = all questions answered, False = one or more questions unanswered
	 */
	private boolean allQuestionsAnswered()
	{
		for (int i = 1; i <= THIQuestionBank.length; i++) {
			if (answers.get(i) == null)
				return false;
		}
		return true;
	}
	
	/**
	 * Calculates the severity of the handicap of the Tinnitus depending on the answers to the
	 * questionnaire
	 * @return the THI score from the questionnaire (if -1 is returned, then all questions were not answered)
	 */
	public int calculateSeverity()
	{
		if(allQuestionsAnswered())
		{
			int tempScore = 0;
			for (int i = 1; i <= THIQuestionBank.length; i++) {
				tempScore += answers.get(i);
			}
			THIScore = tempScore;
			return THIScore;
		}
		return -1;
	}
}
