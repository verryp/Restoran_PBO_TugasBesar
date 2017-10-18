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
public class Pengguna {
    private Integer id;
    private String nama;
    private String username;
    private String password;
    private Peran P; //Perwujudan Asosiasi //Insert di RestoDAO

    public Pengguna(){};
    public Pengguna(Integer id, String nama, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }
    
    public Pengguna(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Pengguna(String nama) {
        this.nama = nama;
    }
    
    public Pengguna(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Peran getPeran() {
        return P;
    }

    public void setPeran(Peran temp) {
        
        this.P = temp;
    }
    
    
}
