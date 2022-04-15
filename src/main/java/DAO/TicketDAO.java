package DAO;

import Models.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAO {
    private Connection con;

    public TicketDAO(Connection con) {
        this.con = con;
    }

    public void add(Ticket ticket) {
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO tickets VALUES(?, ?, ?, ?);");
            st.setString(1, ticket.getMovieName());
            st.setString(2, ticket.getSeat());
            st.setDouble(3, ticket.getPrice());
            st.setBoolean(4, ticket.isSold());
            boolean added = st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void changeStatus(Ticket ticket) {
        try {
            PreparedStatement st = con.prepareStatement("UPDATE tickets SET sold=? WHERE moviename=? AND seat=?");
            st.setBoolean(1, ticket.isSold());
            st.setString(2, ticket.getMovieName());
            st.setString(3, ticket.getSeat());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}