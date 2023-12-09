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
    private String mUser;
    private char optionRuta;
    
    /**
     * Creates new form InfoPunt
     */
    public InfoPunt() {
        initComponents();
    }
    
    public InfoPunt(ConnexioGeneral gbd, Punt jPunt, Ruta ruta, char option, String user, char oR){
        
        initComponents();
        gBD = gbd;
        mTipus = gBD.getListTipus();
        mPunt = jPunt;
        mRuta = ruta;
        mUser = user;
        optionRuta = oR;
        initCbo();
        if (mPunt != null){
            initTexts(option);
        }
        setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Punt");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Número:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 17, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("Nom:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 27, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("Descripció:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setText("Tipus:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        cboTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un element"}));
        cboTipus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipusActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 0, 24);
        getContentPane().add(cboTipus, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 18, 0, 0);
        getContentPane().add(txtNum, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        getContentPane().add(txtNom, gridBagConstraints);

        textAreaDesc.setColumns(20);
        textAreaDesc.setRows(5);
        jScrollPane1.setViewportView(textAreaDesc);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 351;
        gridBagConstraints.ipady = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 24);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jLabel5.setText("Latitud:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 23, 0, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        jLabel6.setText("Longitut:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 15, 0, 0);
        getContentPane().add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 96;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 18, 0, 0);
        getContentPane().add(txtLatitud, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 96;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        getContentPane().add(txtLongitud, gridBagConstraints);

        jLabel7.setText("Altitut:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 2, 0, 0);
        getContentPane().add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 58;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 24);
        getContentPane().add(txtAltitut, gridBagConstraints);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(105, 23, 37, 0);
        getContentPane().add(btnGuardar, gridBagConstraints);

        btnCancel.setText("Cancel·lar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(105, 58, 37, 0);
        getContentPane().add(btnCancel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(rootPane, "Segur que vols cancel·lar?", "Cancel·lar", ConfirmationCallback.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION){
            InfoRuta ir = new InfoRuta(gBD, mRuta, optionRuta, mUser);
            ir.setVisible(true);
            this.dispose();
        }
        
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
                mPunt = new Punt(0, mRuta, txtNom.getText(), textAreaDesc.getText(), null, latitude, longitud, altitude, tipus);
                
                try {
                    if (gBD.afegirPunt(mPunt)){
                        JOptionPane.showMessageDialog(rootPane, "Punt inserit", "Èxit",JOptionPane.OK_OPTION);
                        gBD.validateChanges();
                        InfoRuta ir = new InfoRuta(gBD, mRuta, optionRuta, mUser);
                        ir.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Error inserint el punt", "Error",JOptionPane.OK_OPTION);
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
                        JOptionPane.showMessageDialog(rootPane, "Punt actualitzat", "Èxit",JOptionPane.OK_OPTION);
                        txtNum.setText(mPunt.getId()+"");
                        gBD.validateChanges();
                        InfoRuta ir = new InfoRuta(gBD, mRuta, optionRuta, mUser);
                        ir.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Error actualitzant el punt", "Error",JOptionPane.OK_OPTION);
                    }
                        
                } catch (WikilocException ex){
                    JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.OK_OPTION);
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
