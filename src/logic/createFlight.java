/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import static java.lang.Math.random;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import objects.Vuelo;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import objects.Aerolinea;
import objects.Aeropuerto;
import objects.Avion;
import objects.Tripulante;

public class createFlight {

    public createFlight() {
        
    }

    public static void addFlight(String[] flight) {
        actualData actualData = new actualData();
        List<Vuelo> actualFlight = actualData.getFlights();
        Vuelo newFlight = new Vuelo();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Formato para las horas
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        try {
            newFlight.setIdFlight(Integer.parseInt(flight[0]));
            newFlight.setIdAirline(Integer.parseInt(flight[1]));

            newFlight.setFlightPrice(Integer.parseInt(flight[2]));
            newFlight.setDepartureDate(dateFormat.parse(flight[3]));
            newFlight.setDepartureHour(timeFormat.parse(flight[4]));
            newFlight.setIdDepartureAirport(Integer.parseInt(flight[5]));
            newFlight.setArrivalDate(dateFormat.parse(flight[6]));
            newFlight.setArrivalHour(timeFormat.parse(flight[7]));
            newFlight.setIdArrivalAirport(Integer.parseInt(flight[8]));

            newFlight.setFlightDuration(Integer.parseInt(flight[9]));
            newFlight.setIdPlane(Integer.parseInt(flight[10]));
            newFlight.setIdPilot(Integer.parseInt(flight[11]));
            newFlight.setIdService(Integer.parseInt(flight[12]));

        } catch (NumberFormatException | ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar agregar un vuelo: " + e.getMessage());
            return; // Salir del metodo si hay un error
        }
        actualFlight.add(newFlight);
        actualData.setFlights(actualFlight);
    }

    private void fillAirports(JComboBox jcbAeropuertoSalida, JComboBox jcbAeropuertoLlegada) {
        actualData data = new actualData();
        List<Aeropuerto> airports = data.getAirports();

        for (Aeropuerto airport : airports) {
            jcbAeropuertoSalida.addItem(airport.getAirportName());
            jcbAeropuertoLlegada.addItem(airport.getAirportName());
        }
    }

    private void fillAirlines(JComboBox jcbAerolinea) {
        actualData data = new actualData();
        List<Aerolinea> airlines = data.getAirlines();

        for (Aerolinea airline : airlines) {
            jcbAerolinea.addItem(airline.getAirlineName());
        }
    }

    public void fillComboBoxes(JComboBox jcbAeropuertoSalida, JComboBox jcbAeropuertoLlegada, JComboBox jcbAerolinea) {
        fillAirlines(jcbAerolinea);
        fillAirports(jcbAeropuertoSalida, jcbAeropuertoLlegada);
    }

    public int getAirlineIdByName(String nameAirlineCaptured) {
        actualData actualData = new actualData();
        List<Aerolinea> actualAirlines = actualData.getAirlines();
        for (Aerolinea airline : actualAirlines) {
            if (airline.getAirlineName().equals(nameAirlineCaptured)) {
                return airline.getIdAirline();
            }
        }
        return -1;
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
    
    public int getPlaneId(String airline){
        actualData actualData = new actualData();
        List<Avion> actualPlanes = actualData.getPlanes();
        List<Aerolinea> actualAirlines = actualData.getAirlines();
        for(Aerolinea aerolineaActual : actualAirlines){
            if(aerolineaActual.getAirlineName().equals(airline)){
                for(Avion avionActual: actualPlanes){
                    if(avionActual.getIdAirline() == aerolineaActual.getIdAirline() && avionActual.getState() == 0){
                        
                        avionActual.setState(1);
                        actualData.updatePlanes(actualPlanes);
                        System.out.println(avionActual.getState());
                        return avionActual.getIdPlane();
                    }
                }
                
                
            }
        }
        return 0;
    }
    
    public int[] getCrew(String airline){
        int[] Tripulantes = new int[2];
        Tripulantes[0] = 0;
        Tripulantes[1] = 0;
        boolean rellenadoPiloto = false;
        boolean rellenadoServicio = false;
        actualData actualData = new actualData();
        List<Tripulante> actualCrewMembers = actualData.getCrewMembers();
        List<Aerolinea> actualAirlines = actualData.getAirlines();
        for(Aerolinea aerolineaActual : actualAirlines){
            if(aerolineaActual.getAirlineName().equals(airline)){
    
                    for(Tripulante tripulanteActual: actualCrewMembers){
                        if(tripulanteActual.getIdAirline() == aerolineaActual.getIdAirline() && tripulanteActual.getState() == 0){
                            if(rellenadoPiloto == false){
                                if(tripulanteActual.getRole().equals("Piloto")){
                                    if(Tripulantes[0] == 0){
                                        Tripulantes[0] = tripulanteActual.getIdCrewmember();
                                        tripulanteActual.setState(1);
                                        rellenadoPiloto = true;
                                        actualData.updateCrewMembers(actualCrewMembers);
                                    }
                                }
                            }
                            else if(rellenadoServicio == false){
                                
                                if(tripulanteActual.getRole().equals("Servicio al Cliente")){
                                    if(Tripulantes[1] == 0){
                                        Tripulantes[1] = tripulanteActual.getIdCrewmember();
                                        tripulanteActual.setState(1);
                                        rellenadoServicio = true;
                                        actualData.updateCrewMembers(actualCrewMembers);
                                    }
                                }
                            }
                        }
                    }
                  
            }
        }
        return Tripulantes;
    }
    
    public int getDuration(Date departureDate, Date departureHour, Date arrivalDate, Date arrivalHour) {

        // Convertir Date a LocalDateTime para calculos precisos
        LocalDateTime departureDateTime = LocalDateTime.ofInstant(departureDate.toInstant(), ZoneId.systemDefault())
                .withHour(departureHour.getHours())
                .withMinute(departureHour.getMinutes())
                .withSecond(departureHour.getSeconds());
        LocalDateTime arrivalDateTime = LocalDateTime.ofInstant(arrivalDate.toInstant(), ZoneId.systemDefault())
                .withHour(arrivalHour.getHours())
                .withMinute(arrivalHour.getMinutes())
                .withSecond(arrivalHour.getSeconds());

        // Calcular la duracion entre la hora de llegada y la hora de salida
        Duration duration = Duration.between(departureDateTime, arrivalDateTime);
        long totalMinutes = duration.toMinutes();

        // Convertir los minutos totales a un formato entero (horas y minutos concatenados)
        int hours = (int) (totalMinutes / 60);
        int minutes = (int) (totalMinutes % 60);

        // Concatenar horas y minutos en un solo entero (ejemplo: 830 para 8 horas 30 minutos)
        int combinedTime = hours * 100 + minutes;
        return combinedTime;
    }
    /*public int getDuration(Date departureDate, Date arrivalDate) {
         long diffInMillis = arrivalDate.getTime() - departureDate.getTime();

        // Convertir la diferencia a minutos
        long totalMinutes = diffInMillis / TimeUnit.MINUTES.toMillis(1);

        // Convertir los minutos totales a horas y minutos
        int hours = (int) (totalMinutes / 60);
        int minutes = (int) (totalMinutes % 60);

        // Concatenar horas y minutos en un solo entero (ejemplo: 830 para 8 horas 30 minutos)
        int combinedTime = hours * 100 + minutes;

        return combinedTime;
    
    }*/

    public int generateUniqueFlightId() {
        return (int) (Math.random() * 100000);
    }
    
}
