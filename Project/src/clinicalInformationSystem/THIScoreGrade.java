package clinicalInformationSystem;

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
