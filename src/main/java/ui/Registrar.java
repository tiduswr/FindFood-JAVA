package ui;

import controller.CadastroForm;
import controller.Controller;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import ui.components.Notification;

public final class Registrar extends javax.swing.JFrame implements CadastroForm{
    private Controller con;
    
    public Registrar(Controller con) {
        initComponents();
        
        this.con = con;
        setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setPreferredSize(this.getSize());
        this.setTitle("Simple Bank - Registrar");
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/mainIcon.png")).getImage());
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                new Login(con).setVisible(true);
                super.windowClosing(e);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dtNascimentoChooser = new ui.datechooser.DateChooser();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tableTitle = new javax.swing.JLabel();
        txtCpf = new ui.components.CustomTextField();
        txtNome = new ui.components.CustomTextField();
        txtSobrenome = new ui.components.CustomTextField();
        txtRua = new ui.components.CustomTextField();
        txtNumero = new ui.components.CustomTextField();
        txtBairro = new ui.components.CustomTextField();
        txtCidade = new ui.components.CustomTextField();
        txtEstado = new ui.components.CustomTextField();
        cbTipo = new ui.components.CustomComboBox();
        btSolicita = new ui.components.CustomButton();
        txtSenha = new ui.components.CustomTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(76, 76, 76));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mainIcon.png"))); // NOI18N
        jLabel1.setText("FindFood");

        tableTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        tableTitle.setForeground(new java.awt.Color(76, 76, 76));
        tableTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tableTitle.setText("Dados Pessoais");

        txtCpf.setLabelText("CPF");

        txtNome.setLabelText("Nome");

        txtSobrenome.setLabelText("Sobrenome");

        txtRua.setLabelText("Rua");

        txtNumero.setLabelText("Numero");

        txtBairro.setLabelText("Bairro");

        txtCidade.setLabelText("Cidade");

        txtEstado.setLabelText("Estado");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cliente", "Administrador" }));
        cbTipo.setLblText("Tipo de Usuario");

        btSolicita.setText("Solicitar");
        btSolicita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSolicitaActionPerformed(evt);
            }
        });

        txtSenha.setLabelText("Senha");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tableTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                    .addComponent(cbTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(btSolicita, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableTitle)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btSolicita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSolicitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSolicitaActionPerformed

        try {
            con.createNewUser(this);
            Notification n = new Notification(this, Notification.Type.SUCESS, 
                                            Notification.Location.BOTTOM_RIGHT, "Cadastro realizado!");
            n.showNotification();
        } catch (NumberFormatException e) {
            Notification n = new Notification(this, Notification.Type.WARNING, 
                                            Notification.Location.BOTTOM_RIGHT, e.getMessage());
            n.showNotification();
        }catch(IllegalArgumentException e){
            Notification n = new Notification(this, Notification.Type.WARNING, 
                                            Notification.Location.BOTTOM_RIGHT, e.getMessage());
            n.showNotification();
        }
        
    }//GEN-LAST:event_btSolicitaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.components.CustomButton btSolicita;
    private ui.components.CustomComboBox cbTipo;
    private ui.datechooser.DateChooser dtNascimentoChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel tableTitle;
    private ui.components.CustomTextField txtBairro;
    private ui.components.CustomTextField txtCidade;
    private ui.components.CustomTextField txtCpf;
    private ui.components.CustomTextField txtEstado;
    private ui.components.CustomTextField txtNome;
    private ui.components.CustomTextField txtNumero;
    private ui.components.CustomTextField txtRua;
    private ui.components.CustomTextField txtSenha;
    private ui.components.CustomTextField txtSobrenome;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getNome() {
        return this.txtNome.getText();
    }

    @Override
    public void setNome(String text) {
        this.txtNome.setText(text);
    }

    @Override
    public String getSobrenome() {
        return this.txtSobrenome.getText();
    }

    @Override
    public void setSobrenome(String text) {
        this.txtSobrenome.setText(text);
    }

    @Override
    public String getCPF() {
        return this.txtCpf.getText();
    }

    @Override
    public void setCPF(String text) {
        this.txtCpf.setText(text);
    }

    @Override
    public String getSenha() {
        return this.txtSenha.getText();
    }

    @Override
    public String getRua() {
        return this.txtRua.getText();
    }

    @Override
    public void setRua(String text) {
        this.txtRua.setText(text);
    }

    @Override
    public String getBairro() {
        return this.txtBairro.getText();
    }

    @Override
    public void setBairro(String text) {
        this.txtBairro.setText(text);
    }

    @Override
    public String getEstado() {
        return this.txtEstado.getText();
    }

    @Override
    public void setEstado(String text) {
        this.txtEstado.setText(text);
    }

    @Override
    public String getCidade() {
        return this.txtCidade.getText();
    }

    @Override
    public void setCidade(String text) {
        this.txtCidade.setText(text);
    }

    @Override
    public String getNumero() {
        return this.txtNumero.getText();
    }

    @Override
    public void setNumero(int value) {
        this.txtNumero.setText(String.valueOf(value));
    }

    @Override
    public String getTipoUsuario() {
        return (String) this.cbTipo.getSelectedItem();
    }

    @Override
    public void setTipoUsuario(String text) {
        this.cbTipo.setSelectedItem(text);
    }
}
