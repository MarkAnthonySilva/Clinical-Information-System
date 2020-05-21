package clinicalInformationSystem.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import clinicalInformationSystem.DataTableModel;
import clinicalInformationSystem.controller.*;
import clinicalInformationSystem.model.*;

/**
 * JPanel to display a PatientList
 * @author benja
 *
 */
public class PatientListPanel extends JPanel
{
	private SystemFrame	frame;
	
	private JButton exit;
	private JTable table;
	
	/**
	 * Constructs a PatientList panel that displays all the patients stored in the system
	 * @param patientList the patient list to displau
	 * @param frame the frame to display the patientList
	 */
	public PatientListPanel(SystemFrame frame)
	{
		this.setLayout(new BorderLayout());
		
		PatientList patientList = frame.getPatientList();
		this.frame = frame;
		
		JPanel panel = new JPanel();
		String[] columnNames = {"Name", "Id Number", "Phone Number"};		// TODO Add More column names if necessary
		
		PatientModel[] patientArray = patientList.getPatientArray();
		String[][] data = new String[patientArray.length][columnNames.length];
		
		for (int row = 0; row < patientArray.length; row++ )
		{
			for (int col = 0; col < columnNames.length; col++)
			{
				if (col == 0)
				{
					data[row][col] = patientArray[row].getPatientName();
				}
				else if (col == 1)
				{
					data[row][col] = Integer.toString(patientArray[row].getIdNumber());
				}
				else
				{
					data[row][col] = patientArray[row].getPhoneNumber();
				}
			}
		}
		
		this.table = new JTable(data, columnNames);
		DataTableModel model = new DataTableModel(data, columnNames);
		table.setModel(model);
		table.setBounds(30, 40, this.getWidth() , this.getHeight());
		
		JScrollPane sp = new JScrollPane(table);
		panel.add(sp);
		
		// Add button Panel
		JPanel buttonPanel 	= new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		exit = new JButton("Exit");		
		
		buttonPanel.add(exit);
		
		this.add(panel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Add listener to the actions that can be done on this panel
	 * @param listener the listener to listen to all the actions on this panel
	 */
	public void addListener(ActionListener listener)
	{
		table.getSelectionModel().addListSelectionListener((ListSelectionListener) listener);
		exit.addActionListener(listener);
	}
	
	/**
	 * Get the selected row in the table
	 * @return Selected row
	 */
	public int getSelectedRow()
	{
		return table.getSelectedRow();
	}
	
}
