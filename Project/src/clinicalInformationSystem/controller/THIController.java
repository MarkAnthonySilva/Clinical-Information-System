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
					frame.displayVisit(visit);
					//frame.addTFI(visit);
				} else
				{
					panel.displayErrorMessage("Please answer all questions.");
				}
			}
		}
	}
	
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
