/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

import java.util.Date;

/**
 *
 * @author user
 */
public class Historial {

    private int idHistorial;
    private int idPassenger;
    private int idDepartureAirport;
    private int idArrivalAirport;
    private int idStopoverAirport;
    private Date realTimeFlightBought;
    private int amountOfTickets;
    private String seats;
    private int totalDuration;
    private int totalCost;
    private int idFlight;
    private int idScale;

    public int getIdScale() {
        return idScale;
    }

    public void setIdScale(int idScale) {
        this.idScale = idScale;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public int getIdDepartureAirport() {
        return idDepartureAirport;
    }

    public void setIdDepartureAirport(int idDepartureAirport) {
        this.idDepartureAirport = idDepartureAirport;
    }

    public int getIdArrivalAirport() {
        return idArrivalAirport;
    }

    public void setIdArrivalAirport(int idArrivalAirport) {
        this.idArrivalAirport = idArrivalAirport;
    }

    public int getIdStopoverAirport() {
        return idStopoverAirport;
    }

    public void setIdStopoverAirport(int idStopoverAirport) {
        this.idStopoverAirport = idStopoverAirport;
    }

    public Date getRealTimeFlightBought() {
        return realTimeFlightBought;
    }

    public void setRealTimeFlightBought(Date realTimeFlightBought) {
        this.realTimeFlightBought = realTimeFlightBought;
    }

    public int getAmountOfTickets() {
        return amountOfTickets;
    }

    public void setAmountOfTickets(int amountOfTickets) {
        this.amountOfTickets = amountOfTickets;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

}
