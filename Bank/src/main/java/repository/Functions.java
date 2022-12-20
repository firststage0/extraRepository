package repository;

import settings.Const;
import ru.vsuet.bank.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Functions {

    public final DBHandler dbHandler; // = new DBHandler();

    public Functions(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " + Const.USERS_USERNAME + "=? AND " +
                Const.USERS_PASSWORD + "=?";

        try {
            PreparedStatement prSt = dbHandler.getConnection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Const.USERS_TABLE + "(" + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD +
                "," + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = dbHandler.getConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstname());
            prSt.setString(2, user.getSecondname());
            prSt.setString(3, user.getUsername());
            prSt.setString(4, user.getPassword());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public long findById(String query, String name, String id, String loginText) {
        String Search;
        long findid = 0;
        try {
            Statement statement = dbHandler.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Search = resultSet.getString(name);
                if (Search.equals(loginText)) {
                    findid = resultSet.getLong(id);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return findid;
    }

}
