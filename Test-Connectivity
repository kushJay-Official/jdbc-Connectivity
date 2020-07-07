//First Program to show the connectivity to Database..

package jdbctest;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args)throws Exception {
        getConnection();
    }

    private static void getConnection() throws SQLException {
        Connection con=null;
        Statement stmt;
        ResultSet rs;

        try {
            System.out.println("Connecting to DB....");
             Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:8081/First_Schema","Jay","");
            stmt=con.createStatement();
            rs= stmt.executeQuery("select * from firstTB");
            System.out.println("Connected... Welcome To JDBC");
            int id;double amt;
            while (rs.next()){
                id=rs.getInt("id");
                amt=rs.getDouble("amt");
                System.out.println(id+"     "+amt);
            }
            rs.close();
            stmt.close();
            System.out.println("Printed ...");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed !!!");
        } finally {
            if(con!=null){
                System.out.println("Disconnecting DB.....");
                con.close();
                System.out.println("DB Disconnected !!");
            }
        }
    }
}
