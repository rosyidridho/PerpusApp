/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rosyid
 */
public class KoneksiDatabase 
{
    private static Connection koneksi;
    public static Connection getkoneksi()
    {
        try{
            //String url = "jdbc:mysql://192.168.43.117/perpustakaan?";
            String url = "jdbc:mysql://localhost:3306/perpus";
            String user = "root";
            String password = "20022013";
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, password);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return koneksi;
    }
}
