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
	
	private HashMap<Integer, Integer> answers;
	
	//click through faster for testing purposes
	/*
	public static final String[] THIQuestionBank = {
			"Because of your tinnitus, is it difficult for you to concentrate?"};
	*/
	
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
	 * @param response the answer to the question (Yes, Sometimes, No)
	 * @return True = question answered; False = question not answered
	 */
	public boolean answerQuestion(int questionNumber, String response)
	{
		if (questionNumber > THIQuestionBank.length || questionNumber < 1)
			return false;
		switch(response.toLowerCase())
		{
		case "yes":
			answers.put(questionNumber, YES_SCORE);
			return true;
		case "sometimes":
			answers.put(questionNumber, SOMETIMES_SCORE);
			return true;
		case "no":
			answers.put(questionNumber, NO_SCORE);
			return true;
		}
		return false;
	}
	
	public String getAnswer(int questionNumber)
	{
		switch(answers.get(questionNumber))
		{
		case YES_SCORE:
			return "Yes";
		case SOMETIMES_SCORE:
			return "Sometimes";
		case NO_SCORE:
			return "No";
		}
		return null;
	}
	
	public String[] getAllAnswers()
	{
		if (allQuestionsAnswered())
		{
			String[] allAnswers = new String[THIQuestionBank.length];
			for (int i = 1; i <= THIQuestionBank.length; i++)
			{
				allAnswers[i - 1] = getAnswer(i);
			}
			return allAnswers;
		}
		return null;
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
			int THIScore = 0;
			for (int i = 1; i <= THIQuestionBank.length; i++) {
				THIScore += answers.get(i);
			}
			return THIScore;
		}
		return -1;
	}
}
