package clinicalInformationSystem.view;

import javax.swing.*;

import clinicalInformationSystem.controller.*;
import clinicalInformationSystem.model.*;

import java.awt.*;

public class SystemFrame extends JFrame
{
	
	//Menu Items
	private JMenu patientMenu;
	private JMenu visitMenu;
	
	//Model 
	private PatientList patientList;
	
	//Panel
	private JPanel 				currentPanel;
	
	private AddPatientPanel 	addPatientPanel;
	private PatientListPanel 	patientListPanel;

	 
	/**
	 * Create the main system frame to be shown to user
	 */
	public SystemFrame()
	{
		super("Clinical Information System");
		currentPanel = new JPanel();
		patientList = new PatientList();
		
		//Create Menus and Menu Items
		JMenuBar menuBar = new JMenuBar();
		
		patientMenu = new JMenu("Patient");
		menuBar.add(patientMenu);
		JMenuItem addPatientItem = new JMenuItem("Add Patient");
		JMenuItem viewPatientListItem = new JMenuItem("View Patient List");
		patientMenu.add(addPatientItem);
		patientMenu.add(viewPatientListItem);
		
		visitMenu = new JMenu("Visit");
		menuBar.add(visitMenu);
		JMenuItem addVisitItem = new JMenuItem("Add Visit");
		JMenuItem viewVisitListItem = new JMenuItem("View Visit List");
		visitMenu.add(addVisitItem);
		visitMenu.add(viewVisitListItem);
		
		this.setJMenuBar(menuBar);
		
		//Create all Panels
		this.addPatientPanel = new AddPatientPanel(this);
		
		//Add Panels to Frame
		this.add(currentPanel);
	}
	
	public void registerListeners(MenuController menuController)
	{
		//Register all menu items to be buttons with action listener
		Component[] menuComponetList = patientMenu.getMenuComponents();
		for(Component c: menuComponetList)
		{
			if (c instanceof AbstractButton) 
			{
                AbstractButton button = (AbstractButton) c;
                button.addActionListener(menuController);
            }
		}
		
		menuComponetList = visitMenu.getMenuComponents();
		for(Component c: menuComponetList)
		{
			if (c instanceof AbstractButton) 
			{
                AbstractButton button = (AbstractButton) c;
                button.addActionListener(menuController);
            }
		}
		
	}
	
	/**
	 * Repaint frame to display LogInPanel
	 */
	public void displayLogIn()
	{
		
	}
	
	/**
	 * Repaint frame to display MainMenuPanel
	 */
	public void displayMainMenu()
	{
		
	}
	
	/**
	 * Repaint frame to display PatientListPanel
	 */
	public void displayPatientList()
	{
		this.patientListPanel = new PatientListPanel(patientList, this);
		this.remove(currentPanel);
		currentPanel = patientListPanel;
		this.add(currentPanel);
		this.setVisible(true);
	}
	
	/**
	 * Repaint frame to display VisitListPanel
	 */
	public void displayVisitList()
	{
		
	}
	
	public void displayAddPatient()
	{
		this.remove(currentPanel);
		currentPanel = addPatientPanel;
		this.add(currentPanel);
		this.setVisible(true);
	}

	/**
	 * @return the patientList
	 */
	public PatientList getPatientList()
	{
		return patientList;
	}
}
