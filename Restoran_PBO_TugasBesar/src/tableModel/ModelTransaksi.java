/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Transaksi;

/**
 *
 * @author vrry_
 */
public class ModelTransaksi extends AbstractTableModel {
    private List<Transaksi> list;
    
    public ModelTransaksi(List<Transaksi> list)
    {
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 4;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        switch (columnIndex) {
            case 0 :
                return list.get(rowIndex).getId();
            case 1 :
                return list.get(rowIndex).getTanggal();
            case 2 :
                return list.get(rowIndex).getKustomer();
            case 3 :
                return list.get(rowIndex).getPengguna().getNama();
            default:
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch (column) {
            case 0:
                return "Id Trans";
            case 1:
                return "Tanggal";
            case 2:
                return "Kustomer";
            case 3:
                return "Pengguna";
            default:
                return null;
        }
    }
}
