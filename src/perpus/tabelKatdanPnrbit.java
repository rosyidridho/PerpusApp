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


/**
 *
 * @author Rosyid
 */
public class tabelKatdanPnrbit extends javax.swing.JPanel {
private final DefaultTableModel model;
private final DefaultTableModel model2;
String id="";
String id2="";
    /**
     * Creates new form tabelBuku
     */
    public tabelKatdanPnrbit() {
        initComponents();
        //membuat tablemodel
        model = new DefaultTableModel();
        model2 = new DefaultTableModel();
        //menambah tablemodel ke tabel
        jTable1.setModel(model);        
        model.addColumn("ID Penerbit");
        model.addColumn("Nama");
        model.addColumn("No HP");
        model.addColumn("No telepon");
        model.addColumn("Alamat");
        
        TKategori.setModel(model2);        
        model2.addColumn("ID Kategori");
        model2.addColumn("Nama");
        model2.addColumn("Keterangan");
        
        loadData();
        loadData2();
        
        enaButtonSimpan2();
        enaButtonSimpan1();
    }
    
    public void disButtonSimpan1(){
        jBSimpan1.setEnabled(false);
        jBEdit1.setEnabled(true);
        jBHapus1.setEnabled(true);
    }
    
    public void enaButtonSimpan1(){
        jBSimpan1.setEnabled(true);
        jBEdit1.setEnabled(false);
        jBHapus1.setEnabled(false);
    }
    
    public void disButtonSimpan2(){
        jBSimpan2.setEnabled(false);
        jBEdit2.setEnabled(true);
        jBHapus2.setEnabled(true);
    }
    
    public void enaButtonSimpan2(){
        jBSimpan2.setEnabled(true);
        jBEdit2.setEnabled(false);
        jBHapus2.setEnabled(false);
    }
    
    int row = 0;
    public void tabelclick()
    {
        row = jTable1.getSelectedRow();
        id = jTable1.getValueAt(row, 0).toString();
        nama.setText(jTable1.getValueAt(row, 1).toString());
        noHP.setText(jTable1.getValueAt(row, 2).toString());
        no_telp.setText(jTable1.getValueAt(row, 3).toString());
        alamat.setText(jTable1.getValueAt(row, 4).toString());        
    }
    
    int row2 = 0;
    public void tabelclick2()
    {
        row2 = TKategori.getSelectedRow();
        id2 = TKategori.getValueAt(row2, 0).toString();
        namaKat.setText(TKategori.getValueAt(row2, 1).toString());
        taArea.setText(TKategori.getValueAt(row2, 2).toString());      
    }
    
    public void bersih()
    {
        nama.setText("");
        noHP.setText("");
        no_telp.setText("");
        alamat.setText("");
        cari.setText("");
    }
    
    public void bersih2()
    {
        namaKat.setText("");
        taArea.setText("");
        cari2.setText("");
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
            String sql = "select * from penerbit";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[5];
                o[0] = r.getString("id_penerbit");
                o[1] = r.getString("nama");
                o[2] = r.getString("no_hp");
                o[3] = r.getString("no_telp");
                o[4] = r.getString("alamat");
                model.addRow(o);
            }
            r.close();
            s.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void loadData2()
    {
        //menghapus seluruh data
        model2.getDataVector().removeAllElements();
        //memberitahu bahwa data telah kosong
        model2.fireTableDataChanged();
        try{
            Connection c = KoneksiDatabase.getkoneksi();
            Statement s = c.createStatement();
            String sql = "select * from kategori";
            ResultSet r = s.executeQuery(sql);
            
            while(r.next())
            {
                Object[] o = new Object[3];
                o[0] = r.getString("id_kategori");
                o[1] = r.getString("nama");
                o[2] = r.getString("ket");
                model2.addRow(o);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jBEdit1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jBHapus1 = new javax.swing.JButton();
        ComboBoxcari = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        noHP = new javax.swing.JTextField();
        jBSimpan1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        nama = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        no_telp = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jBEdit2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        cari2 = new javax.swing.JTextField();
        jBHapus2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jBSimpan2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TKategori = new javax.swing.JTable();
        namaKat = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taArea = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 0, 51));

        jPanel3.setBackground(new java.awt.Color(204, 0, 51));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(204, 0, 51));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Penerbit & Kategori");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(180, 2, 46));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("No Telepon");

        jBEdit1.setText("Edit");
        jBEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEdit1ActionPerformed(evt);
            }
        });

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Alamat");

        jBHapus1.setText("Hapus");
        jBHapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHapus1ActionPerformed(evt);
            }
        });

        ComboBoxcari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID Penerbit", "Nama Penerbit" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama");

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No HP");

        noHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noHPActionPerformed(evt);
            }
        });

        jBSimpan1.setText("Simpan");
        jBSimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSimpan1ActionPerformed(evt);
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

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Penerbit");

        no_telp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_telpActionPerformed(evt);
            }
        });

        alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ComboBoxcari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(no_telp, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(noHP, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nama, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(alamat))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                    .addComponent(jBHapus1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBEdit1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jBSimpan1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jBHapus1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jBEdit1)
                    .addComponent(no_telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jBSimpan1)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(ComboBoxcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(180, 2, 46));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBEdit2.setText("Edit");
        jBEdit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEdit2ActionPerformed(evt);
            }
        });

        jButton7.setText("Cari");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jBHapus2.setText("Hapus");
        jBHapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHapus2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nama");

        jButton9.setText("Refresh");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ket");

        jBSimpan2.setText("Simpan");
        jBSimpan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSimpan2ActionPerformed(evt);
            }
        });

        TKategori.setModel(new javax.swing.table.DefaultTableModel(
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
        TKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TKategoriMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TKategori);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Kategori");

        taArea.setColumns(20);
        taArea.setRows(5);
        jScrollPane3.setViewportView(taArea);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Masukkan Nama");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(namaKat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jBHapus2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBEdit2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBSimpan2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(cari2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaKat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBHapus2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEdit2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSimpan2))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(cari2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEdit1ActionPerformed
        // TODO add your handling code here:
        if("".equals(id)){
            JOptionPane.showMessageDialog(null, "Klik Pada Tabel untuk Mengedit Data");
        }
        else if("".equals(nama.getText()) || "".equals(noHP.getText()) || "".equals(no_telp.getText()) || "".equals(alamat.getText()))
        {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        }else{
            
            String nm = nama.getText();
            String hp = noHP.getText();
            String telp = no_telp.getText();
            String almt = alamat.getText();

            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "UPDATE penerbit SET nama = ?, no_hp = ?, no_telp = ?, alamat = ? where id_penerbit = ?";
                PreparedStatement p = c.prepareStatement(query);

                p.setString(1, nm);
                p.setString(2, hp);
                p.setString(3, telp);
                p.setString(4, almt);
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
        disButtonSimpan1();
    }//GEN-LAST:event_jBEdit1ActionPerformed

    private void jBHapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHapus1ActionPerformed
        // TODO add your handling code here:
        if("".equals(id))
        {
            JOptionPane.showMessageDialog(null, "Klik pada tabel untuk menghapus data");
        }
        else
        {        
            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "DELETE FROM penerbit where id_penerbit = ?";
            
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
            disButtonSimpan1();
        }
        
    }//GEN-LAST:event_jBHapus1ActionPerformed

    private void noHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noHPActionPerformed

    private void jBSimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSimpan1ActionPerformed
        // TODO add your handling code here:
        
        if("".equals(nama.getText()) || "".equals(noHP.getText()) || "".equals(no_telp.getText()) || "".equals(alamat.getText()))
        {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        }
        else
        {
            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "insert into penerbit (nama, no_hp, no_telp, alamat) values (?,?,?,?)";
                PreparedStatement p = c.prepareStatement(query);

                p.setString(1, ""+nama.getText()+"");
                p.setString(2, ""+noHP.getText()+"");
                p.setString(3, ""+no_telp.getText()+"");
                p.setString(4, ""+alamat.getText()+"");
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
        
    }//GEN-LAST:event_jBSimpan1ActionPerformed
    
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
                plh = "id_penerbit";
            }
            else if(ComboBoxcari.getSelectedIndex()==1)
            {
                plh = "nama";
            }
            ResultSet rs = s.executeQuery("SELECT * FROM penerbit WHERE "+plh+" LIKE '%"+cari.getText()+"%'");

            
            while(rs.next())
            {
                Object[] o = new Object[6];
                o[0] = rs.getString("id_penerbit");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("no_hp");
                o[3] = rs.getString("no_telp");
                o[4] = rs.getString("alamat");
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
            disButtonSimpan1();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        bersih();
        cari.setText("");
        id="";
        loadData();
        enaButtonSimpan1();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void no_telpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_telpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_telpActionPerformed

    private void alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatActionPerformed

    private void jBEdit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEdit2ActionPerformed
        // TODO add your handling code here:
        if("".equals(id2)){
            JOptionPane.showMessageDialog(null, "Klik Pada Tabel untuk Mengedit Data");
        }
        else if("".equals(namaKat.getText()) || "".equals(taArea.getText()))
        {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        }else{
            
            String nm = namaKat.getText();
            String ket = taArea.getText();

            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "UPDATE kategori SET nama = ?, ket = ? where id_kategori = ?";
                PreparedStatement p = c.prepareStatement(query);

                p.setString(1, nm);
                p.setString(2, ket);
                p.setString(3, id2);
                p.executeUpdate();
                p.close();

                JOptionPane.showMessageDialog(null,"Berhasil Edit Data");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
                //bersih();
                loadData2();
            }
        }
        id2="";
        disButtonSimpan2();
    }//GEN-LAST:event_jBEdit2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if("".equals(cari2.getText())){
            JOptionPane.showMessageDialog(null, "Masukkan key terlebih dulu pada field cari");
        }else{
            //menghapus seluruh data
        model2.getDataVector().removeAllElements();
        //memberitahu bahwa data telah kosong
        model2.fireTableDataChanged();
        try{
            Connection c = KoneksiDatabase.getkoneksi();
            Statement s = c.createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM kategori WHERE nama LIKE '%"+cari2.getText()+"%'");

            
            while(rs.next())
            {
                Object[] o = new Object[3];
                o[0] = rs.getString("id_kategori");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("ket");
                model2.addRow(o);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jBHapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHapus2ActionPerformed
        // TODO add your handling code here:
        if("".equals(id2))
        {
            JOptionPane.showMessageDialog(null, "Klik pada tabel untuk menghapus data");
        }
        else
        {        
            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "DELETE FROM kategori where id_kategori = ?";
            
                PreparedStatement p = c.prepareStatement(query);

                p.setString(1, id2);
                p.executeUpdate();
                p.close();

                JOptionPane.showMessageDialog(null,"Berhasil Hapus Data");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
                //bersih();
                loadData2();
            }
            id2="";
            disButtonSimpan2();
        }
    }//GEN-LAST:event_jBHapus2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        bersih2();
        id2="";
        loadData2();
        enaButtonSimpan2();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jBSimpan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSimpan2ActionPerformed
        // TODO add your handling code here:
        if("".equals(namaKat.getText()) || "".equals(taArea.getText()))
        {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        }
        else
        {
            try{
                Connection c = KoneksiDatabase.getkoneksi();
                String query = "insert into kategori (nama, ket) values (?,?)";
                PreparedStatement p = c.prepareStatement(query);

                p.setString(1, ""+namaKat.getText()+"");
                p.setString(2, ""+taArea.getText()+"");
                p.execute();

                JOptionPane.showMessageDialog(null,"Berhasil Menyimpan Data");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Isilah Field Dengan Benar");
            }finally{
                //bersih();
                loadData2();
            }
            id2="";
        }
    }//GEN-LAST:event_jBSimpan2ActionPerformed

    private void TKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TKategoriMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            tabelclick2();
            disButtonSimpan2();
        }
    }//GEN-LAST:event_TKategoriMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBoxcari;
    private javax.swing.JTable TKategori;
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField cari;
    private javax.swing.JTextField cari2;
    private javax.swing.JButton jBEdit1;
    private javax.swing.JButton jBEdit2;
    private javax.swing.JButton jBHapus1;
    private javax.swing.JButton jBHapus2;
    private javax.swing.JButton jBSimpan1;
    private javax.swing.JButton jBSimpan2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField namaKat;
    private javax.swing.JTextField noHP;
    private javax.swing.JTextField no_telp;
    private javax.swing.JTextArea taArea;
    // End of variables declaration//GEN-END:variables

    private String getName(ComboBoxModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
