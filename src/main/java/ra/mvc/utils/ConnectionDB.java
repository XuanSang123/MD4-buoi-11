package ra.mvc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    // mở kết nối
    public static Connection getConnection() {
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?createDatabaseIfNotExist=true","root","0964417590");
            return conn;
        }catch (ClassNotFoundException e){

            System.err.println("Driver k tim thya");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.err.println("loi ket noi");
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection conn){
        try {
            if (!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("loi roi");
            throw new RuntimeException(e);
        }
    }
}
