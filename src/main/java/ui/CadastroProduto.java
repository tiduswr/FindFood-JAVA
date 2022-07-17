package ui;

import controller.CadastrarProdutosForm;
import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.JSONObject;
import ui.components.CustomTable;
import ui.components.CustomButton;
import ui.components.Notification;
import ui.models.ProdutosTableModel;

public class CadastroProduto extends javax.swing.JPanel implements CadastrarProdutosForm{
    
    private ProdutosTableModel tblModel;
    private Controller con;
    
    public CadastroProduto(Controller con) {
        initComponents();
        this.con = con;
        
        CustomTable.setBasicScrollConfigurations(mainScroll);
        CustomTable.setBasicScrollConfigurations(scrollProdutos);
        
        tblModel = new ProdutosTableModel(con);
        tblProdutos.setModel(tblModel);
        tblProdutos.setAutoCreateRowSorter(true);
        btBuscaImg.addActionListener((ActionEvent e) -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Image file", "jpg", "jpeg", "PNG");
            jFileChooser.addChoosableFileFilter(fileNameExtensionFilter);
            
            int checkInput = jFileChooser.showOpenDialog(null);
            if (checkInput == JFileChooser.APPROVE_OPTION) {
                File openedFile = jFileChooser.getSelectedFile();
                try {
                    BufferedImage image = ImageIO.read(openedFile.getAbsoluteFile());
                    txtImgPath.setText(openedFile.getAbsolutePath());
                } catch (IOException ioException) {
                    txtImgPath.setText("");
                    Notification n = new Notification(MenuCentral.getFrame(), Notification.Type.WARNING, 
                                            Notification.Location.BOTTOM_RIGHT, "Problema ao carregar Imagem!");
                    n.showNotification();
                }
            }
        });
        tblProdutos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Long id = getEditedItemId();
                if(id != null){
                    JSONObject obj = new JSONObject(con.searchProduct(id));
                    fillFields(obj);
                }
            }
        });
        tblProdutos.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    tblProdutos.clearSelection();
                    clearFields();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainScroll = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        lblDadosPessoais = new javax.swing.JLabel();
        txtNome = new ui.components.CustomTextField();
        txtTipo = new ui.components.CustomTextField();
        txtDesc = new ui.components.CustomTextField();
        txtPreco = new ui.components.CustomTextField();
        txtEstoque = new ui.components.CustomTextField();
        txtImgPath = new ui.components.CustomTextField();
        btSalvar = new ui.components.CustomButton();
        btExcluir = new ui.components.CustomButton();
        lblDadosPessoais1 = new javax.swing.JLabel();
        scrollProdutos = new javax.swing.JScrollPane();
        tblProdutos = new ui.components.CustomTable();
        btBuscaImg = new ui.components.ImageButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblDadosPessoais.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblDadosPessoais.setForeground(new java.awt.Color(76, 76, 76));
        lblDadosPessoais.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDadosPessoais.setText("CADASTRAR PRODUTOS");

        txtNome.setLabelText("Nome");

        txtTipo.setLabelText("Tipo");

        txtDesc.setLabelText("Descrição");

        txtPreco.setLabelText("Preço");

        txtEstoque.setLabelText("Estoque");

        txtImgPath.setEditable(false);
        txtImgPath.setLabelText("Imagem");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.setStyle(CustomButton.ButtonStyle.DESTRUCTIVE);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        lblDadosPessoais1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblDadosPessoais1.setForeground(new java.awt.Color(76, 76, 76));
        lblDadosPessoais1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDadosPessoais1.setText("PRODUTOS CADASTRADOS");

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollProdutos.setViewportView(tblProdutos);

        btBuscaImg.setText("imageButton1");
        try {
            btBuscaImg.setImage("icons/buscar.png");
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollProdutos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblDadosPessoais1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDadosPessoais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscaImg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDadosPessoais1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainScroll.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fillFields(JSONObject o){
        txtNome.setText(o.getString("nome"));
        txtPreco.setText(String.valueOf(o.getDouble("price")));
        txtTipo.setText(o.getString("tipo"));
        txtEstoque.setText(String.valueOf(o.getInt("estoque")));
        txtDesc.setText(o.getString("descricao"));
        txtImgPath.setText(o.getString("imgPath"));
    }    
    
    private void clearFields(){
        txtNome.setText("");
        txtPreco.setText("");
        txtTipo.setText("");
        txtEstoque.setText("");
        txtDesc.setText("");
        txtImgPath.setText("");
    }
    
    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        int r = tblProdutos.getSelectedRow();
        try{
            if(r == -1){
                con.registerProducts(this);
                Notification n = new Notification(MenuCentral.getFrame(), Notification.Type.SUCESS, 
                                            Notification.Location.BOTTOM_RIGHT, "Produto cadastrado!");
                n.showNotification();
            }else{
                con.updateProduct(this);
                Notification n = new Notification(MenuCentral.getFrame(), Notification.Type.SUCESS, 
                                            Notification.Location.BOTTOM_RIGHT, "Produto Atualizado!");
                n.showNotification();
            }
            this.tblModel.reload();
            clearFields();
        } catch (NumberFormatException e) {
            Notification n = new Notification(MenuCentral.getFrame(), Notification.Type.WARNING, 
                                            Notification.Location.BOTTOM_RIGHT, e.getMessage());
            n.showNotification();
        }catch(IllegalArgumentException e){
            Notification n = new Notification(MenuCentral.getFrame(), Notification.Type.WARNING, 
                                            Notification.Location.BOTTOM_RIGHT, e.getMessage());
            n.showNotification();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int r = tblProdutos.getSelectedRow();
        if(r != -1){
            try{
                con.deleteProduct(this);
                this.tblModel.removeRow(r);
                clearFields();
            }catch(IllegalArgumentException e){
                Notification n = new Notification(MenuCentral.getFrame(), Notification.Type.WARNING, 
                                                Notification.Location.BOTTOM_RIGHT, e.getMessage());
                n.showNotification();
            }
        }else{
            Notification n = new Notification(MenuCentral.getFrame(), Notification.Type.WARNING, 
                                            Notification.Location.BOTTOM_RIGHT, "Selecione um Item para Excluir!");
            n.showNotification();
        }
    }//GEN-LAST:event_btExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.components.ImageButton btBuscaImg;
    private ui.components.CustomButton btExcluir;
    private ui.components.CustomButton btSalvar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDadosPessoais;
    private javax.swing.JLabel lblDadosPessoais1;
    private javax.swing.JScrollPane mainScroll;
    private javax.swing.JScrollPane scrollProdutos;
    private ui.components.CustomTable tblProdutos;
    private ui.components.CustomTextField txtDesc;
    private ui.components.CustomTextField txtEstoque;
    private ui.components.CustomTextField txtImgPath;
    private ui.components.CustomTextField txtNome;
    private ui.components.CustomTextField txtPreco;
    private ui.components.CustomTextField txtTipo;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public Long getEditedItemId(){
        if(tblModel == null) return null;
        
        int r = tblProdutos.getSelectedRow();
        
        if(r == -1) return null;
        
        return tblModel.getJsonAt(r).getLong("id");
    }
    
    @Override
    public String getNome() {
        return this.txtNome.getText();
    }

    @Override
    public String getTipo() {
        return this.txtTipo.getText();
    }

    @Override
    public String getDesc() {
        return this.txtDesc.getText();
    }

    @Override
    public String getPreco() {
        return this.txtPreco.getText();
    }

    @Override
    public String getEstoque() {
        return this.txtEstoque.getText();
    }

    @Override
    public String getImgPath() {
        return this.txtImgPath.getText();
    }

    @Override
    public void setNome(String v) {
        this.txtNome.setText(v);
    }

    @Override
    public void setTipo(String v) {
        this.txtTipo.setText(v);
    }

    @Override
    public void setDesc(String v) {
        this.txtDesc.setText(v);
    }

    @Override
    public void setPreco(String v) {
        this.txtPreco.setText(v);
    }

    @Override
    public void setEstoque(String v) {
        this.txtEstoque.setText(v);
    }

    @Override
    public void setImgPath(String v) {
        this.txtImgPath.setText(v);
    }
}
