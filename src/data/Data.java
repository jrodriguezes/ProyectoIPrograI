/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import logic.validations;
import objects.*;

/**
 *
 * @author Juanelas
 */
public class Data {

    public static List<String[]> leerArchivo(String rutaArchivo, String separador) throws IOException {
        List<String[]> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(separador);
                datos.add(campos);
            }
        }
        return datos;
    }

    public static void escribirArchivo(String rutaArchivo, List<String> datos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String cadena : datos) {
                // Reemplazar `\n` en la cadena con una nueva linea para dividir los registros
                String[] registros = cadena.split("\\n");
                for (String registro : registros) {
                    writer.write(registro);  // Escribe cada registro en el archivo
                    writer.newLine();        // Agrega una nueva linea despues de cada registro
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<?> procesarDatos(List<String[]> datos, String tipo) {
        System.out.println("Tipo de archivo recibido: " + tipo);
        switch (tipo) {
            case "aerolinea":
                List<Aerolinea> aerolineas = new ArrayList<>();
                for (String[] linea : datos) {
                    Aerolinea aerolineaActual = new Aerolinea();
                    int id = Integer.parseInt(linea[0].trim());
                    String nombre = linea[1].trim();
                    aerolineaActual.setAirlineName(nombre);
                    aerolineaActual.setIdAirline(id);
                    aerolineas.add(aerolineaActual);
                }
                return aerolineas;

            case "aeropuerto":
                List<Aeropuerto> aeropuertos = new ArrayList<>();
                for (String[] linea : datos) {
                    Aeropuerto aeropuertoActual = new Aeropuerto();
                    int id = Integer.parseInt(linea[0].trim());
                    String nombre = linea[1].trim();
                    String pais = linea[2].trim();
                    aeropuertoActual.setIdAirport(id);
                    aeropuertoActual.setAirportName(nombre);
                    aeropuertoActual.setAirportCountry(pais);
                    aeropuertos.add(aeropuertoActual);
                }
                return aeropuertos;

            case "avion":
                List<Avion> aviones = new ArrayList<>();
                for (String[] linea : datos) {
                    Avion avionActual = new Avion();
                    int id = Integer.parseInt(linea[0].trim());
                    String modelo = linea[1].trim();
                    int aerolineaId = Integer.parseInt(linea[2].trim());
                    int status = Integer.parseInt(linea[3].trim());
                    avionActual.setIdAirline(aerolineaId);
                    avionActual.setIdPlane(id);
                    avionActual.setPlaneModel(modelo);
                    avionActual.setState(status);
                    aviones.add(avionActual);
                }
                return aviones;

            case "tripulante":
                List<Tripulante> crewMembers = new ArrayList<>();
                for (String[] linea : datos) {
                    Tripulante actualCrewMember = new Tripulante();
                    int id = Integer.parseInt(linea[0].trim());
                    String nombre = linea[1].trim();
                    int aerolineaId = Integer.parseInt(linea[2].trim());
                    String puesto = linea[3].trim();
                    int status = Integer.parseInt(linea[4].trim());
                    actualCrewMember.setIdCrewmember(id);
                    actualCrewMember.setMemberName(nombre);
                    actualCrewMember.setIdAirline(aerolineaId);
                    actualCrewMember.setRole(puesto);
                    actualCrewMember.setState(status);
                    crewMembers.add(actualCrewMember);
                }
                return crewMembers;

            case "usuarios":
                List<Usuario> users = new ArrayList<>();
                for (String[] linea : datos) {
                    if (linea.length >= 6) {
                        Usuario actualUser = new Usuario();
                        int id = Integer.parseInt(linea[0].trim());
                        String nombre = linea[1].trim();
                        int age = Integer.parseInt(linea[2].trim());
                        String password = linea[3].trim();
                        String eMail = linea[4].trim();
                        int type = Integer.parseInt(linea[5].trim());

                        actualUser.setIdUser(id);
                        actualUser.setUserName(nombre);
                        actualUser.setUserAge(age);
                        actualUser.setUserPassword(password);
                        actualUser.setUserMail(eMail);
                        actualUser.setType(type);

                        users.add(actualUser);
                    } else {
                        System.err.println("Registro de usuario incompleto: " + Arrays.toString(linea));
                    }
                }
                return users;
            case "vuelo":
                List<Vuelo> vuelos = new ArrayList<>();
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("h:mm a");

                for (String[] linea : datos) {
                    if (linea.length >= 13) {
                        try {
                            Vuelo actualFlight = new Vuelo();
                            actualFlight.setIdFlight(Integer.parseInt(linea[0].trim()));
                            actualFlight.setIdAirline(Integer.parseInt(linea[1].trim()));
                            actualFlight.setFlightPrice(Integer.parseInt(linea[2].trim()));

                            // Parseo de fecha con SimpleDateFormat
                            actualFlight.setDepartureDate(removeTime(dateFormat.parse(linea[3].trim())));
                            actualFlight.setDepartureHour(getTimeOnly(dateFormat.parse(linea[4].trim())));
                            actualFlight.setIdDepartureAirport(Integer.parseInt(linea[5].trim()));

                            actualFlight.setArrivalDate(removeTime(dateFormat.parse(linea[6].trim())));
                            actualFlight.setArrivalHour(getTimeOnly(dateFormat.parse(linea[7].trim())));
                            actualFlight.setIdArrivalAirport(Integer.parseInt(linea[8].trim()));

                            actualFlight.setFlightDuration(Integer.parseInt(linea[9].trim()));
                            actualFlight.setIdPlane(Integer.parseInt(linea[10].trim()));
                            actualFlight.setIdPilot(Integer.parseInt(linea[11].trim()));
                            actualFlight.setIdService(Integer.parseInt(linea[12].trim()));

                            vuelos.add(actualFlight);
                        } catch (NumberFormatException | ParseException e) {
                            System.err.println("Error al parsear la línea: " + Arrays.toString(linea));
                            e.printStackTrace();
                        }
                    } else {
                        System.err.println("Registro de vuelo incompleto: " + Arrays.toString(linea));
                    }
                }
                return vuelos;
            case "historial":
                List<Historial> historiales = new ArrayList<>();
                SimpleDateFormat primaryFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
                SimpleDateFormat alternativeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                for (String[] lineaDato : datos) {
                    if (lineaDato.length >= 10) {
                        try {
                            Historial actualHistory = new Historial();
                            validations validations = new validations();
                            actualHistory.setIdHistorial(Integer.parseInt(lineaDato[0].trim()));
                            actualHistory.setIdPassenger(Integer.parseInt(lineaDato[1].trim()));
                            actualHistory.setIdDepartureAirport(Integer.parseInt(lineaDato[2].trim()));
                            actualHistory.setIdArrivalAirport(Integer.parseInt(lineaDato[3].trim()));
                            actualHistory.setIdStopoverAirport(Integer.parseInt(lineaDato[4].trim()));

                            Date parsedDate = validations.safeParseDate(lineaDato[5].trim(), primaryFormat);
                            if (parsedDate != null) {
                                actualHistory.setRealTimeFlightBought(parsedDate);
                            }

                            actualHistory.setAmountOfTickets(Integer.parseInt(lineaDato[6].trim()));
                            actualHistory.setSeats((lineaDato[7].trim()));
                            actualHistory.setTotalDuration(Integer.parseInt(lineaDato[8].trim()));
                            actualHistory.setTotalCost(Integer.parseInt(lineaDato[9].trim()));

                            historiales.add(actualHistory);

                        } catch (NumberFormatException e) {
                            System.err.println("Error al parsear la línea: " + Arrays.toString(lineaDato));
                            e.printStackTrace();
                        }
                    } else {
                        System.err.println("Registro de historial incompleto: " + Arrays.toString(lineaDato));
                    }
                }
                return historiales;
            default:
                System.out.println("Tipo de archivo desconocido: " + tipo);
                return new ArrayList<>();
        }
    }

    public static Date removeTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private static Date getTimeOnly(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, Calendar.JANUARY, 1); // Usamos una fecha base
        calendar.set(Calendar.HOUR_OF_DAY, date.getHours());
        calendar.set(Calendar.MINUTE, date.getMinutes());
        calendar.set(Calendar.SECOND, date.getSeconds());
        return calendar.getTime();
    }

}
