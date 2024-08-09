/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package presentacion;

import java.awt.Image;
import java.awt.Window;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import logic.SearchFlight;
import logic.actualData;
import logic.createFlight;
import objects.Aerolinea;
import objects.Aeropuerto;
import objects.Vuelo;


public class FlightSearch extends javax.swing.JDialog {
    
    private static DefaultTableModel model;
    public static String rutaImagenAvion = "src/resources/photos/avion2.jpg";
    public static String rutaImagenExit = "src/resources/photos/btnSalir.png";

    public FlightSearch(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        cargarImagen();
        loadExitImage();
        fillCombos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBusquedaVuelos = new javax.swing.JLabel();
        lblPasajeros = new javax.swing.JLabel();
        lblOrigen = new javax.swing.JLabel();
        lblFechaSalida = new javax.swing.JLabel();
        jcbDestino = new javax.swing.JComboBox<>();
        jcbOrigen = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        datechooserFechaSalida = new datechooser.beans.DateChooserCombo();
        btnBuscar = new javax.swing.JButton();
        lblImagenExit = new javax.swing.JLabel();
        lblDestino1 = new javax.swing.JLabel();
        spinnerPassengers = new javax.swing.JSpinner();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBusquedaVuelos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblBusquedaVuelos.setText("BUSQUEDA DE VUELOS");
        jPanel1.add(lblBusquedaVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 270, 20));

        lblPasajeros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPasajeros.setText("Pasajeros");
        jPanel1.add(lblPasajeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, -1, -1));

        lblOrigen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOrigen.setText("ORIGEN");
        jPanel1.add(lblOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        lblFechaSalida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaSalida.setText("FECHA DE SALIDA");
        jPanel1.add(lblFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, -1, -1));

        jcbDestino.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jcbDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el aeropuerto de destino" }));
        jPanel1.add(jcbDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 300, 30));

        jcbOrigen.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jcbOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el aeropuerto de origen" }));
        jPanel1.add(jcbOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 300, 30));

        model = new DefaultTableModel(new Object[][]{}, new String[]{
            "Aerolinea", "Aeropuerto salida", "Aeropuerto llegada",
            "Escala", "Hora salida", "Hora llegada", "Duracion", "Precios totales"
        });

        // Llenar el modelo con datos de la lista de vuelos
        jTable1.setModel(model);
        ListSelectionModel selectionModel = jTable1.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow >= 0) {
                        showFlightDetailsDialog(selectedRow);
                    }
                }
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 980, 190));
        jPanel1.add(datechooserFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 160, 30));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 100, 30));

        lblImagenExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagenExitMouseClicked(evt);
            }
        });
        jPanel1.add(lblImagenExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 30));

        lblDestino1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDestino1.setText("DESTINO");
        jPanel1.add(lblDestino1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        spinnerPassengers.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));
        jPanel1.add(spinnerPassengers, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, -1, 30));
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void lblImagenExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenExitMouseClicked
        Window window = SwingUtilities.getWindowAncestor(lblImagenExit);
        window.dispose();
    }//GEN-LAST:event_lblImagenExitMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        filterFlights();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void showFlightDetailsDialog(int selectedRow) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

// Get values from table
        String aerolinea = (String) jTable1.getValueAt(selectedRow, 0);
        String aeropuertoSalida = (String) jTable1.getValueAt(selectedRow, 1);
        String aeropuertoLlegada = (String) jTable1.getValueAt(selectedRow, 2);
        String escala = (String) jTable1.getValueAt(selectedRow, 3);

// Convert Date objects to Strings if necessary
        Object horaSalidaObj = jTable1.getValueAt(selectedRow, 4);
        Object horaLlegadaObj = jTable1.getValueAt(selectedRow, 5);
        Object duracionObj = jTable1.getValueAt(selectedRow, 6);
        Object preciosTotalesObj = jTable1.getValueAt(selectedRow, 7);

// Handle Date objects separately
        String horaSalida = horaSalidaObj instanceof Date ? dateFormat.format((Date) horaSalidaObj) : horaSalidaObj.toString();
        String horaLlegada = horaLlegadaObj instanceof Date ? dateFormat.format((Date) horaLlegadaObj) : horaLlegadaObj.toString();

// Assuming duracionObj and preciosTotalesObj are not Date objects
        String duracion = duracionObj != null ? duracionObj.toString() : "N/A";
        String preciosTotales = preciosTotalesObj != null ? preciosTotalesObj.toString() : "N/A";

        JButton btnRegresar = new JButton("Regresar");
        JButton btnComprar = new JButton("Comprar");
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnRegresar);
        panelBotones.add(btnComprar);

        String message = "Fila seleccionada:\n"
                + "Aerolinea: " + aerolinea + "\n"
                + "Aeropuerto salida: " + aeropuertoSalida + "\n"
                + "Aeropuerto llegada: " + aeropuertoLlegada + "\n"
                + "Escala: " + escala + "\n"
                + "Hora salida: " + horaSalida + "\n"
                + "Hora llegada: " + horaLlegada + "\n"
                + "Duracion: " + duracion + "\n"
                + "Precios totales: " + preciosTotales;

// Set up button actions
        btnRegresar.addActionListener(event -> {
            Window window = SwingUtilities.getWindowAncestor(panelBotones);
            if (window != null) {
                window.dispose();
            }
        });

        btnComprar.addActionListener(event -> {
            SearchFlight searchFlight = new SearchFlight();

            int uniqueId = searchFlight.generateUniqueHistoryId();
            SimpleDateFormat actualDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            int userId = 0; // Implement this as needed
            int idDepartureAirport = searchFlight.getAirportIdByName(aeropuertoSalida);
            int idArrivalAirport = searchFlight.getAirportIdByName(aeropuertoLlegada);
            int quantityTickets = (Integer) spinnerPassengers.getValue();
            Date actualDateTime = new Date();

            String[] historial = new String[10];
            historial[0] = String.valueOf(uniqueId);
            historial[1] = String.valueOf(userId); //usuario necesita ser implementada
            historial[2] = String.valueOf(idDepartureAirport);
            historial[3] = String.valueOf(idArrivalAirport);
            historial[4] = String.valueOf(31); // escala necesita ser implementada
            historial[5] = actualDate.format(actualDateTime);  // fecha y hora de compra
            historial[6] = String.valueOf(quantityTickets);
            historial[7] = "A1"; // asientos necesita ser implementada
            historial[8] = String.valueOf(duracion);
            historial[9] = String.valueOf(preciosTotales);

            searchFlight.addHistory(historial);
        });

        // Panel que se muestra
        JOptionPane.showOptionDialog(
                null,
                new Object[]{message, panelBotones}, // Contenido del dialogo se puede pasar un array de objetos, aqui un mensaje y un panel de botones.
                "Detalle del Vuelo",
                JOptionPane.DEFAULT_OPTION, // 'DEFAULT_OPTION' significa que el cuadro de dialogo no tiene botones de opcion especifico solo el predeterminado
                JOptionPane.INFORMATION_MESSAGE,
                null, // Icono personalizado'null' significa que se usara el icono predeterminado para el tipo de mensaje
                new Object[]{}, // Opciones del cuadro de dialogo un array vacío indica que no hay un conjunto personalizado de opciones
                null // Opcion predeterminada'null' significa que no se selecciona una opcion predeterminada
        );
    }

    private void filterFlights() {
        actualData dataActual = new actualData();
        List<Aeropuerto> actualAirports = dataActual.getAirports();
        List<Vuelo> actualFlights = dataActual.getFlights();
        List<Aerolinea> actualAirlines = dataActual.getAirlines();
        int id1 = 0;
        int id2 = 0;
        int id3 = 0;

        String departureAirport = String.valueOf(jcbOrigen.getSelectedItem());
        String arrivalAirport = String.valueOf(jcbDestino.getSelectedItem());
        List<Vuelo> filteredFlights = new ArrayList();
        for (Vuelo actualFlight : actualFlights) {
            for (Aeropuerto actualArport : actualAirports) {
                if (actualArport.getAirportName().equals(departureAirport)) {
                    id1 = actualArport.getIdAirport();

                } else if (actualArport.getAirportName().equals(arrivalAirport)) {
                    id2 = actualArport.getIdAirport();

                }

            }
            if (actualFlight.getIdDepartureAirport() == id1 && actualFlight.getIdArrivalAirport() == id2) {
                filteredFlights.add(actualFlight);//lista filtrada para los vuelos que cumplen los parametros
                System.out.println(datechooserFechaSalida.getSelectedDate());
            }
            else if(actualFlight.getIdDepartureAirport() == id1 && actualFlight.getIdArrivalAirport() != id2){
                for(Vuelo actualFlight2: actualFlights){
                    if(actualFlight2.getIdArrivalAirport() == id2 && actualFlight2.getIdDepartureAirport() == actualFlight.getIdArrivalAirport()){
                        id3 = actualFlight2.getIdDepartureAirport();
                        filteredFlights.add(actualFlight);
                        filteredFlights.add(actualFlight2);
                    }
                }
            }
            
                
                
            
        }
        model.setRowCount(0);
        showFlights(filteredFlights, dataActual, id3);

    }

    private void showFlights(List<Vuelo> filteredFlights, actualData dataActual, int id3){
        String nombre = "";
            String aeropuerto1 = "";
            String aeropuerto2 = "";
            String aeropuertoEscala = "";
            System.out.println(id3);
        if(id3 == 0){
            for (Vuelo actualFlight : filteredFlights) {
            

            for (Aerolinea airline : dataActual.getAirlines()) {
                if (actualFlight.getIdAirline() == airline.getIdAirline()) {
                    nombre = airline.getAirlineName();
                }
            }
            for (Aeropuerto airport : dataActual.getAirports()) {
                if (actualFlight.getIdDepartureAirport() == airport.getIdAirport()) {
                    aeropuerto1 = airport.getAirportName();
                }
            }
            for (Aeropuerto airport : dataActual.getAirports()) {
                if (actualFlight.getIdArrivalAirport() == airport.getIdAirport()) {
                    aeropuerto2 = airport.getAirportName();
                }
            }
            int passengers = (Integer) spinnerPassengers.getValue();
            int passengersMultipliedPrice = actualFlight.getFlightPrice() * passengers;
            System.out.println("no se ejecuta la escala");
            model.addRow(new Object[]{
                nombre,
                aeropuerto1,
                aeropuerto2,
                "",
                actualFlight.getDepartureHour(),
                actualFlight.getArrivalHour(),
                actualFlight.getFlightDuration(),
                passengersMultipliedPrice
            });
        }
        }
        else{
            
            for (int i = 0; i < filteredFlights.size() - 1; i += 2) {
            Vuelo flight1 = filteredFlights.get(i);
            Vuelo flight2 = filteredFlights.get(i + 1);
            int passengers = (Integer) spinnerPassengers.getValue();
            int passengersMultipliedPrice = (flight1.getFlightPrice() + flight2.getFlightPrice()) * passengers;
            for (Aerolinea airline : dataActual.getAirlines()) {
                if (flight1.getIdAirline() == airline.getIdAirline()) {
                    nombre = airline.getAirlineName();
                }
            }
            for (Aeropuerto airport : dataActual.getAirports()) {
                if (flight1.getIdDepartureAirport() == airport.getIdAirport()) {
                    aeropuerto1 = airport.getAirportName();
                }
                else if(flight1.getIdArrivalAirport() == airport.getIdAirport() && flight2.getIdDepartureAirport() == airport.getIdAirport()){
                    aeropuertoEscala = airport.getAirportName();
                }
            }
            for (Aeropuerto airport : dataActual.getAirports()) {
                if(flight2.getIdArrivalAirport()== airport.getIdAirport()){
                    aeropuerto2 = airport.getAirportName();
                }
                
            }
            System.out.println(aeropuertoEscala +"se ejecuta la escala");
            // Crear un nuevo registro con datos seleccionados de ambos objetos
           model.addRow(new Object[]{
                nombre,
                aeropuerto1,
                aeropuerto2,
                aeropuertoEscala,
                flight1.getDepartureHour(),
                flight2.getArrivalHour(),
                flight1.getFlightDuration()+flight2.getFlightDuration(),
                passengersMultipliedPrice
            });
        }
        }
        
    }

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

    private void fillCombos() {
        actualData dataActual = new actualData();
        for (Aeropuerto actualAirport : dataActual.getAirports()) {
            jcbOrigen.addItem(actualAirport.getAirportName());
            jcbDestino.addItem(actualAirport.getAirportName());
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
            java.util.logging.Logger.getLogger(FlightSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlightSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlightSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlightSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FlightSearch dialog = new FlightSearch(new javax.swing.JFrame(), true);
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
    private datechooser.beans.DateChooserCombo datechooserFechaSalida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbDestino;
    private javax.swing.JComboBox<String> jcbOrigen;
    private javax.swing.JLabel lblBusquedaVuelos;
    private javax.swing.JLabel lblDestino1;
    private javax.swing.JLabel lblFechaSalida;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblImagenExit;
    private javax.swing.JLabel lblOrigen;
    private javax.swing.JLabel lblPasajeros;
    private javax.swing.JSpinner spinnerPassengers;
    // End of variables declaration//GEN-END:variables
}
