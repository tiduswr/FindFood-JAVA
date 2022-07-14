package ui;

import com.fasterxml.jackson.core.JsonProcessingException;
import controller.Controller;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import org.json.JSONObject;

public final class MenuCentral extends javax.swing.JFrame {
    private static JFrame form;
    private Controller con;
    
    public MenuCentral() {
        initComponents();
        con = new Controller();
        initConfigs();
        updateHeader();
    }
    
    public MenuCentral(Controller con) {
        initComponents();
        this.con = con;        
        initConfigs();
        
        menuLateral.config(MenuCentral.this);
        try {
            if(getTipoUser() != null){
                if(getTipoUser().equalsIgnoreCase("administrador")){
                    admMenuLateralConfig();
                }else if (getTipoUser().equalsIgnoreCase("cliente")){
                    clienteMenuLateralConfig();
                }
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MenuCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        updateHeader();
    }
    
    private void initConfigs(){
        formPanel.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        form = MenuCentral.this;
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                con.closeDatabaseConnection();
                super.windowClosing(e);
            }
        });
    }
    
    private void setForm(JComponent c){
        formPanel.removeAll();
        formPanel.add(c);
        formPanel.revalidate();
        formPanel.repaint();
    }
    
    private void clienteMenuLateralConfig(){
        menuLateral.addEventMenuSelected((int index) -> {
            switch (index) {
                case 1:
                    setForm(new UserCentral(con));
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    con.closeDatabaseConnection();
                    dispose();
                    break;
                default:
                    break;
            }
        });
    }
    
    private void admMenuLateralConfig(){
        menuLateral.addEventMenuSelected((int index) -> {
            switch (index) {
                case 1:
                    setForm(new UserCentral(con));
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    con.closeDatabaseConnection();
                    dispose();
                    break;
                default:
                    break;
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder = new ui.centralmenu.PanelBorder();
        menuLateral = new ui.centralmenu.MenuLateral();
        formPanel = new javax.swing.JPanel();
        header = new ui.centralmenu.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        formPanel.setBackground(new java.awt.Color(255, 255, 255));
        formPanel.setForeground(new java.awt.Color(255, 255, 255));
        formPanel.setOpaque(false);

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorderLayout = new javax.swing.GroupLayout(panelBorder);
        panelBorder.setLayout(panelBorderLayout);
        panelBorderLayout.setHorizontalGroup(
            panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderLayout.createSequentialGroup()
                .addComponent(menuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorderLayout.setVerticalGroup(
            panelBorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public String getTipoUser() throws JsonProcessingException{
        if(con.getLogged() != null){
            JSONObject o = new JSONObject(con.getLogged());
            return o.getJSONObject("access").getString("tipo");
            
        }
        return null;
    }
    
    public void updateHeader(){
        if(con != null){
            con.updateHeader(header);
        }
    }
    
    public static JFrame getFrame(){
        return form;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel formPanel;
    private ui.centralmenu.Header header;
    private ui.centralmenu.MenuLateral menuLateral;
    private ui.centralmenu.PanelBorder panelBorder;
    // End of variables declaration//GEN-END:variables
}
