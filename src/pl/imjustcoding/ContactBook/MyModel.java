package pl.imjustcoding.ContactBook;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;


//create a table model to display the contacts images in jtable
public class MyModel extends AbstractTableModel {

    private String[] columns;
    private Object[][] rows;
    
    public MyModel(){}
    
    public MyModel(Object[][] data, String[] columnsName){
        this.columns=columnsName;
        this.rows=data;
    }
    
    public Class getColumnClass(int col){
        //the index of the image column is 8
        if(col==8){
            return Icon.class;
        }else{
            return getValueAt(0,col).getClass();
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
