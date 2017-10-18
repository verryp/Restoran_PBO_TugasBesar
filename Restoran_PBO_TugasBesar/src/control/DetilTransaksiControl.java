package control;

import dao.DetilTransaksiDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.text.html.HTML;
import model.DetilTransaksi;
import tableModel.ModelDetil;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bobby Pratama
 */
public class DetilTransaksiControl {
     DetilTransaksiDAO DTO = new DetilTransaksiDAO();
    
    public void insertDetilTransaksi(DetilTransaksi DT) {
       
        DTO.makeConnection();
        DTO.insertDetilTransaksi(DT);                        
        DTO.closeConnection();
        
        
    }
    
    public void DeleteDetilTransaksi(int id)
    {
        DTO.makeConnection();
        DTO.deleteDetilTransaksi(id);
        DTO.closeConnection();
    }
    
    public void deleteDetilTransaksiByIdTrans(int id) {
        DTO.makeConnection();
        DTO.deleteDetilTransaksiByIdTrans(id);
        DTO.closeConnection();
    }
    
    public TableModel displayDetilTrans(){
        DTO.makeConnection();
        TableModel modelDetil = new ModelDetil(DTO.showAll());
        DTO.closeConnection();
        
        return modelDetil;   
    }
    
    public TableModel displayDetilTransById(Integer id){
        DTO.makeConnection();
        TableModel modelDetil = new ModelDetil(DTO.showById(id));
        DTO.closeConnection();
        
        return modelDetil;   
    }
    
    public TableModel displaySeacrhDetilTrans(int id){
        DTO.makeConnection();
        TableModel modelDetil = new ModelDetil(DTO.showSearchDetil(id));
        DTO.closeConnection();
        
        return modelDetil;
    }
    
    public double getHargaMenu(int idmenu){
        double temp = 0;
        DTO.makeConnection();
        temp = DTO.getHarga(idmenu);
        DTO.closeConnection();
        
        return temp;
    }
    
    public Integer getNextId() {
       DTO.makeConnection();
       Integer nextId = DTO.getNextId();
       DTO.closeConnection();
       return nextId;
    }
}
