package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bobby Pratama
 */
public class DetilTransaksi {
    private int id;
    private Menu menu;
    private int jumlah;
    private int idtrans;

    public DetilTransaksi () {};
    public DetilTransaksi(int id, Menu menu, int jumlah,int idtrans) {
        this.id = id;
        this.menu = menu;
        this.jumlah = jumlah;
        this.idtrans = idtrans;
    }
    
    public DetilTransaksi(int id, Menu menu, int jumlah) {
        this.id = id;
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getIdtrans() {
        return idtrans;
    }

    public void setIdtrans(int idtrans) {
        this.idtrans = idtrans;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    
}
