/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import model.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Eka Juliantara
 */
public class ModelPengguna extends AbstractTableModel{
    private List<Pengguna> list;

    public ModelPengguna(List<Pengguna> list) {
        this.list = list;
    }        

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getUsername();
            case 3:
                return list.get(rowIndex).getPeran().getNama();
            default:
                return null;
        }
    }    
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Username";  
            case 3:
                return "Peran";
            default:
                return null;
        }
    }
}
