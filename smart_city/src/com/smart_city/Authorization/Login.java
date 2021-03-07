package com.smart_city.Authorization;

import com.smart_city.users.LoginUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login implements ILogin {
    @Override
    public boolean login(Connection con, LoginUser user) {
        try {
            Statement st = con.createStatement();
            String loginQuery = "SELECT id FROM users WHERE login = \'" + user.getLogin() + "\' AND password = \'" + user.getPassword() + '\'';

            ResultSet rs = st.executeQuery(loginQuery);

            if (!rs.next()) {
                System.err.println("No user found!");
                System.exit(404);
            } else {
                System.out.println("Successfully logged in!");
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }
}
