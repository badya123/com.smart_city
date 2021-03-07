package com.smart_city.DB;

import java.sql.Connection;

public interface IDB {
    Connection openConnection  ();
    boolean closeConnection (Connection con);
}
