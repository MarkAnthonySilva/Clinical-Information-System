package clinicalInformationSystem.view;

import java.awt.*;

import javax.swing.*;

import clinicalInformationSystem.DataTableModel;
import clinicalInformationSystem.controller.*;
import clinicalInformationSystem.model.*;

public class PatientListPanel extends JPanel
{
	private PatientList patientList;
	private SystemFrame	frame;
	
	public PatientListPanel(PatientList patientList, SystemFrame frame)
	{
		this.setLayout(new BorderLayout());
		
		this.patientList = patientList;
		this.frame = frame;
		
		JPanel panel = new JPanel();
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
		DataTableModel model = new DataTableModel(data, columnNames);
		table.setModel(model);
		table.setBounds(30, 40, this.getWidth() , this.getHeight());
		
		JScrollPane sp = new JScrollPane(table);
		panel.add(sp);
		
		//Add button Panel
		JPanel buttonPanel 	= new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton edit 	 	= new JButton("Edit");		
		JButton exit	 	= new JButton("Exit");
		
		buttonPanel.add(edit);
		buttonPanel.add(exit);
		
		PatientListController controller = new PatientListController(this, frame);
		edit.addActionListener(controller);
		exit.addActionListener(controller);
		
		this.add(panel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
}
