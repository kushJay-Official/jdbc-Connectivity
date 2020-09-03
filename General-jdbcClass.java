//this is general class which will inherit by any sub class and we use it to connect with any database


package jdbctest;

import java.sql.*;

public class ConnectToDatabase {
     static Connection con;
     static Statement stmt;
     static ResultSet rs;
     public static int getConToDB(String table, String schema) throws SQLException {
        try {
            System.out.println("Connecting to DB....");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:8081/"+schema,"Jay","");
            stmt=con.createStatement();
            rs= stmt.executeQuery("select * from "+table);
            System.out.println("Connected... ");
            return 1;
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed !!!");
            return 0;
        }
        
    }

    public static void checkConnectivity(int i){
        if(i==1)
            System.out.println("Your Database is Connected....");
        else
            System.out.println("Database Connection fail...");
    }
    public static void getDisConToDB() throws SQLException {
        if(con!=null){
            System.out.println("Disconnecting DB.....");
            con.close();
            System.out.println("DB Disconnected !!");
        }
    }

}


//subclass

package jdbctest;

import java.sql.ResultSet;

public class Ran extends ConnectToDatabase{
    public static void main(String[] args)throws Exception {

       int i=getConToDB("firstTB","First_Schema");
        checkConnectivity(i);

        String sql;
        sql="INSERT INTO firstTB VALUES(13,4895.0)";
        stmt.executeUpdate(sql);


        sql="DELETE FROM firstTB WHERE ID =10";
        stmt.executeUpdate(sql);


        rs=stmt.executeQuery("select * from firstTB");
        int id;double amt;
        while (rs.next()){
            id=rs.getInt("id");
            amt=rs.getDouble("amt");
            System.out.println(id+"     "+amt);
        }
        getDisConToDB();

    }
}
