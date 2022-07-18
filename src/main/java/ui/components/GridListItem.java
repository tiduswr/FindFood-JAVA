package ui.components;

import controller.Controller;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import ui.models.ModelGridListItem;

public final class GridListItem extends javax.swing.JPanel {
    
    private ModelGridListItem data;
    private Controller con;
    
    public GridListItem() {
        initComponents();
    }
    
    public GridListItem(Controller con, ModelGridListItem m) {
        this.con = con;
        initComponents();
        this.data = m;
        updateData();
        btAdd.addActionListener((ActionEvent e) -> {
            con.addItemToCart(data.getId());
        });
    }
    
    public void updateData(){
        this.txtName.setText(data.getNome());
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(data.getPreco());
        this.txtPreco.setText(moneyString);
        try {
            this.icon.setImage(data.getImgPath());
        } catch (IOException ex) {
            Logger.getLogger(GridListItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
        revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JLabel();
        icon = new ui.components.ImageLabel();
        txtPreco = new javax.swing.JLabel();
        btAdd = new ui.components.CustomButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        txtName.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(76, 76, 76));
        txtName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtName.setText("PRODUCT NAME");

        icon.setText("imageLabel1");

        txtPreco.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtPreco.setForeground(new java.awt.Color(0, 102, 0));
        txtPreco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtPreco.setText("PRECO");

        btAdd.setText("Comprar");
        btAdd.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.white);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
        super.paint(g);
    }
    
    public void setData(ModelGridListItem m){
        this.data = m;
        updateData();
    }

    public CustomButton getBtAdd() {
        return btAdd;
    }

    public ImageLabel getIcon() {
        return icon;
    }

    public JLabel getTxtName() {
        return txtName;
    }

    public JLabel getTxtPreco() {
        return txtPreco;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.components.CustomButton btAdd;
    private ui.components.ImageLabel icon;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtPreco;
    // End of variables declaration//GEN-END:variables
}
