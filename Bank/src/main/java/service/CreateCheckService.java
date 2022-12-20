package service;

import repository.Functions;
import settings.Const;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateCheckService{
    private static Long userId;
    private static String Search;

    protected static void createCheck(String checkName, String loginText){
        Functions functions = new Functions(dbHandler);
        String name = "username";
        String id = "idusers";
        String query = "select * from " + Const.USERS_TABLE;
        userId = functions.findById(query, name, id, loginText);
        String insert = "insert into " + Const.ACCOUNTS_TABLE + "(" + Const.ACCOUNTS_ID + "," + Const.ACCOUNTS_CHEK +
                "," + Const.ACCOUNTS_MONEY + ") values(?,?,?)";
        try {
            PreparedStatement prst = functions.dbHandler.getConnection().prepareStatement(insert);
            prst.setString(1, String.valueOf(userId));
            prst.setString(2, checkName);
            prst.setString(3, String.valueOf(0));

            prst.executeUpdate();
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    protected static int isCheckExist(String checkName){
        int count = 0;
        Functions functions = new Functions(dbHandler);
        String query = "SELECT * FROM " + Const.ACCOUNTS_TABLE;
        try {
            Statement statement = functions.dbHandler.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String checkSearch = resultSet.getString("chekNumber");
                if(checkSearch.equals(checkName)){
                    count++;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }
}
