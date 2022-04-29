package DAO;

import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection con;

    public UserDAO(Connection con) {
        this.con = con;
    }

    public void add(User user){
        try {  PreparedStatement pr=con.prepareStatement("Insert into users values(?,?,?);");
            pr.setString(1, user.getUsername());
            pr.setString(2, user.getPass());
            pr.setString(3, user.getGmail());
            pr.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(User user){
        try {
            PreparedStatement st = con.prepareStatement("DELETE FROM users WHERE username=? AND password=?");
            st.setString(1, user.getUsername());
            st.setString(2, user.getPass());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    public boolean checkUser(User user) {
        try {
            PreparedStatement st = con.prepareStatement("SELECT * FROM users WHERE username = ? and pwd = ?;");
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            ResultSet res = st.executeQuery();
            return res.next();
        } catch (SQLException e) {}
        return false;
    }
     */


    public boolean CheckUserbyall(User user){
        try {
            PreparedStatement pr=con.prepareStatement("select * from users where username = ? and " +
                    "pass = ? and gmail=?;");
            pr.setString(1, user.getUsername());
            pr.setString(2, user.getPass());
            pr.setString(3, user.getGmail());
            ResultSet rs=pr.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return false;

    }
    public boolean CheckUser(String username, String password){
        try {
            PreparedStatement pr=con.prepareStatement("select * from users where username=? and pass=?;");
            pr.setString(1, username);
            pr.setString(2, password);
            ResultSet rs=pr.executeQuery();
            if(!rs.next()) return false;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    public boolean CheckUsername(String username){
        try {
            PreparedStatement pr = con.prepareStatement("select username from users where username = ?;");
            pr.setString(1, username);
            ResultSet rs = pr.executeQuery();
            return rs.next();
        } catch (SQLException e) {

        }
        return false;
    }
    }

