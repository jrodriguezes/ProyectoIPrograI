/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import objects.Aeropuerto;
import objects.Historial;

/**
 *
 * @author user
 */
public class SearchFlight {

    public void addHistory(String[] history) {
        actualData actualData = new actualData();

        List<Historial> actualHistory = actualData.getFlightHistory();

        Historial newHistory = new Historial();

        SimpleDateFormat actualDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            newHistory.setIdHistorial(Integer.parseInt(history[0]));
            newHistory.setIdPassenger(Integer.parseInt(history[1]));
            newHistory.setIdDepartureAirport(Integer.parseInt(history[2]));
            newHistory.setIdArrivalAirport(Integer.parseInt(history[3]));
            newHistory.setIdStopoverAirport(Integer.parseInt(history[4]));
            newHistory.setRealTimeFlightBought(actualDate.parse(history[5]));
            newHistory.setAmountOfTickets(Integer.parseInt(history[6]));
            newHistory.setSeats(history[7]);
            newHistory.setTotalDuration(Integer.parseInt(history[8]));
            newHistory.setTotalCost(Integer.parseInt(history[9]));

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al parsear la fecha: " + e.getMessage());
            e.printStackTrace();  // Print the stack trace for debugging
            return;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al parsear un número: " + e.getMessage());
            e.printStackTrace();  // Print the stack trace for debugging
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar agregar un historial: " + e.getMessage());
            e.printStackTrace();  // Print the stack trace for debugging
            return;
        }

        actualHistory.add(newHistory);
        actualData.setFlightHistory(actualHistory);
    }

    public int generateUniqueHistoryId() {
        return (int) (Math.random() * 100000);
    }

    public int getAirportIdByName(String nameAiport) {
        actualData actualData = new actualData();
        List<Aeropuerto> actualAirport = actualData.getAirports();
        for (Aeropuerto airport : actualAirport) {
            if (airport.getAirportName().equals(nameAiport)) {
                return airport.getIdAirport();
            }
        }
        return -2;
    }

    public String generateActualDate() {
        Date now = new Date();

        // Definir el formato deseado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Formatear la fecha y hora actuales
        String formattedDateTime = sdf.format(now);
        return formattedDateTime;
    }
    
    public void searchForScale(){
        
    }

}
