package repository;

import settings.Config;

import java.sql.*;

import static settings.Config.*;

public class DBHandler {
    private Connection dbconnection;

    public Connection getConnection()
            throws SQLException {
        String connectionString = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";

        if (dbconnection == null || dbconnection.isClosed()) {
            dbconnection = DriverManager.getConnection(connectionString, DB_USER, DB_PASSWORD);
        }

        return dbconnection;
    }

}
