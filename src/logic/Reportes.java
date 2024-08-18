/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import objects.Aerolinea;
import objects.Aeropuerto;
import objects.Avion;
import objects.Historial;
import objects.Tripulante;
import objects.Usuario;
import objects.Vuelo;

/**
 *
 * @author user
 */
public class Reportes {

    // Reporte 1
    // Reporte 1
    // Reporte 1
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
    // Reporte 2
    // Reporte 2
    // Reporte 2
    public void loadAirline(JComboBox jcbAerolineas) {
        actualData actualData = new actualData();
        List<Aerolinea> airlines = actualData.getAirlines();

        for (Aerolinea airline : airlines) {
            jcbAerolineas.addItem(airline.getAirlineName());
        }
    }

    public int getAirlineIdByName(String name) {
        actualData actualData = new actualData();
        List<Aerolinea> airlineData = actualData.getAirlines();

        for (Aerolinea actualAirline : airlineData) {
            if (actualAirline.getAirlineName().equals(name)) {
                System.out.println("ID Airline: " + actualAirline.getIdAirline());
                return actualAirline.getIdAirline();
            }
        }
        return -999; // ID inválido si no se encuentra la aerolínea
    }

    public int getIdCrewmateServiceByAirline(int idAirline) {
        actualData actualData = new actualData();
        List<Vuelo> flightData = actualData.getFlights();
        List<Historial> historyData = actualData.getFlightHistory();

        for (Historial actualHistory : historyData) {
            Vuelo actualFlight = null;

            // Bucle para encontrar el vuelo correspondiente al historial actual
            for (Vuelo flight : flightData) {
                if (flight.getIdFlight() == actualHistory.getIdFlight()) {
                    actualFlight = flight;
                    break; // Salir del bucle una vez que encontramos el vuelo
                }
            }

            // Si encontramos un vuelo, y su aerolínea coincide, devolvemos el ID del servicio
            if (actualFlight != null && actualFlight.getIdAirline() == idAirline) {
                return actualFlight.getIdService();
            }
        }
        return -999;
    }

    public int getIdCrewmatePilotByAirline(int idAirline) {
        actualData actualData = new actualData();
        List<Vuelo> flightData = actualData.getFlights();
        List<Historial> historyData = actualData.getFlightHistory();

        for (Historial actualHistory : historyData) {
            Vuelo actualFlight = null;

            // Bucle para encontrar el vuelo correspondiente al historial actual
            for (Vuelo flight : flightData) {
                if (flight.getIdFlight() == actualHistory.getIdFlight()) {
                    actualFlight = flight;
                    break; // Salir del bucle una vez que encontramos el vuelo
                }
            }

            // Si encontramos un vuelo, y su aerolínea coincide, devolvemos el ID del piloto
            if (actualFlight != null && actualFlight.getIdAirline() == idAirline) {
                return actualFlight.getIdPilot();
            }
        }
        return -999;
    }

    public int getPlaneByAirlineId(int idAirline) {
        actualData actualData = new actualData();
        List<Vuelo> flightData = actualData.getFlights();
        List<Historial> historyData = actualData.getFlightHistory();

        for (Historial actualHistory : historyData) {
            Vuelo actualFlight = null;

            // Bucle para encontrar el vuelo correspondiente al historial actual
            for (Vuelo flight : flightData) {
                if (flight.getIdFlight() == actualHistory.getIdFlight()) {
                    actualFlight = flight;
                    break; // Salir del bucle una vez que encontramos el vuelo
                }
            }

            // Si encontramos un vuelo, y su aerolínea coincide, devolvemos el ID del avión
            if (actualFlight != null && actualFlight.getIdAirline() == idAirline) {
                return actualFlight.getIdPlane();
            }
        }
        return -999;
    }

    public String getCrewmatePilotNameById(int id) {
        actualData actualData = new actualData();
        List<Tripulante> crewmateData = actualData.getCrewMembers();

        for (Tripulante actualCrewmate : crewmateData) {
            if (actualCrewmate.getIdCrewmember() == id && "Piloto".equals(actualCrewmate.getRole())) {
                return actualCrewmate.getMemberName();
            }
        }
        return "Error al obtener piloto";
    }

    public String getCrewmateServiceNameById(int id) {
        actualData actualData = new actualData();
        List<Tripulante> crewmateData = actualData.getCrewMembers();

        for (Tripulante actualCrewmate : crewmateData) {
            if (actualCrewmate.getIdCrewmember() == id && "Servicio al Cliente".equals(actualCrewmate.getRole())) {
                return actualCrewmate.getMemberName();
            }
        }
        return "Error al obtener nombre de servicio al cliente";
    }

    // Reporte 3 
    // Reporte 3 
    // Reporte 3 
    // Reporte 3 
    public void loadIdToJCB(JComboBox jcb) {
        actualData actualData = new actualData();

        List<Historial> hitorialData = actualData.getFlightHistory();
        for (Historial actualHistorial : hitorialData) {
            jcb.addItem(actualHistorial.getIdPassenger());
        }
    }

    public String obtainClientNameById(int id) {
        actualData actualData = new actualData();

        List<Historial> historialData = actualData.getFlightHistory();
        List<Usuario> usersData = actualData.getPassengers();
        for (Historial actualHistorial : historialData) {
            if (actualHistorial.getIdPassenger() == id) {

                for (Usuario actualUser : usersData) {
                    if (actualUser.getIdUser() == id) {

                        return actualUser.getUserName();
                    }
                }
            }
        }
        return "Error al obtener cliente por id:";
    }

    public int obtainDepartureAirportByClientId(int id) {
        actualData actualData = new actualData();

        List<Historial> historialData = actualData.getFlightHistory();

        for (Historial actualHistorialData : historialData) {
            if (actualHistorialData.getIdPassenger() == id) {
                return actualHistorialData.getIdDepartureAirport();
            }
        }
        return -99;
    }

    public String obtainDepartureAirportNameByClientId(int idAirport) {
        actualData actualData = new actualData();

        List<Aeropuerto> airportData = actualData.getAirports();

        for (Aeropuerto actualAirport : airportData) {
            if (actualAirport.getIdAirport() == idAirport) {
                return actualAirport.getAirportName();
            }
        }
        return "Error al obtener el nombre del aeropuerto de salida";
    }

    public int obtainArrivalAirportByClientId(int id) {
        actualData actualData = new actualData();

        List<Historial> historialData = actualData.getFlightHistory();

        for (Historial actualHistorialData : historialData) {
            if (actualHistorialData.getIdPassenger() == id) {
                return actualHistorialData.getIdArrivalAirport();
            }
        }
        return -99;
    }

    public String obtainArrivalAirportNameByClientId(int idAirport) {
        actualData actualData = new actualData();

        List<Aeropuerto> airportData = actualData.getAirports();

        for (Aeropuerto actualAirport : airportData) {
            if (actualAirport.getIdAirport() == idAirport) {
                return actualAirport.getAirportName();
            }
        }
        return "Error al obtener el nombre del aeropuerto de salida";
    }

    public int obtainStopoverAirportIdByClientId(int id) {
        actualData actualData = new actualData();

        List<Historial> historialData = actualData.getFlightHistory();

        for (Historial actualHistorialData : historialData) {
            if (actualHistorialData.getIdPassenger() == id) {
                return actualHistorialData.getIdStopoverAirport();
            }
        }
        return -99;
    }

    public String obtainStopoverAirportNameByClientId(int idAirport) {
        actualData actualData = new actualData();

        List<Aeropuerto> airportData = actualData.getAirports();

        for (Aeropuerto actualAirport : airportData) {
            if (actualAirport.getIdAirport() == idAirport) {
                return actualAirport.getAirportName();
            }
        }
        return "No habia aeropuerto de escala";
    }

    public int obtainTotalDurationByClientId(int id) {
        actualData actualData = new actualData();

        List<Historial> historialData = actualData.getFlightHistory();

        for (Historial actualHistorialData : historialData) {
            if (actualHistorialData.getIdPassenger() == id) {
                return actualHistorialData.getTotalDuration();
            }
        }
        return -99;
    }

    public int obtainTicketsByClientId(int id) {
        actualData actualData = new actualData();

        List<Historial> historialData = actualData.getFlightHistory();

        for (Historial actualHistorialData : historialData) {
            if (actualHistorialData.getIdPassenger() == id) {
                return actualHistorialData.getAmountOfTickets();
            }
        }
        return -99;
    }

    public String obtainSeatsByClientId(int id) {
        actualData actualData = new actualData();

        List<Historial> historialData = actualData.getFlightHistory();

        for (Historial actualHistorialData : historialData) {
            if (actualHistorialData.getIdPassenger() == id) {
                return actualHistorialData.getSeats();
            }
        }
        return "Error al obtener el dato de los asientos";
    }

    public int obtainTotalCostByClientId(int id) {
        actualData actualData = new actualData();

        List<Historial> historialData = actualData.getFlightHistory();

        for (Historial actualHistorialData : historialData) {
            if (actualHistorialData.getIdPassenger() == id) {
                return actualHistorialData.getTotalCost();
            }
        }
        return -99;
    }

    public List<Historial> obtenerComprasPorCliente(int idCliente) {
        actualData actualData = new actualData();
        List<Historial> historialData = actualData.getFlightHistory();
        List<Historial> comprasCliente = new ArrayList<>();

        for (Historial actualHistorial : historialData) {
            if (actualHistorial.getIdPassenger() == idCliente) {
                comprasCliente.add(actualHistorial);
            }
        }
        return comprasCliente;
    }

    public List<Historial> obtenerHistorial() {
        actualData actualData = new actualData();
        return actualData.getFlightHistory();  // Aquí se asume que actualData tiene un método para obtener la lista de Historial
    }

}
