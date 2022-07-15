package com.oc_p8.ecommerce.ordercycle.infrastructure.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionManagerSQL {

    private static ConnectionManagerSQL INSTANCE;

    private String url = "jdbc:postgresql://localhost:5432/order_cycle";
    private String userName = "postgres";
    private String password = "postgres";
    // Command Line: % /usr/local/mysql/bin/mysql -uroot -proot3264restController
    // SHOW DATABASES;
    // SHOW TABLES FROM order_cycle;

    // USE order_cycle
    // psql -U postgres -d order_cycle
    // \dt (Tables)
    // SELECT * FROM "order";

    private Connection connection;

    private ConnectionManagerSQL() throws SQLException {
        this.connection = DriverManager.getConnection(url, userName, password);
    }

    public static ConnectionManagerSQL getInstance() throws SQLException {
        if (ConnectionManagerSQL.INSTANCE == null) {
            ConnectionManagerSQL.INSTANCE = new ConnectionManagerSQL();
        }
        return ConnectionManagerSQL.INSTANCE;

    }

    public Connection getConnection() {
        return this.connection;
    }

    public void close() throws SQLException {
        if (this.connection != null) {
            this.connection.close();
        }
    }

}
