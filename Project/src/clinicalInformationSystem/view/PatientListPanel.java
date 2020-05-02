package clinicalInformationSystem.view;

import javax.swing.*;

import clinicalInformationSystem.model.*;

public class PatientListPanel extends JPanel
{
	private PatientList patientList;
	private SystemFrame	frame;
	
	public PatientListPanel(PatientList patientList, SystemFrame frame)
	{
		this.patientList = patientList;
		this.frame = frame;
		
		String[] columnNames = {"Name", "Gender", "Address"};		// TODO Add More column names if necessary
		
		PatientModel[] patientArray = patientList.getPatientArray();
		String[][] data = new String[patientArray.length][columnNames.length];
		
		for(int row = 0; row < patientArray.length; row++ )
		{
			for(int col = 0; col < columnNames.length; col++)
			{
				if(col == 0)
				{
					data[row][col] = patientArray[row].getPatientName();
				}
				else if(col == 1)
				{
					data[row][col] = patientArray[row].getGender();
				}
				else
				{
					data[row][col] = patientArray[row].getAddress();
				}
			}
		}
		
		JTable table = new JTable(data, columnNames);
		table.setBounds(30, 40, this.getWidth() , this.getHeight());
		
		JScrollPane sp = new JScrollPane(table);
		this.add(sp);
	}
	
}
