package com.smart_city.Authorization.Menus.MenuBegin;

import com.smart_city.Authorization.Login;
import com.smart_city.DB.DBConnector;
import com.smart_city.Modules.Module1;
import com.smart_city.Modules.Module2;
import com.smart_city.Modules.Module3;
import com.smart_city.users.LoginUser;
import com.smart_city.users.User;

import java.sql.Connection;
import java.util.Scanner;

public class Begin {
    public static void start() {
        DBConnector dbConnector = new DBConnector("jdbc:postgresql://localhost:5432/smart_city", "postgres", "badya123");
        Connection con = dbConnector.openConnection();

        User user = null;

        System.out.println("bla bla bla welcome write:\n1 if you want to login\n2 if you are a tourist");
        Scanner sc = new Scanner(System.in);
        String inputBegin;
        while (true) {
            inputBegin = sc.next();
            if (inputBegin.equals("1") || inputBegin.equals("2")) break;
        }

        if (inputBegin.equals("1")) {
            System.out.println("Input login and password");
            String login = sc.next();
            String password = sc.next();

            LoginUser lu = new LoginUser(login, password);
            Login loginClass = new Login();
            if (loginClass.login(con, lu)) {
                user = new User(lu);
                System.out.println(user);
            }


        }
        System.out.println("choose your module (1-3)");

        String chooseModule;
        while (true) {
            chooseModule = sc.next();

            if (chooseModule.equals("1")) {
                Module1.start();
                break;
            } else if (chooseModule.equals("2")) {
                Module2.start();
                break;
            } else if (chooseModule.equals("3")) {
                Module3.start();
                break;
            }
            System.out.println("Incorrect module id!");

        }

        dbConnector.closeConnection(con);
    }
}
