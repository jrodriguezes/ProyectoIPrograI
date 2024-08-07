/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

/**
 *
 * @author Juanelas
 */
public class Tripulante {
    private int idCrewmember;
    private String memberName;
    private int idAirline;
    private String role;
    private int state;

    public int getIdCrewmember() {
        return idCrewmember;
    }

    public void setIdCrewmember(int idCrewmember) {
        this.idCrewmember = idCrewmember;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(int idAirline) {
        this.idAirline = idAirline;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
}
