package ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import controller.Controller;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.components.CustomTable;
import ui.components.GridList;
import ui.components.GridListItem;
import ui.components.Notification;
import ui.models.ModelGridListItem;

public class ComprarProdutos extends javax.swing.JPanel {

    private Controller con;
    private List<String> tipos;
    
    public ComprarProdutos(Controller con) {
        initComponents();
        this.con = con;
        loadTipos();
        loadProdutos(null);
        cbTipo.addItemListener((ItemEvent e) -> {
            loadProdutos(cbTipo.getSelectedItem().toString());
        });
        CustomTable.setBasicScrollConfigurations(this.jScrollPane1);
    }
    
    private void loadTipos(){
        //Load Tipos
        this.tipos = new ArrayList<>();
        getArrayProdutos().forEach(e -> {
            JSONObject o = new JSONObject(e.toString());
            System.out.println(o);
            tipos.add(o.getString("tipo"));
        });
        tipos = tipos.stream().distinct().collect(Collectors.toList());
        cbTipo.addItem("Todos");
        tipos.forEach(e -> cbTipo.addItem(e));
    }
    
    private JSONArray getArrayProdutos(){
        JSONArray arr;
        try {
            arr = new JSONArray(con.getProdutos());
        } catch (JsonProcessingException ex) {
            Notification n = new Notification(MenuCentral.getFrame(), Notification.Type.WARNING, 
                                    Notification.Location.BOTTOM_RIGHT, ex.getMessage());
            System.out.println(ex.getMessage());
            n.showNotification();
            repaint();
            revalidate();
            return null;
        }
        return arr;
    }
    
    private boolean loadProdutos(String filter){
        JSONArray arr = getArrayProdutos();
        gridList.removeAll();
        
        if(filter == null || filter.equalsIgnoreCase("Todos")){
            arr.forEach(e -> {
                JSONObject o = new JSONObject(e.toString());
                gridList.addItem(new GridListItem(con, new ModelGridListItem(o.toString())), 
                        String.valueOf(o.getLong("id")));
            });
        }else{
            arr.forEach(e -> {
                JSONObject o = new JSONObject(e.toString());
                if(o.getString("tipo").equals(filter)){
                    gridList.addItem(new GridListItem(con, new ModelGridListItem(o.toString())), 
                        String.valueOf(o.getLong("id")));
                }
            });
        }
        
        repaint();
        revalidate();
        
        return true;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public GridList getGridList() {
        return gridList;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbTipo = new ui.components.CustomComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridList = new ui.components.GridList();

        setBackground(new java.awt.Color(255, 255, 255));

        cbTipo.setLblText("Tipo Produto");

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        gridList.setBackground(new java.awt.Color(204, 204, 204));
        gridList.setOpaque(true);
        jScrollPane1.setViewportView(gridList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(cbTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.components.CustomComboBox cbTipo;
    private ui.components.GridList gridList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
