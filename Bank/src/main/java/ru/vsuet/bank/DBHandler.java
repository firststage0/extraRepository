package ru.vsuet.bank;

import java.sql.*;

public class DBHandler extends Config{
    private static Connection dbconnection;
    public Connection getConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbconnection = DriverManager.getConnection(connectionString, dbUser, dbpassword);
        return dbconnection;
    }

    /*public void signUpUser(User user){
        String insert = "INSERT INTO " + Const.USERS_TABLE + "(" + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD +
            "," + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + ")" + "VALUES(?,?,?,?)";

        try{
            PreparedStatement prSt = getConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstname());
            prSt.setString(2, user.getSecondname());
            prSt.setString(3, user.getUsername());
            prSt.setString(4, user.getPassword());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " + Const.USERS_USERNAME + "=? AND " +
                Const.USERS_PASSWORD + "=?";

        try {
            PreparedStatement prSt = getConnection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;

    }*/

}
