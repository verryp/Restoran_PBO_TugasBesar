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
public class Menu {
    
    private Integer ID;
    private String nama;
    private Integer harga;
    private String deskripsi;

    public Menu(Integer ID, String nama, Integer harga, String deskripsi) {
        this.ID = ID;
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public Menu(Integer id, String nama) {
        this.ID = id;
        this.nama = nama;
    }
    

    //public Menu() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }       
    
}
