/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emailplus;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vishal
 */
public class DefaultTableStructure extends DefaultTableModel{
    public DefaultTableStructure(Object[][] data,String[] header)
    {
        super(data,header);
    }
    public boolean isCellEditable(int row, int col) {
            return false;
        }
}
