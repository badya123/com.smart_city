package com.smart_city.users;

import com.smart_city.DB.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;

    public User(LoginUser user) {
        DBConnector dbConnector = new DBConnector("jdbc:postgresql://localhost:5432/smart_city", "postgres", "badya123");
        Connection con = dbConnector.openConnection();
        Statement st = null;
        try {
            st = con.createStatement();
            String loginQuery = "SELECT * FROM users WHERE login = \'" + user.getLogin() + "\' AND password = \'" + user.getPassword() + '\'';

            ResultSet rs = st.executeQuery(loginQuery);

            rs.next();
            id = rs.getInt("id");
            firstName = rs.getString("first_name");
            lastName = rs.getString("last_name");
            login = user.getLogin();
            password = user.getPassword();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dbConnector.closeConnection(con);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
