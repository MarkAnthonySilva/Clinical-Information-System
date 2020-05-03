package clinicalInformationSystem;

import javax.swing.table.DefaultTableModel;

public class DataTableModel extends DefaultTableModel
{
	public DataTableModel(String[][] data, String[] columnnames) {
		super(data, columnnames);
	}

	public boolean isCellEditable(int row, int column)
	{
		return false;
	}
}
