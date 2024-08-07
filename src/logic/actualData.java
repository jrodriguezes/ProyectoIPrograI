package logic;

import java.io.IOException;
import java.util.List;
import objects.Aerolinea;
import objects.Aeropuerto;
import objects.Avion;
import objects.Tripulante;
import objects.Vuelo;
import objects.Usuario;
import data.Data;
import java.util.ArrayList;

public class actualData {

    private List<Aerolinea> airlines;
    private List<Aeropuerto> airports;
    private List<Avion> planes;
    private List<Tripulante> crewMembers;
    private List<Vuelo> flights;
    private List<Usuario> passengers;

    // Constructor para cargar todos los datos al inicializar la clase
    public actualData() {
        loadAirlines();
        loadAirports();
        loadPlanes();
        loadCrewMembers();
        loadFlights();
        loadPassengers();
        loadFlights();
    }

    // Métodos para cargar datos desde archivos
    private void loadAirlines() {
        try {
            List<String[]> datosArchivo = Data.leerArchivo("src/resources/Aerolineas.txt", ",");
            this.airlines = (List<Aerolinea>) Data.procesarDatos(datosArchivo, "aerolinea");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAirports() {
        try {
            List<String[]> datosArchivo = Data.leerArchivo("src/resources/Aeropuertos.txt", ",");
            this.airports = (List<Aeropuerto>) Data.procesarDatos(datosArchivo, "aeropuerto");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPlanes() {
        try {
            List<String[]> datosArchivo = Data.leerArchivo("src/resources/Aviones.txt", ",");
            this.planes = (List<Avion>) Data.procesarDatos(datosArchivo, "avion");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCrewMembers() {
        try {
            List<String[]> datosArchivo = Data.leerArchivo("src/resources/Tripulaciones.txt", ",");
            this.crewMembers = (List<Tripulante>) Data.procesarDatos(datosArchivo, "tripulante");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFlights() {
        try {
            List<String[]> datosArchivo = Data.leerArchivo("src/resources/Vuelos.txt", ",");
            this.flights = (List<Vuelo>) Data.procesarDatos(datosArchivo, "vuelo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPassengers() {
        try {
            List<String[]> datosArchivo = Data.leerArchivo("src/resources/Usuarios.txt", ",");
            this.passengers = (List<Usuario>) Data.procesarDatos(datosArchivo, "usuarios");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Métodos getter para obtener las listas
    public List<Aerolinea> getAirlines() {
        return airlines;
    }

    public List<Aeropuerto> getAirports() {
        return airports;
    }

    public List<Avion> getPlanes() {
        return planes;
    }

    public List<Tripulante> getCrewMembers() {
        return crewMembers;
    }

    public List<Vuelo> getFlights() {
        return flights;
    }

    public List<Usuario> getPassengers() {
        return passengers;
    }

    void setPassengers(List<Usuario> passengers) {
        this.passengers = passengers;
        List<String> passengersToString = new ArrayList<>();
        for (Usuario usuarioActual : passengers) {
            passengersToString.add(String.valueOf(usuarioActual.getIdUser()) + "," + usuarioActual.getUserName() + "," + String.valueOf(usuarioActual.getUserAge()) + "," + String.valueOf(usuarioActual.getUserPassword()) + "," + usuarioActual.getUserMail() + "," + String.valueOf(usuarioActual.getType()) + "\n");
        }
        Data.escribirArchivo("src/resources/Usuarios.txt", passengersToString);
    }

    void setFlights(List<Vuelo> flights) {
        this.flights = flights;
        List<String> flightToString = new ArrayList<>();
        for (Vuelo actualFlight : flights) {
            flightToString.add(String.valueOf(actualFlight.getIdFlight()) + ","
                    + actualFlight.getIdAirline() + ","
                    + actualFlight.getFlightPrice() + ","
                    + actualFlight.getDepartureDate() + ","
                    + actualFlight.getDepartureHour() + ","
                    + actualFlight.getIdDepartureAirport() + ","
                    + actualFlight.getArrivalDate() + ","
                    + actualFlight.getArrivalHour() + ","
                    + actualFlight.getIdArrivalAirport() + ","
                    + actualFlight.getFlightDuration() + ","
                    + actualFlight.getIdPlane() + ","
                    + actualFlight.getIdPilot() + ","
                    + actualFlight.getIdService()+ "\n");
        }
        Data.escribirArchivo("src/resources/Vuelos.txt", flightToString);
    }
    
    void updateCrewMembers(List<Tripulante> crewMembers) {
        this.crewMembers = crewMembers;
        List<String> crewMemberstToString = new ArrayList<>();
        for (Tripulante actualCrewMember : crewMembers) {
            crewMemberstToString.add(String.valueOf(actualCrewMember.getIdCrewmember()) + ","
                    + actualCrewMember.getMemberName()+ ","
                    + actualCrewMember.getIdAirline()+ ","
                    + actualCrewMember.getRole()+ ","
                    + actualCrewMember.getState()+ "\n");
        }
        Data.escribirArchivo("src/resources/Tripulaciones.txt", crewMemberstToString);
    }
    
    void updatePlanes(List<Avion> planes) {
        this.planes = planes;
        List<String> planesToString = new ArrayList<>();
        for (Avion actualPlane : planes) {
            planesToString.add(String.valueOf(actualPlane.getIdPlane()) + ","
                    + actualPlane.getPlaneModel() + ","
                    + actualPlane.getIdAirline() + ","
                    + actualPlane.getState() + "\n");
        }
        Data.escribirArchivo("src/resources/Aviones.txt", planesToString);
    }
}
