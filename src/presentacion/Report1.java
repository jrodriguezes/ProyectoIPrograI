/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package presentacion;

import java.awt.Window;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import logic.Reportes;
import logic.Validations;
import logic.actualData;
import objects.Historial;

/**
 *
 * @author user
 */
public class Report1 extends javax.swing.JDialog {

    private static DefaultTableModel model;
    public static String rutaImagenAvion = "src/resources/photos/avion3.jpg";

    public Report1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        loadImages();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        datechooserFechaFin = new datechooser.beans.DateChooserCombo();
        datechooserFechaInicio = new datechooser.beans.DateChooserCombo();
        btnBuscar = new javax.swing.JButton();
        lblImagenExit = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REPORTE 1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        model = new DefaultTableModel(new Object[][]{}, new String[]{
            "Cedula", "Nombre", "Aeropuerto Salida",
            "Escala", "Aeropuerto Llegada", "Fecha-Hora de Compra"
        });
        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 830, 190));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FECHA INICIO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FECHA FIN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("RANGO DE FECHA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));
        jPanel1.add(datechooserFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 160, 30));

        datechooserFechaInicio.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    jPanel1.add(datechooserFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 160, 30));

    btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    btnBuscar.setText("Buscar");
    btnBuscar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBuscarActionPerformed(evt);
        }
    });
    jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

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
        Date inicialDate = (Date) datechooserFechaInicio.getSelectedDate().getTime();
        Date finalDate = (Date) datechooserFechaFin.getSelectedDate().getTime();

        model.setRowCount(0);
        showHistoryInformation(inicialDate, finalDate);
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

    public void showHistoryInformation(Date datechooserFechaInicio, Date datechooserFechaFin) {
        actualData actualData = new actualData();
        Reportes reportes = new Reportes();

        List<Historial> flightHistory = actualData.getFlightHistory();
        boolean foundData = false; // Flag para saber si se encontró algún dato

        for (Historial historialActual : flightHistory) {

            Date fechaCompra = historialActual.getRealTimeFlightBought();
            if ((quitarHora(fechaCompra).after(quitarHora(datechooserFechaInicio)) || quitarHora(fechaCompra).equals(quitarHora(datechooserFechaInicio)))
                    && (quitarHora(fechaCompra).before(quitarHora(datechooserFechaFin)) || quitarHora(fechaCompra).equals(quitarHora(datechooserFechaFin)))) {

                foundData = true; // Si se encuentra al menos un dato

                int idClient = historialActual.getIdPassenger();
                String nameClient = reportes.getClientNameById(idClient);

                int idDepartureAirport = historialActual.getIdDepartureAirport();
                String departureAirportName = reportes.getDepartureAirportNameById(idDepartureAirport);

                int idStopoverAirport = historialActual.getIdStopoverAirport();
                String stopoverAirportName = (idStopoverAirport != 0) ? reportes.getDepartureAirportNameById(idStopoverAirport) : "N/A";

                int idArrivalAirport = historialActual.getIdArrivalAirport();
                String arrivalAirportName = reportes.getDepartureAirportNameById(idArrivalAirport);

                Date dateBought = historialActual.getRealTimeFlightBought();

                model.addRow(new Object[]{
                    idClient,
                    nameClient,
                    departureAirportName,
                    stopoverAirportName,
                    arrivalAirportName,
                    dateBought
                });
            }
        }

        if (!foundData) { // Si no se encontro ningun dato
            JOptionPane.showMessageDialog(this, "No se encontró información para el rango de fechas seleccionado.", "Información no disponible", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private static Date quitarHora(Date fecha) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.set(Calendar.HOUR_OF_DAY, 0);
        calendario.set(Calendar.MINUTE, 0);
        calendario.set(Calendar.SECOND, 0);
        calendario.set(Calendar.MILLISECOND, 0);
        return calendario.getTime();
    }
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
            java.util.logging.Logger.getLogger(Report1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Report1 dialog = new Report1(new javax.swing.JFrame(), true);
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
    private datechooser.beans.DateChooserCombo datechooserFechaFin;
    private datechooser.beans.DateChooserCombo datechooserFechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblImagenExit;
    // End of variables declaration//GEN-END:variables
}
