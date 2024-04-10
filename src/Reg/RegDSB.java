/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reg;

import Admin.AdminDSB;
import Config.DBConnector;
import Login.Logindashboard;

import User.UserDSB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class RegDSB extends javax.swing.JFrame {

    /**
     * Creates new form RegDSB
     */
    public RegDSB() {
        initComponents();
    }
        public static boolean registerAccount(String user, String password, String email, String contact) {

        if (!contact.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Contact Must Contain Only Digits!");
            return false;
        }

        try (Connection cn = new DBConnector().getConnection()) {

            PreparedStatement checkerStmt = cn.prepareStatement("SELECT COUNT(*) FROM kets WHERE email = ? OR user = ? OR contact = ?");
            checkerStmt.setString(1, email);
            checkerStmt.setString(2, user);
            checkerStmt.setString(3, contact);
            ResultSet resultStmt = checkerStmt.executeQuery();
            resultStmt.next();
            int count = resultStmt.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Account Already Exist!");
                return false;
            }

            cn.setAutoCommit(false);

            PreparedStatement insertStmt = cn.prepareStatement("INSERT INTO kets (email,contact,user,pass,status) VALUES (?,?,?,?,'Active')");
            insertStmt.setString(1, email);
            insertStmt.setString(2, contact);
            insertStmt.setString(3, user);
            insertStmt.setString(4, password);
            int rows = insertStmt.executeUpdate();

            cn.commit();

            return rows > 0;

        } catch (SQLException er) {
            System.out.println("Eror: " + er.getMessage());
        }

        return false;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        combo3 = new javax.swing.JComboBox<>();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel1.setText("User name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 82, 39));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 82, 39));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 82, 39));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Contact number:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 113, 39));

        jButton1.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, 76, 39));

        jButton2.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jButton2.setText("REGISTER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, -1, 39));

        combo3.setFont(new java.awt.Font("Yu Gothic", 1, 10)); // NOI18N
        combo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "USER" }));
        getContentPane().add(combo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 86, -1));

        user.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 217, 39));

        pass.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 217, 39));

        email.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 217, 39));

        contact.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        getContentPane().add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 217, 39));

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel5.setText("REGISTRATION FORM");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 36, 185, 29));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Reg/cementery (3).jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-370, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Logindashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                if (contact.getText().length() <= 10) {
            JOptionPane.showMessageDialog(this, "Contact Must Be Atleast 10 Characters!");
        } else if (!email.getText().contains("@gmail.com")) {
            JOptionPane.showMessageDialog(this, "Email Must Contain @gmail.com! TANGINAMO!");
        } else if (pass.getText().length() <= 7) {
            JOptionPane.showMessageDialog(this, "Password Must Be Atleast 7 Characters!");
        } else {

            if (registerAccount(user.getText(), pass.getText(), email.getText(), contact.getText())) {

                String selectedUser = (String) combo3.getSelectedItem();

                if ("USER".equals(selectedUser)) {
                    new UserDSB().setVisible(true);
                    dispose();
                } else if ("ADMIN".equals(selectedUser)) {
                    new AdminDSB().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "ERROR: Invalid user type selected");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error!");
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(RegDSB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegDSB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegDSB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegDSB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegDSB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo3;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
