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
import tableModel.*;

/**
 *
 * @author daniel
 */
public class TransaksiDAO {
    
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
    
    public void insertTransaksi(Transaksi T){
        String sql = "INSERT INTO TBL_TRANSAKSI(ID,Tanggal,Kustomer,Pengguna) VALUES("+T.getId()+",'"+T.getTanggal()+"','"+T.getKustomer()+"',"+T.getPengguna().getId()+")";
        System.out.println(sql);
        System.out.println("Adding Transaksi...");
        try{
            Statement statement = CON.createStatement();
            int result=statement.executeUpdate(sql);                                   
            System.out.println("Added"+result+"Transaksi\n");
            statement.close();
        }catch(Exception Ex){
            System.out.println("Error Adding a Transaksi...");
            System.out.println(Ex);
        } 
    }
    public void deleteTransaksi(Transaksi T)
    {
        String sql = "DELETE FROM TBL_TRANSAKSI WHERE ID = '"+T.getId()+"'";
        System.out.println("Deleting transaction...");
        try{
            Statement statement = CON.createStatement();
            int result=statement.executeUpdate(sql);
            System.out.println("Deleted"+result+"Transaksi\n");
            statement.close();
        }catch(Exception Ex){
            System.out.println("Error delete a Transaksi...");
            System.out.println(Ex);
        } 
    }
    
    public List <Transaksi> showSearch(int id){
        String sql = "SELECT * FROM TBL_TRANSAKSI WHERE ID = ('" + id + "')";
        System.out.println("Daftar Dosen...");
        
        List <Transaksi> list=new ArrayList<Transaksi>();
        try{
            Statement statement=CON.createStatement();
            ResultSet rs =statement.executeQuery(sql);
            if(rs != null){
                while(rs.next()){
                    Transaksi trans = new Transaksi(rs.getInt("ID"), rs.getString("Tanggal"), rs.getString("Kustomer"));
                    list.add(trans);
                }
            }
            rs.close();
            statement.close();

        }
        catch(Exception Ex){
            System.out.println("Error reading database information...\n");
            System.out.println(Ex);
        }
         return list;
    }
    
    /*public Transaksi searchTransaksi(int id) throws SQLException {
     
        String sql = "SELECT * FROM TBL_TRANSAKSI WHERE ID = ('" + id + "')";
        Transaksi t= null;

        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
//                   t = new Transaksi(rs.getInt("ID"), rs.getString("Tanggal"), rs.getString("Kustomer"),rs.getInt("Pengguna"), rs.getInt("idDetil"), rs.getInt("menu"), rs.getInt("jumlah"));
                   //User u = new User(rs.getString("username"), rs.getString("password"));

                }
            }
            rs.close();
            statement.close();
        } catch (Exception ex) {
            System.out.println("Error reading database information...\n");
            System.out.println(ex);
        }
        return t;

    }*/
    
    public List<Transaksi> showAll()
    {
        String sql = "SELECT T.ID, T.Tanggal, T.Kustomer, P.Nama from TBL_TRANSAKSI T INNER JOIN TBL_PENGGUNA P ON T.Pengguna = P.ID";
        
        System.out.println("Daftar Transaksi...");
        List<Transaksi> list = new ArrayList<>();
        
        try
        {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
      
            if (rs != null)
            {
                while (rs.next())
                {
                    Pengguna p = new Pengguna(rs.getString("Nama"));
                    Transaksi t = new Transaksi(rs.getInt("ID"), rs.getString("Tanggal"), rs.getString("Kustomer"));
                    t.setPengguna(p);
                    list.add(t);
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
    
    public Integer getNextId() {
        String sql = "SELECT TOP 1 ID FROM TBL_TRANSAKSI ORDER BY ID DESC";        
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

