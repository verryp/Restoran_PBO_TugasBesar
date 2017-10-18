    package model;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bobby Pratama
 */
public class Transaksi {
    
    private int id;
    private String tanggal;
    private String kustomer; //ini nama kustomer nya
    private Pengguna pengguna; //ini id pengguna nya
    private ArrayList<DetilTransaksi> DT = new ArrayList<>();//perwujudan *komposisi*


    public Transaksi () {};
    public Transaksi(int id, String tanggal, String kustomer)
    {
        this.id = id;
        this.tanggal = tanggal;
        this.kustomer = kustomer;
        //this.pengguna = pengguna;
    }
    
    public Transaksi(int id)
    {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKustomer() {
        return kustomer;
    }

    public void setKustomer(String kustomer) {
        this.kustomer = kustomer;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public ArrayList<DetilTransaksi> getDT() {
        return DT;
    }

    public void setDT(ArrayList<DetilTransaksi> DT) {
        this.DT = DT;
    }
    
    
}
