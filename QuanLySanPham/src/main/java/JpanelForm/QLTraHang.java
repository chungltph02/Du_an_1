/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JpanelForm;

import Repositories.IThongKeRepository;
import Repositories.ThongKeRepository;
import Services.HoaDonChiTietService;
import Services.HoaDonDoiTraChiTietService;
import Services.HoaDonDoiTraService;
import Services.HoaDonService;
import Services.IHoaDonChiTietService;
import Services.IHoaDonDoiTraChiTietService;
import Services.IHoaDonDoiTraService;
import Services.IHoaDonService;
import Services.ISanPhamService;
import Services.IThongKeService;
import Services.SanPhamService;
import Services.ThongKeService;
import Utils.Auth;
import Utils.CheckData;
import ViewsModels.HoaDonChiTietModel;
import ViewsModels.HoaDonDoiTraChiTietModel;
import ViewsModels.HoaDonDoiTraMoDel;
import ViewsModels.HoaDonModel;
import ViewsModels.KhachHangModel;
import ViewsModels.SanPhamModel;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dytc0
 */
public class QLTraHang extends javax.swing.JFrame {

    DefaultTableModel _defaultTB;
    IThongKeService _IThongKeRepository;
    CheckData _checkDt;
    IHoaDonChiTietService _HoaDonCTService;
    IHoaDonDoiTraService _hoaDonDoiTraService;
    IHoaDonDoiTraChiTietService _ihoadDoiTraChiTietService;
    NumberFormat _formatter = new DecimalFormat("#,###");
    IHoaDonService _iHoaDonService;
    ISanPhamService _ISanPhamService;

    /**
     * Creates new form QLTraHang
     */
    public QLTraHang() {
        initComponents();
        _HoaDonCTService = new HoaDonChiTietService();
        _IThongKeRepository = new ThongKeService();
        _hoaDonDoiTraService = new HoaDonDoiTraService();
        _ihoadDoiTraChiTietService = new HoaDonDoiTraChiTietService();
        _iHoaDonService = new HoaDonService();
        _ISanPhamService = new SanPhamService();
        _checkDt = new CheckData();
        loadtable(_IThongKeRepository.thongke5());
        setlbl();
        tbl_hd.setEnabled(false);
    }

    void setlbl() {
        lbl_hoadon.setText("");
        lbl_nhanVien.setText("");
        lbl_khachHang.setText("");
        lbl_tongtienhoantra.setText("0");
    }

    void tongTienTra() {
        long tongtien = 0;
        for (int i = 0; i < tbl_sanPhamTra.getRowCount(); i++) {
            tongtien = tongtien + (Long.parseLong(tbl_sanPhamTra.getModel().getValueAt(i, 8).toString()) * Long.parseLong(tbl_sanPhamTra.getModel().getValueAt(i, 9).toString()));
        }
        lbl_tongtienhoantra.setText(String.valueOf(_formatter.format(tongtien)));
    }

    public void loadtableSanPhamTra(int mahddt) {
        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_sanPhamTra.getModel();
        _DefaultTableModel.setRowCount(0);
        int stt = 1;
        for (HoaDonDoiTraChiTietModel x : _ihoadDoiTraChiTietService.getListFromDB(mahddt)) {
            _DefaultTableModel.addRow(new Object[]{
                stt++,
                x.getSanPhamModel().getMaSanPham(), x.getSanPhamModel().getTenSanPham(),
                x.getSanPhamModel().getChatlieuModel().getTenChatLieu(),
                x.getSanPhamModel().getDanhMucSanPhamModel().getTenDanhMuc(),
                x.getSanPhamModel().getKieudangModel().getTenKieuDang(),
                x.getSanPhamModel().getSizeModel().getTenSize(),
                x.getSanPhamModel().getMausacModel().getTenMauSac(),
                x.getSoLuong(), x.getDonGia()
            });
        }
    }

    public void loadtable(List<HoaDonModel> hdmd) {
        DefaultTableModel _DefaultTableModel = new DefaultTableModel();
        _DefaultTableModel = (DefaultTableModel) tbl_hd.getModel();
        _DefaultTableModel.setRowCount(0);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (HoaDonModel x : hdmd) {
            _DefaultTableModel.addRow(new Object[]{x.getMaHoaDon(), dateFormat.format(x.getThoiGianTao()),
                x.getTrangThai() == 0 ? "??ang Ch???" : x.getTrangThai() == 1 ? "H???y" : "Th??nh C??ng",
                x.getKhachhang().getMaKhachHang() == 1 ? "Kh??ch L???" : x.getKhachhang().getHoTen(), x.getKhuyenmai().getTenKhuyenMai(), x.getNhanvien().getHoTen()});
        }
    }

    void fillTableTheoNgay(int a) {
        DefaultTableModel model = (DefaultTableModel) tbl_hdct.getModel();
        model.setRowCount(0);
        List<HoaDonChiTietModel> list = _HoaDonCTService.getListFromDB(a);
        for (HoaDonChiTietModel x : list) {
            model.addRow(new Object[]{
                x.getSanPhamModel().getMaSanPham(), x.getSanPhamModel().getTenSanPham(), x.getSoLuong(), x.getDonGia(), _formatter.format(x.getDonGia() * x.getSoLuong())
            });
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

        pmn_tblHoaDonChiTiet = new javax.swing.JPopupMenu();
        mni_trahang = new javax.swing.JMenuItem();
        pmn_danhSachSPTra = new javax.swing.JPopupMenu();
        mni_xoaSp = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hd = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_hdct = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_sanPhamTra = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_hoadon = new javax.swing.JLabel();
        lbl_nhanVien = new javax.swing.JLabel();
        lbl_khachHang = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tar_lydo = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        lbl_tongtienhoantra = new javax.swing.JLabel();
        btn_traHang = new javax.swing.JButton();

        mni_trahang.setText("Tr??? H??ng");
        mni_trahang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_trahangActionPerformed(evt);
            }
        });
        pmn_tblHoaDonChiTiet.add(mni_trahang);

        mni_xoaSp.setText("X??a");
        mni_xoaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mni_xoaSpActionPerformed(evt);
            }
        });
        pmn_danhSachSPTra.add(mni_xoaSp);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jPanel2AncestorRemoved(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Danh S??ch H??a ????n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tbl_hd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma Hoa Don", "Thoi Gian", "Trang Thai", "T??n Khach Hang", "T??n Khuyen Mai", "T??n Nhan Vien"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_hd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hdMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_hdMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hd);

        jLabel6.setText("T??m Ki???m :");

        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "H??a ????n Chi Ti???t", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tbl_hdct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? S???n Ph???m", "T??n S???n Ph???m", "S??? L?????ng", "????n Gi??", "T???ng ti???n"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_hdct.setComponentPopupMenu(pmn_tblHoaDonChiTiet);
        jScrollPane2.setViewportView(tbl_hdct);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh S??ch S???n Ph???m Tr???", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tbl_sanPhamTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "M?? s???n ph???m", "T??n s???n ph???m", "Ch???t Li???u", "Danh M???c", "Ki???u d??ng", "Size", "M??u S???c", "S??? l?????ng", "Gi?? ti???n"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_sanPhamTra.setComponentPopupMenu(pmn_danhSachSPTra);
        tbl_sanPhamTra.setInheritsPopupMenu(true);
        jScrollPane3.setViewportView(tbl_sanPhamTra);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Th??ng Tin Tr??? H??ng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setText("Nh??n Vi??n :");

        jLabel2.setText("H??a ????n :");

        jLabel3.setText("Kh??ch H??ng :");

        jLabel4.setText("L?? Do :");

        lbl_hoadon.setText("hoadon");

        lbl_nhanVien.setText("nhanvien");

        lbl_khachHang.setText("kh??ch h??ng");

        tar_lydo.setColumns(20);
        tar_lydo.setRows(5);
        jScrollPane4.setViewportView(tar_lydo);

        jLabel5.setText("T???ng ti???n Ho??n Tr??? :");

        lbl_tongtienhoantra.setText("0");

        btn_traHang.setText("Tr??? H??ng");
        btn_traHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_traHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_traHang)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_tongtienhoantra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_nhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(lbl_hoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                    .addComponent(lbl_khachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_hoadon))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_nhanVien))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_khachHang))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_tongtienhoantra))
                .addGap(18, 18, 18)
                .addComponent(btn_traHang)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_hdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hdMouseClicked
//        
    }//GEN-LAST:event_tbl_hdMouseClicked

    private void mni_trahangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_trahangActionPerformed
        int row = tbl_hdct.getSelectedRow();
        int rowhdon = tbl_hd.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui l??ng ch???n S???n Ph???m C???n Tr???");
            return;
        }
        if (Integer.parseInt(tbl_hdct.getModel().getValueAt(row, 2).toString()) == 0) {
            JOptionPane.showMessageDialog(this, "???? tr??? h???t h???t ph???m");
            return;
        }
        String temp = JOptionPane.showInputDialog(this, "Nh???p S??? L?????ng S???n ph???m Mu???n Tr???");
        if (temp == null) {
            return;
        }
        if (temp.isBlank()) {
            JOptionPane.showMessageDialog(this, "Kh??ng ???????c ????? tr???ng");
            return;
        }
        if (_checkDt.chekcKhoangTrang(temp)) {
            JOptionPane.showMessageDialog(this, "Kh??ng ???????c ????? kho???ng tr???ng");
            return;
        }
        if (temp.length() > 6) {
            JOptionPane.showMessageDialog(this, "Nh???p t???i ??a 5 k?? t??? s???");
            return;
        }
        if (!_checkDt.checkso(temp) || Integer.parseInt(temp) <= 0) {
            JOptionPane.showMessageDialog(this, "B???n Ph???i nh???p s??? v?? ph???i > 0 , kh??ng ch???a k?? t???");
            return;
        }
        if (Long.parseLong(temp) > 99999) {
            JOptionPane.showMessageDialog(this, "s??? l?????ng t???i ??a c?? th??? nh???p l?? l?? 99,999");
            return;
        }

        if (Integer.parseInt(temp) > Integer.parseInt(tbl_hdct.getModel().getValueAt(row, 2).toString())) {
            JOptionPane.showMessageDialog(this, "S??? l?????ng tr??? ph???i b?? h??n s??? l?????ng ??ang c??");
            return;
        }
        HoaDonModel hdmodel = new HoaDonModel();
        hdmodel.setMaHoaDon(Integer.parseInt(tbl_hd.getModel().getValueAt(rowhdon, 0).toString()));

        KhachHangModel khmodel = new KhachHangModel();
        khmodel.setMaKhachHang(1);

        SanPhamModel sanPhamModel = new SanPhamModel();
        sanPhamModel.setMaSanPham(tbl_hdct.getModel().getValueAt(row, 0).toString());

        HoaDonDoiTraMoDel hoaDonDoiTraMoDel = _hoaDonDoiTraService.them(new HoaDonDoiTraMoDel(0, Integer.parseInt(tbl_hdct.getModel().getValueAt(row, 3).toString()) * Integer.parseInt(tbl_hdct.getModel().getValueAt(row, 2).toString()), new java.util.Date(), "", hdmodel, khmodel, Auth.user));//t???o h??a ????n tr???

        HoaDonChiTietModel hdct = new HoaDonChiTietModel(0, Integer.parseInt(tbl_hdct.getModel().getValueAt(row, 2).toString()) - Integer.parseInt(temp), Integer.parseInt(tbl_hdct.getModel().getValueAt(row, 3).toString()), sanPhamModel, hdmodel);//s???a h??a ????n chi ti???t
        _HoaDonCTService.sua(hdct);
        _ihoadDoiTraChiTietService.them(new HoaDonDoiTraChiTietModel(0, Integer.parseInt(temp), Integer.parseInt(tbl_hdct.getModel().getValueAt(row, 3).toString()), hoaDonDoiTraMoDel, sanPhamModel));
        fillTableTheoNgay(Integer.parseInt(tbl_hd.getValueAt(rowhdon, 0).toString()));
        loadtableSanPhamTra(hoaDonDoiTraMoDel.getMaHoaDonDoiHang());
        tongTienTra();
    }//GEN-LAST:event_mni_trahangActionPerformed

    private void mni_xoaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mni_xoaSpActionPerformed
        int row = tbl_sanPhamTra.getSelectedRow();
        int rowhdon = tbl_hd.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui l??ng ch???n s???n ph???m c???n x??a");
            return;
        }
        HoaDonModel hdmodel = new HoaDonModel();
        hdmodel.setMaHoaDon(Integer.parseInt(tbl_hd.getModel().getValueAt(rowhdon, 0).toString()));

        KhachHangModel khmodel = new KhachHangModel();
        khmodel.setMaKhachHang(1);

        SanPhamModel sanPhamModel = new SanPhamModel();
        sanPhamModel.setMaSanPham(tbl_hdct.getModel().getValueAt(row, 0).toString());

        HoaDonDoiTraMoDel hoaDonDoiTraMoDel = _hoaDonDoiTraService.them(new HoaDonDoiTraMoDel(0, 0, new java.util.Date(), "", hdmodel, khmodel, Auth.user));
        int soluong = 0;
        for (HoaDonChiTietModel x : _HoaDonCTService.getListFromDB(Integer.parseInt(tbl_hd.getValueAt(rowhdon, 0).toString()))) {
            if (x.getSanPhamModel().getMaSanPham().equals(tbl_sanPhamTra.getModel().getValueAt(row, 1).toString())) {
                soluong = x.getSoLuong() + Integer.parseInt(tbl_sanPhamTra.getModel().getValueAt(row, 8).toString());
                x.setSoLuong(soluong);
                _HoaDonCTService.sua(x);
            }
        }
        for (HoaDonDoiTraChiTietModel x : _ihoadDoiTraChiTietService.getListFromDB(hoaDonDoiTraMoDel.getMaHoaDonDoiHang())) {
            if (x.getSanPhamModel().getMaSanPham().equals(tbl_sanPhamTra.getModel().getValueAt(row, 1).toString())) {
                _ihoadDoiTraChiTietService.xoa(x);
            }
        }

        fillTableTheoNgay(Integer.parseInt(tbl_hd.getValueAt(rowhdon, 0).toString()));
        loadtableSanPhamTra(hoaDonDoiTraMoDel.getMaHoaDonDoiHang());
        tongTienTra();
        if (tbl_sanPhamTra.getRowCount() == 0) {
            _hoaDonDoiTraService.xoa(hoaDonDoiTraMoDel.getMaHoaDonDoiHang());
        }
    }//GEN-LAST:event_mni_xoaSpActionPerformed

    private void btn_traHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_traHangActionPerformed
        int rowhdon = tbl_hd.getSelectedRow();
        if (rowhdon < 0) {
            JOptionPane.showMessageDialog(this, "Ch???n h??a ????n c???n tr??? h??ng");
            return;
        }
        if (tbl_sanPhamTra.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Ch???n s???n ph???m v?? s??? l?????ng c???n tr??? h??ng");
            return;
        }
        int temp = JOptionPane.showConfirmDialog(this, "X??c Nh???n b???n mu???n tr??? h??ng? ");
        if (temp != 0) {
            return;
        }
        HoaDonModel hdmodel = new HoaDonModel();
        hdmodel.setMaHoaDon(Integer.parseInt(tbl_hd.getModel().getValueAt(rowhdon, 0).toString()));

        KhachHangModel khmodel = new KhachHangModel();
        khmodel.setMaKhachHang(1);

        hdmodel.setMaHoaDon(Integer.parseInt(tbl_hd.getModel().getValueAt(rowhdon, 0).toString()));
        HoaDonDoiTraMoDel hoaDonDoiTraMoDel = _hoaDonDoiTraService.them(new HoaDonDoiTraMoDel(0, 0, new java.util.Date(), "", hdmodel, khmodel, Auth.user));
        hoaDonDoiTraMoDel.setTongTienHoanTra(Integer.parseInt(lbl_tongtienhoantra.getText().replaceAll(",", "")));
        hoaDonDoiTraMoDel.setNgayTaoHoaDon(new java.util.Date());
        hoaDonDoiTraMoDel.setMoTa(tar_lydo.getText());
        _hoaDonDoiTraService.sua(hoaDonDoiTraMoDel);
        hdmodel = hoaDonDoiTraMoDel.getHoaDonModel();
        hdmodel.setTrangThai(3);
        _iHoaDonService.sua(hdmodel);

        for (int i = 0; i < tbl_sanPhamTra.getRowCount(); i++) {
            for (SanPhamModel x : _ISanPhamService.getlistsanpham()) {
                if (x.getMaSanPham().equals(tbl_sanPhamTra.getModel().getValueAt(i, 1).toString())) {
                    _ISanPhamService.suaSoLuongSP(tbl_sanPhamTra.getValueAt(i, 1).toString(), x.getSoLuong() + Integer.parseInt(tbl_sanPhamTra.getModel().getValueAt(i, 8).toString()));//update so luong san pham
                }
            }
        }
        fillTableTheoNgay(-1);
        loadtableSanPhamTra(-1);
        tongTienTra();
        loadtable(_IThongKeRepository.thongke5());
    }//GEN-LAST:event_btn_traHangActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //S??? Ki???n ????ng Jpame
    }//GEN-LAST:event_formWindowClosed

    private void jPanel2AncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel2AncestorRemoved
        //S??? Ki???n ????ng JPane
//        int row = tbl_sanPhamTra.getSelectedRow();
        int rowhdon = tbl_hd.getSelectedRow();
//        if (row < 0) {
//            JOptionPane.showMessageDialog(this, "Vui l??ng ch???n s???n ph???m c???n x??a");
//            return;
//        }
        for (int i = 0; i < tbl_sanPhamTra.getRowCount(); i++) {
            HoaDonModel hdmodel = new HoaDonModel();
            hdmodel.setMaHoaDon(Integer.parseInt(tbl_hd.getModel().getValueAt(rowhdon, 0).toString()));

            KhachHangModel khmodel = new KhachHangModel();
            khmodel.setMaKhachHang(1);

            SanPhamModel sanPhamModel = new SanPhamModel();
            sanPhamModel.setMaSanPham(tbl_hdct.getModel().getValueAt(i, 0).toString());

            HoaDonDoiTraMoDel hoaDonDoiTraMoDel = _hoaDonDoiTraService.them(new HoaDonDoiTraMoDel(0, 0, new java.util.Date(), "", hdmodel, khmodel, Auth.user));
            int soluong = 0;
            for (HoaDonChiTietModel x : _HoaDonCTService.getListFromDB(Integer.parseInt(tbl_hd.getValueAt(rowhdon, 0).toString()))) {
                if (x.getSanPhamModel().getMaSanPham().equals(tbl_sanPhamTra.getModel().getValueAt(i, 1).toString())) {
                    soluong = x.getSoLuong() + Integer.parseInt(tbl_sanPhamTra.getModel().getValueAt(i, 8).toString());
                    x.setSoLuong(soluong);
                    _HoaDonCTService.sua(x);
                }
            }
            for (HoaDonDoiTraChiTietModel x : _ihoadDoiTraChiTietService.getListFromDB(hoaDonDoiTraMoDel.getMaHoaDonDoiHang())) {
                if (x.getSanPhamModel().getMaSanPham().equals(tbl_sanPhamTra.getModel().getValueAt(i, 1).toString())) {
                    _ihoadDoiTraChiTietService.xoa(x);
                }
            }

            fillTableTheoNgay(Integer.parseInt(tbl_hd.getValueAt(rowhdon, 0).toString()));
            loadtableSanPhamTra(hoaDonDoiTraMoDel.getMaHoaDonDoiHang());
            tongTienTra();
            if (tbl_sanPhamTra.getRowCount() == 0) {
                _hoaDonDoiTraService.xoa(hoaDonDoiTraMoDel.getMaHoaDonDoiHang());
            }
        }


    }//GEN-LAST:event_jPanel2AncestorRemoved

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate

    }//GEN-LAST:event_jTextField1CaretUpdate

    private void tbl_hdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hdMouseReleased
//        if (tbl_sanPhamTra.getRowCount() > 0) {
//            JOptionPane.showMessageDialog(this, "B???n ??ang c?? h??a ????n ??ang tr???");
//            return;
//        }
        int row = tbl_hd.getSelectedRow();
        if (row < 0) {
            return;
        }
        fillTableTheoNgay(Integer.parseInt(tbl_hd.getValueAt(row, 0).toString()));
        lbl_hoadon.setText(tbl_hd.getModel().getValueAt(row, 0).toString());
        lbl_nhanVien.setText(tbl_hd.getModel().getValueAt(row, 5).toString());
        lbl_khachHang.setText(tbl_hd.getModel().getValueAt(row, 3).toString());
        lbl_tongtienhoantra.setText("0");
        tbl_hd.setColumnSelectionAllowed(false);
    }//GEN-LAST:event_tbl_hdMouseReleased

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
            java.util.logging.Logger.getLogger(QLTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLTraHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_traHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_hoadon;
    private javax.swing.JLabel lbl_khachHang;
    private javax.swing.JLabel lbl_nhanVien;
    private javax.swing.JLabel lbl_tongtienhoantra;
    private javax.swing.JMenuItem mni_trahang;
    private javax.swing.JMenuItem mni_xoaSp;
    private javax.swing.JPopupMenu pmn_danhSachSPTra;
    private javax.swing.JPopupMenu pmn_tblHoaDonChiTiet;
    private javax.swing.JTextArea tar_lydo;
    private javax.swing.JTable tbl_hd;
    private javax.swing.JTable tbl_hdct;
    private javax.swing.JTable tbl_sanPhamTra;
    // End of variables declaration//GEN-END:variables
}
