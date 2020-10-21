
package br.com.fitfood.senai.views;

import br.com.fitfood.senai.database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EmployeeView extends javax.swing.JInternalFrame {
    public EmployeeView() {
        initComponents();
        desabilitarCampos();
    }
    
    private void consultar(){
        String sql = "SELECT * FROM employees WHERE id = ?";
        
        try {
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(sql);
            
            preparedStatement.setString(1, txtFuncId.getText());
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                txtFuncNome.setText(resultSet.getString(2));
                txtFuncBairro.setText(resultSet.getString(3));
                txtFuncCidade.setText(resultSet.getString(4));
                txtFuncEstado.setText(resultSet.getString(5));
                txtFuncCep.setText(resultSet.getString(6));
                cbmFuncSexo.setSelectedItem(resultSet.getString(7));
                txtFuncCpf.setText(resultSet.getString(8));
                txtFuncRg.setText(resultSet.getString(9));
                cmbFuncCivil.setSelectedItem(resultSet.getString(10));
                txtFuncNasc.setText(resultSet.getString(11));
                txtFuncCel.setText(resultSet.getString(12));
                txtFuncEmail.setText(resultSet.getString(13));
            } else {
                desabilitarCampos();
                JOptionPane.showMessageDialog(null, "Erro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void update(){
        String sql = "UPDATE employees SET nome=?, bairro=?, cidade=?, estado=?, cep=?, sexo=?, cpf=?, rg=?, civil=?, nasc=?, cel=?, email=? WHERE id=?";
    
        try {
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(sql);
            
            preparedStatement.setString(1,txtFuncNome.getText());
            preparedStatement.setString(2,txtFuncBairro.getText());
            preparedStatement.setString(3,txtFuncCidade.getText());
            preparedStatement.setString(4,txtFuncEstado.getText());
            preparedStatement.setString(5,txtFuncCep.getText());
            preparedStatement.setString(6,cbmFuncSexo.getSelectedItem().toString());
            preparedStatement.setString(7,txtFuncCpf.getText());
            preparedStatement.setString(8,txtFuncRg.getText());
            preparedStatement.setString(9,cmbFuncCivil.getSelectedItem().toString());
            preparedStatement.setString(10,txtFuncNasc.getText());
            preparedStatement.setString(11,txtFuncCel.getText());
            preparedStatement.setString(12,txtFuncEmail.getText());
            preparedStatement.setString(13,txtFuncId.getText());
            
            int op = preparedStatement.executeUpdate();
            
            if (op > 0) {
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }   
    }

    private void inserir(){
        String sql = "INSERT INTO " +
                        "employees(nome, bairro, cidade , estado, cep, sexo, cpf, rg, civil, nasc, cel, email)" +
                        "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    
        try {
            PreparedStatement preparedStatement = Database.getConnection().prepareStatement(sql);
            
            preparedStatement.setString(1, txtFuncNome.getText());
            preparedStatement.setString(2, txtFuncBairro.getText());
            preparedStatement.setString(3, txtFuncCidade.getText());
            preparedStatement.setString(4, txtFuncEstado.getText());
            preparedStatement.setString(5, txtFuncCep.getText());
            preparedStatement.setString(6, cbmFuncSexo.getSelectedItem().toString());
            preparedStatement.setString(7, txtFuncCpf.getText());
            preparedStatement.setString(8, txtFuncRg.getText());
            preparedStatement.setString(9, cmbFuncCivil.getSelectedItem().toString());
            preparedStatement.setString(10, txtFuncNasc.getText());
            preparedStatement.setString(11, txtFuncCel.getText());
            preparedStatement.setString(12, txtFuncEmail.getText());
            
            int op = preparedStatement.executeUpdate();
            
            if (op > 0) {
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void deletar(){
        String sql = "DELETE FROM employees WHERE id=?";
        
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar?", "Atenção", JOptionPane.YES_NO_OPTION);
        
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement pst = Database.getConnection().prepareStatement(sql);
                
                pst.setString(1, txtFuncId.getText());
                
                int op = pst.executeUpdate();
                
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
        txtFuncNome.setText(null);
        txtFuncBairro.setText(null);
        txtFuncCidade.setText(null);
        txtFuncCidade.setText(null);
        txtFuncCep.setText(null);
        cbmFuncSexo.setSelectedItem(null);
        txtFuncCpf.setText(null);
        txtFuncRg.setText(null);
        cmbFuncCivil.setSelectedItem(null);
        txtFuncNasc.setText(null);
        txtFuncCel.setText(null);
        txtFuncEmail.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFuncNasc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtFuncCel = new javax.swing.JTextField();
        txtFuncEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbmFuncSexo = new javax.swing.JComboBox<>();
        txtFuncId = new javax.swing.JTextField();
        cmbFuncCivil = new javax.swing.JComboBox<>();
        bntCliPesquisar = new javax.swing.JButton();
        txtFuncNome = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        bntInserir = new javax.swing.JButton();
        bntDeletar = new javax.swing.JButton();
        txtFuncBairro = new javax.swing.JTextField();
        txtFuncCidade = new javax.swing.JTextField();
        txtFuncEstado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFuncCep = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFuncCpf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFuncRg = new javax.swing.JTextField();

        jLabel8.setText("Sexo:");

        jLabel9.setText("CPF:");

        jLabel10.setText("RG:");

        jLabel11.setText("Estado civil:");

        jLabel12.setText("Data Nascimento:");

        jLabel13.setText("CEL:");

        jLabel14.setText("Email:");

        cbmFuncSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "masculino", "feminino", "outros" }));

        cmbFuncCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "casado", "solteiro", "outros" }));

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

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel4.setText("Bairro:");

        jLabel5.setText("Cidade:");

        jLabel6.setText("Estado:");

        jLabel7.setText("CEP:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel1))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFuncId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFuncCel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtFuncCidade)
                                        .addComponent(txtFuncEstado)
                                        .addComponent(txtFuncBairro)
                                        .addComponent(txtFuncNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(5, 5, 5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFuncRg, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFuncCpf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(cbmFuncSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbFuncCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtFuncCep))
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFuncNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFuncEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bntCliPesquisar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bntInserir)
                                .addGap(18, 18, 18)
                                .addComponent(bntDeletar)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFuncId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFuncNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtFuncCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbmFuncSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFuncCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtFuncBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtFuncCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFuncCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtFuncRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFuncEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtFuncNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFuncCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtFuncEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntCliPesquisar)
                    .addComponent(btnEditar)
                    .addComponent(bntInserir)
                    .addComponent(bntDeletar))
                .addGap(0, 26, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCliPesquisar;
    private javax.swing.JButton bntDeletar;
    private javax.swing.JButton bntInserir;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cbmFuncSexo;
    private javax.swing.JComboBox<String> cmbFuncCivil;
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
    private javax.swing.JTextField txtFuncBairro;
    private javax.swing.JTextField txtFuncCel;
    private javax.swing.JTextField txtFuncCep;
    private javax.swing.JTextField txtFuncCidade;
    private javax.swing.JTextField txtFuncCpf;
    private javax.swing.JTextField txtFuncEmail;
    private javax.swing.JTextField txtFuncEstado;
    private javax.swing.JTextField txtFuncId;
    private javax.swing.JTextField txtFuncNasc;
    private javax.swing.JTextField txtFuncNome;
    private javax.swing.JTextField txtFuncRg;
    // End of variables declaration//GEN-END:variables
}
