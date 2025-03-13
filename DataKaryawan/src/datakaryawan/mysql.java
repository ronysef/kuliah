/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datakaryawan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Roni Sefia
 */
public class mysql {
    String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    String dbUrl = "jdbc:mysql://localhost/data_karyawan";
    String user = "root";
    String pass = "";

    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;

    public mysql() {
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(dbUrl, user, pass);
            System.out.println("Berhasil terkoneksi ke Database");
        } catch (SQLException ex) {
            System.out.println("Gagal koneksi ke Database");
            Logger.getLogger(mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertKry(String nik, String nama, String jabatan, String alamat, String email, String notelp) {
        String query = "insert into tbl_data_karyawan (nik, nama, jabatan, alamat, email, notelp) values (?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, nik);
            pst.setString(2, nama);
            pst.setString(3, jabatan);
            pst.setString(4, alamat);
            pst.setString(5, email);
            pst.setString(6, notelp);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("gagal insert");
            Logger.getLogger(mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateKry(String nik, String nama, String jabatan, String alamat, String email, String notelp) {
        String query = "update tbl_data_karyawan set nama=?, jabatan=?, alamat=? , email=?, notelp=? where nik = ?";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, nama);
            pst.setString(2, jabatan);
            pst.setString(3, alamat);
            pst.setString(4, email);
            pst.setString(5, notelp);
            pst.setString(6, nik);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("gagal update");
            Logger.getLogger(mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteKry(String nik) {
        String query = "delete from tbl_data_karyawan where nik = ?";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, nik);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("gagal delete");
            Logger.getLogger(mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getDataKaryawan() {
        try {
            String query = "Select * from tbl_data_karyawan";
            st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(mysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

}
