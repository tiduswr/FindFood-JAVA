package ui.centralmenu;

import controller.Controller;
import java.awt.Frame;
import java.text.NumberFormat;
import javax.swing.JDialog;
import ui.components.CustomTable;
import ui.models.CarrinhoTableModel;

public class CarrinhoCompras extends javax.swing.JDialog {
    
    private CarrinhoTableModel tblModel;
    private Controller con;
    
    public CarrinhoCompras(Controller con, Frame parent, boolean modal) {
        super(parent, modal);
        this.con = con;
        initComponents();
        CustomTable.setBasicScrollConfigurations(tblScroll);
        tblModel = new CarrinhoTableModel(con);
        tblCompra.setModel(tblModel);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(con.getCarrinhoPrecoTotal());
        
        this.lblPreco.setText(moneyString);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        tblScroll = new javax.swing.JScrollPane();
        tblCompra = new ui.components.CustomTable();
        btOK = new ui.components.CustomButton();
        lblTotalLabel = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(76, 76, 76));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("RESUMO DAS COMPRAS");

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        tblScroll.setViewportView(tblCompra);

        btOK.setText("Confirmar");

        lblTotalLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblTotalLabel.setForeground(new java.awt.Color(76, 76, 76));
        lblTotalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalLabel.setText("TOTAL:");

        lblPreco.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblPreco.setForeground(new java.awt.Color(0, 153, 0));
        lblPreco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPreco.setText("PRECO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tblScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tblScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalLabel)
                    .addComponent(lblPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.components.CustomButton btOK;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalLabel;
    private ui.components.CustomTable tblCompra;
    private javax.swing.JScrollPane tblScroll;
    // End of variables declaration//GEN-END:variables
}
