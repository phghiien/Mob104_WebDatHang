/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.poly.shopbangiay.view;

import edu.poly.shopbangiay.helper.Auth;
import edu.poly.shopbangiay.model.KhachHang;
import edu.poly.shopbangiay.model.Voucher;
import edu.poly.shopbangiay.raven.datechooser.DateChooser;
import edu.poly.shopbangiay.service.VCService;
import edu.poly.shopbangiay.service.impl.VCServiceImpl;

import java.awt.Color;

import table.TableCustom;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Quang
 */
public class VoucherUI extends javax.swing.JPanel {

    /**
     * Creates new form VoucherUI
     */
    private VCService vcService = new VCServiceImpl();
    private DefaultTableModel defaultTableModel;
    private DateChooser dateChooser = new DateChooser();
    private DateChooser dateChooser1 = new DateChooser();

    DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public VoucherUI() {
        initComponents();
        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        loadData(vcService.timKiem(txtTim.getText()));
        groupTT();

        dateChooser.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        dateChooser1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        dateChooser.setTextField(txtTuNgay);
        dateChooser1.setTextField(txtDenNgay);
        phanQuyen();
    }

    public void phanQuyen() {
        if (Auth.isManager()) {
            btnThem.setVisible(true);
            btnSua.setVisible(true);
            btnXoa.setVisible(true);
        } else {
            btnThem.setVisible(false);
            btnSua.setVisible(false);
            btnXoa.setVisible(false);
        }
    }

    public void loadData(List<Voucher> list) {
        defaultTableModel = (DefaultTableModel) tblVC.getModel();
        defaultTableModel.setRowCount(0);

        int stt = 1;
        for (Voucher vc : list) {
            defaultTableModel.addRow(new Object[]{
                    stt++,
                    vc.getMa(),
                    vc.getTen(),
                    vc.getPhanTramGiam(),
                    simpleDateFormat.format(vc.getNgayTao()),
                    simpleDateFormat.format(vc.getNgayBD()),
                    simpleDateFormat.format(vc.getNgayKT()),
                    vc.getTrangThai() ? "Hoạt động" : "Hết hạn",
                    vc.getMoTa()
            });
        }
    }

    public String genMaVC() {
        for (int i = 0; i < vcService.getList().size() + 1; i++) {
            String ma = "VC" + i;
            if (vcService.getVCByMa(ma) == null) {
                return ma;
            }
        }
        return null;
    }

    ButtonGroup rdoTT = new ButtonGroup();

    public void groupTT() {
        rdoTT.add(rdoOnl);
        rdoTT.add(rdoHetHan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtMa = new textfield.TextField();
        txtTen = new textfield.TextField();
        txtGiam = new textfield.TextField();
        txtNgayTao = new textfield.TextField();
        txtTuNgay = new textfield.TextField();
        txtDenNgay = new textfield.TextField();
        jLabel2 = new javax.swing.JLabel();
        rdoOnl = new radio_button.RadioButtonCustom();
        rdoHetHan = new radio_button.RadioButtonCustom();
        textAreaScroll1 = new textarea.TextAreaScroll();
        txtMoTa = new textarea.TextArea();
        btnXoa = new edu.poly.shopbangiay.raven.button.Button();
        txtTim = new textfield.TextField();
        btnSua = new edu.poly.shopbangiay.raven.button.Button();
        btnThem = new edu.poly.shopbangiay.raven.button.Button();
        jPanel2 = new javax.swing.JPanel();
        tableScrollButton1 = new table.TableScrollButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVC = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHUYẾN MẠI");

        txtMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMa.setLabelText("Mã");

        txtTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTen.setLabelText("Tên");

        txtGiam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGiam.setLabelText("Phần trăm giảm");

        txtNgayTao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNgayTao.setLabelText("Ngày tạo");

        txtTuNgay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTuNgay.setLabelText("Ngày áp dụng");

        txtDenNgay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDenNgay.setLabelText("Ngày hết hạn");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Trạng thái");

        rdoOnl.setText("Hoạt động");
        rdoOnl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        rdoHetHan.setText("Hết hạn");
        rdoHetHan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        textAreaScroll1.setBackground(new java.awt.Color(255, 255, 255));
        textAreaScroll1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textAreaScroll1.setLabelText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        textAreaScroll1.setViewportView(txtMoTa);

        btnXoa.setBackground(new java.awt.Color(255, 0, 153));
        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtTim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTim.setLabelText("Tìm kiếm");
        txtTim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimCaretUpdate(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 255, 102));
        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(102, 255, 102));
        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtGiam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(txtTuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDenNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoOnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTim, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                        .addGap(659, 659, 659)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoHetHan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoOnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblVC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tblVC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên", "Giảm", "Ngày tạo", "Ngày áp dụng", "Ngày hết hạn", "Trạng thái", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVC);

        tableScrollButton1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableScrollButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Xóa khuyến mại này");
        if (confirm == 0) {
            int row = tblVC.getSelectedRow();
            Voucher voucher = vcService.timKiem(txtTim.getText()).get(row);

            if (vcService.xoa(voucher)) {
                loadData(vcService.timKiem(txtTim.getText()));
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = tblVC.getSelectedRow();
        Voucher voucher = vcService.timKiem(txtTim.getText()).get(row);
        voucher.setMa(txtMa.getText());
        voucher.setTen(txtTen.getText());
        voucher.setPhanTramGiam(Integer.parseInt(txtGiam.getText()));
        voucher.setNgayTao(Date.valueOf(txtNgayTao.getText()));
        voucher.setNgayBD(Date.valueOf(txtTuNgay.getText()));
        voucher.setNgayKT(Date.valueOf(txtDenNgay.getText()));
        boolean trangThai = true;
        if (rdoHetHan.isSelected()) {
            trangThai = false;
        }
        voucher.setTrangThai(trangThai);
        voucher.setMoTa(txtMoTa.getText());

        if (vcService.sua(voucher)) {
            loadData(vcService.timKiem(txtTim.getText()));
            JOptionPane.showMessageDialog(this, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        Voucher voucher = new Voucher();
        voucher.setMa(genMaVC());
        voucher.setTen(txtTen.getText());
        voucher.setPhanTramGiam(Integer.parseInt(txtGiam.getText()));
        voucher.setNgayTao(Date.valueOf(LocalDate.now()));
        voucher.setNgayBD(Date.valueOf(txtTuNgay.getText()));
        voucher.setNgayKT(Date.valueOf(txtDenNgay.getText()));
        boolean trangThai = true;
        if (rdoHetHan.isSelected()) {
            trangThai = false;
        }
        voucher.setTrangThai(trangThai);
        voucher.setMoTa(txtMoTa.getText());

        if (vcService.them(voucher)) {
            loadData(vcService.timKiem(txtTim.getText()));
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblVCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVCMouseClicked
        // TODO add your handling code here:
        int row = tblVC.getSelectedRow();
        Voucher voucher = vcService.timKiem(txtTim.getText()).get(row);
        txtMa.setText(voucher.getMa());
        txtTen.setText(voucher.getTen());
        txtGiam.setText(voucher.getPhanTramGiam().toString());
        txtNgayTao.setText(voucher.getNgayTao().toString());
        txtTuNgay.setText(voucher.getNgayBD().toString());
        txtDenNgay.setText(voucher.getNgayKT().toString());
        if (voucher.getTrangThai() == true) {
            rdoOnl.setSelected(true);
        } else {
            rdoOnl.setSelected(false);
        }
        txtMoTa.setText(voucher.getMoTa());
    }//GEN-LAST:event_tblVCMouseClicked

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
        // TODO add your handling code here:
        String tim = txtTim.getText();
        List<Voucher> list = vcService.timKiem(tim);
        loadData(list);
    }//GEN-LAST:event_txtTimCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private edu.poly.shopbangiay.raven.button.Button btnSua;
    private edu.poly.shopbangiay.raven.button.Button btnThem;
    private edu.poly.shopbangiay.raven.button.Button btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private radio_button.RadioButtonCustom rdoHetHan;
    private radio_button.RadioButtonCustom rdoOnl;
    private table.TableScrollButton tableScrollButton1;
    private javax.swing.JTable tblVC;
    private textarea.TextAreaScroll textAreaScroll1;
    private textfield.TextField txtDenNgay;
    private textfield.TextField txtGiam;
    private textfield.TextField txtMa;
    private textarea.TextArea txtMoTa;
    private textfield.TextField txtNgayTao;
    private textfield.TextField txtTen;
    private textfield.TextField txtTim;
    private textfield.TextField txtTuNgay;
    // End of variables declaration//GEN-END:variables
}