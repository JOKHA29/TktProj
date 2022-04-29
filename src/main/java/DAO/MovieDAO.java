package DAO;

import Models.Movie;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieDAO {
    private Connection con;

    public MovieDAO(Connection con){
        this.con=con;
    }

    public void add(Movie movie) {
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO movies VALUES(?, ?, ?, ?);");
            st.setString(1, movie.getName());
            st.setDate(2, (Date) movie.getDate());
            st.setString(3, movie.getDescription());
            st.setString(4, movie.getGenre());
            boolean added = st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(Movie movie){
        try {
            PreparedStatement st = con.prepareStatement("DELETE FROM movies WHERE name=? AND date=?");
            st.setString(1, movie.getName());
            st.setDate(2, (Date) movie.getDate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
