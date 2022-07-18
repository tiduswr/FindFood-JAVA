package ui.components;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.HashMap;
import javax.swing.JComponent;

public class GridList extends javax.swing.JPanel {
    
    private final HashMap<String, JComponent> items;
    private final int top = 3, left = 3, bottom = 3, right = 3;
    private final Insets i = new Insets(top, left, bottom, right);
    
    public GridList() {
        items = new HashMap<>();
        initComponents();
        setLayout(new WrapLayout(WrapLayout.LEFT, 5, 5));
    }

    public void addItem(JComponent c, String key){
        items.put(key, c);
        
        //Configurando espaço entre os itens
        GridBagConstraints cg = new GridBagConstraints();
        cg.insets = i;
        
        this.add(c, cg);
        repaint();
        revalidate();
    }
    
    public void removeItem(String key){
        JComponent busca = items.get(key);
        if(busca != null){
            this.remove(busca);
            items.remove(key);
            repaint();
            revalidate();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
