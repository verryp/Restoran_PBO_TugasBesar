/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import dao.MenuDAO;
import model.Menu;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.TableModel;
import tableModel.ModelMenu;

/**
 *
 * @author daniel
 */
public class MenuControl {
    
    private MenuDAO MD = new MenuDAO();
    
    //Memasukan Menu ke database
    public void insertMenu(Menu M) {
        
        MD.makeConnection();;
        MD.InsertMenu(M);
        MD.closeConnection();
    }
    
    public void deleteMenu(int id)
    {
       MD.makeConnection();
       MD.deleteMenu(id);
       MD.closeConnection();
    }
    
    public void UpdateMenu(Menu M) 
    {
        MD.makeConnection();
        MD.UpdateMenu(M);
        MD.closeConnection();
    }
    public TableModel showMenu(Integer id) {
        
        MD.makeConnection();
        TableModel modelMenu = new ModelMenu(MD.showAll());
        MD.closeConnection();
        return modelMenu;
    }
    
    public List<Menu> showMenu() {
        
        MD.makeConnection();
        List<Menu> temp = MD.showAll();
        MD.closeConnection();
        return temp;
    }
    
    public List<Menu> showById(Integer id)
    {
        MD.makeConnection();
        List<Menu> temp = MD.showById(id);
        MD.closeConnection();
        
        return temp;
    }
    
    public Integer getNextID()
    {
        MD.makeConnection();
        Integer nextID = MD.getNextId();
        MD.closeConnection();
        
        return nextID;
    }
    
    public Integer getIdByName(String nama) {
        MD.makeConnection();
        Integer id = MD.getIdByName(nama);
        MD.closeConnection();
        
        return id;
    }
}
