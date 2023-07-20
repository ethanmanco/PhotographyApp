package photographyapp;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ethan
 */

public class TheModel extends AbstractTableModel {
    private String[] columns;
    private Object[][] rows;
    
    public TheModel(){}
    
    public TheModel(Object[][] data, String[] columnName){
    
        this.rows = data;
        this.columns = columnName;
    }
    
    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
            case 6: return ImageIcon.class;
            default: return Object.class;
        }
    }
    
    
    @Override
    public int getRowCount() {
     return this.rows.length;
    }

    @Override
    public int getColumnCount() {
     return this.columns.length;
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];
    }
    
    @Override
    public String getColumnName(int col){
        return this.columns[col];
    }

}
