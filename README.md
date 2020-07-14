# S20-CS151-2-Team9

How to use the Clinical Information System:
1) Import the project into desired IDE (e.g. Eclipse).
2) Open the SystemTester.java file which provides the main method to run.
3) Add a new line with the command frame.addUser(username, password) to add a new user that will be able to login to the system
	(where username and password is the username and password used to login in quotation marks)
4) Run the SystemTester.java file which will open the JFrame representing the Clinical Information System.
5) The initial screen is a login screen where you enter the username and password specified in step 3 and press the "Log In" button.
	Default Username: admin
	Default Password: admin

Navigating the Clinical Information System once logged in:
1) There are two drop down menus each containing two actions that will be usable once logged in:
	- Patient
		- Add Patient: Adds a new patient. (More information in Step 1-1)
		- View Patient List: View all patients that have been added. (More information in Step 1-2)
	- Visit
		- Add Visit: Adds a visit for a specific patient. (More information in Step 1-3)
		- View Visit List: View all visits that have been added. (More information in Step 1-4)

1-1) Add Patient Panel: All required fields need to be filled out for a patient to be added.
	Required fields are marked with an asterisk ("*").
	Fields that require a numerical input to be added include: ID Number, Social Security Number, and Insurance Number
	Fields that require a date formatted as mm/dd/yyyy include: Date of Birth and Register Date
	All other fields are plain text format.
	Once a patient is added by clicking the "Submit" button, you will be taken to the Patient List panel which you can also get to by clicking "View Patient List" in the Patient dropdown menu.
	You can also click the "Exit" button to exit the panel and return to a blank frame with only the menu dropdowns.

1-2) View Patient List Panel: All patients that have been added will be shown in this panel in a table displaying the Name, ID Number, and Phone Number for each patient.
	You can click on a row corresponding to a specific patient which will take you to a panel displaying all the information about that patient. (More information on this panel in Step 1-5).
	When clicking the "Exit" button, you exit the panel and return to a blank frame with only the menu dropdowns.

1-3) Add Visit Panel: Add a visit
	Choose the patient you are adding the visit for in the dropdown menu. If the desired patient is a new patient, add the patient first via the "Add Patient" option and then come back to Add Visit panel.
	Type the date of the visit as well as the sequence number corresponding to the visit.
	Then, press the "Add THI/TFI" button to add the THI and TFI scores to the visit.
	You can also press the "Exit" button to exit the panel and return to a blank frame with only the menu dropdowns.
	Once finished with the THI and TFI menus, it will take you to the detailed view of the visit. (More information on this panel in Step 1-6).

1-4) View Visit List: All visits that have been added will be shown in this panel in a table displaying the Patient Name, Date of the Visit, and the Visit's Sequence Number.
	You can click on a row corresponding to a specific visit which will take you to a panel displaying all the information about that visit. (More information on this panel in Step 1-6).
	When clicking the "Exit" button, you exit the panel and return to a blank frame with only the menu dropdowns.

1-5) Patient Information: Displays all the information related to that patient.
	This panel by default is uneditable and displays all previously entered information.
	Edit/Submit button: Toggles editability of all fields and saves information when "Submit" is pressed.
	Delete: Delete the patient.
	Visits: Show all visits corresponding to the patient.
	Exit: Exit the panel and return to a blank frame with only the menu dropdowns.

1-6) Visit Information: Displays all the information related to that visit as well as calculated THI and TFI scores.
	This panel by default is uneditable and displays all previously entered information.
	Edit/Done button: Toggles editability of all fields and saves information when "Done" is pressed.
	View THI: View the THI form filled out when adding the visit.
	View TFI: View the TFI form filled out when adding the visit.
	Delete: Delete the visit.
	Exit: Exit the panel and return to a blank frame with only the menu dropdowns.
	Back to Visits: Return to the previous list of visits.