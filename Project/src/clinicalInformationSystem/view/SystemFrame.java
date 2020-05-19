package clinicalInformationSystem.view;

import javax.swing.*;

import clinicalInformationSystem.controller.*;
import clinicalInformationSystem.model.*;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SystemFrame extends JFrame
{
	AuthorizedUsers users;
	boolean userAuthorized;
	
	// Menu Items
	private JMenu patientMenu;
	private JMenu visitMenu;
	
	// Model 
	private PatientList patientList;
	private VisitList visitList;
	
	// Panel
	private JPanel 				currentPanel;
	
	/**
	 * Create the main system frame to be shown to user
	 */
	public SystemFrame()
	{
		super("Clinical Information System");
		currentPanel = new JPanel();
		
		users = new AuthorizedUsers();
		userAuthorized = false;
		
		patientList = new PatientList();
		
		//add a test patient
		try {
			SimpleDateFormat standardDateFormat = new SimpleDateFormat("MM/dd/yyyy");
			PatientModel patient = new PatientModel.Builder()
					.withPatientName("Test patient")
					.withIdNumber(12345)
					.withDateOfBirth(standardDateFormat.parse("01/01/1990"))
					.withGender("male")
					.withPhoneNumber("4081234567")
					.withAddress("111 St San Jose CA 95129 USA")
					.withSSN(123456789)
					.withInsuranceNumber(222222)
					.withDateOfRegistration(standardDateFormat.parse("01/01/2020"))
					.build();
			patientList.addPatient("Test patient", patient);
		}
		catch (ParseException e1)
		{
		}
		//end of add a test patient
		
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
		
		MenuController menuController = new MenuController(this);
		registerListeners(menuController);
		
		//Add Panel to Frame
		this.add(currentPanel);
		
		displayLogIn();
	}
	
	/**
	 * Register the menucontroller for this frame
	 * @param menuController the controller that listens for the actions of the menu
	 */
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
	 * Add an authorized user to use the system
	 * @param username Username of user
	 * @param password Password of user
	 */
	public void addUser(String username, String password)
	{
		users.addAuthorizedUser(username, password);
	}
	
	/**
	 * Repaint frame to display PatientListPanel
	 */
	public void displayPatientList()
	{
		PatientListPanel patientListPanel = new PatientListPanel(this);
		PatientListController controller = new PatientListController(this, patientList, patientListPanel);
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
	 * Display this THI panel for the given visit
	 * @param visit the visit to display the THI panel for
	 */
	public void THI(VisitModel visit)
	{
		THIPanel panel = new THIPanel();
		THIController thiController = new THIController(this, visit, panel);
		this.remove(currentPanel);
		currentPanel = panel;
		this.add(currentPanel);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Display this TFI panel for the given visit
	 * @param visit the visit to display the TFI panel for
	 */
	public void TFI(VisitModel visit)
	{
		TFIPanel panel = new TFIPanel();
		TFIController tfiController = new TFIController(this, visit, panel);
		this.remove(currentPanel);
		currentPanel = panel;
		this.add(currentPanel);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Repaint frame to display Visit
	 * @param visit VisitModel holding details for visit
	 */
	public void displayVisit(VisitModel visit)
	{
		VisitPanel visitPanel = new VisitPanel();
		VisitController visitController = new VisitController(this, visit, visitList, visitPanel);
		this.remove(currentPanel);
		currentPanel = visitPanel;
		this.add(currentPanel);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Repaint frame to display VisitListPanel called by the menu bar. 
	 */
	public void displayVisitList()
	{
		VisitListPanel visitListPanel = new VisitListPanel();
		VisitController visitController = new VisitController(this, visitList, visitListPanel);
		this.remove(currentPanel);
		currentPanel = visitListPanel;
		this.add(currentPanel);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Repaint frame to display VisitListPanel for a certain patient. Called within a Patient panel
	 * @param visitList display this specific visiList
	 */
	public void displayVisitList(VisitList visitList)
	{
		VisitListPanel visitListPanel = new VisitListPanel();
		VisitController visitController = new VisitController(this, visitList, visitListPanel);
		this.remove(currentPanel);
		currentPanel = visitListPanel;
		this.add(currentPanel);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Repaint frame to display AddPatientPanel
	 */
	public void displayAddPatient()
	{
		AddPatientPanel addPatientPanel = new AddPatientPanel();
		AddPatientController controller = new AddPatientController(this, addPatientPanel);
		this.remove(currentPanel);
		currentPanel = addPatientPanel;
		this.add(currentPanel);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * Repaint the frame to display a Patients information
	 */
	public void diplayPatient(PatientModel patient)
	{
		PatientPanel patientPanel 		= new PatientPanel();
		PatientController controller 	= new PatientController(this, patient, patientPanel);
		this.remove(currentPanel);
		currentPanel = patientPanel;
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
	
	/**
	 * @return the visitList
	 */
	public VisitList getVisitList()
	{
		return visitList;
	}
	
	/**
	 * Check if user is authorized in system
	 * @return True = authorized, False = unauthorized
	 */
	public boolean checkAuth()
	{
		return userAuthorized;
	}
	
	/**
	 * Set authorization for system based on parameters
	 * @param username Username for authorization
	 * @param password Password for authorization
	 */
	public void setAuthorized(String username, String password)
	{
		userAuthorized = users.isAuthorized(username, password);
	}
	
	/**
	 * Display error message on this system frame
	 * @param message the error message to displat
	 */
	public void displayErrorMessage(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}
}
