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
public class tabelPeminjaman extends javax.swing.JPanel {
private final DefaultTableModel model;
private final DefaultTableModel model2;
String id="";
    /**
     * Creates new form tabelPeminjaman
     */
     
     FormUtama FU = new FormUtama();
    public tabelPeminjaman() 
    {
        initComponents();
        model = new DefaultTableModel();
        model2 = new DefaultTableModel();
        jTable1.setModel(model);
        model.addColumn("ID Pinjam");
        model.addColumn("ID Buku");
        model.addColumn("Judul");
        model.addColumn("ID Petugas");
        model.addColumn("Nama Petugas");
        model.addColumn("ID Anggota");
        model.addColumn("Nama Anggota");
        model.addColumn("TGL Pinjam");
        
        loadData();
        enaButtonSimpan();
    }
    
    public void disButtonSimpan(){
        jBSubmit.setEnabled(false);
        jBHapus.setEnabled(true);
    }
    
    public void enaButtonSimpan(){
        jBSubmit.setEnabled(true);
        jBHapus.setEnabled(false);
    }
    
    public void bersih()
    {
        id_bku.setText("");
        id_petugas.setText("");
        id_anggota.setText("");
        tgl_pinjam.setText("");
        cari.setText("");
        System.out.println(FU.getUsern());
    }
    
    int row = 0;
    public void tableclick()
    {
        row = jTable1.getSelectedRow();
        id=jTable1.getValueAt(row, 0).toString();
        id_bku.setText(jTable1.getValueAt(row, 1).toString());
        id_petugas.setText(jTable1.getValueAt(row, 3).toString());
        id_anggota.setText(jTable1.getValueAt(row, 5).toString());
        tgl_pinjam.setText(jTable1.getValueAt(row, 7).toString());
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
            String sql = "SELECT * FROM vpeminjaman";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[8];
                o[0] = r.getString("id_pinjam");
                o[1] = r.getString("id_buku");
                o[2] = r.getString("judul");
                o[3] = r.getString("id_petugas");
                o[4] = r.getString("nama_petugas");
                o[5] = r.getString("id_anggota");
                o[6] = r.getString("nama_anggota");
                o[7] = r.getString("tgl_pinjam");
                model.addRow(o);
            }
            r.close();
            s.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        id_bku = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        id_petugas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        id_anggota = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tgl_pinjam = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBSubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBHapus = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ComboBoxcari = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        cari = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 0, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Buku");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Petugas");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID Anggota");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TGL Pinjam");

        jPanel1.setBackground(new java.awt.Color(204, 0, 51));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(204, 0, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Peminjaman");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(413, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(410, 410, 410))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jBSubmit.setText("Submit Peminjaman");
        jBSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSubmitActionPerformed(evt);
            }
        });

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

        jBHapus.setText("Hapus");
        jBHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHapusActionPerformed(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ComboBoxcari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID Buku", "ID Petugas", "ID Anggota" }));

        jButton3.setText("Cari");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_bku, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tgl_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBSubmit)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                        .addComponent(jBHapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(53, 53, 53)
                        .addComponent(id_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxcari, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_bku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jBHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgl_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jBSubmit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSubmitActionPerformed
        // TODO add your handling code here:
        String ket="";
        if("".equals(id_bku.getText()) || "".equals(id_petugas.getText()) || "".equals(id_anggota.getText()) || "".equals(tgl_pinjam.getText()))
        {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        }
        else
        {
            try{
            Connection c = KoneksiDatabase.getkoneksi();
            Statement s = c.createStatement();
            String sql = "select stts from buku where id_buku = '"+id_bku.getText()+"'";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                ket = r.getString("stts");
            }
            r.close();
            s.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
            
            System.out.println("ket:"+ket);
            if("Pinjam".equals(ket)){
                JOptionPane.showMessageDialog(null, "Maaf Buku Sudah Dipinjam");
            }else{
                try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "insert into peminjaman (id_buku, id_petugas, id_anggota, tgl_pinjam) values (?,?,?,?)";
                PreparedStatement p = c.prepareStatement(query);

                p.setString(1, ""+id_bku.getText()+"");
                p.setString(2, ""+id_petugas.getText()+"");
                p.setString(3, ""+id_anggota.getText()+"");
                p.setString(4, ""+tgl_pinjam.getText()+"");
                p.execute();

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
                //bersih();
                loadData();
            }
            }
            
        }
        
    }//GEN-LAST:event_jBSubmitActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1)
        {
            tableclick();
            disButtonSimpan();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jBHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHapusActionPerformed
        // TODO add your handling code here:
        if("".equals(id)){
            JOptionPane.showMessageDialog(null, "Klik pada tabel untuk mengedit data");
        }else
        {
            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query1 = "update buku set stts='Kembali' where id_buku=?";
                String query2 = "DELETE FROM peminjaman where id_pinjam = ?";

                PreparedStatement p = c.prepareStatement(query1);
                p.setString(1, ""+id_bku.getText()+"");
                p.executeUpdate();
                
                p = c.prepareStatement(query2);
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
        disButtonSimpan();
    }//GEN-LAST:event_jBHapusActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        bersih();
        loadData();
        enaButtonSimpan();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBoxcari;
    private javax.swing.JTextField cari;
    private javax.swing.JTextField id_anggota;
    private javax.swing.JTextField id_bku;
    private javax.swing.JTextField id_petugas;
    private javax.swing.JButton jBHapus;
    private javax.swing.JButton jBSubmit;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tgl_pinjam;
    // End of variables declaration//GEN-END:variables
}
