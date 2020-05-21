package clinicalInformationSystem;

import javax.swing.table.DefaultTableModel;

/**
 * Custom table model for use on data table
 * @author benja
 *
 */
public class DataTableModel extends DefaultTableModel
{
	/**
	 * Construct custom DataTableModel
	 * @param data Data for table
	 * @param columnnames Column names for table
	 */
	public DataTableModel(String[][] data, String[] columnnames) {
		super(data, columnnames);
	}
	
	/**
	 * Make all cells not editable in table
	 */
	public boolean isCellEditable(int row, int column)
	{
		return false;
	}
}
