/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import P1_T5_CapaOracle_FerrerMuñozCarles.ConnexioGeneral;
import P1_T5_Model_FerrerMuñozCarles.Punt;
import P1_T5_Model_FerrerMuñozCarles.Ruta;
import P1_T5_Model_FerrerMuñozCarles.Tipus;
import P1_T5_Model_FerrerMuñozCarles.WikilocException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author isard
 */
public class InfoPunt extends JFrame {

    private ConnexioGeneral gBD = null;
    private Punt mPunt;
    private Ruta mRuta;
    private List<Tipus> mTipus = new ArrayList();
    /**
     * Creates new form InfoPunt
     */
    public InfoPunt() {
        initComponents();
    }
    
    public InfoPunt(ConnexioGeneral gbd, Punt jPunt, Ruta ruta, char option){
        initComponents();
        gBD = gbd;
        mTipus = gBD.getListTipus();
        mPunt = jPunt;
        mRuta = ruta;
        initCbo();
        if (mPunt != null){
            initTexts(option);
        }
        txtAltitut.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
            
            private void validateText() {
                String inputValue = txtAltitut.getText();

                try {
                    // Attempt to parse the entered text as a double
                    double doubleValue = Double.parseDouble(inputValue);
                    // Valid double value, you can handle it as needed
                    txtAltitut.setForeground(Color.BLACK);
                    btnGuardar.setEnabled(true);
                } catch (NumberFormatException ex) {
                    // Handling the case where parsing fails
                    // Change text color or provide other feedback to indicate an error
                    txtAltitut.setForeground(Color.RED);
                    btnGuardar.setEnabled(false);
                }
            }
        });
        txtLatitud.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
            
            private void validateText() {
                String inputValue = txtLatitud.getText();

                try {
                    // Attempt to parse the entered text as a double
                    double doubleValue = Double.parseDouble(inputValue);
                    // Valid double value, you can handle it as needed
                    txtLatitud.setForeground(Color.BLACK);
                    btnGuardar.setEnabled(true);
                } catch (NumberFormatException ex) {
                    // Handling the case where parsing fails
                    // Change text color or provide other feedback to indicate an error
                    txtLatitud.setForeground(Color.RED);
                    btnGuardar.setEnabled(false);
                }
            }
        });
        txtLongitud.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
            
            private void validateText() {
                String inputValue = txtLongitud.getText();

                try {
                    // Attempt to parse the entered text as a double
                    double doubleValue = Double.parseDouble(inputValue);
                    // Valid double value, you can handle it as needed
                    txtLongitud.setForeground(Color.BLACK);
                    btnGuardar.setEnabled(true);
                } catch (NumberFormatException ex) {
                    // Handling the case where parsing fails
                    // Change text color or provide other feedback to indicate an error
                    txtLongitud.setForeground(Color.RED);
                    btnGuardar.setEnabled(false);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboTipus = new javax.swing.JComboBox<>();
        txtNum = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDesc = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLatitud = new javax.swing.JTextField();
        txtLongitud = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAltitut = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jLabel1.setText("Número:");

        jLabel2.setText("Nom:");

        jLabel3.setText("Descripció:");

        jLabel4.setText("Tipus:");

        cboTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un element"}));
        cboTipus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipusActionPerformed(evt);
            }
        });

        textAreaDesc.setColumns(20);
        textAreaDesc.setRows(5);
        jScrollPane1.setViewportView(textAreaDesc);

        jLabel5.setText("Latitud:");

        jLabel6.setText("Longitut:");

        jLabel7.setText("Altitut:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel·lar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLatitud, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtLongitud))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAltitut))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNum)
                                        .addComponent(txtNom, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cboTipus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCancel)
                                .addGap(61, 61, 61)
                                .addComponent(btnGuardar)
                                .addGap(112, 112, 112)))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(cboTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtAltitut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancel))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(this, "Estàs segur que vols inserir el Punt?", "Inserir punt", ConfirmationCallback.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION){
            if (mPunt == null){
                Double latitude = Double.parseDouble(txtLatitud.getText());
                Double longitud = Double.parseDouble(txtLongitud.getText());
                Double altitude = Double.parseDouble(txtAltitut.getText());
                Tipus tipus = mTipus.get(cboTipus.getSelectedIndex()-1);
                //System.out.println(mRuta);
                mPunt = new Punt(0, mRuta, txtNom.getText(), textAreaDesc.getText(), null, latitude, longitud, altitude, tipus);
                
                try {
                    if (gBD.afegirPunt(mPunt)){
                        JOptionPane.showMessageDialog(rootPane, "Punt inserit", "Èxit",0);
                        gBD.validateChanges();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Error inserint el punt", "Error",0);
                    }
                } catch (WikilocException ex){
                    JOptionPane.showMessageDialog(this, "ex", "Error", 1);
                }
            } else {
                Double latitude = Double.parseDouble(txtLatitud.getText());
                Double longitud = Double.parseDouble(txtLongitud.getText());
                Double altitude = Double.parseDouble(txtAltitut.getText());
                Tipus tipus = mTipus.get(cboTipus.getSelectedIndex());
                mPunt.setNom(txtNom.getText());
                mPunt.setDesc(textAreaDesc.getText());
                mPunt.setTipus(tipus);
                mPunt.setLongitude(longitud);
                mPunt.setLatitude(latitude);
                mPunt.setAltitude(altitude);
                
                try {
                    if(gBD.actualitzarPunt(mPunt)){
                        JOptionPane.showMessageDialog(rootPane, "Punt actualitzat", "Èxit",0);
                        txtNum.setText(mPunt.getId()+"");
                        gBD.validateChanges();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Error inserint el punt", "Error",0);
                    }
                        
                } catch (WikilocException ex){
                    JOptionPane.showMessageDialog(this, ex, "Error", 1);
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cboTipusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipusActionPerformed
        // TODO add your handling code here:
        btnGuardar.setEnabled(cboTipus.getSelectedIndex()!=0);
        
    }//GEN-LAST:event_cboTipusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InfoPunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoPunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoPunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoPunt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoPunt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboTipus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaDesc;
    private javax.swing.JTextField txtAltitut;
    private javax.swing.JTextField txtLatitud;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNum;
    // End of variables declaration//GEN-END:variables

    private void initCbo() {
        for (Tipus t : mTipus){
            cboTipus.addItem(t.getNom());
        }
    }

    private void initTexts(char option) {
        txtNum.setText(mPunt.getId()+"");
        txtNom.setText(mPunt.getNom());
        txtAltitut.setText(mPunt.getAltitude()+"");
        txtLongitud.setText(mPunt.getLongitude()+"");
        txtLatitud.setText(mPunt.getLatitude()+"");
        cboTipus.setSelectedIndex(mPunt.getTipus().getId());
        textAreaDesc.setText(mPunt.getDesc());
        if (option=='r'){
            initTextsBool(false);
        } else {
            initTextsBool(true);
        }
    }

    private void initTextsBool(boolean b) {
        txtNum.setEnabled(b);
        txtNom.setEnabled(b);
        txtAltitut.setEnabled(b);
        txtLongitud.setEnabled(b);
        txtLatitud.setEnabled(b);
        cboTipus.setEnabled(b);
        textAreaDesc.setEnabled(b);
    }
}
