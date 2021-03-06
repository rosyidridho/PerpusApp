/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rosyid
 */
public class TabelPengurus extends javax.swing.JPanel {
private final DefaultTableModel model;
String id="";
    /**
     * Creates new form tabelKaryawan
     */

    public void disButtonSimpan(){
        jBsimpan.setEnabled(false);
        jBEdit.setEnabled(true);
        jBHapus.setEnabled(true);
    }
    
    public void enaButtonSimpan(){
        jBsimpan.setEnabled(true);
        jBEdit.setEnabled(false);
        jBHapus.setEnabled(false);
    }

    public TabelPengurus() {
        initComponents();
        
        //membuat tablemodel
        model = new DefaultTableModel();
        //menambah tablemodel ke tabel
        jTable1.setModel(model);
        
        model.addColumn("ID Pengurus");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("No HP");
        model.addColumn("TGL Lahir");
        model.addColumn("TGL Masuk");
        
       loadData();
       enaButtonSimpan();
    }
    
    public void loadData()
    {
        //menghapus seluruh data
        model.getDataVector().removeAllElements();
        //memberitahu bahwa data telah kosong
        model.fireTableDataChanged();
        try{
            Connection c = KoneksiDatabase.getkoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM petugas order by tgl_masuk desc";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[6];
                o[0] = r.getString("id_petugas");
                o[1] = r.getString("nama");
                o[2] = r.getString("alamat");
                o[3] = r.getString("no_hp");
                o[4] = r.getString("tgl_lahir");
                o[5] = r.getString("tgl_masuk");
                model.addRow(o);
            }
            r.close();
            s.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void bersih()
    {
        nama.setText("");
        alamat.setText("");
        telp.setText("");
        tgl.setText("");
        cari.setText("");
    }
    
    int row = 0;
    public void tabelclick()
    {
        row = jTable1.getSelectedRow();
        id = jTable1.getValueAt(row, 0).toString();
        nama.setText(jTable1.getValueAt(row, 1).toString());
        alamat.setText(jTable1.getValueAt(row, 2).toString());
        telp.setText(jTable1.getValueAt(row, 3).toString());
        tgl.setText(jTable1.getValueAt(row, 4).toString());
    }
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        telp = new javax.swing.JTextField();
        cari = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        tgl = new javax.swing.JTextField();
        ComboBoxcari = new javax.swing.JComboBox();
        nama = new javax.swing.JTextField();
        jBEdit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        alamat = new javax.swing.JTextField();
        jBHapus = new javax.swing.JButton();
        jBsimpan = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 0, 51));

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 0, 51));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(204, 0, 51));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Pengurus");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        ComboBoxcari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID Petugas", "Nama", "Alamat", "No HP" }));

        jBEdit.setText("Edit");
        jBEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("No. HP");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Alamat");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tgl Lahir");

        alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatActionPerformed(evt);
            }
        });

        jBHapus.setText("Hapus");
        jBHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHapusActionPerformed(evt);
            }
        });

        jBsimpan.setText("Simpan");
        jBsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(telp, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jBEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBHapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ComboBoxcari, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton5))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jBHapus))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jBEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jBsimpan))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if("".equals(cari.getText())){
            JOptionPane.showMessageDialog(null, "Masukkan key terlebih dulu pada field cari");
        }else{
            //menghapus seluruh data
        model.getDataVector().removeAllElements();
        //memberitahu bahwa data telah kosong
        model.fireTableDataChanged();
        try{
            Connection c = KoneksiDatabase.getkoneksi();
            Statement s = c.createStatement();
            String plh="";
            if(ComboBoxcari.getSelectedIndex()==0)
            {
                plh="id_petugas";
            }
            else if(ComboBoxcari.getSelectedIndex()==1)
            {
                plh="nama";
            }
            else if(ComboBoxcari.getSelectedIndex()==2)
            {
                plh="alamat";
            }
            else if(ComboBoxcari.getSelectedIndex()==3)
            {
                plh="no_hp";
            }
            ResultSet r = s.executeQuery("SELECT * FROM petugas where "+plh+" LIKE '%"+cari.getText()+"%'");

            while(r.next())
            {
                Object[] o = new Object[6];
                o[0] = r.getString("id_petugas");
                o[1] = r.getString("nama");
                o[2] = r.getString("alamat");
                o[3] = r.getString("no_hp");
                o[4] = r.getString("tgl_lahir");
                o[5] = r.getString("tgl_masuk");
                model.addRow(o);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        bersih();
        cari.setText("");
        id="";
        loadData();
        enaButtonSimpan();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jBEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditActionPerformed
        // TODO add your handling code here:
        if("".equals(id)){
            JOptionPane.showMessageDialog(null, "Klik pada tabel untuk mengedit data");
        }else if("".equals(nama.getText()) || "".equals(alamat.getText()) || "".equals(telp.getText()) || "".equals(tgl.getText()))
        {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        }
        else
        {
            String nma = nama.getText();
            String almt = alamat.getText();
            String tlp = telp.getText();
            String tg = tgl.getText();

            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "UPDATE petugas SET nama = ?, alamat = ?, no_hp = ?, tgl_lahir = ? where id_petugas = ?";
                PreparedStatement p = c.prepareStatement(query);

                p.setString(1, nma);
                p.setString(2, almt);
                p.setString(3, tlp);
                p.setString(4, tg);
                p.setString(5, id);
                p.executeUpdate();
                p.close();

                JOptionPane.showMessageDialog(null,"Berhasil Edit");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
                //bersih();
                loadData();
            }
        }
        id="";
        enaButtonSimpan();
    }//GEN-LAST:event_jBEditActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1)
        {
            tabelclick();
            disButtonSimpan();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatActionPerformed

    private void jBHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHapusActionPerformed
        // TODO add your handling code here:
        if("".equals(id)){
            JOptionPane.showMessageDialog(null, "Klik pada tabel untuk mengedit data");
        }else
        {
            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "DELETE FROM petugas where id_petugas = ?";

                PreparedStatement p = c.prepareStatement(query);

                p.setString(1, id);
                p.executeUpdate();
                p.close();

                JOptionPane.showMessageDialog(null,"Berhasil Hapus");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
                //bersih();
                loadData();
            }
        }
        id="";
        enaButtonSimpan();
    }//GEN-LAST:event_jBHapusActionPerformed

    private void jBsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsimpanActionPerformed
        // TODO add your handling code here:
        if("".equals(nama.getText()) || "".equals(alamat.getText()) || "".equals(telp.getText()) || "".equals(tgl.getText()))
        {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        }
        else
        {
            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "insert into petugas (nama, alamat, no_hp, tgl_lahir) values (?,?,?,?)";
                PreparedStatement p = c.prepareStatement(query);

                p.setString(1, ""+nama.getText()+"");
                p.setString(2, ""+alamat.getText()+"");
                p.setString(3, ""+telp.getText()+"");
                p.setString(4, ""+tgl.getText()+"");
                p.execute();

                JOptionPane.showMessageDialog(null,"Berhasil Menyimpan Data");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Isilah Field Dengan Benar");
            }finally{
                //bersih();
                loadData();
            }
        }
        id="";
    }//GEN-LAST:event_jBsimpanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBoxcari;
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField cari;
    private javax.swing.JButton jBEdit;
    private javax.swing.JButton jBHapus;
    private javax.swing.JButton jBsimpan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField telp;
    private javax.swing.JTextField tgl;
    // End of variables declaration//GEN-END:variables
}
