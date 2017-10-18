/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import dao.TransaksiDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.TableModel;
import model.DetilTransaksi;
import tableModel.ModelTransaksi;
import model.Transaksi;

/**
 *
 * @author daniel
 */
public class TransaksiControl {
    
    TransaksiDAO TD = new TransaksiDAO();
    DetilTransaksiControl DTC = new DetilTransaksiControl();
    
    public void insertTransaksi(Transaksi T) {
        TD.makeConnection();
        TD.insertTransaksi(T);
        
        if (!T.getDT().isEmpty()) {
            for(DetilTransaksi DT : T.getDT()) {
                DTC.insertDetilTransaksi(DT);
            }
        }
        
        TD.closeConnection();
    }
    
    public void DeleteTransaksi(Transaksi T)
    {
        TD.makeConnection();        
        DTC.deleteDetilTransaksiByIdTrans(T.getId());        
        TD.deleteTransaksi(T);
        TD.closeConnection();
    }
    
    /*public Transaksi searchTransaksi(int id) throws SQLException
    {
        Transaksi T = new Transaksi();
        TD.makeConnection();
        T = TD.showSearch(id);
        TD.closeConnection();
        
        return T;
    }*/
    
    public List<Transaksi> showTransaksi() throws SQLException
    {
        TD.makeConnection();
        List<Transaksi> temp = TD.showAll();
        TD.closeConnection();
        return temp;
    }
    
    public TableModel displayTransaksi()
    {
        TD.makeConnection();
        
        
        TableModel modelTrans = new ModelTransaksi(TD.showAll());
        TD.closeConnection();
        
        return modelTrans;
    }
    
    public TableModel displaySeacrhTransaksi(int search){
        TD.makeConnection();
        TableModel modelTrans = new ModelTransaksi(TD.showSearch(search));
        TD.closeConnection();
        return modelTrans;
    }
    
    public Integer getNextId() {
       TD.makeConnection();
       Integer nextId = TD.getNextId();
       TD.closeConnection();
       return nextId;
    }
}
