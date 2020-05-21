package clinicalInformationSystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clinicalInformationSystem.model.THIModel;
import clinicalInformationSystem.model.VisitModel;
import clinicalInformationSystem.view.THIPanel;
import clinicalInformationSystem.view.SystemFrame;

public class THIController
{
	private SystemFrame frame;
	private VisitModel visit;
	private THIPanel panel;
	
	/**
	 * Constructs a THIController using SystemFrame, VisitModel, and THIPanel to either display a panel to add THI score or display THI score
	 * @param frame Frame to display the panel for THI score
	 * @param visit Visit to add the THI score to or view THI score
	 * @param panel Panel containing the THI form
	 */
	public THIController(SystemFrame frame, VisitModel visit, THIPanel panel)
	{
		this.frame = frame;
		this.visit = visit;
		this.panel = panel;
		this.panel.setQuestions(THIModel.THIQuestionBank);
		if (this.visit.getTHIModel() != null)
		{
			this.panel.setResults(this.visit.getTHIModel().getAllAnswers());
			this.panel.addActionListener(new THIListener());
		}
		else
		{
			this.panel.addActionListener(new AddTHIListener());
		}
	}
	
	/**
	 * Listens to input on the THI form when adding a THI score to visit
	 * @author benja
	 *
	 */
	private class AddTHIListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if (command.equals("Done"))
			{
				THIModel THI = new THIModel();
				if (panel.allAnswered())
				{
					for (int i = 1; i <= THIModel.THIQuestionBank.length; i++)
					{
						THI.answerQuestion(i, panel.getAnswer(i));
					}
					visit.setTHIModel(THI);
					frame.TFI(visit);
				} else
				{
					panel.displayErrorMessage("Please answer all questions.");
				}
			}
		}
	}
	
	/**
	 * Listens to input on the THI form when viewing a THI score (not adding)
	 * @author benja
	 *
	 */
	private class THIListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			if (command.equals("Done"))
				frame.displayVisit(visit);
		}
	}
}
