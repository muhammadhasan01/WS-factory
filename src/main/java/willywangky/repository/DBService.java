package willywangky.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBService {
    private Connection connection;
    private static DBService dbService = new DBService();

    public DBService(){
        try{
            String DB_URL = "jdbc:mysql://localhost/wwfactory?useLegacyDatetimeCode=false&serverTimezone=UTC";
            String DB_USERNAME = "root";
            String DB_PASSWORD = "rootroot";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection Success");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

    public static DBService getDbService(){
        return DBService.dbService;
    }
}
