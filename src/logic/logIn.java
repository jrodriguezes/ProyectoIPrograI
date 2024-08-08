/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import objects.Usuario;
import java.awt.desktop.UserSessionEvent;
import java.util.List;

/**
 *
 * @author Juanelas
 */
public class logIn {

    public String logIn(int id, String password) {
        actualData data = new actualData();
        List<Usuario> actualUsers = data.getPassengers();
        for (Usuario usuarioActual : actualUsers) {
            if (usuarioActual.getIdUser() == id && usuarioActual.getUserPassword().equals(password)) {
                if (usuarioActual.getType() == 1) {
                    return "admin";
                } else {
                    return "user";
                }
            }

        }
        return "not found";

    }
}
