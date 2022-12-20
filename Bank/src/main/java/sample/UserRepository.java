package sample;

import repository.DBHandler;
import ru.vsuet.bank.Const;
import ru.vsuet.bank.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository<User> {

    private final DBHandler dbHandler;

    public UserRepository(DBHandler dbHandler) {
        this.dbHandler = dbHandler;
    }

    @Override
    public User find(Long id) {
        String query = "select * from " + Const.USERS_TABLE + " where " + Const.USERS_ID + " = ?";
        try (
                PreparedStatement statement = dbHandler.getConnection().prepareStatement(query)
        ) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                long userId = resultSet.getLong(Const.USERS_ID);
                String name = resultSet.getString(Const.USERS_USERNAME);
                String password = resultSet.getString(Const.USERS_PASSWORD);
                String firstName = resultSet.getString(Const.USERS_FIRSTNAME);
                String lastName = resultSet.getString(Const.USERS_LASTNAME);
                User user = new User(userId, firstName, lastName, name, password);
                users.add(user);
            }
            if (users.isEmpty()) {
                throw new RuntimeException("User not found by id=" + id);
            }
            return users.get(0);
        } catch (SQLException e) {
            throw new RuntimeException("Error while method find call: " + e.getMessage());
        }
    }

    public User find(String userName) {
        String query = "select * from " + Const.USERS_TABLE + " where " + Const.USERS_USERNAME + " = ?";
        try (
                PreparedStatement statement = dbHandler.getConnection().prepareStatement(query)
        ) {
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                long userId = resultSet.getLong(Const.USERS_ID);
                String name = resultSet.getString(Const.USERS_USERNAME);
                String password = resultSet.getString(Const.USERS_PASSWORD);
                String firstName = resultSet.getString(Const.USERS_FIRSTNAME);
                String lastName = resultSet.getString(Const.USERS_LASTNAME);
                User user = new User(userId, firstName, lastName, name, password);
                users.add(user);
            }
            if (users.isEmpty()) {
                throw new RuntimeException("User not found by userName=" + userName);
            }
            return users.get(0);
        } catch (SQLException e) {
            throw new RuntimeException("Error while method find call: " + e.getMessage());
        }
    }
}
