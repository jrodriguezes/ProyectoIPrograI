/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import objects.Usuario;
import java.util.List;

/**
 *
 * @author Juanelas
 */
import java.util.List;

public class createPassenger {

    public createPassenger() {

    }

    public void addPassenger(String[] passenger) {
        actualData actualData = new actualData();
        List<Usuario> actualPassengers = actualData.getPassengers();
        Usuario newPassenger = new Usuario();
        newPassenger.setIdUser(Integer.parseInt(passenger[0]));
        newPassenger.setUserName(passenger[1]);
        newPassenger.setUserMail(passenger[2]);
        newPassenger.setUserAge(Integer.parseInt(passenger[3]));
        newPassenger.setUserPassword(passenger[4]);
        newPassenger.setType(Integer.parseInt(passenger[5]));

        actualPassengers.add(newPassenger);
        actualData.setPassengers(actualPassengers);

    }
}
