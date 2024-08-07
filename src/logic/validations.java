/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Admin
 */
public class validations {

    public validations() {

    }

    public boolean validateArrivalTime(Date departureDate, Date departureHour, Date arrivalDate, Date arrivalHour) {

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

        if (duration.toHours() < 1) {
            JOptionPane.showMessageDialog(null, "La hora de llegada debe ser al menos una hora mayor que la hora de salida.");
            return false;
        }
        return true;
    }
    
    
    
    public boolean validateArrivalDate(Date departureDate, Date arrivalDate) {
        if (arrivalDate != null && departureDate != null) {
            if (!arrivalDate.after(departureDate)) {
                JOptionPane.showMessageDialog(null, "La fecha de llegada debe de ser mayor que la fecha de salida.");
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean validateAirport(String airport1, String airport2) {
        if (airport1 != "Seleccione un aeropuerto de salida" && airport2 != "Seleccione un aeropuerto de llegada") {
            if (airport1 != airport2) {
                return true;
            }
            JOptionPane.showMessageDialog(null, "El aeropuerto de llegada y de salida no deben de ser los mismos");
            return false;
        }
        JOptionPane.showMessageDialog(null, "Debe de seleccionar los 2 aeropuertos");
        return false;
    }

    // para combobox
    public boolean validateNotLeaveBlankSpace(String airline, String textofmodel) {
        if (airline != textofmodel) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion.");
        return false;
    }

    // para textfield
    public boolean validateNotLeaveBlankSpaceTextField(String textfield, String text) {
        if (textfield == null || textfield.trim().isEmpty() || textfield.equals(text)) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            return false;
        }
        return true;
    }

    public boolean validateAsAIntegerInTextField(String textfield) {
        try {
            Integer.parseInt(textfield.trim());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Algunas casillas deben contener solo numeros.");
            return false;
        }
    }

    public void configurateSpinner(JSpinner spinner) {
        // Crear un SpinnerDateModel que solo maneje horas
        SpinnerDateModel model = new SpinnerDateModel();
        model.setCalendarField(Calendar.HOUR_OF_DAY);

        // Asignar el modelo al JSpinner
        spinner.setModel(model);

        // Crear un editor de fecha para mostrar solo horas
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm");
        spinner.setEditor(editor);
    }
}
