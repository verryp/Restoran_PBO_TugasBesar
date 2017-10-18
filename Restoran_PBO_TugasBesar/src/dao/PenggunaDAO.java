/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.TransaksiDAO.CON;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.*;
import model.Pengguna;

/**
 *
 * @author daniel
 */
public class PenggunaDAO {

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

    //Perwujudan Asosiasi Pengguna-Peran// UNDER CONSTRUCTIONS
    public void insertPeran(Pengguna user, Peran temp) {

        user.setPeran(temp);
    }

    //Untuk me-returnkan ID Pengguna berdasarkan nama di saat insert Transaksi
    //Masalah return *PERLU DITES*
    public int getIdPengguna(String nama) {

        String sql = "SELECT ID FROM TBL_PENGGUNA WHERE NAMA = '" + nama + "')";
        Pengguna p = null;
        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    p = new Pengguna(rs.getInt("ID"), rs.getString("Nama"), rs.getString("Username"), rs.getString("Password"));
                }
            }

            rs.close();
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error reading databaseinformation...\n");
            System.out.println(Ex);
        }
        return p.getId();
    }

    //Masalah return *PERLU DITES*
    public int getIdPeran(String namaPeran) throws SQLException {
        String sql = "SELECT ID FROM TBL_PERAN WHERE Nama = '" + namaPeran + "')";
        Peran p = null;
        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    p = new Peran(Integer.parseInt(rs.getString("ID")), rs.getString("Nama"));
                }
            }

            rs.close();
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error reading databaseinformation...\n");
            System.out.println(Ex);
        }
        return p.getId();
    }

    public void insertPengguna(Pengguna P) {
        String sql = "INSERT INTO TBL_PENGGUNA(ID,Nama,Username,Password,ID_Peran) VALUES('" + P.getId() + "','" + P.getNama() + "','" + P.getUsername() + "','" + P.getPassword() + "','" + P.getPeran().getId() + "')";
        System.out.println("Adding pengguna...");
        try {
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " pengguna\n");
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error Adding a pengguna...");
            System.out.println(Ex);
        }
    }

    public void updatePengguna(Pengguna P) {
        String sql = "UPDATE TBL_PENGGUNA SET Nama = '" + P.getNama() + "', Username = '" + P.getUsername() + "', Password = '" + P.getPassword() + "', ID_Peran='" + P.getPeran().getId() + "' WHERE ID = '" + P.getId() + "'";
        System.out.println("Updating pengguna...");
        try {
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Updated " + result + " pengguna\n");
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error Updating a pengguna...");
            System.out.println(Ex);
        }
    }

    public void deletePengguna(int id) {
        String sql = "DELETE FROM TBL_PENGGUNA WHERE ID = '" + id + "'";
        System.out.println("Deleting transaction...");
        try {
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Deleted" + result + "User\n");
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error Deleting a user.....");
            System.out.println(Ex);
        }
    }

    public List<Pengguna> showAll() {
        String sql = "SELECT ID,Nama,Username,Password,ID_Peran from TBL_PENGGUNA";
        return show(sql);
    }

    public List<Pengguna> showById(Integer id) {
        String sql = "SELECT ID,Nama,Username,Password,ID_Peran from TBL_PENGGUNA WHERE ID = '" + id + "'";
        return show(sql);
    }

    public List<Pengguna> show(String sql) {
        List<Pengguna> list = new ArrayList<>();

        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    Peran pe = null;

                    if (rs.getInt("ID_Peran") == 1) {
                        pe = new Peran(1, "Administrator");
                    } else {
                        pe = new Peran(2, "Kasir");
                    }

                    Pengguna p = new Pengguna(rs.getInt("ID"), rs.getString("Nama"), rs.getString("Username"), rs.getString("Password"));
                    p.setPeran(pe);
                    list.add(p);
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
        String sql = "SELECT TOP 1 ID FROM TBL_PENGGUNA ORDER BY ID DESC";
        Integer nextId = 1;

        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    nextId = rs.getInt("ID") + 1;
                }
            }
            rs.close();
            statement.close();

        } catch (Exception ex) {
            System.out.println("Error reading database information...\n");
            System.out.println(ex);
        }
        return nextId;
    }

    public List<Pengguna> doLogin(Pengguna p) {
        String sql = "SELECT * FROM TBL_PENGGUNA WHERE USERNAME = '" + p.getUsername() + "' AND PASSWORD = '" + p.getPassword() + "'";
        List<Pengguna> list = new ArrayList<>();
        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Peran pe = null;

                    if (rs.getInt("ID_Peran") == 1) {
                        pe = new Peran(1, "Administrator");
                    } else {
                        pe = new Peran(2, "Kasir");
                    }

                    p = new Pengguna(rs.getInt("ID"), rs.getString("Nama"), rs.getString("Username"), rs.getString("Password"));
                    p.setPeran(pe);
                    list.add(p);
                }
            } else {
                return null;
            }

            rs.close();
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error reading databaseinformation...\n");
            System.out.println(Ex);
        }
        return list;
    }

    public Pengguna pengguna(String username, String password) {
        String sql = "SELECT * FROM TBL_PENGGUNA where Username like '" + username + "' and Password like'" + password + "'";
        Pengguna P = new Pengguna();
        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    P = new Pengguna(rs.getInt("id"), rs.getString("nama"), rs.getString("username"), rs.getString("password"));

                }
            }
            rs.close();
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error reading database information...\n");
            System.out.println(Ex);
        }
        return P;
    }

    //hangat gan
    public boolean searchPengguna(String username) {
        boolean temp = true;
        String sql = "SELECT Username FROM TBL_PENGGUNA";
        try {
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    if (rs.getString("Username").toString().compareToIgnoreCase(username) != 0) {
                        temp = false;
                    }
                }
            }
            rs.close();
            statement.close();

        } catch (Exception Ex) {
            System.out.println("Error reading database information...\n");
            System.out.println(Ex);
        }
        return temp;
    }
}
