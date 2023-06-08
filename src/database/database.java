package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pao";
    private static final String User = "root";
    private static final String pass = "1234";
    private static Connection dbCon;

    private database(){}

    public static Connection getDatabaseConnection(){
        try{
            if (dbCon == null || dbCon.isClosed()){
                dbCon = DriverManager.getConnection(DB_URL, User, pass);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dbCon;
    }

    public static void closeDatabaseConneciton(){
        try{
            if (dbCon != null && !dbCon.isClosed()){
                dbCon.close();
            }

        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
