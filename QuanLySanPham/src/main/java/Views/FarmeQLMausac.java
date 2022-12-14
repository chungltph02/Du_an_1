/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Services.IMauSacService;
import Services.MauSacService;
import Utils.CheckData;
import ViewsModels.MauSacModel;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hieu
 */
public class FarmeQLMausac extends javax.swing.JFrame {
    MauSacModel _MauSacModel;
    IMauSacService _IMauSacService;
    DefaultTableModel _DefaultTableModel;
    CheckData _check;

    public FarmeQLMausac() {
        initComponents();
        _IMauSacService = new MauSacService();
        _check = new CheckData();
        loadtable(_IMauSacService.getproduct());
        txt_mamausac.setText("MS" + String.valueOf(_IMauSacService.getmamausac()));
        txt_mamausac.setEnabled(false);
    }

    MauSacModel getdata() {
        return new MauSacModel(Integer.parseInt(txt_mamausac.getText().substring(2)), txt_tenmaussac.getText(), txt_mota.getText());
    }

    public void loadtable(List<MauSacModel> ms) {
        _DefaultTableModel = (DefaultTableModel) tbl_mausac.getModel();
        _DefaultTableModel.setRowCount(0);
        for (MauSacModel x : ms) {
            _DefaultTableModel.addRow(new Object[]{"MS" + x.getMaMauSac(), x.getTenMauSac(), x.getMota()});
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_tenmaussac = new javax.swing.JTextField();
        txt_mota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_mausac = new javax.swing.JTable();
        btn_sua = new javax.swing.JButton();
        txt_mamausac = new javax.swing.JTextField();
        btn_sua1 = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("M??u s???c");

        jLabel2.setText("M?? m??u s???c");

        jLabel3.setText("T??n m??u s???c");

        btn_them.setText("Th??m");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        jLabel4.setText("M?? t???");

        tbl_mausac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "m?? m??u s???c", "T??n", "m?? t???"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_mausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_mausacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_mausac);
        if (tbl_mausac.getColumnModel().getColumnCount() > 0) {
            tbl_mausac.getColumnModel().getColumn(0).setResizable(false);
            tbl_mausac.getColumnModel().getColumn(1).setResizable(false);
            tbl_mausac.getColumnModel().getColumn(2).setResizable(false);
        }

        btn_sua.setText("s???a");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_sua1.setText("Clear");
        btn_sua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua1ActionPerformed(evt);
            }
        });

        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });
        txt_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timkiemActionPerformed(evt);
            }
        });

        jButton1.setText("T??m ki???m");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tenmaussac, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(txt_mamausac))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btn_them)
                                .addGap(18, 18, 18)
                                .addComponent(btn_sua)
                                .addGap(18, 18, 18)
                                .addComponent(btn_sua1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_mamausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_tenmaussac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them)
                            .addComponent(btn_sua)
                            .addComponent(btn_sua1))
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed

        if (txt_tenmaussac.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Kh??ng ???????c ????? tr???ng t??n");
            return;
        }
        int xacnhan = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n th??m ko ? ");
        if (xacnhan != JOptionPane.YES_OPTION) {
            return;
        }
        List<MauSacModel> ds = _IMauSacService.getproduct();
        MauSacModel spMoi = getdata();
        if (_IMauSacService.them(getdata()) != null) {
            JOptionPane.showMessageDialog(this, "Th??nh c??ng");
        } else {
            JOptionPane.showMessageDialog(this, "Th???t b???i");
        }
        loadtable(_IMauSacService.getproduct());

    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        for (MauSacModel x : _IMauSacService.getproduct()) {
             if (x.getMaMauSac() == Integer.parseInt(txt_mamausac.getText().substring(2))) {
                if (_check.checkNullString(txt_tenmaussac.getText())) {
                    JOptionPane.showMessageDialog(this, "Kh??ng ???????c ????? tr???ng T??n");
                    return;
                }
                int xacnhan = JOptionPane.showConfirmDialog(this, "B???n c?? mu???n th??y ?????i ko?");
        if (xacnhan != JOptionPane.YES_OPTION) {
            return;
        }
                JOptionPane.showMessageDialog(this, _IMauSacService.sua(getdata()));
                loadtable(_IMauSacService.getproduct());
                return;
        }
        }
        JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y m??!");
    }//GEN-LAST:event_btn_suaActionPerformed

    private void tbl_mausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_mausacMouseClicked
        int row = tbl_mausac.getSelectedRow();
        txt_mamausac.setText(tbl_mausac.getValueAt(row, 0).toString());
        txt_tenmaussac.setText(tbl_mausac.getValueAt(row, 1).toString());
        txt_mota.setText(tbl_mausac.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tbl_mausacMouseClicked

    private void btn_sua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua1ActionPerformed
        txt_mamausac.setText("MS" + String.valueOf(_IMauSacService.getmamausac()));
        txt_tenmaussac.setText("");
        txt_mota.setText("");
    }//GEN-LAST:event_btn_sua1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       JOptionPane.showMessageDialog(this, _IMauSacService.Timkiem(txt_timkiem.getText())); 
        loadtable( _IMauSacService.Timkiem(txt_timkiem.getText()));
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timkiemActionPerformed
         JOptionPane.showMessageDialog(this, _IMauSacService.Timkiem(txt_timkiem.getText())); 
        loadtable(_IMauSacService.Timkiem(txt_timkiem.getText()));
    }//GEN-LAST:event_txt_timkiemActionPerformed

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate
        
        loadtable(_IMauSacService.Timkiem(txt_timkiem.getText()));
    }//GEN-LAST:event_txt_timkiemCaretUpdate

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FarmeQLMausac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FarmeQLMausac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FarmeQLMausac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FarmeQLMausac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FarmeQLMausac().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_sua1;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_mausac;
    private javax.swing.JTextField txt_mamausac;
    private javax.swing.JTextField txt_mota;
    private javax.swing.JTextField txt_tenmaussac;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
