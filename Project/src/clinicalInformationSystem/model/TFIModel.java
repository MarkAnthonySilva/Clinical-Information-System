package clinicalInformationSystem.model;

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
	
	public static final String[] TFIQuestionBank = {
			"Over the past week, what percentage of your time awake were you consciously AWARE OF your tinnitus? (0 = 0% aware, 10 = 100% aware)",
			"Over the past week, how STRONG or LOUD was your tinnitus? (0 = not at all strong or loud, 10 = extremely strong or loud)",
			"Over the past week, what percentage of your time awake were you ANNOYED by your tinnitus? (0 = none of the time, 10 = all of the time)",
			"Over the past week, did you feel IN CONTROL in regard to your tinnitus? (0 = always in control, 10 = never in control)",
			"Over the past week, how easy was it for you to COPE with your tinnitus? (0 = very easy to cope, 10 = impossible to cope)",
			"Over the past week, how easy was it for you to IGNORE your tinnitus? (0 = very easy to ignore, 10 = impossible to ignore)",
			"Over the past week, how much has your tinnitus interfered with your ability to CONCENTRATE? (0 = did not interfere, 10 = completely interfered)",
			"Over the past week, how much has your tinnitus interfered with your ability to THINK CLEARLY? (0 = did not interfere, 10 = completely interfered)",
			"Over the past week, how much has your tinnitus interfered with your ability to FOCUS ATTENTION on other things besides your tinnitus? (0 = did not interfere, 10 = completely interfered)",
			"Over the past week, how often did your tinnitus make it difficult to FALL ASLEEP or STAY ASLEEP? (0 = never had difficulty, 10 = always had difficulty)",
			"Over the past week, how often did your tinnitus cause you difficulty in getting AS MUCH SLEEP as you needed? (0 = never had difficulty, 10 = always had difficulty)",
			"Over the past week, how much of the time did your tinnitus keep you from SLEEPING as DEEPLY or as PEACEFULLY as you would have liked?? (0 = none of the time, 10 = all of the time)",
			"Over the past week, how much has your tinnitus interfered with your ability to HEAR CLEARLY? (0 = did not interfere, 10 = completely interfered)",
			"Over the past week, how much has your tinnitus interfered with your ability to UNDERSTAND PEOPLE who are talking? (0 = did not interfere, 10 = completely interfered)",
			"Over the past week, how much has your tinnitus interfered with your ability to FOLLOW CONVERSATIONS in a group or at meetings? (0 = did not interfere, 10 = completely interfered)",
			"Over the past week, how much has your tinnitus interfered with your QUIET RESTING ACTIVITIES? (0 = did not interfere, 10 = completely interfered)",
			"Over the past week, how much has your tinnitus interfered with your ability to RELAX? (0 = did not interfere, 10 = completely interfered)",
			"Over the past week, how much has your tinnitus interfered with your ability to enjoy “PEACE AND QUIET”? (0 = did not interfere, 10 = completely interfered)",	
			"Over the past week, how much has your tinnitus interfered with your enjoyment of SOCIAL ACTIVITIES? (0 = did not interfere, 10 = completely interfered)",
			"Over the past week, how much has your tinnitus interfered with your ENJOYMENT OF LIFE? (0 = did not interfere, 10 = completely interfered)",
			"Over the past week, how much has your tinnitus interfered with your RELATIONSHIPS with family, friends and other people? (0 = did not interfere, 10 = completely interfered)",
			"Over the past week, how often did your tinnitus cause you to have difficulty performing your WORK OR OTHER TASKS, such as home maintenance, school work, or caring for children or others? (0 = never had difficulty, 10 = always had difficulty)",		
			"Over the past week, how ANXIOUS or WORRIED has your tinnitus made you feel? (0 = not at all anxious or worried, 10 = extremely anxious or worried)",
			"Over the past week, how BOTHERED or UPSET have you been because of your tinnitus? (0 = not at all bothered or upset, 10 = extremely bothered or upset)",
			"Over the past week, how DEPRESSED were you because of your tinnitus? (0 = not at all depressed, 10 = extremely depressed)",
	};
	
	/**
	 * Constructs a TFI Model with an empty HashMap
	 */
	public TFIModel()
	{
		answers = new HashMap<Integer, Integer>();
	}
	
	/**
	 * Answer the question corresponding to the question number with the given response
	 * @param question the question to answer (1 - 25)
	 * @param response the answer to the question (0 - 10)
	 * @return True = question answered; False = question not answered
	 */
	public boolean answerQuestion(int questionNumber, int response)
	{
		if (questionNumber > TFIQuestionBank.length || questionNumber < 1)
			return false;
		answers.put(questionNumber, response);	
		return true;
	}
	
	public int getAnswer(int questionNumber)
	{
		if(answers.get(questionNumber) == null)
			return -1;
		return answers.get(questionNumber);
	}
	
	public int[] getAllAnswers()
	{
		int[] allAnswers = new int[TFIQuestionBank.length];
		for (int i = 1; i <= TFIQuestionBank.length; i++)
		{
				allAnswers[i - 1] = getAnswer(i);
		}
		return allAnswers;
	}
	
	/**
	 * Check if all questions have been answered
	 * @return True = all questions answered, False = one or more questions unanswered
	 */
	private boolean allQuestionsAnswered()
	{
		for (int i = 1; i <= TFIQuestionBank.length; i++) {
			if (answers.get(i) == null)
				return false;
		}
		return true;
	}
	
	/**
	 * Calculates the severity of the handicap of the Tinnitus depending on the answers to the
	 * questionnaire. Requires that less than 7 of the questions have been ommited from the 25 questions.
	 * In other words, at least 19 questions (76%) must be answered.
	 * @return the overall TFI score from the questionnaire 
	 */
	public int calculateSeverity()
	{
		int omissions = 0;
		double sum = 0;
		for(int i = 1; i <= 25; i++)
		{
			if(answers.get(i) == null)
				omissions++;
			else
				sum += answers.get(i);
		}
		
		if(omissions < 7)
		{
			double IScore = sum / (25 - omissions) * 10;
			return (int)IScore;
		}
		return -1;
	}
	
	//Subscale scores calculations
	
	/**
	 * Calculate the subscale score for INTRUSIVE using the questions #1, 2, 3.
	 * @return the subscale score for INTRUSIVE. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateI()
	{
		int omissions = 0;
		double sum = 0;
		for(int i = 1; i <= 3; i++)
		{
			if(answers.get(i) == null)
				omissions++;
			else
				sum += answers.get(i);
		}
		
		if(omissions <= 1)
		{
			double IScore = sum / (3 - omissions) * 10;
			return (int)IScore;
		}
		return -1;
	}
	
	/**
	 * Calculate the subscale score for SENSE OF CONTROL using the questions #4, 5, 6.
	 * @return the subscale score for SENSE OF CONTROL. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateSC()
	{
		int omissions = 0;
		double sum = 0;
		for(int i = 4; i <= 6; i++)
		{
			if(answers.get(i) == null)
				omissions++;
			else
				sum += answers.get(i);
		}
		
		if(omissions <= 1)
		{
			double SCScore = sum / (3 - omissions) * 10;
			return (int)SCScore;
		}
		return -1;
	}
	
	/**
	 * Calculate the subscale score for COGNITIVE using the questions #7, 8, 9.
	 * @return the subscale score for COGNITIVE. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateC()
	{
		int omissions = 0;
		double sum = 0;
		for(int i = 7; i <= 9; i++)
		{
			if(answers.get(i) == null)
				omissions++;
			else
				sum += answers.get(i);
		}
		
		if(omissions <= 1)
		{
			double CScore = sum / (3 - omissions) * 10;
			return (int)CScore;
		}
		return -1;
	}
	
	/**
	 * Calculate the subscale score for SLEEP using the questions #10, 11, 12.
	 * @return the subscale score for SLEEP. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateSL()
	{
		int omissions = 0;
		double sum = 0;
		for(int i = 10; i <= 12; i++)
		{
			if(answers.get(i) == null)
				omissions++;
			else
				sum += answers.get(i);
		}
		
		if(omissions <= 1)
		{
			double SLScore = sum / (3 - omissions) * 10;
			return (int)SLScore;
		}
		return -1;
	}
	
	/**
	 * Calculate the subscale score for AUDITORY using the questions #13, 14, 15.
	 * @return the subscale score for AUDITORY. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateA()
	{
		int omissions = 0;
		double sum = 0;
		for(int i = 13; i <= 15; i++)
		{
			if(answers.get(i) == null)
				omissions++;
			else
				sum += answers.get(i);
		}
		
		if(omissions <= 1)
		{
			double AScore = sum / (3 - omissions) * 10;
			return (int)AScore;
		}
		return -1;
	}
	
	/**
	 * Calculate the subscale score for RELAXIATION using the questions #16, 17, 18.
	 * @return the subscale score for RELAXIATION. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateR()
	{
		int omissions = 0;
		double sum = 0;
		for(int i = 16; i <= 18; i++)
		{
			if(answers.get(i) == null)
				omissions++;
			else
				sum += answers.get(i);
		}
		
		if(omissions <= 1)
		{
			double RScore = sum / (3 - omissions) * 10;
			return (int)RScore;
		}
		return -1;
	}
	
	/**
	 * Calculate the subscale score for QUALITY OF LIFE using the questions #19, 20, 21, 22.
	 * @return the subscale score for QUALITY OF LIFE. Only one question can be ommitted
	 * to calculate the subscale score.
	 */
	public int calculateQ()
	{
		int omissions = 0;
		double sum = 0;
		for(int i = 19; i <= 22; i++)
		{
			if(answers.get(i) == null)
				omissions++;
			else
				sum += answers.get(i);
		}
		
		if(omissions <= 1)
		{
			double QScore = sum / (4 - omissions) * 10;
			return (int)QScore;
		}
		return -1;
	}
	
	/**
	 * Calculate the subscale score for EMOTIONAL using the questions #23, 24, 25
	 * @return the subscale score for EMOTIONAL. Only one question can be omitted
	 * to calculate the subscale score.
	 */
	public int calculateE()
	{
		int omissions = 0;
		double sum = 0;
		for(int i = 23; i <= 25; i++)
		{
			if(answers.get(i) == null)
				omissions++;
			else
				sum += answers.get(i);
		}
		
		if(omissions <= 1)
		{
			double EScore = sum / (3 - omissions) * 10;
			return (int)EScore;
		}
		return -1;
	}
}
