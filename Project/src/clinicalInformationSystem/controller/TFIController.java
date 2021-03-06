package clinicalInformationSystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clinicalInformationSystem.model.*;
import clinicalInformationSystem.view.*;

/**
 * Controller for adding TFI to a visit
 * @author benja
 *
 */
public class TFIController {

	private SystemFrame frame;
	private VisitModel visit;
	private TFIPanel panel;
	private boolean filledOut;
	
	/**
	 * Constructs a TFIController using SystemFrame, VisitModel, and TFIPanel to either display a panel to add TFI score or display TFI scores
	 * @param frame Frame to display the panel for TFI score
	 * @param visit Visit to add the TFI score to or view TFI scores
	 * @param panel Panel containing the TFI form
	 */
	public TFIController(SystemFrame frame, VisitModel visit, TFIPanel panel)
	{
		this.frame = frame;
		this.visit = visit;
		this.panel = panel;
		this.panel.setQuestions(TFIModel.TFIQuestionBank);
		filledOut = false;
		if (this.visit.getTFIModel() != null)
		{
			this.panel.setResults(this.visit.getTFIModel().getAllAnswers());
			this.panel.setScores(this.visit.getTFIModel().calculateAll());
			this.panel.addActionListener(new TFIListener());
		}
		else
		{
			this.panel.addActionListener(new AddTFIListener());
		}
	}
	
	/**
	 * Listens to input on the TFI form when adding a TFI score to visit
	 * @author benja
	 *
	 */
	private class AddTFIListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if (command.equals("Done"))
			{
				if (filledOut == false)
				{
					TFIModel TFI = new TFIModel();
					if (panel.omissions() < 7)
					{
						for (int i = 1; i <= TFIModel.TFIQuestionBank.length; i++)
						{
							if (!panel.getAnswer(i).equals(""))
							{
								try
								{
									int answer = Integer.parseInt(panel.getAnswer(i));
									if (answer < 0 || answer > 10)
									{
										panel.displayErrorMessage(String.format("Question %d has invalid input. Please enter an integer number beween 0 and 10.", i));
										return;
									}
									TFI.answerQuestion(i, answer);
								}
								catch (NumberFormatException ex)
								{
									panel.displayErrorMessage(String.format("Question %d has invalid input. Please enter an integer number beween 0 and 10.", i));
									return;
								}
							}
							else
							{
								TFI.answerQuestion(i, -1);
							}
						}
						visit.setTFIModel(TFI);
						
						// Calculate scores
						int[] scores = TFI.calculateAll();
						panel.setScores(scores);
						panel.displayErrorMessage("Note: a subscore of -1 means that there were too many omissions for that subcategory. Click 'Done' again to return to Visits.");
						filledOut = true;
					}
					else
					{
						panel.displayErrorMessage("Please omit less than 7 questions.");
					}
				}
				else
				{
					frame.displayVisit(visit);
				}
			}
		}
	}
	
	/**
	 * Listens to input on the TFI form when viewing a TFI score (not adding)
	 * @author benja
	 *
	 */
	private class TFIListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if (command.equals("Done"))
				frame.displayVisit(visit);
		}
	}
}
