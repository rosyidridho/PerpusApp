/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpus;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author rosyid
 */
public class Perpus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            Connection c = KoneksiDatabase.getkoneksi();
            FormUtama call = new FormUtama();
            call.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
