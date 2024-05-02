/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.*;
/**
 *
 * @author jasper
 */
public class Ticket {
    private int ID;
    private int clientID;
    private int flightID;
    private int price;
    private int pay;
    public Ticket() {
    }

    public Ticket(int ID, int clientID, int flightID, int price, int pay) {
        this.ID = ID;
        this.clientID = clientID;
        this.flightID = flightID;
        this.price = price;
        this.pay = pay;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public int getID() {
        return ID;
    }

    public int getClientID() {
        return clientID;
    }

    public int getFlightID() {
        return flightID;
    }

    public int getPrice() {
        return price;
    }

    public int getPay() {
        return pay;
    }
    
    

    
    
    
}
