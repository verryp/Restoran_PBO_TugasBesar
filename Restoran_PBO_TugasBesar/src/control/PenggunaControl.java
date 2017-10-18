/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PenggunaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;
import model.*;
import tableModel.*;

/**
 *
 * @author daniel
 */
public class PenggunaControl {

    PenggunaDAO PD = new PenggunaDAO();

    public void insertPengguna(Pengguna P) {
        PD.makeConnection();
        PD.insertPengguna(P);
        PD.closeConnection();
    }

    public void updatePengguna(Pengguna P) {
        PD.makeConnection();
        PD.updatePengguna(P);
        PD.closeConnection();
    }

    //Untuk mengisi ID Pengguna di saat insert Transaksi
    public int getIdByName(String nama) {

        PD.makeConnection();
        int temp = PD.getIdPengguna(nama);
        PD.closeConnection();

        return temp;
    }

    public int getIdPeran(String namaPeran) throws SQLException {
        PD.makeConnection();
        int temp = PD.getIdPeran(namaPeran);
        PD.closeConnection();

        return temp;
    }

    public void deletePengguna(int id) {
        PD.makeConnection();
        PD.deletePengguna(id);
        PD.closeConnection();
    }

    public TableModel showAll() {
        PD.makeConnection();
        TableModel penggunaModel = new ModelPengguna(PD.showAll());
        PD.closeConnection();
        return penggunaModel;
    }

    public List<Pengguna> showById(Integer id) {
        PD.makeConnection();
        List<Pengguna> temp = PD.showById(id);
        PD.closeConnection();
        return temp;
    }

    public Integer getNextId() {
        PD.makeConnection();
        Integer nextId = PD.getNextId();
        PD.closeConnection();
        return nextId;
    }

    public List<Pengguna> doLogin(Pengguna P) {
        PD.makeConnection();
        List<Pengguna> temp = PD.doLogin(P);
        PD.closeConnection();
        return temp;
    }

    public Pengguna pengguna(String username, String password) {
        PD.makeConnection();
        Pengguna P = PD.pengguna(username, password);
        PD.closeConnection();
        return P;
    }

    //HANGAT GAN
    public boolean cekUsername(String username) {
        PD.makeConnection();
        boolean tampung = PD.searchPengguna(username);
        PD.closeConnection();

        return tampung;
    }

}
