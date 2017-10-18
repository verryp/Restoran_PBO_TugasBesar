/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author daniel
 */
public class DetilTransaksiDAO {
    
    public static Connection CON;
    public static final String url = "jdbc:ucanaccess://";
    public static final String path = "D:\\DBResto.accdb"; //**lokasi dapat berubah
    
    public void makeConnection(){
        System.out.println("Opening Database...");
        try
        {
            CON=DriverManager.getConnection(url+path);
            System.out.println("Success!\n");
        }catch(Exception Ex){
            System.out.println("Error opening the database...");
            System.out.println(Ex);
        } 
    }
    
    public void closeConnection(){
        System.out.println("Closing database...");
        try{
            CON.close();
            System.out.println("Success!\n");
        }catch(Exception Ex){
            System.out.println("Error Closing the database...");
            System.out.println(Ex);
        }
    }
    
    //Query untuk input data//   UNDER CONSTRUCTIONS
    public void insertDetilTransaksi(DetilTransaksi DT) {
        
        String sql = "INSERT INTO TBL_DETILTRANSAKSI (ID,ID_Menu,Jumlah,ID_Trans) VALUES("+DT.getId()+","+DT.getMenu().getID()+","+DT.getJumlah()+","+DT.getIdtrans()+")";
        System.out.println("Adding DetilTransaksi...");
        System.out.println(sql);
        try{
            Statement statement = CON.createStatement();
            int result=statement.executeUpdate(sql);
            System.out.println("Added"+result+"Detil\n");
            statement.close();
        }catch(Exception Ex){
            System.out.println("Error Adding a Detil...");
            System.out.println(Ex);
        } 
    }
    
     public void deleteDetilTransaksi(int id)
    {
        String sql = "DELETE FROM TBL_DETILTRANSAKSI WHERE ID = '"+id+"'";
        System.out.println("Deleting transaction detail...");
        try{
            Statement statement = CON.createStatement();
            int result=statement.executeUpdate(sql);
            System.out.println("Deleted"+result+"Transaksi\n");
            statement.close();
        }catch(Exception Ex){
            System.out.println("Error Adding a Transaksi...");
            System.out.println(Ex);
        } 
    }
     
    public void deleteDetilTransaksiByIdTrans(int id)
    {
        String sql = "DELETE FROM TBL_DETILTRANSAKSI WHERE ID_Trans = '"+id+"'";
        System.out.println("Deleting transaction detail...");
        try{
            Statement statement = CON.createStatement();
            int result=statement.executeUpdate(sql);
            System.out.println("Deleted"+result+"Transaksi\n");
            statement.close();
        }catch(Exception Ex){
            System.out.println("Error Adding a Transaksi...");
            System.out.println(Ex);
        } 
    }
    
     public List<DetilTransaksi> showSearchDetil(int iddetil) {
     
        String sql = "SELECT D.ID ID_D, D.Jumlah, M.ID ID_M, M.Nama from TBL_DETILTRANSAKSI D INNER JOIN TBL_MENU M ON D.ID_Menu = M.ID WHERE D.ID = ('" + iddetil + "')";
        System.out.println("Daftar Detil Transaksi...");
        
        List<DetilTransaksi> list = new ArrayList<>();

        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Menu menu = new Menu(rs.getInt("ID_M"), rs.getString("Nama"));  
                    DetilTransaksi dt = new DetilTransaksi(rs.getInt("id"), menu,rs.getInt("jumlah"),rs.getInt("idtrans"));
                   list.add(dt);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception ex) {
            System.out.println("Error reading database information...\n");
            System.out.println(ex);
        }
        return list;

    }
     
    public List<DetilTransaksi> showAll()
    {
        String sql = "SELECT D.ID ID_D, D.Jumlah, M.ID ID_M, M.Nama from TBL_DETILTRANSAKSI D INNER JOIN TBL_MENU M ON D.ID_Menu = M.ID";
        DetilTransaksi dt= new DetilTransaksi();
        System.out.println("Daftar Detil Transaksi...");
        
        List<DetilTransaksi> list = new ArrayList<>();
        
        try
        {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
      
            if (rs != null)
            {
                while (rs.next())
                {
                    Menu menu = new Menu(rs.getInt("ID_M"), rs.getString("Nama"));                 
                    dt = new DetilTransaksi(rs.getInt("ID"), menu, rs.getInt("Jumlah"),rs.getInt("ID_Trans"));                    
                    list.add(dt);
                }
            }
            rs.close();
            statement.close();
            
        } catch (Exception ex)
        {
            System.out.println("Error reading database information...\n");
            System.out.println(ex);
        }
        return list;
    }
    
    public List<DetilTransaksi> showById(Integer id)
    {
        String sql = "SELECT D.ID ID_D, D.ID_Trans, D.Jumlah, M.ID ID_M, M.Nama from TBL_DETILTRANSAKSI D INNER JOIN TBL_MENU M ON D.ID_Menu = M.ID WHERE D.ID_Trans = "+id;
        DetilTransaksi dt= new DetilTransaksi();
        System.out.println("Daftar Detil Transaksi...");
        
        List<DetilTransaksi> list = new ArrayList<>();
        
        try
        {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
      
            if (rs != null)
            {
                while (rs.next())
                {
                    Menu menu = new Menu(rs.getInt("ID_M"), rs.getString("Nama"));                 
                    dt = new DetilTransaksi(rs.getInt("ID"), menu, rs.getInt("Jumlah"),rs.getInt("ID_Trans"));                    
                    list.add(dt);
                }
            }
            rs.close();
            statement.close();
            
        } catch (Exception ex)
        {
            System.out.println("Error reading database information...\n");
            System.out.println(ex);
        }
        return list;
    }
     
     public double getHarga(int id){
         double temp = 0;
         
         String sql = "SELECT Harga FROM TBL_MENU WHERE ID = '"+id+"'";
         
         try {
             Statement state = CON.createStatement();
             ResultSet rs = state.executeQuery(sql);
             
             if(rs != null){
                 while(rs.next()){
                     temp = Double.parseDouble(rs.getString("Harga"));
                 }
             }
             
             rs.close();
             state.close();
         } catch (Exception e) {
             System.out.println("Error Reading From database. . .");
             System.out.println(e);
         }
         
         return temp;
     }
     
    public Integer getNextId() {
        String sql = "SELECT TOP 1 ID FROM TBL_DETILTRANSAKSI ORDER BY ID DESC";        
        Integer nextId = 1;
        
        try
        {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
      
            if (rs != null)
            {
                while (rs.next())
                {
                    nextId = rs.getInt("ID") + 1;
                }
            }
            rs.close();
            statement.close();
            
        } catch (Exception ex)
        {
            System.out.println("Error reading database information...\n");
            System.out.println(ex);
        }
        return nextId;
    }
}
