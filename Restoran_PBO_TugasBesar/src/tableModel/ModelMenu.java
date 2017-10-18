/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Menu;

/**
 *
 * @author Bobby Pratama
 */
public class ModelMenu extends AbstractTableModel{

    private List<Menu> list;

    /**
     * Creates a new instance of ModelDosen
     */
    public ModelMenu(List<Menu> list) {
        this.list = list;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getID();
            case 1:
                return list.get(rowIndex).getNama();
            case 2 :
                return list.get(rowIndex).getHarga();
            case 3 : 
                return list.get(rowIndex).getDeskripsi();
            default:
                return null;
        }
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2 :
                return "Harga";
            case 3 :
                return "Deskripsi";
            default:
                return null;
        }
    }
}
