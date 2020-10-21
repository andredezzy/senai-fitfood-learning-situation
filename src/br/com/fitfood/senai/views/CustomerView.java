
package br.com.fitfood.senai.views;

import br.com.fitfood.senai.database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CustomerView extends javax.swing.JFrame {
    public CustomerView() {
        initComponents();
        desabilitarCampos();
    }
    
    private void consultar(){
        String sql = "SELECT * FROM customers WHERE id = ?";
        
        try {
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(sql);
            
            preparedStatement.setString(1, txtCliId.getText());
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                txtCliNome.setText(resultSet.getString(2));
                txtCliBairro.setText(resultSet.getString(3));
                txtCliCidade.setText(resultSet.getString(4));
                txtCliEstado.setText(resultSet.getString(5));
                txtCliCep.setText(resultSet.getString(6));
                cbmCliSexo.setSelectedItem(resultSet.getString(7));
                txtCliCpf.setText(resultSet.getString(8));
                txtCliRg.setText(resultSet.getString(9));
                cmbCliCivil.setSelectedItem(resultSet.getString(10));
                txtCliNasc.setText(resultSet.getString(11));
                txtCliCel.setText(resultSet.getString(12));
                txtCliEmail.setText(resultSet.getString(13));
            } else {
                desabilitarCampos();
                JOptionPane.showMessageDialog(null, "Erro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void update(){
        String sql = "UPDATE customers SET nome=?, bairro=?, cidade=?, estado=?, cep=?, sexo=?, cpf=?, rg=?, civil=?, nasc=?, cel=?, email=? WHERE id=?";
    
        try {
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(sql);
            
            preparedStatement.setString(1, txtCliNome.getText());
            preparedStatement.setString(2, txtCliBairro.getText());
            preparedStatement.setString(3, txtCliCidade.getText());
            preparedStatement.setString(4, txtCliEstado.getText());
            preparedStatement.setString(5, txtCliCep.getText());
            preparedStatement.setString(6, cbmCliSexo.getSelectedItem().toString());
            preparedStatement.setString(7, txtCliCpf.getText());
            preparedStatement.setString(8, txtCliRg.getText());
            preparedStatement.setString(9, cmbCliCivil.getSelectedItem().toString());
            preparedStatement.setString(10, txtCliNasc.getText());
            preparedStatement.setString(11, txtCliCel.getText());
            preparedStatement.setString(12, txtCliEmail.getText());
            preparedStatement.setString(13, txtCliId.getText());
            
            int op = preparedStatement.executeUpdate();
            
            if (op > 0) {
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }   
    }

    private void inserir(){
        String sql = "INSERT INTO "
                        + "customers(nome, bairro, cidade , estado, cep, sexo, cpf, rg, civil, nasc, cel, email)"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
        try {
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(sql);
            
            preparedStatement.setString(1, txtCliNome.getText());
            preparedStatement.setString(2, txtCliBairro.getText());
            preparedStatement.setString(3, txtCliCidade.getText());
            preparedStatement.setString(4, txtCliEstado.getText());
            preparedStatement.setString(5, txtCliCep.getText());
            preparedStatement.setString(6, cbmCliSexo.getSelectedItem().toString());
            preparedStatement.setString(7, txtCliCpf.getText());
            preparedStatement.setString(8, txtCliRg.getText());
            preparedStatement.setString(9, cmbCliCivil.getSelectedItem().toString());
            preparedStatement.setString(10, txtCliNasc.getText());
            preparedStatement.setString(11, txtCliCel.getText());
            preparedStatement.setString(12, txtCliEmail.getText());
            
            int op = preparedStatement.executeUpdate();
            
            if (op > 0) {
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void deletar(){
        String sql = "DELETE FROM customers WHERE id=?";
        
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar?", "Atenção", JOptionPane.YES_NO_OPTION);
        
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement preparedStatement = Database.getConnection().prepareStatement(sql);
                
                preparedStatement.setString(1, txtCliId.getText());
                
                int op = preparedStatement.executeUpdate();
                
                if (op > 0) {
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
                }
                
                desabilitarCampos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    private void desabilitarCampos() {
        txtCliNome.setText(null);
        txtCliBairro.setText(null);
        txtCliCidade.setText(null);
        txtCliEstado.setText(null);
        txtCliCep.setText(null);
        cbmCliSexo.setSelectedItem(null);
        txtCliCpf.setText(null);
        txtCliRg.setText(null);
        cmbCliCivil.setSelectedItem(null);
        txtCliNasc.setText(null);
        txtCliCel.setText(null);
        txtCliEmail.setText(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCliId = new javax.swing.JTextField();
        txtCliNome = new javax.swing.JTextField();
        txtCliBairro = new javax.swing.JTextField();
        txtCliCidade = new javax.swing.JTextField();
        txtCliEstado = new javax.swing.JTextField();
        txtCliCep = new javax.swing.JTextField();
        txtCliCpf = new javax.swing.JTextField();
        txtCliRg = new javax.swing.JTextField();
        txtCliNasc = new javax.swing.JTextField();
        txtCliCel = new javax.swing.JTextField();
        txtCliEmail = new javax.swing.JTextField();
        cbmCliSexo = new javax.swing.JComboBox<>();
        cmbCliCivil = new javax.swing.JComboBox<>();
        bntCliPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        bntInserir = new javax.swing.JButton();
        bntDeletar = new javax.swing.JButton();
        areaTrabalho = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menCadFunc = new javax.swing.JMenuItem();

        jTextField4.setText("jTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel4.setText("Bairro:");

        jLabel5.setText("Cidade:");

        jLabel6.setText("Estado:");

        jLabel7.setText("CEP:");

        jLabel8.setText("Sexo:");

        jLabel9.setText("CPF:");

        jLabel10.setText("RG:");

        jLabel11.setText("Estado civil:");

        jLabel12.setText("Data nascimento:");

        jLabel13.setText("Cel.:");

        jLabel14.setText("Email:");

        cbmCliSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "masculino", "feminino", "outros" }));

        cmbCliCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "casado", "solteiro", "outros" }));

        bntCliPesquisar.setText("Pesquisar");
        bntCliPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCliPesquisarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        bntInserir.setText("Inserir");
        bntInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntInserirActionPerformed(evt);
            }
        });

        bntDeletar.setText("Deletar");
        bntDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout areaTrabalhoLayout = new javax.swing.GroupLayout(areaTrabalho);
        areaTrabalho.setLayout(areaTrabalhoLayout);
        areaTrabalhoLayout.setHorizontalGroup(
            areaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        areaTrabalhoLayout.setVerticalGroup(
            areaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastro");

        menCadFunc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menCadFunc.setText("Cadastro Funcionarios");
        menCadFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadFuncActionPerformed(evt);
            }
        });
        jMenu1.add(menCadFunc);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTrabalho)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bntCliPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bntInserir)
                        .addGap(18, 18, 18)
                        .addComponent(bntDeletar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCliCel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel1))
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtCliCidade)
                                                        .addComponent(txtCliEstado)
                                                        .addComponent(txtCliBairro)
                                                        .addComponent(txtCliNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel10))
                                            .addComponent(jLabel8))
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtCliRg, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCliCpf, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(cbmCliSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmbCliCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtCliCep)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCliNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCliCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbmCliSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCliCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtCliBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCliRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCliNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntCliPesquisar)
                    .addComponent(btnEditar)
                    .addComponent(bntInserir)
                    .addComponent(bntDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(areaTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntCliPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCliPesquisarActionPerformed
       consultar();
    }//GEN-LAST:event_bntCliPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        update();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void bntInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntInserirActionPerformed
       inserir();
    }//GEN-LAST:event_bntInserirActionPerformed

    private void bntDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDeletarActionPerformed
       deletar();
    }//GEN-LAST:event_bntDeletarActionPerformed

    private void menCadFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadFuncActionPerformed
        EmployeeView cd = new EmployeeView();
        cd.setVisible(true);
        
        areaTrabalho.add(cd);
    }//GEN-LAST:event_menCadFuncActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane areaTrabalho;
    private javax.swing.JButton bntCliPesquisar;
    private javax.swing.JButton bntDeletar;
    private javax.swing.JButton bntInserir;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cbmCliSexo;
    private javax.swing.JComboBox<String> cmbCliCivil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JMenuItem menCadFunc;
    private javax.swing.JTextField txtCliBairro;
    private javax.swing.JTextField txtCliCel;
    private javax.swing.JTextField txtCliCep;
    private javax.swing.JTextField txtCliCidade;
    private javax.swing.JTextField txtCliCpf;
    private javax.swing.JTextField txtCliEmail;
    private javax.swing.JTextField txtCliEstado;
    private javax.swing.JTextField txtCliId;
    private javax.swing.JTextField txtCliNasc;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtCliRg;
    // End of variables declaration//GEN-END:variables
}
