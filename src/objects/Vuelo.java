/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import java.util.Date;

/**
 *
 * @author Juanelas
 */
public class Vuelo {
    private int idFlight;
    private int idAirline;
    private int flightPrice;
    private Date departureDate;
    private Date departureHour;
    private int idDepartureAirport;
    private Date arrivalDate;
    private Date arrivalHour;
    private int idArrivalAirport;
    private int flightDuration;
    private int idPlane;
    private int idPilot;
    private int idService;

    public int getIdPilot() {
        return idPilot;
    }

    public void setIdPilot(int idPilot) {
        this.idPilot = idPilot;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public int getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(int idAirline) {
        this.idAirline = idAirline;
    }

    public int getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(int flightPrice) {
        this.flightPrice = flightPrice;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(Date departureHour) {
        this.departureHour = departureHour;
    }

    public int getIdDepartureAirport() {
        return idDepartureAirport;
    }

    public void setIdDepartureAirport(int idDepartureAirport) {
        this.idDepartureAirport = idDepartureAirport;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(Date arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public int getIdArrivalAirport() {
        return idArrivalAirport;
    }

    public void setIdArrivalAirport(int idArrivalAirport) {
        this.idArrivalAirport = idArrivalAirport;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    
}
