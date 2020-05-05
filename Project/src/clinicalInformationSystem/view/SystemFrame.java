package clinicalInformationSystem.view;

import javax.swing.*;

import clinicalInformationSystem.controller.*;
import clinicalInformationSystem.model.*;

import java.awt.*;

public class SystemFrame extends JFrame
{
	AuthorizedUsers users;
	boolean userAuthorized;
	
	//Menu Items
	private JMenu patientMenu;
	private JMenu visitMenu;
	
	//Model 
	private PatientList patientList;
	private VisitList visitList;
	
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
		
		users = new AuthorizedUsers();
		users.addAuthorizedUser("admin", "admin");
		userAuthorized = false;
		
		patientList = new PatientList();
		visitList = new VisitList();
		
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
		
		//Add Panel to Frame
		this.add(currentPanel);
		
		displayLogIn();
	}
	
	public void registerListeners(MenuController menuController)
	{
		//Register all menu items to be buttons with action listener
		Component[] menuComponentList = patientMenu.getMenuComponents();
		for(Component c: menuComponentList)
		{
			if (c instanceof AbstractButton)
			{
                AbstractButton button = (AbstractButton) c;
                button.addActionListener(menuController);
            }
		}
		
		menuComponentList = visitMenu.getMenuComponents();
		for(Component c: menuComponentList)
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
		LogInPanel logInPanel = new LogInPanel();
		LogInController logInController = new LogInController(this, users, logInPanel);
		this.remove(currentPanel);
		currentPanel = logInPanel;
		this.add(currentPanel);
		this.pack();
		this.setVisible(true);
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
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Repaint frame to display AddVisitPanel
	 */
	public void displayAddVisit()
	{
		AddVisitPanel addVisitPanel = new AddVisitPanel();
		VisitController visitController = new VisitController(this, patientList, visitList, addVisitPanel);
		this.remove(currentPanel);
		currentPanel = addVisitPanel;
		this.add(currentPanel);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Repaint frame to display VisitListPanel
	 */
	public void displayVisitList()
	{
		VisitListPanel visitListPanel = new VisitListPanel();
		VisitController visitController = new VisitController(visitList, visitListPanel);
		this.remove(currentPanel);
		currentPanel = visitListPanel;
		this.add(currentPanel);
		this.pack();
		this.setVisible(true);
	}
	
	public void displayAddPatient()
	{
		this.addPatientPanel = new AddPatientPanel(this);
		this.remove(currentPanel);
		currentPanel = addPatientPanel;
		this.add(currentPanel);
		this.pack();
		this.setVisible(true);
	}

	/**
	 * @return the patientList
	 */
	public PatientList getPatientList()
	{
		return patientList;
	}
	
	public boolean checkAuth()
	{
		return userAuthorized;
	}
	
	public void setAuthorized(String username, String password)
	{
		userAuthorized = users.isAuthorized(username, password);
	}
}
