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
import javax.swing.ComboBoxModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Rosyid
 */
public class tabelBuku extends javax.swing.JPanel {
private final DefaultTableModel model;
String id="";
    /**
     * Creates new form tabelBuku
     */
    public tabelBuku() {
        initComponents();
        //membuat tablemodel
        model = new DefaultTableModel();
        //menambah tablemodel ke tabel
        jTable1.setModel(model);
        
        model.addColumn("ID Buku");
        model.addColumn("Judul");
        model.addColumn("Pengarang");
        model.addColumn("Penerbit");
        model.addColumn("Kategori");
        model.addColumn("Keterangan");
        
        loadData();
        xxx();
        enaButtonSimpan();
        cbbKategori.setSelectedIndex(0);
        cbbPenerbit.setSelectedIndex(0);
    }
    
    public void disButtonSimpan(){
        jBSimpan.setEnabled(false);
        jBEdit.setEnabled(true);
        jBHapus.setEnabled(true);
    }
    
    public void enaButtonSimpan(){
        jBSimpan.setEnabled(true);
        jBEdit.setEnabled(false);
        jBHapus.setEnabled(false);
    }
    
    public void xxx(){
        cbbPenerbit.removeAllItems();
        cbbKategori.removeAllItems();
        try{
            Connection c = KoneksiDatabase.getkoneksi();
            Statement s = c.createStatement();
            String sql = "select nama from penerbit";
            ResultSet r = s.executeQuery(sql);
            cbbPenerbit.addItem("-- Pilih Penerbit --");
            while(r.next())
            {
                String p = r.getString("nama");
                cbbPenerbit.addItem(p);
            }
            
            sql = "select nama from kategori";
            r = s.executeQuery(sql);
            cbbKategori.addItem("-- Pilih Kategori --");
            while(r.next())
            {
                String p = r.getString("nama");
                cbbKategori.addItem(p);
            }
            r.close();
            s.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    int row = 0;
    public void tabelclick()
    {
        row = jTable1.getSelectedRow();
        id = jTable1.getValueAt(row, 0).toString();
        judul.setText(jTable1.getValueAt(row, 1).toString());
        pengarang.setText(jTable1.getValueAt(row, 2).toString());
        String pnerbit = jTable1.getValueAt(row, 3).toString();
        String Ktegori = jTable1.getValueAt(row, 4).toString();
        for(int i=0; i<cbbPenerbit.getItemCount(); i++){
            String temp = cbbPenerbit.getItemAt(i).toString();
            if(temp.equals(pnerbit)){
                cbbPenerbit.setSelectedIndex(i);
                break;
            }            
        }
        
        for(int i=0; i<cbbKategori.getItemCount(); i++){
            String temp = cbbKategori.getItemAt(i).toString();
            if(temp.equals(Ktegori)){
                cbbKategori.setSelectedIndex(i);
                break;
            }            
        }
    }
    
    
    public void bersih()
    {
        judul.setText("");
        pengarang.setText("");
        cbbPenerbit.setSelectedIndex(0);
        cbbKategori.setSelectedIndex(0);
        cari.setText("");
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
            String sql = "select * from vbuku";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[6];
                o[0] = r.getString("id_buku");
                o[1] = r.getString("judul");
                o[2] = r.getString("pengarang");
                o[3] = r.getString("penerbit");
                o[4] = r.getString("ketegori");
                o[5] = r.getString("keterangan");
                model.addRow(o);
            }
            r.close();
            s.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jBEdit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jBHapus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pengarang = new javax.swing.JTextField();
        jBSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        judul = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        ComboBoxcari = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbbPenerbit = new javax.swing.JComboBox();
        cbbKategori = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(204, 0, 51));

        jBEdit.setText("Edit");
        jBEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kategori");

        jBHapus.setText("Hapus");
        jBHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHapusActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Judul");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pengarang");

        pengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengarangActionPerformed(evt);
            }
        });

        jBSimpan.setText("Simpan");
        jBSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSimpanActionPerformed(evt);
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Penerbit");

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ComboBoxcari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID Buku", "Judul", "Pengarang", "Penerbit", "Kategori" }));

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 0, 51));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(204, 0, 51));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Buku");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(435, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(462, 462, 462))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbbPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPenerbitActionPerformed(evt);
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
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pengarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(judul, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(cbbPenerbit, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbKategori, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBoxcari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addComponent(jBHapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBSimpan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap(39, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jBHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jBEdit)
                    .addComponent(cbbPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jBSimpan)
                    .addComponent(cbbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(ComboBoxcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditActionPerformed
        // TODO add your handling code here:
        if("".equals(id)){
            JOptionPane.showMessageDialog(null, "Klik Pada Tabel untuk Mengedit Data");
        }
        else if("".equals(judul.getText()) || "".equals(pengarang.getText()) || cbbKategori.getSelectedIndex()==0 || cbbPenerbit.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        }else{
            
            String jdl = judul.getText();
            String pngarang = pengarang.getText();
            int pnerbit = cbbPenerbit.getSelectedIndex();
            int kategori = cbbKategori.getSelectedIndex();

            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "UPDATE buku SET judul = ?, pengarang = ?, id_penerbit = ?, id_kategori = ? where id_buku = ?";
                PreparedStatement p = c.prepareStatement(query);

                p.setString(1, jdl);
                p.setString(2, pngarang);
                p.setInt(3, pnerbit);
                p.setInt(4, kategori);
                p.setString(5, id);
                p.executeUpdate();
                p.close();

                JOptionPane.showMessageDialog(null,"Berhasil Edit Data");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
                //bersih();
                loadData();
            }
        }
        id="";
        disButtonSimpan();
    }//GEN-LAST:event_jBEditActionPerformed

    private void jBHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHapusActionPerformed
        // TODO add your handling code here:
        if("".equals(id))
        {
            JOptionPane.showMessageDialog(null, "Klik pada tabel untuk menghapus data");
        }
        else
        {        
            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "DELETE FROM buku where id_buku = ?";
            
                PreparedStatement p = c.prepareStatement(query);

                p.setString(1, id);
                p.executeUpdate();
                p.close();

                JOptionPane.showMessageDialog(null,"Berhasil Hapus Data");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
                //bersih();
                loadData();
            }
            id="";
            disButtonSimpan();
        }
        
    }//GEN-LAST:event_jBHapusActionPerformed

    private void pengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pengarangActionPerformed

    private void jBSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSimpanActionPerformed
        // TODO add your handling code here:
        String kategori="";
        String penerbit="";
        
        if("".equals(judul.getText()) || "".equals(pengarang.getText()) || cbbKategori.getSelectedIndex()==0 || cbbPenerbit.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        }
        else
        {
            
            try{
            Connection c = KoneksiDatabase.getkoneksi();
            Statement s = c.createStatement();
            String sql = "select id_kategori from kategori where nama = '"+cbbKategori.getSelectedItem()+"'";
            ResultSet r = s.executeQuery(sql);
            while(r.next())
            {
                String p = r.getString("id_kategori");
                kategori = p;
            }
            
            sql = "select id_penerbit from penerbit where nama = '"+cbbPenerbit.getSelectedItem()+"'";
            r = s.executeQuery(sql);
            while(r.next())
            {
                String p = r.getString("id_penerbit");
                penerbit = p;
            }
            
            r.close();
            s.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
            
            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "insert into buku (judul, pengarang, id_penerbit, id_kategori, stts) values (?,?,?, ?,'Baru')";
                PreparedStatement p = c.prepareStatement(query);

                p.setString(1, ""+judul.getText()+"");
                p.setString(2, ""+pengarang.getText()+"");
                p.setString(3, ""+penerbit+"");
                p.setString(4, ""+kategori+"");
                p.execute();

                JOptionPane.showMessageDialog(null,"Berhasil Menyimpan Data");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Isilah Field Dengan Benar");
            }finally{
                //bersih();
                loadData();
            }
            id="";
        }
        
    }//GEN-LAST:event_jBSimpanActionPerformed
    
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
                plh = "id_buku";
            }
            else if(ComboBoxcari.getSelectedIndex()==1)
            {
                plh = "judul";
            }else if(ComboBoxcari.getSelectedIndex()==2)
            {
                plh = "pengarang";
            }
            else if(ComboBoxcari.getSelectedIndex()==3)
            {
                plh = "penerbit";
            }
            else if(ComboBoxcari.getSelectedIndex()==4)
            {
                plh = "ketegori";
            }
            ResultSet rs = s.executeQuery("SELECT * FROM vbuku WHERE "+plh+" LIKE '%"+cari.getText()+"%'");

            
            while(rs.next())
            {
                Object[] o = new Object[6];
                o[0] = rs.getString("id_buku");
                o[1] = rs.getString("judul");
                o[2] = rs.getString("pengarang");
                o[3] = rs.getString("penerbit");
                o[4] = rs.getString("ketegori");
                o[5] = rs.getString("keterangan");
                model.addRow(o);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==1)
        {
            tabelclick();
            disButtonSimpan();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        bersih();
        cari.setText("");
        id="";
        loadData();
        enaButtonSimpan();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cbbPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPenerbitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBoxcari;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox cbbKategori;
    private javax.swing.JComboBox cbbPenerbit;
    private javax.swing.JButton jBEdit;
    private javax.swing.JButton jBHapus;
    private javax.swing.JButton jBSimpan;
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
    private javax.swing.JTextField judul;
    private javax.swing.JTextField pengarang;
    // End of variables declaration//GEN-END:variables

    private String getName(ComboBoxModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
