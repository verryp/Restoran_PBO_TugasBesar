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
import model.Menu;

/**
 *
 * @author daniel
 */
public class MenuDAO {

    public static Connection CON;
    public static final String url = "jdbc:ucanaccess://";
    public static final String path = "D:\\DBResto.accdb"; //**lokasi dapat berubah

    public void makeConnection() {
        System.out.println("Opening Database...");
        try {
            CON = DriverManager.getConnection(url + path);
            System.out.println("Success!\n");
        } catch (Exception Ex) {
            System.out.println("Error opening the database...");
            System.out.println(Ex);
        }
    }

    public void closeConnection() {
        System.out.println("Closing database...");
        try {
            CON.close();
            System.out.println("Success!\n");
        } catch (Exception Ex) {
            System.out.println("Error Closing the database...");
            System.out.println(Ex);
        }
    }

    //Query untuk memasukan data ke table TBL_MENU
    public void InsertMenu(Menu M) {

        String sql = "INSERT INTO TBL_MENU(ID,Nama,Harga,Deskripsi) VALUES(" + M.getID() + ",'" + M.getNama() + "'," + M.getHarga() + ",'" + M.getDeskripsi() + "')";
        System.out.println("Adding Menu...");
        try {
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added" + result + "Menu\n");
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error Adding a Menu...");
            System.out.println(Ex);
        }
    }

    //Query untuk meng-Update data di TBL_MENU menggunakan Nama, dengan object tampungan di view
    public void UpdateMenu(Menu M) {

        String sql = "UPDATE TBL_MENU SET NAMA = '" + M.getNama() + "', Harga = " + M.getHarga() + ", Deskripsi = '" + M.getDeskripsi() + "' WHERE ID = '" + M.getID() + "'";

        System.out.println("Update Menu...");
        try {
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Update" + result + "Menu\n");
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error Updating a Menu...");
            System.out.println(Ex);
        }
    }

    public void deleteMenu(int id) {
        String sql = "DELETE FROM TBL_MENU WHERE ID = '" + id + "'";
        System.out.println("Deleting menu...");
        try {
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted" + result + "Menu\n");
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error Deleting a menu...");
            System.out.println(Ex);
        }
    }

    public List<Menu> showAll() {
        String sql = "SELECT ID,Nama,Harga,Deskripsi FROM TBL_MENU";

        List<Menu> list = new ArrayList<Menu>();

        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    Menu m = new Menu(Integer.parseInt(rs.getString("ID")), rs.getString("Nama"), Integer.parseInt(rs.getString("Harga")), rs.getString("Deskripsi"));
                    list.add(m);
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
    
    public List<Menu> showById(Integer id) {
        String sql = "SELECT ID,Nama,Harga,Deskripsi FROM TBL_MENU WHERE ID = '"+id+"'";

        List<Menu> list = new ArrayList<Menu>();

        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    Menu m = new Menu(Integer.parseInt(rs.getString("ID")), rs.getString("Nama"), Integer.parseInt(rs.getString("Harga")), rs.getString("Deskripsi"));
                    list.add(m);
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
    
    public Integer getNextId() {
        String sql = "SELECT TOP 1 ID FROM TBL_MENU ORDER BY ID DESC";        
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
    
    public Integer getIdByName(String nama) {
        String sql = "SELECT ID FROM TBL_MENU WHERE Nama = '"+nama+"'";        
        Integer id = null;
        
        try
        {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
      
            if (rs != null)
            {
                while (rs.next())
                {
                    id = rs.getInt("ID");
                }
            }
            rs.close();
            statement.close();
            
        } catch (Exception ex)
        {
            System.out.println("Error reading database information...\n");
            System.out.println(ex);
        }
        return id;
    }
}
