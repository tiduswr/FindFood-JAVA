package ui;

import controller.CadastroForm;
import controller.Controller;

public class UserCentral extends javax.swing.JPanel implements CadastroForm{
    
    private Controller con;
    
    public UserCentral(Controller con) {
        initComponents();
        this.con = con;
        con.loadUserDataOnCadastroForm(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEndereco = new javax.swing.JLabel();
        txtCpf = new ui.components.CustomTextField();
        txtNome = new ui.components.CustomTextField();
        txtSobrenome = new ui.components.CustomTextField();
        txtRua = new ui.components.CustomTextField();
        txtNumero = new ui.components.CustomTextField();
        txtBairro = new ui.components.CustomTextField();
        txtCidade = new ui.components.CustomTextField();
        txtEstado = new ui.components.CustomTextField();
        tipoUser = new ui.components.CustomTextField();
        lblDadosPessoais = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblEndereco.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblEndereco.setForeground(new java.awt.Color(76, 76, 76));
        lblEndereco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEndereco.setText("Endereço");

        txtCpf.setEditable(false);
        txtCpf.setLabelText("CPF");

        txtNome.setEditable(false);
        txtNome.setLabelText("Nome");

        txtSobrenome.setEditable(false);
        txtSobrenome.setLabelText("Sobrenome");

        txtRua.setEditable(false);
        txtRua.setLabelText("Rua");

        txtNumero.setEditable(false);
        txtNumero.setLabelText("Numero");

        txtBairro.setEditable(false);
        txtBairro.setLabelText("Bairro");

        txtCidade.setEditable(false);
        txtCidade.setLabelText("Cidade");

        txtEstado.setEditable(false);
        txtEstado.setLabelText("Estado");

        tipoUser.setEditable(false);
        tipoUser.setLabelText("Tipo do Usuário");

        lblDadosPessoais.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblDadosPessoais.setForeground(new java.awt.Color(76, 76, 76));
        lblDadosPessoais.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDadosPessoais.setText("Dados Pessoais");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblDadosPessoais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEndereco)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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
        return "";
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
        return (String) this.tipoUser.getText();
    }

    @Override
    public void setTipoUsuario(String text) {
        this.tipoUser.setText(text);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDadosPessoais;
    private javax.swing.JLabel lblEndereco;
    private ui.components.CustomTextField tipoUser;
    private ui.components.CustomTextField txtBairro;
    private ui.components.CustomTextField txtCidade;
    private ui.components.CustomTextField txtCpf;
    private ui.components.CustomTextField txtEstado;
    private ui.components.CustomTextField txtNome;
    private ui.components.CustomTextField txtNumero;
    private ui.components.CustomTextField txtRua;
    private ui.components.CustomTextField txtSobrenome;
    // End of variables declaration//GEN-END:variables
}
