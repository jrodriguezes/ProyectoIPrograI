/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package presentacion;

import java.awt.Color;
import java.awt.Image;
import java.awt.Window;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import logic.logIn;
import logic.validations;

public class LogIn extends javax.swing.JDialog {

    private String idCedula;
    private JFramePrincipal parent;
    public static String rutaImagenAvion = "src/resources/photos/avion.jpg";
    public static String rutaImagenExit = "src/resources/photos/btnSalir.png";

    public LogIn(JFramePrincipal parent, boolean modal) {
        super(parent, "Log In", modal);
        initComponents();
        cargarImagen();
        this.parent = parent;
        setLocationRelativeTo(null);
        loadExitImage();
        parent.jMenuItem1.setVisible(false);
        parent.jMenuItem2.setVisible(false);
        parent.jMenuItem3.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIniciarSesion = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        txtContrasena = new javax.swing.JPasswordField();
        lblImagenExit = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblIniciarSesion.setForeground(new java.awt.Color(0, 102, 153));
        lblIniciarSesion.setText("INICIAR SESION");
        jPanel1.add(lblIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 140, 40));

        lblCedula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCedula.setForeground(new java.awt.Color(0, 102, 153));
        lblCedula.setText("CEDULA");
        jPanel1.add(lblCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        txtCedula.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(204, 204, 204));
        txtCedula.setText("Ingrese su cedula");
        txtCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCedulaMousePressed(evt);
            }
        });
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 350, 40));

        lblContrasena.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContrasena.setForeground(new java.awt.Color(0, 102, 153));
        lblContrasena.setText("CONTRASEÑA");
        jPanel1.add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(0, 102, 153));
        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        txtContrasena.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(204, 204, 204));
        txtContrasena.setText("********");
        txtContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContrasenaMousePressed(evt);
            }
        });
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 350, 40));

        lblImagenExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenExitMouseClicked(evt);
            }
        });
        jPanel1.add(lblImagenExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 30));

        lblImagen.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 579, 419));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        parent.jMenuItem1.setVisible(false);
        parent.jMenuItem2.setVisible(false);
        parent.jMenuItem3.setVisible(false);
        logIn login = new logIn();
        validations validationS = new validations();

        String txtCedulaConverted = txtCedula.getText();
        if (!validationS.validateAsAIntegerInTextField(txtCedulaConverted)) {
            return;
        }
        String status = login.logIn(Integer.parseInt(txtCedula.getText()), txtContrasena.getText());
        switch (status) {
            case "admin":
                JOptionPane.showMessageDialog(this, "Usted es admin", "Información", JOptionPane.INFORMATION_MESSAGE);
                parent.jMenuItem1.setVisible(true);
                parent.jMenuItem2.setVisible(false);
                parent.jMenuItem3.setVisible(true);
                parent.jMenuItemLogout.setVisible(true); 
                parent.setLogged(1);
                this.dispose();
                break;
            case "user":
                parent.jMenuItem2.setVisible(true);
                parent.jMenuItemLogout.setVisible(true); 
                parent.setLogged(1);
                this.dispose();
                break;
            case "not found":
                JOptionPane.showMessageDialog(this, "Datos erróneos, o usuario inexistente", "Información", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtCedulaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaMousePressed
        if (txtCedula.getText().equals("Ingrese su cedula")) {
            txtCedula.setText("");
            txtCedula.setForeground(Color.black);
        }
        if (String.valueOf(txtContrasena.getPassword()).isEmpty()) {
            txtContrasena.setText("********");
            txtContrasena.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtCedulaMousePressed

    private void txtContrasenaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContrasenaMousePressed
        if (String.valueOf(txtContrasena.getPassword()).equals("********")) {
            txtContrasena.setText("");
            txtContrasena.setForeground(Color.black);
        }
        if (txtCedula.getText().isEmpty()) {
            txtCedula.setText("Ingrese su cedula");
            txtCedula.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtContrasenaMousePressed

    private void lblImagenExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenExitMouseClicked
        Window window = SwingUtilities.getWindowAncestor(lblImagenExit);
        window.dispose();
        parent.setLogged(0);
    }//GEN-LAST:event_lblImagenExitMouseClicked

    private void cargarImagen() {
        if (rutaImagenAvion != null && !rutaImagenAvion.isEmpty()) {
            File imagen = new File(rutaImagenAvion);
            if (imagen.exists()) {
                ImageIcon imageIcon = new ImageIcon(imagen.getAbsolutePath());
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImageIcon = new ImageIcon(newimg);
                lblImagen.setIcon(newImageIcon);
            } else {
                lblImagen.setText("No se encontró la imagen.");
            }
        } else {
            lblImagen.setText("No se proporcionó ninguna ruta de imagen.");
        }
    }

    private void loadExitImage() {
        if (rutaImagenExit != null && !rutaImagenExit.isEmpty()) {
            File imagen = new File(rutaImagenExit);
            if (imagen.exists()) {
                ImageIcon imageIcon = new ImageIcon(imagen.getAbsolutePath());
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(lblImagenExit.getWidth(), lblImagenExit.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImageIcon = new ImageIcon(newimg);
                lblImagenExit.setIcon(newImageIcon);
            } else {
                lblImagenExit.setText("No se encontró la imagen.");
            }
        } else {
            lblImagenExit.setText("No se proporcionó ninguna ruta de imagen.");
        }
    }

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LogIn dialog = new LogIn(new JFramePrincipal(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblImagenExit;
    private javax.swing.JLabel lblIniciarSesion;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JPasswordField txtContrasena;
    // End of variables declaration//GEN-END:variables
}
