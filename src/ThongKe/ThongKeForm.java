/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ThongKe;

import DonHang.DonHang;
import ExportExcel.ExportExcel;
import MenuQuanLy.MenuForm;
import NhaCungCap.NCC;
import SanPham.SanPham;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import static ExportExcel.ExportExcel.exportExcel;
import javax.swing.table.TableModel;
/**
 *
 * @author Administrator
 */
public class ThongKeForm extends javax.swing.JFrame {

    private ArrayList<NCC> listNCC = NCC.getNCCList();
    private ArrayList<DonHang> listDH = DonHang.getDonHangList();
    private ArrayList<SanPham> listSP = SanPham.getSanPhamList();
    private DefaultTableModel tblModel = new DefaultTableModel();

    /**
     * Creates new form ThongKeForm
     */
    public ThongKeForm() {
        initComponents();
        initTable();
        fillTable();
        setLocationRelativeTo(null); // chinh cua so xuat hien chinh giua man hinh
    }

    private int tongSLN(String maSP) {
        int tongSLN = 0;
        for (NCC o : listNCC) {
            if (o.getMaSP().equalsIgnoreCase(maSP)) {
                tongSLN += o.getSoLuongNhap();
            }
        }
        return tongSLN;
    }

    private int tongSLX(String maSP) {
        int tongSLX = 0;
        for (DonHang o : listDH) {
            if (o.getMaSP().equalsIgnoreCase(maSP)) {
                tongSLX += o.getSoLuongMua();
            }
        }
        return tongSLX;
    }
    
    private int tongSLCo(String maSP) {
        int tongSLCo = 0;
        for (SanPham o : listSP) {
            if (o.getMaSP().equalsIgnoreCase(maSP)) {
                tongSLCo += o.getSoLuong();
            }
        }
        return tongSLCo;
    }

    private double tinhTienTheoSLN(String maSP) {
        double tongTienSLN = 0;
        for (SanPham o : listSP) {
            if (o.getMaSP().equalsIgnoreCase(maSP)) {
                tongTienSLN += tongSLN(o.getMaSP()) * o.getGia();
            }
        }
        return tongTienSLN;
    }

    private double tinhTienTheoSLX(String maSP) {
        double tongTienSLX = 0;
        for (SanPham o : listSP) {
            if (o.getMaSP().equalsIgnoreCase(maSP)) {
                tongTienSLX += tongSLX(o.getMaSP()) * o.getGia();
            }
        }
        return tongTienSLX;
    }

    private void fillTable() {
        tblModel.setRowCount(0);
        for (SanPham o : listSP) {
            tblModel.addRow(new String[]{o.getMaSP(),
                "" + tongSLN(o.getMaSP()),
                "" + tinhTienTheoSLN(o.getMaSP()),
                "" + tongSLX(o.getMaSP()),
                "" + tinhTienTheoSLX(o.getMaSP()),
                ""+ ( tongSLCo(o.getMaSP()) +  tongSLN(o.getMaSP()) -  tongSLX(o.getMaSP()) )
            });
        }
        tblModel.fireTableDataChanged();
    }

    private void initTable() {
        String[] columns = new String[]{"Mã sản phẩm", "Tổng số lượng nhập", "Tổng tiền nhập",  "Tổng số lượng xuất", "Tổng tiền xuất", "Số lượng tồn kho"};
        tblModel.setColumnIdentifiers(columns);
        tblTKe.setModel(tblModel);
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
        btnBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTKe = new javax.swing.JTable();
        btn_xuatFileExel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Thống kê");

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setText("Quay Lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblTKe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblTKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(tblTKe);

        btn_xuatFileExel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_xuatFileExel.setText("Xuất file exel");
        btn_xuatFileExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatFileExelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_xuatFileExel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_xuatFileExel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuForm formMenu = new MenuForm();
        formMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btn_xuatFileExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatFileExelActionPerformed
        // TODO add your handling code here:
        ExportExcel.exportExcel(tblTKe);
    }//GEN-LAST:event_btn_xuatFileExelActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ThongKeForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btn_xuatFileExel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblTKe;
    // End of variables declaration//GEN-END:variables

    
}
