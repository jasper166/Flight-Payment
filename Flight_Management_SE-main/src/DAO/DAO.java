/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Flight;
import Model.Schedule;
import Model.Ticket;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Quang Nguyen
 */
public class DAO {
    private static String connectionString = "jdbc:sqlserver://localhost:1434;databaseName=test;user=sa;password=Duckie@01;encrypt=false";

    private Connection _connect;

    public DAO() {

        _connect = initializeDBConnection();
    }

    private Connection initializeDBConnection() {
        try {
            String password = "";
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println("DB connected");
            return connection;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public List<Schedule> getAllSchedule(List <Integer> userSchedule) throws SQLException {
        List<Schedule> allSchedule = new ArrayList<>();
        String query = "select * from schedule";
        try {
            PreparedStatement statement = _connect.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(result.getInt("id"));
                
                if (!userSchedule.contains(schedule.getId())) continue;
                
                schedule.setGate(result.getString("gate"));
                schedule.setDepartureTime(result.getTimestamp("departureTime"));
                schedule.setDeparture(result.getString("departure"));
                schedule.setStatus(result.getString("status"));
                allSchedule.add(schedule);
            }
        } catch (SQLException ex) {
            System.out.println("ERR");
            throw ex;
        }
        return allSchedule;
    }
    
    public void cancelPayment(ArrayList <Integer> Ticket) throws SQLException {
        int n = Ticket.size();
        String idx = "(";
        for (int i = 0; i < n - 1; ++i) {
                int x = Ticket.get(i);
                idx += String.valueOf(x);
                idx += ",";
        }
        idx += String.valueOf(Ticket.get(n - 1));
        idx += ")";
        String query = "UPDATE Ticket SET Pay = 0 WHERE ID IN " + idx + ";";
        
        System.out.println(query);
        try {
            PreparedStatement statement = _connect.prepareStatement(query);
            ResultSet result = statement.executeQuery();
        } catch (SQLException ex) {
            System.out.println("ERR");
            throw ex;
        }
        return;
    }
    
    public List<Flight> getAllFlight(List <Integer> userFlight) throws SQLException {
        List<Flight> flights = new ArrayList<>();
        String query = "select * from Flight";
        try {
            PreparedStatement statement = _connect.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Flight flight = new Flight();
                flight.setId(result.getInt("id"));
                
                if (!userFlight.contains(flight.getId())) continue;
                
                flight.setName(result.getString("name"));
                flight.setDeparture(result.getString("departure"));
                flight.setArrival(result.getString("arrival"));
                flight.setDurationMinutes(result.getInt("durationMinutes"));
                flight.setScheduleId(result.getInt("scheduleId"));
                flights.add(flight);
            }
        } catch (SQLException ex) {
            System.out.println("ERR");
            throw ex;
        }
        return flights;
    }
    
    public List<Ticket> getAllTickets(int _userID) throws SQLException {
        List<Ticket> ticketDetails = new ArrayList<>();
        String query = "SELECT * FROM Ticket";
        try {
            PreparedStatement statement = _connect.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Ticket ticketDetail = new Ticket();
                ticketDetail.setID(result.getInt("id"));
                ticketDetail.setClientID(result.getInt("clientId"));
                ticketDetail.setFlightID(result.getInt("flightId"));
                ticketDetail.setPrice(result.getInt("price"));
                ticketDetail.setPay(result.getInt("pay"));
                if (ticketDetail.getClientID() == _userID)
                    ticketDetails.add(ticketDetail);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return ticketDetails;
    }
    
    public List<Flight> searchByFlight(int _ask) throws SQLException {
        List<Flight> searchDetails = new ArrayList<>();
        String query = "SELECT * FROM Flight";
        try {
            PreparedStatement statement = _connect.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                Flight flight = new Flight();
                
                flight.setId(result.getInt("id"));
                if (flight.getId() != _ask) continue;
                
                flight.setName(result.getString("name"));
                flight.setDeparture(result.getString("departure"));
                flight.setArrival(result.getString("arrival"));
                flight.setDurationMinutes(result.getInt("durationMinutes"));
                flight.setScheduleId(result.getInt("scheduleId"));
//                    ticketDetails.add(ticketDetail);
                searchDetails.add(flight);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return searchDetails;
    }
}
