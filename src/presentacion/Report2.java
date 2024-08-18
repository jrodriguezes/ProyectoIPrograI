/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package presentacion;

import java.awt.Window;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import logic.Reportes;
import logic.Validations;

/**
 *
 * @author user
 */
public class Report2 extends javax.swing.JDialog {

    private static DefaultTableModel model;
    public static String rutaImagenAvion = "src/resources/photos/avion3.jpg";

    public Report2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        loadAirline();
        loadImages();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jcbAerolinea = new javax.swing.JComboBox<>();
        lblImagenExit = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REPORTE 2");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        model = new DefaultTableModel(new Object[][]{}, new String[]{
            "Cedula Piloto", "Cedula Servicio Cliente", "Nombre Piloto", "Nombre Servicio Cliente", "Id avion"

        });
        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 830, 190));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("AEROLINEA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        jcbAerolinea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una aerolinea:" }));
        jPanel1.add(jcbAerolinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, 30));

        lblImagenExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenExitMouseClicked(evt);
            }
        });
        jPanel1.add(lblImagenExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 30));

        lblImagen.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        model.setRowCount(0);
        showHistoryInformation();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void lblImagenExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenExitMouseClicked
        Window window = SwingUtilities.getWindowAncestor(lblImagenExit);
        window.dispose();
    }//GEN-LAST:event_lblImagenExitMouseClicked

    private void loadImages() {
        Validations validations = new Validations();
        validations.loadExitImage(lblImagenExit);
        validations.cargarImagen(lblImagen, rutaImagenAvion);
    }

    private void showHistoryInformation() {
        Reportes reportes = new Reportes();

        String airlineName = (String) jcbAerolinea.getSelectedItem();
        int idAirline = reportes.getAirlineIdByName(airlineName);

        // Obtener la informacion del historial basado en la aerolínea seleccionada
        int idPilot = reportes.getIdCrewmatePilotByAirline(idAirline);
        int idService = reportes.getIdCrewmateServiceByAirline(idAirline);

        if (idPilot == -999 || idService == -999) {
            JOptionPane.showMessageDialog(this, "No se encontro informacion para la aerolinea seleccionada.", "Informacion no disponible", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String pilotName = reportes.getCrewmatePilotNameById(idPilot);
        String serviceClientName = reportes.getCrewmateServiceNameById(idService);

        int idPlane = reportes.getPlaneByAirlineId(idAirline);

        // Agregar la información obtenida al JTable
        model.addRow(new Object[]{
            idPilot,
            idService,
            pilotName,
            serviceClientName,
            idPlane
        });
    }

    private void loadAirline() {
        Reportes reportes = new Reportes();
        reportes.loadAirline(jcbAerolinea);
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
            java.util.logging.Logger.getLogger(Report2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Report2 dialog = new Report2(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbAerolinea;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblImagenExit;
    // End of variables declaration//GEN-END:variables
}
