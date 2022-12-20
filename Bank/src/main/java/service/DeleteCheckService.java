package service;

import repository.Functions;

import java.sql.SQLException;
import java.sql.Statement;

public class DeleteCheckService {
    protected static void Delete(String checkName){

        Functions functions = new Functions(dbHandler);
        String query = "delete from accounts where chekNumber = '" + checkName + "'";
        try {
            Statement statement = functions.dbHandler.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
