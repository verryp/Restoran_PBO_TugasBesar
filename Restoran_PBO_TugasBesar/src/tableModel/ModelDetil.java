/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.DetilTransaksi;
/**
 *
 * @author vrry_
 */
public class ModelDetil extends AbstractTableModel {
    private List<DetilTransaksi> list;

    public ModelDetil(List<DetilTransaksi> list) {
        this.list = list;
    }
    
    public int getColumnCount(){
        return 3;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getMenu().getNama();
            case 2:
                return list.get(rowIndex).getJumlah();
            default :
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "Id Detil";
            case 1:
                return "Menu";
            case 2:
                return "Jumlah";
            default:
                return null;
        }
    }
}
