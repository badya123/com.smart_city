package com.smart_city.Authorization;

import com.smart_city.users.LoginUser;

import java.sql.Connection;

public interface ILogin {
    boolean login (Connection con, LoginUser user);
}
