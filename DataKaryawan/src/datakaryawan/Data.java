/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datakaryawan;

/**
 *
 * @author Roni Sefia
 */
public class Data {
    String nik, nama, jabatan, alamat, email, notelp;
    
     public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String setJabatan(){
        return jabatan;
    }
    public void getJabatan(String jabatan){
        this.jabatan = jabatan;
    }
    
    public String setAlamat(){
        return alamat;
    }
    public void getAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public String setEmail(){
       return email;
    }
    public void getEmail(String email){
        this.email = email;
    }
    
    public String setNotelp(){
        return notelp;
    }
    public void getNotelp(String notelp){
        this.notelp = notelp;
    }
}
