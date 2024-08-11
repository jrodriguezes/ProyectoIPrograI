/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import objects.Aerolinea;
import objects.Aeropuerto;
import objects.Historial;
import objects.Usuario;
import objects.Vuelo;

/**
 *
 * @author user
 */
public class Reportes {

    //reporte 1 
    // cedula, nombre, nombre del aeropuerto de salida, nombre del aeropuerto de escala (si hay), nombre del aeropuerto de llegada y fecha y hora de compra. 
    
//    public void showHistoryInformation(Date datechooserFechaInicio, Date datechooserFechaFin) {
//        actualData actualData = new actualData();
//
//        List<Historial> flightHistory = actualData.getFlightHistory();
//
//        for (Historial historialActual : flightHistory) {
//            Date fechaCompra = historialActual.getRealTimeFlightBought();
//            if (fechaCompra.after(datechooserFechaInicio) || fechaCompra.equals(datechooserFechaInicio) && fechaCompra.before(datechooserFechaFin) || fechaCompra.equals(datechooserFechaFin)) {
//
//                int idClient = historialActual.getIdPassenger();
//                String nameClient = getClientNameById(idClient);
//
//                int idDepartureAirport = historialActual.getIdDepartureAirport();
//                String departureAirportName = getDepartureAirportNameById(idDepartureAirport);
//
//                int idStopoverAirport = historialActual.getIdStopoverAirport();
//                String stopoverAirportName = (idStopoverAirport != 0) ? getDepartureAirportNameById(idStopoverAirport) : "N/A";
//
//                int idArrivalAirport = historialActual.getIdArrivalAirport();
//                String arrivalAirportName = getDepartureAirportNameById(idArrivalAirport);
//
//                Date dateBought = historialActual.getRealTimeFlightBought();
//
//                model.addRow(new Object[]{
//                    idClient,
//                    nameClient,
//                    departureAirportName,
//                    "escalaImplementar",
//                    stopoverAirportName,
//                    arrivalAirportName,
//                    dateBought
//                });
//
//            }
//        }
//    }
    
    // Reporte 1
    public String getClientNameById(int id) {
        actualData actualData = new actualData();

        List<Usuario> passengersData = actualData.getPassengers();

        for (Usuario actualUser : passengersData) {
            if (actualUser.getIdUser() == id) {
                return actualUser.getUserName();
            }
        }
        return "Error al conseguir nombre del cliente";
    }

    public String getDepartureAirportNameById(int id) {
        actualData actualData = new actualData();

        List<Aeropuerto> airportData = actualData.getAirports();

        for (Aeropuerto actualAirport : airportData) {
            if (actualAirport.getIdAirport() == id) {
                return actualAirport.getAirportName();
            }
        }
        return "Error al conseguir nombre del aeropuerto";
    }
    
    // Reporte 2
    
    public void loadAirline(JComboBox jcbAerolineas) {
        actualData actualData = new actualData();
        
        List<Aerolinea> airlines = actualData.getAirlines();
        
        for (Aerolinea airline : airlines) {
            jcbAerolineas.addItem(airline.getAirlineName());
        }
    }
    
    public String getCrewmateNameById(int id) {
        actualData actualData = new actualData();
        
        List<Vuelo> flightData = actualData.getFlights();
        for (Vuelo actualFlight : flightData) {
            if (actualFlight.getIdPilot() == id) {
//                return actualFlight.
            }
        }
        return "error";
    }
    
}
